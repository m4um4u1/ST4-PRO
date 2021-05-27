package tempsensor;

import org.eclipse.milo.opcua.sdk.client.OpcUaClient;
import org.eclipse.milo.opcua.sdk.client.api.config.OpcUaClientConfigBuilder;
import org.eclipse.milo.opcua.stack.client.DiscoveryClient;
import org.eclipse.milo.opcua.stack.core.UaException;
import org.eclipse.milo.opcua.stack.core.types.structured.EndpointDescription;
import org.eclipse.milo.opcua.stack.core.util.EndpointUtil;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class Client {
    private OpcUaClient client;
    private List<EndpointDescription> endpoints;

    public Client() {
        try {
            endpoints = DiscoveryClient.getEndpoints("opc.tcp://localhost:4840").get();
            EndpointDescription configPoint = EndpointUtil.updateUrl(endpoints.get(0), "127.0.0.1", 4840);
            OpcUaClientConfigBuilder cfg = new OpcUaClientConfigBuilder();
            cfg.setEndpoint(configPoint);

            client = OpcUaClient.create(cfg.build());
            client.connect().get();
        } catch (InterruptedException | ExecutionException | UaException e) {
            e.printStackTrace();
        }
    }
    public OpcUaClient getClient() {
        return client;
    }
}
