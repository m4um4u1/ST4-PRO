package dk.sdu.mmmi.semproject.backend.model;

public class Batch {

    private Long id;
    private Float amount;
    private Float machSpeed;
    private Float productType;

    public Batch() {}

    public Batch(Long id, Float amount, Float machSpeed, Float productType) {
        this.id = id;
        this.amount = amount;
        this.machSpeed = machSpeed;
        this.productType = productType;
    }

    public Float getMachSpeed() {
        return machSpeed;
    }

    public void setMachSpeed(Float machSpeed) {
        this.machSpeed = machSpeed;
    }

    public Float getProductType() {
        return productType;
    }

    public void setProductType(Float productType) {
        this.productType = productType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }
}
