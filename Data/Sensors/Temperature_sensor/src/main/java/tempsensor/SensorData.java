package tempsensor;

import java.io.Serializable;

public class SensorData implements Serializable {
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
}
