import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Collections;

public class BrandList {

    private List<Brand> brandList;
    private String brandFile;
    private String carFile;

    public BrandList(String brandFile, String carFile) {
        brandList = new ArrayList<>();
        this.brandFile = brandFile;
        this.carFile = carFile;
        loadBrand();
        loadCar();
    }

    public boolean addBrand(String id, String name, String sound, double price) {
        if(getBrandById(id) != null) {
            return false;
        }
        brandList.add(new Brand(id, name, sound, price));
        return true;
    }

    public boolean addCar(String id, String brandId, String color, String frameId, String engineId) {
        Brand brand = getBrandById(brandId);
        if(brand == null || getCarById(id) != null || getCarByFrameId(frameId) != null || getCarByEngineId(engineId) != null) {
            return false;
        }
        brand.addCar(new Car(id, brand, color, frameId, engineId));
        return true;
    }

    public boolean updateBrand(String id, String name, String sound, double price) {
        Brand brand = getBrandById(id);
        if(brand == null) {
            return false;
        }
        brand.setName(name);
        brand.setSound(sound);
        brand.setPrice(price);
        return true;
    }

    public boolean updateCar(String id, String brandId, String color, String frameId, String engineId) {
        Brand brand = getBrandById(brandId);
        Car car = getCarById(id);
        if(brand == null || car == null || getCarByFrameId(frameId) != car || getCarByEngineId(engineId) != car) {
            return false;
        }
        car.setBrand(brand);
        car.setColor(color);
        car.setFrameId(frameId);
        car.setEngineId(engineId);
        return true;
    }

    public boolean removeCar(String id) {
        Car car = getCarById(id);
        if(car == null) {
            return false;
        }
        car.getBrand().getCar().remove(car);
        return true;
    }

    public Brand getBrandById(String id) {
        for(Brand brand: brandList) {
            if(brand.getId().equalsIgnoreCase(id)) {
                return brand;
            }
        }
        return null;
    }

    public Car getCarById(String id) {
        for(Brand brand: brandList) {
            for(Car car: brand.getCar()) {
                if(car.getId().equalsIgnoreCase(id)) {
                    return car;
                }
            }
        }
        return null;
    }

    public Car getCarByFrameId(String id) {
        for(Brand brand: brandList) {
            for(Car car: brand.getCar()) {
                if(car.getFrameId().equalsIgnoreCase(id)) {
                    return car;
                }
            }
        }
        return null;
    }

    public Car getCarByEngineId(String id) {
        for(Brand brand: brandList) {
            for(Car car: brand.getCar()) {
                if(car.getEngineId().equalsIgnoreCase(id)) {
                    return car;
                }
            }
        }
        return null;
    }

    public List<Car> getCarsByBrandName(String name) {
        List<Car> ret = new LinkedList<>();
        for(Brand brand: brandList) {
            if(brand.getName().toLowerCase().contains(name.toLowerCase())) {
                ret.addAll(brand.getCar());
            }
        }
        return ret;
    }

    public void loadBrand() {
        try {
            new File(brandFile).createNewFile();
            BufferedReader reader = new BufferedReader(new FileReader(brandFile));
            String line;
            while((line = reader.readLine()) != null) {
                String[] param = line.split("[,:] ");
                addBrand(param[0], param[1], param[2], Double.parseDouble(param[3]));
            }
            reader.close();
        }
        catch(Exception e) {}
    }

    public void loadCar() {
        try {
            new File(carFile).createNewFile();
            BufferedReader reader = new BufferedReader(new FileReader(carFile));
            String line;
            while((line = reader.readLine()) != null) {
                String[] param = line.split(", ");
                addCar(param[0], param[1], param[2], param[3], param[4]);
            }
            reader.close();
        }
        catch(Exception e) {}
    }

    public boolean saveBrand() {
        try {
            FileWriter writer = new FileWriter(brandFile);
            for(Brand brand: getBrand()) {
                writer.write(brand.toString() + '\n');
            }
            writer.close();
            return true;
        }
        catch(Exception e) {
            return false;
        }
    }

    public boolean saveCar() {
        try {
            FileWriter writer = new FileWriter(carFile);
            for(Car car: getCar()) {
                writer.write(car.toString() + '\n');
            }
            writer.close();
            return true;
        }
        catch(Exception e) {
            return false;
        }
    }

    public void sort() {
        Collections.sort(brandList);
    }

    public List<Brand> getBrand() {
        return brandList;
    }

    public List<Car> getCar() {
        List<Car> ret = new LinkedList<>();
        for(Brand brand: brandList) {
            ret.addAll(brand.getCar());
        }
        return ret;
    }
}
