package vibsensor;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.topic.ITopic;
import org.eclipse.milo.opcua.sdk.client.OpcUaClient;
import org.eclipse.milo.opcua.sdk.client.api.subscriptions.UaMonitoredItem;
import org.eclipse.milo.opcua.sdk.client.api.subscriptions.UaSubscription;
import org.eclipse.milo.opcua.stack.core.AttributeId;
import org.eclipse.milo.opcua.stack.core.types.builtin.DataValue;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;
import org.eclipse.milo.opcua.stack.core.types.builtin.QualifiedName;
import org.eclipse.milo.opcua.stack.core.types.builtin.Variant;
import org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.UInteger;
import org.eclipse.milo.opcua.stack.core.types.enumerated.MonitoringMode;
import org.eclipse.milo.opcua.stack.core.types.enumerated.TimestampsToReturn;
import org.eclipse.milo.opcua.stack.core.types.structured.MonitoredItemCreateRequest;
import org.eclipse.milo.opcua.stack.core.types.structured.MonitoringParameters;
import org.eclipse.milo.opcua.stack.core.types.structured.ReadValueId;
import static com.google.common.collect.Lists.newArrayList;
import java.util.concurrent.CompletableFuture;

import java.util.List;

import static org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.Unsigned.uint;

public class Publisher {

    private HazelcastInstance hz;
    private static final String TOPIC_NAME = "vibsensor";
    private static ITopic topic = null;
    private Client client;
    private CompletableFuture<OpcUaClient> future;
    private static SensorData sd = new SensorData();

    public Publisher() {
        hz = HazelcastClient.newHazelcastClient();
        client = new Client();
        topic = hz.getTopic(TOPIC_NAME);
        future = new CompletableFuture<>();
    }

    public void readName() {
        try {
            NodeId nodeId = new NodeId(6, "::Program:Cube.Status.Parameter[4].Name");
            DataValue dataValue = client.getClient().readValue(0, TimestampsToReturn.Both, nodeId).get();
            Variant variant = dataValue.getValue();
            sd.setName(variant.getValue().toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void readId() {
        try {
            NodeId nodeId = new NodeId(6, "::Program:Cube.Status.Parameter[4].ID");
            DataValue dataValue = client.getClient().readValue(0, TimestampsToReturn.Both, nodeId).get();
            Variant variant = dataValue.getValue();
            sd.setId(Integer.parseInt(variant.getValue().toString()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void readSymbol() {
        try {
            NodeId nodeId = new NodeId(6, "::Program:Cube.Status.Parameter[4].Unit");
            DataValue dataValue = client.getClient().readValue(0, TimestampsToReturn.Both, nodeId).get();
            Variant variant = dataValue.getValue();
            sd.setSymbol(variant.getValue().toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void subscribeToNode() {
        try {
            UaSubscription subscription = client.getClient().getSubscriptionManager().createSubscription(1000.0).get();

            //::Program:Cube.Status.Parameter[4].Value <- the actual nodeId
            NodeId nodeId = new NodeId(6, "::Program:Cube.Command.Parameter[2].Value");
            // subscribe to the Value attribute of the server's CurrentTime node
            ReadValueId readValueId = new ReadValueId(nodeId, AttributeId.Value.uid(), null, QualifiedName.NULL_VALUE);

            // IMPORTANT: client handle must be unique per item within the context of a subscription.
            // You are not required to use the UaSubscription's client handle sequence; it is provided as a convenience.
            // Your application is free to assign client handles by whatever means necessary.
            UInteger clientHandle = subscription.nextClientHandle();

            MonitoringParameters parameters = new MonitoringParameters(
                    clientHandle,
                    1000.0,     // sampling interval
                    null,       // filter, null means use default
                    uint(10),   // queue size
                    true        // discard oldest
            );

            MonitoredItemCreateRequest request = new MonitoredItemCreateRequest(
                    readValueId,
                    MonitoringMode.Reporting,
                    parameters
            );

            UaSubscription.ItemCreationCallback onItemCreated =
                    (item, id) -> item.setValueConsumer(Publisher::onSubscriptionValue);

            List<UaMonitoredItem> items = subscription.createMonitoredItems(
                    TimestampsToReturn.Both,
                    newArrayList(request),
                    onItemCreated
            ).get();

            for (UaMonitoredItem item : items) {
                if (item.getStatusCode().isGood()) {
                    System.out.println(("item created for nodeId={}" + item.getReadValueId().getNodeId()));
                } else {
                    System.out.println((
                            "failed to create item for nodeId={} (status={})" +
                            item.getReadValueId().getNodeId() + item.getStatusCode()));
                }
            }

            Thread.sleep(5000);
            future.complete(client.getClient());
        }
        catch(Throwable ex)
        {
            ex.printStackTrace();
        }
    }

    private static void onSubscriptionValue(UaMonitoredItem item, DataValue value) {
        sd.setValue(Float.parseFloat(value.getValue().getValue().toString()));
        System.out.println(sd.getId() +" "+ sd.getName() +" "+ sd.getValue() + sd.getSymbol());
        topic.publish(sd.getId() +" "+ sd.getName() +" "+ sd.getValue() +" "+ sd.getSymbol());
    }
}
