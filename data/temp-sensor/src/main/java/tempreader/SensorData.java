package tempreader;

import com.hazelcast.topic.Message;
import com.hazelcast.topic.MessageListener;

public class SensorData implements MessageListener, ISensorData {
    private int id;
    private float value;
    private String Name;
    private String symbol;

    public int getId() {
        return id;
    }

    public float getValue() {
        return value;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public void onMessage(Message message) {
        String[] split = message.getMessageObject().toString().split(" ");
        setId(Integer.parseInt(split[0]));
        setName(split[1]);
        setValue(Float.parseFloat(split[2]));
        setSymbol(split[3]);
    }
}
