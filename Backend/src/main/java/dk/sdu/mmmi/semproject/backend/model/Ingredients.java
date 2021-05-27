package dk.sdu.mmmi.semproject.backend.model;

public class Ingredients {

    private float barley;
    private float hops;
    private float malt;
    private float wheat;
    private float yeast;

    public Ingredients() {
    }

    public Ingredients(float barley, float hops, float malt, float wheat, float yeast) {
        this.barley = barley;
        this.hops = hops;
        this.malt = malt;
        this.wheat = wheat;
        this.yeast = yeast;
    }

    public float getBarley() {
        return barley;
    }

    public void setBarley(float barley) {
        this.barley = barley;
    }

    public float getHops() {
        return hops;
    }

    public void setHops(float hops) {
        this.hops = hops;
    }

    public float getMalt() {
        return malt;
    }

    public void setMalt(float malt) {
        this.malt = malt;
    }

    public float getWheat() {
        return wheat;
    }

    public void setWheat(float wheat) {
        this.wheat = wheat;
    }

    public float getYeast() {
        return yeast;
    }

    public void setYeast(float yeast) {
        this.yeast = yeast;
    }
}
