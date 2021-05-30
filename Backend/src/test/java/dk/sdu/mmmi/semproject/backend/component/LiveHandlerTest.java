package dk.sdu.mmmi.semproject.backend.component;

import dk.sdu.mmmi.semproject.Humidity;
import dk.sdu.mmmi.semproject.Temperature;
import dk.sdu.mmmi.semproject.Vibration;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class LiveHandlerTest {
    @Mock
    SensorHandler sh;
    @InjectMocks
    LiveHandler liveHandler;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetTemperature() throws Exception {
        when(sh.getTemperatureReader()).thenReturn(new Temperature());

        Double result = liveHandler.getTemperature();
        Assert.assertEquals(Double.valueOf(0), result);
    }

    @Test
    public void testGetHumidity() throws Exception {
        when(sh.getHumidityReader()).thenReturn(new Humidity());

        Double result = liveHandler.getHumidity();
        Assert.assertEquals(Double.valueOf(0), result);
    }

    @Test
    public void testGetVibration() throws Exception {
        when(sh.getVibrationReader()).thenReturn(new Vibration());

        Double result = liveHandler.getVibration();
        System.out.println(Double.valueOf(result));
        Assert.assertEquals(Double.valueOf(0), result);
    }
}
