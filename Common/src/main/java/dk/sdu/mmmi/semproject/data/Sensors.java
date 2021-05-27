package dk.sdu.mmmi.semproject.data;

import java.util.ArrayList;

public class Sensors {

    private final ArrayList<SensorData> sensors = new ArrayList<>();

    public void putSensorData(SensorData sd) {
        sensors.add(sd);
    }


}
