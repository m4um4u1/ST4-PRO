package dk.sdu.mmmi.semproject.backend.component;

import dk.sdu.mmmi.semproject.data.Client;
import dk.sdu.mmmi.semproject.services.ISensorReader;

public class SensorHandler {

    private Client temp;
    private Client hum;
    private Client vib;
    private ISensorReader temperatureReader;
    private ISensorReader humidityReader;
    private ISensorReader vibrationReader;


    public SensorHandler() {
    }

    public void createTemp() {
        temp = new Client();
        temperatureReader.start(temp.getHz());
    }

    public void createHum() {
        hum = new Client();
        humidityReader.start(hum.getHz());
    }

    public void createVib() {
        vib = new Client();
        vibrationReader.start(vib.getHz());
    }

    public void stopSensors() {
        temperatureReader.stop(temp.getHz());
        humidityReader.stop(hum.getHz());
        vibrationReader.stop(vib.getHz());
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
