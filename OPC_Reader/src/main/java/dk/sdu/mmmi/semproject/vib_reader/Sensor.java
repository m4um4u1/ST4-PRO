package dk.sdu.mmmi.semproject.vib_reader;

import dk.sdu.mmmi.semproject.OPC_Common.SensorData;
import org.json.JSONException;
import org.json.JSONObject;

public class Sensor implements Runnable{

    JSONObject vib = new JSONObject();
    SensorData sd;

    public SensorData getSd() {
        return sd;
    }

    public JSONObject getVib() {
        return vib;
    }

    @Override
    public void run() {
        while (true){
            try {
                vib.put("ID", sd.getId());
                vib.put("Name", sd.getName());
                vib.put("Value", sd.getValue());
                vib.put("Symbol", sd.getSymbol());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
