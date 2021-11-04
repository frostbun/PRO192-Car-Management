import java.util.List;
import java.util.LinkedList;

public class Brand implements Comparable<Brand> {

    private String id;
    private String name;
    private String sound;
    private double price;
    private List<Car> carList;

    public Brand(String id, String name, String sound, double price) {
        this.id = id;
        this.name = name;
        this.sound = sound;
        this.price = price;
        this.carList = new LinkedList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSound() {
        return sound;
    }

    public double getPrice() {
        return price;
    }
    
    public List<Car> getCar() {
        return carList;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void addCar(Car c) {
        carList.add(c);
    }

    public void removeCar(Car c) {
        carList.remove(c);
    }

    public String toString() {
        return String.format("%s, %s, %s: %.3f", getId(), getName(), getSound(), getPrice());
    }

    public int compareTo(Brand other) {
        return this.getName().compareTo(other.getName());
    }
}
