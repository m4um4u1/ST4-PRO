package dk.sdu.mmmi.semproject.backend.service;

import dk.sdu.mmmi.semproject.backend.component.LiveHandler;
import dk.sdu.mmmi.semproject.backend.component.UaHandler;
import org.eclipse.milo.opcua.stack.core.types.builtin.DataValue;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;
import org.eclipse.milo.opcua.stack.core.types.builtin.Variant;
import org.eclipse.milo.opcua.stack.core.types.enumerated.TimestampsToReturn;
import org.springframework.stereotype.Service;

@Service
public class LiveService {

    private final LiveHandler lh;
    private float batchID;
    private int produced;
    private int accepted;
    private int defective;
    private float machSpeed;
    private float productType;
    private float amount;

    public LiveService(LiveHandler lh) {
        this.lh = lh;
    }


    public Float getBatchID(){
        NodeId nodeId = new NodeId(6, "::Program:Cube.Status.Parameter[0].Value");
        try {
            DataValue data = UaHandler.client.readValue(0, TimestampsToReturn.Both, nodeId).get();
            Variant var = data.getValue();
            batchID = (float) var.getValue();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return batchID;
    }

    public Integer getProduced(){
        NodeId nodeId = new NodeId(6, "::Program:Cube.Admin.ProdProcessedCount");
        try {
            DataValue data = UaHandler.client.readValue(0, TimestampsToReturn.Both, nodeId).get();
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
            DataValue data = UaHandler.client.readValue(0, TimestampsToReturn.Both, nodeId).get();
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
            DataValue data = UaHandler.client.readValue(0, TimestampsToReturn.Both, nodeId).get();
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
            DataValue data = UaHandler.client.readValue(0, TimestampsToReturn.Both, nodeId).get();
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
            DataValue data = UaHandler.client.readValue(0, TimestampsToReturn.Both, nodeId).get();
            Variant var = data.getValue();
            amount = (float) var.getValue();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return amount;
    }

    public double getTemperature() {
        return lh.getTemperature();
    }

    public double getHumidity() {
        return lh.getHumidity();
    }

    public double getVibration() {
        return lh.getVibration();
    }
}

