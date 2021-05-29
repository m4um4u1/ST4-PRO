package dk.sdu.mmmi.semproject.backend.model;


public class LiveData {

    private float batchID;
    private int produced;
    private int accepted;
    private int defective;
    private float machSpeed;
    private float productType;
    private float amount;
    private double temperature;
    private double humidity;
    private double vibration;

    public LiveData() {
    }

    public LiveData(float batchID, int produced, int accepted, int defective, float machSpeed, float productType, float amount, double temperature, double humidity, double vibration) {
        this.batchID = batchID;
        this.produced = produced;
        this.accepted = accepted;
        this.defective = defective;
        this.machSpeed = machSpeed;
        this.productType = productType;
        this.amount = amount;
        this.temperature = temperature;
        this.humidity = humidity;
        this.vibration = vibration;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getVibration() {
        return vibration;
    }

    public void setVibration(double vibration) {
        this.vibration = vibration;
    }

    public float getBatchID() {
        return batchID;
    }

    public void setBatchID(float batchID) {
        this.batchID = batchID;
    }

    public int getProduced() {
        return produced;
    }

    public void setProduced(int produced) {
        this.produced = produced;
    }

    public int getAccepted() {
        return accepted;
    }

    public void setAccepted(int accepted) {
        this.accepted = accepted;
    }

    public int getDefective() {
        return defective;
    }

    public void setDefective(int defective) {
        this.defective = defective;
    }

    public float getMachSpeed() {
        return machSpeed;
    }

    public void setMachSpeed(float machSpeed) {
        this.machSpeed = machSpeed;
    }

    public float getProductType() {
        return productType;
    }

    public void setProductType(float productType) {
        this.productType = productType;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}
