package dk.sdu.mmmi.semproject.temp_reader;

import dk.sdu.mmmi.semproject.OPC_Common.SensorData;
import org.json.JSONException;
import org.json.JSONObject;

public class Sensor implements Runnable{

    JSONObject temp = new JSONObject();
    SensorData sd;

    public SensorData getSd() {
        return sd;
    }

    public JSONObject getTemp() {
        return temp;
    }

    @Override
    public void run() {
        while (true){
            try {
                temp.put("ID", sd.getId());
                temp.put("Name", sd.getName());
                temp.put("Value", sd.getValue());
                temp.put("Symbol", sd.getSymbol());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
