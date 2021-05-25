package dk.sdu.mmmi.semproject.vib_reader;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.topic.ITopic;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

public class Vibration {
    HazelcastInstance hz = HazelcastClient.newHazelcastClient();
    ITopic temp = hz.getTopic("vibsensor");
    Sensor s = new Sensor();
    Thread t = new Thread(s);

    public void read(){
        temp.addMessageListener(s.getSd());
        t.start();
        s.getVib();
    }
}
