package dk.sdu.mmmi.semproject.backend.component;

import org.springframework.stereotype.Component;

@Component
public class LiveHandler {
    private double temperature;
    private double humidity;
    private double vibration;

    private final SensorHandler sh;

    public LiveHandler(SensorHandler sh) {
        this.sh = sh;
    }

    public Double getTemperature(){
        sh.createTemp();
        temperature = sh.getTemperatureReader().getSd().getValue();
        return (double)Math.round(temperature  * 100d) / 100d;
    }

    public Double getHumidity(){
        sh.createHum();
        humidity = sh.getHumidityReader().getSd().getValue();
        return (double)Math.round(humidity  * 100d) / 100d;
    }

    public Double getVibration(){
        sh.createVib();
        vibration = sh.getVibrationReader().getSd().getValue();
        return vibration;
    }

}
