package dk.sdu.mmmi.semproject;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.topic.ITopic;
import dk.sdu.mmmi.semproject.data.SensorData;
import dk.sdu.mmmi.semproject.services.ISensorReader;

public class Humidity implements ISensorReader {

    private SensorData sd = new SensorData();

    public SensorData getSd() {
        return sd;
    }

    @Override
    public void start(HazelcastInstance hz) {
        ITopic topic = hz.getTopic("humidity_sensor");
        topic.addMessageListener(sd);
    }

    @Override
    public void stop(HazelcastInstance hz) {
        hz.shutdown();
    }


}

