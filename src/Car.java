public class Car {

    private String id;
    private Brand brand;
    private String color;
    private String frameId;
    private String engineId;

    public Car(String id, Brand brand, String color, String frameId, String engineId) {
        this.id = id;
        this.brand = brand;
        this.color = color;
        this.frameId = frameId;
        this.engineId = engineId;
    }

    public String getId() {
        return id;
    }

    public Brand getBrand() {
        return brand;
    }

    public String getColor() {
        return color;
    }

    public String getFrameId() {
        return frameId;
    }

    public String getEngineId() {
        return engineId;
    }

    public void setBrand(Brand brand) {
        this.brand.removeCar(this);
        brand.addCar(this);
        this.brand = brand;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setFrameId(String frameId) {
        this.frameId = frameId;
    }

    public void setEngineId(String engineId) {
        this.engineId = engineId;
    }

    public String toString() {
        return String.format("%s, %s, %s, %s, %s", getId(), getBrand().getId(), getColor(), getFrameId(), getEngineId());
    }
}