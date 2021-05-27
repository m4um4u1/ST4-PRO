package dk.sdu.mmmi.semproject.backend.service;

import dk.sdu.mmmi.semproject.backend.component.SensorHandler;
import dk.sdu.mmmi.semproject.backend.component.UaHandler;
import org.eclipse.milo.opcua.stack.core.types.builtin.DataValue;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;
import org.eclipse.milo.opcua.stack.core.types.builtin.Variant;
import org.eclipse.milo.opcua.stack.core.types.enumerated.TimestampsToReturn;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class LiveService {

    ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
    SensorHandler sh = context.getBean("sensorHandler", SensorHandler.class);
    private float batchID;
    private int produced;
    private int accepted;
    private int defective;
    private float machSpeed;
    private float productType;
    private float amount;
    private double temperature;
    private double humidity;
    private double vibration;


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

    public Double getTemperature(){
        sh.createTemp();
        temperature = sh.getTemperatureReader().getSd().getValue();
        return temperature;
    }

    public Double getHumidity(){
        sh.createHum();
        humidity = sh.getHumidityReader().getSd().getValue();
        return humidity;
    }

    public Double getVibration(){
        sh.createVib();
        vibration = sh.getVibrationReader().getSd().getValue();
        return vibration;
    }
}

