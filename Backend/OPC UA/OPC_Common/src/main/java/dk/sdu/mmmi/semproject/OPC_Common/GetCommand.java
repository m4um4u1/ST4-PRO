package dk.sdu.mmmi.semproject.OPC_Common;

import org.eclipse.milo.opcua.stack.core.types.builtin.DataValue;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;
import org.eclipse.milo.opcua.stack.core.types.builtin.Variant;
import org.eclipse.milo.opcua.stack.core.types.enumerated.TimestampsToReturn;

public class GetCommand {

    private int maintenance; // stadig i tvivl med den her.
    private int batchID;
    private int produced;
    private int accepted;
    private int defective;
    private float barley;
    private float hops;
    private float malt;
    private float wheat;
    private float yeast;
    private float machSpeed;
    private float productType;
    private float amount;


    public float getBarley() {
        try {
            NodeId nodeId = new NodeId(6, "::Program:Inventory.Barley");
            DataValue dataValue = CommandUA.client.readValue(0, TimestampsToReturn.Both, nodeId).get();
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
            DataValue dataValue = CommandUA.client.readValue(0, TimestampsToReturn.Both, nodeId).get();
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
            DataValue dataValue = CommandUA.client.readValue(0, TimestampsToReturn.Both, nodeId).get();
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
            DataValue dataValue = CommandUA.client.readValue(0, TimestampsToReturn.Both, nodeId).get();
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
            DataValue dataValue = CommandUA.client.readValue(0, TimestampsToReturn.Both, nodeId).get();
            Variant variant = dataValue.getValue();
            yeast = (float) variant.getValue();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return yeast;
    }

    public Integer getBatchID(){
        NodeId nodeId = new NodeId(6, "::Program:Cube.Status.Parameter[0].Value");
        try {
            DataValue data = CommandUA.client.readValue(0, TimestampsToReturn.Both, nodeId).get();
            Variant var = data.getValue();
            batchID = Integer.parseUnsignedInt(String.valueOf(var.getValue()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return batchID;
    }

    public Integer getProduced(){
        NodeId nodeId = new NodeId(6, "::Program:Cube.Admin.ProdProcessedCount");
        try {
            DataValue data = CommandUA.client.readValue(0, TimestampsToReturn.Both, nodeId).get();
            Variant var = data.getValue();
            produced = Integer.parseUnsignedInt(String.valueOf(var.getValue()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return produced;
    }

    public Integer getDefective(){
        NodeId nodeId = new NodeId(6, "::Program:Cube.Admin.ProdDefectiveCount");
        try {
            DataValue data = CommandUA.client.readValue(0, TimestampsToReturn.Both, nodeId).get();
            Variant var = data.getValue();
            defective = Integer.parseUnsignedInt(String.valueOf(var.getValue()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return defective;
    }

    public Integer getAccepted(){
        accepted = produced - defective;
        return accepted;
    }

    public Float getMachSpeed(){
        NodeId nodeId = new NodeId(6, "::Program:Cube.Status.MachSpeed");
        try {
            DataValue data = CommandUA.client.readValue(0, TimestampsToReturn.Both, nodeId).get();
            Variant var = data.getValue();
            machSpeed = Float.parseFloat(String.valueOf(var.getValue()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return machSpeed;
    }

    public Float getProductType(){
        NodeId nodeId = new NodeId(6, "::Program:Cube.Admin.Parameter[0].Value");
        try {
            DataValue data = CommandUA.client.readValue(0, TimestampsToReturn.Both, nodeId).get();
            Variant var = data.getValue();
            productType = Float.parseFloat(String.valueOf(var.getValue()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productType;
    }

    public Float getAmount(){
        NodeId nodeId = new NodeId(6, "::Program:Cube.Status.Parameter[1].Value");
        try {
            DataValue data = CommandUA.client.readValue(0, TimestampsToReturn.Both, nodeId).get();
            Variant var = data.getValue();
            amount = Float.parseFloat(String.valueOf(var.getValue()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return amount;
    }
}
