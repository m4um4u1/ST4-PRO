package dk.sdu.mmmi.semproject.temp_reader;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.topic.ITopic;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Temperature {
    HazelcastInstance hz = HazelcastClient.newHazelcastClient();
    ITopic temp = hz.getTopic("temp-sensor");
    Sensor s = new Sensor();
    Thread t = new Thread(s);

    @GetMapping("http://127.0.0.1/api/get/liveData")
    public void read() {
        temp.addMessageListener(s.getSd());
        t.start();
        s.getTemp();
    }
}
