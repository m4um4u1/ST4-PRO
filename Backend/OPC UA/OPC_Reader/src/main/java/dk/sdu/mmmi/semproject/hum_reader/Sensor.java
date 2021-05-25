package dk.sdu.mmmi.semproject.hum_reader;

import dk.sdu.mmmi.semproject.OPC_Common.SensorData;
import org.json.JSONException;
import org.json.JSONObject;

public class Sensor implements Runnable{

    JSONObject hum = new JSONObject();
    SensorData sd;

    public SensorData getSd() {
        return sd;
    }

    public JSONObject getHum() {
        return hum;
    }

    @Override
    public void run() {
        while (true){
            try {
                hum.put("ID", sd.getId());
                hum.put("Name", sd.getName());
                hum.put("Value", sd.getValue());
                hum.put("Symbol", sd.getSymbol());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
