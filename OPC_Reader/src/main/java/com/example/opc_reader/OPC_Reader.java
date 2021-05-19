package com.example.opc_reader;


import dk.sdu.mmmi.semproject.OPC_Common.CommandUA;
import dk.sdu.mmmi.semproject.OPC_Common.SetCommand;
import dk.sdu.mmmi.semproject.OPC_Services.IOpcService;
import org.eclipse.milo.opcua.stack.core.types.builtin.DataValue;
import org.eclipse.milo.opcua.stack.core.types.builtin.Variant;
import org.eclipse.milo.opcua.stack.core.types.enumerated.TimestampsToReturn;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;


public class OPC_Reader implements IOpcService {



    private int maintenance;
    private float barley;
    private float hops;
    private float malt;
    private float wheat;
    private float yeast;

    CommandUA ca;

    @Override
    public void command(CommandUA ca, SetCommand sc) {
        this.ca = ca;
    }

    public int getMaintenance() {
        try {

            NodeId nodeId = new NodeId(6, "::Program:Maintenance.Counter");
            DataValue dataValue = ca.client.readValue(0, TimestampsToReturn.Both, nodeId).get();
            Variant variant = dataValue.getValue();
            maintenance = Integer.parseUnsignedInt(String.valueOf(variant.getValue()));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return maintenance;
    }


    public float getBarley() {
        try {

            NodeId nodeId = new NodeId(6, "::Program:Inventory.Barley");
            DataValue dataValue = ca.client.readValue(0, TimestampsToReturn.Both, nodeId).get();
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
            DataValue dataValue = ca.client.readValue(0, TimestampsToReturn.Both, nodeId).get();
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
            DataValue dataValue = ca.client.readValue(0, TimestampsToReturn.Both, nodeId).get();
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
            DataValue dataValue = ca.client.readValue(0, TimestampsToReturn.Both, nodeId).get();
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
            DataValue dataValue = ca.client.readValue(0, TimestampsToReturn.Both, nodeId).get();
            Variant variant = dataValue.getValue();
            yeast = (float) variant.getValue();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return yeast;
    }

}
