package dk.sdu.mmmi.semproject.backend.component;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.core.HazelcastInstance;
import dk.sdu.mmmi.semproject.data.Client;
import dk.sdu.mmmi.semproject.services.ISensorReader;

public class SensorHandler {

    private HazelcastInstance hz;
    private ISensorReader temperatureReader;
    private ISensorReader humidityReader;
    private ISensorReader vibrationReader;


    public SensorHandler() {
        this.hz = HazelcastClient.newHazelcastClient();
    }

    public void createTemp() {
        temperatureReader.start(hz);
    }

    public void createHum() {
        humidityReader.start(hz);
    }

    public void createVib() {
        vibrationReader.start(hz);
    }

    public void stopSensors() {
        temperatureReader.stop(hz);
        humidityReader.stop(hz);
        vibrationReader.stop(hz);
    }

    public ISensorReader getTemperatureReader() {
        return temperatureReader;
    }

    public ISensorReader getHumidityReader() {
        return humidityReader;
    }

    public ISensorReader getVibrationReader() {
        return vibrationReader;
    }

    public void setTemperatureReader(ISensorReader temperatureReader) {
        this.temperatureReader = temperatureReader;
    }

    public void setHumidityReader(ISensorReader humidityReader) {
        this.humidityReader = humidityReader;
    }

    public void setVibrationReader(ISensorReader vibrationReader) {
        this.vibrationReader = vibrationReader;
    }
}
