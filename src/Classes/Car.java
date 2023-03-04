package Classes;

public class Car {
    private Boolean cool = null;

    public void setCool(Boolean cool) {
        this.cool = cool;
    }
    @Override
    public String toString() {
        return String.valueOf(cool);
    }
    public Car(Boolean cool) {
        setCool(cool);
    }
    public Boolean getCool() {
        return cool;
    }
}
