package dk.sdu.mmmi.semproject.services;

import com.hazelcast.core.HazelcastInstance;
import dk.sdu.mmmi.semproject.data.SensorData;

public interface ISensorReader {

    void start(HazelcastInstance hz);

    void stop(HazelcastInstance hz);

    SensorData getSd();

}
