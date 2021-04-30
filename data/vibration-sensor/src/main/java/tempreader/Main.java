package tempreader;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.topic.ITopic;

import java.util.Timer;
import java.util.TimerTask;

public class Main {
    public static void main(String[] args) {
        HazelcastInstance hz = HazelcastClient.newHazelcastClient();
        SensorData sd = new SensorData();
        ITopic temp = hz.getTopic("vibsensor");
        temp.addMessageListener(sd);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(sd.getId() +" "+ sd.getName() +" "+ sd.getValue() + sd.getSymbol());
            }
        },0 , 5000);
    }
}
