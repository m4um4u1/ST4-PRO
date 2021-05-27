package dk.sdu.mmmi.semproject.data;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.core.HazelcastInstance;

public class Client {
    HazelcastInstance hz;

    public Client() {
        this.hz = HazelcastClient.newHazelcastClient();
    }

    public HazelcastInstance getHz() {
        return hz;
    }
}
