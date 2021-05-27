package dk.sdu.mmmi.semproject.backend.service;

import dk.sdu.mmmi.semproject.backend.component.UaHandler;
import org.eclipse.milo.opcua.stack.core.types.builtin.DataValue;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;
import org.eclipse.milo.opcua.stack.core.types.builtin.Variant;
import org.eclipse.milo.opcua.stack.core.types.enumerated.TimestampsToReturn;
import org.springframework.stereotype.Service;

@Service
public class IngredientsService {

    private float barley;
    private float hops;
    private float malt;
    private float wheat;
    private float yeast;


    public float getBarley() {
        try {
            NodeId nodeId = new NodeId(6, "::Program:Inventory.Barley");
            DataValue dataValue = UaHandler.client.readValue(0, TimestampsToReturn.Both, nodeId).get();
            Variant variant = dataValue.getValue();
            barley = (float) variant.getValue();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return barley;
    }

    public float getHops() {
        try {
            NodeId nodeId = new NodeId(6, "::Program:Inventory.Hops");
            DataValue dataValue = UaHandler.client.readValue(0, TimestampsToReturn.Both, nodeId).get();
            Variant variant = dataValue.getValue();
            hops = (float) variant.getValue();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return hops;
    }

    public float getMalt() {
        try {
            NodeId nodeId = new NodeId(6, "::Program:Inventory.Malt");
            DataValue dataValue = UaHandler.client.readValue(0, TimestampsToReturn.Both, nodeId).get();
            Variant variant = dataValue.getValue();
            malt = (float) variant.getValue();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return malt;
    }

    public float getWheat() {
        try {
            NodeId nodeId = new NodeId(6, "::Program:Inventory.Wheat");
            DataValue dataValue = UaHandler.client.readValue(0, TimestampsToReturn.Both, nodeId).get();
            Variant variant = dataValue.getValue();
            wheat = (float) variant.getValue();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return wheat;
    }

    public float getYeast() {
        try {
            NodeId nodeId = new NodeId(6, "::Program:Inventory.Yeast");
            DataValue dataValue = UaHandler.client.readValue(0, TimestampsToReturn.Both, nodeId).get();
            Variant variant = dataValue.getValue();
            yeast = (float) variant.getValue();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return yeast;
    }

}
