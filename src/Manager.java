import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;

public class Manager {

    public static void main(String[] args) {

        String title = "==========================Car=Manager===========================";
        List<String> option = new ArrayList<>();
        option.add("Exit");
        option.add("List all Brands");
        option.add("Add a Brand");
        option.add("Search Brand by Id");
        option.add("Update Brand by Id");
        option.add("Save Brands");
        option.add("List all Cars");
        option.add("Search Cars by Brand Name");
        option.add("Add a Car");
        option.add("Remove a Car by Id");
        option.add("Update a Car by Id");
        option.add("Save Cars");

        int choice;
        BrandList list = new BrandList("brands.txt", "cars.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while((choice = Menu.getChoice(reader, title, option)) != 0) {
            System.out.println("================================================================");
            if(choice == 1) {
                list.sort();
                List<Brand> brandList = list.getBrand();
                for(Brand brand:brandList) {
                    System.out.println(brand);
                }
                if(brandList.isEmpty()) {
                    System.out.println("Empty!");
                }
            }
            if(choice == 2) {
                String id = Menu.getString(reader, "Brand Id: ");
                String name = Menu.getString(reader, "Brand Name: ");
                String sound = Menu.getString(reader, "Sound Brand: ");
                double price = Menu.getDouble(reader, "Price: ", 0, Double.MAX_VALUE);
                if(list.addBrand(id, name, sound, price)) {
                    System.out.println("Brand added!");
                }
                else {
                    System.out.println("Brand Id existed!");
                }
            }
            if(choice == 3) {
                Brand brand = list.getBrandById(Menu.getString(reader, "Brand Id: "));
                if(brand != null) {
                    System.out.println(brand);
                }
                else {
                    System.out.println("Brand Id not exist!");
                }
            }
            if(choice == 4) {
                String id = Menu.getString(reader, "Brand Id: ");
                String name = Menu.getString(reader, "Brand Name: ");
                String sound = Menu.getString(reader, "Sound Brand: ");
                double price = Menu.getDouble(reader, "Price: ", 0, Double.MAX_VALUE);
                if(list.updateBrand(id, name, sound, price)) {
                    System.out.println("Brand updated!");
                }
                else {
                    System.out.println("Brand Id not exist!");
                }
            }
            if(choice == 5) {
                if(list.saveBrand()) {
                    System.out.println("Brands saved!");
                }
                else {
                    System.out.println("There was an error saving Brands!");
                }
            }
            if(choice == 6) {
                list.sort();
                List<Car> carList = list.getCar();
                for(Car car:carList) {
                    System.out.println(car);
                }
                if(carList.isEmpty()) {
                    System.out.println("Empty!");
                }
            }
            if(choice == 7) {
                List<Car> carList = list.getCarsByBrandName(Menu.getString(reader, "Brand Name: "));
                for(Car car:carList) {
                    System.out.println(car);
                }
                if(carList.isEmpty()) {
                    System.out.println("Brand Name not exist!");
                }
            }
            if(choice == 8) {
                String id = Menu.getString(reader, "Car Id: ");
                String brandId = Menu.getString(reader, "Brand Id: ");
                String color = Menu.getString(reader, "Color: ");
                String frameId = Menu.getPattern(reader, "Frame Id (F00000): ", "^F\\d{5}$");
                String engineId = Menu.getPattern(reader, "Engine Id (E00000): ", "^E\\d{5}$");
                if(list.addCar(id, brandId, color, frameId, engineId)) {
                    System.out.println("Car added!");
                }
                else {
                    System.out.println("Car Id, Frame Id, Engine Id existed or Brand Id not exist!");
                }
            }
            if(choice == 9) {
                String id = Menu.getString(reader, "Car Id: ");
                if(list.removeCar(id)) {
                    System.out.println("Car removed!");
                }
                else {
                    System.out.println("Car Id not exist!");
                }
            }
            if(choice == 10) {
                String id = Menu.getString(reader, "Car Id: ");
                String brandId = Menu.getString(reader, "Brand Id: ");
                String color = Menu.getString(reader, "Color: ");
                String frameId = Menu.getPattern(reader, "Frame Id (F00000): ", "^F\\d{5}$");
                String engineId = Menu.getPattern(reader, "Engine Id (E00000): ", "^E\\d{5}$");
                if(list.updateCar(id, brandId, color, frameId, engineId)) {
                    System.out.println("Car updated!");
                }
                else {
                    System.out.println("Car Id, Brand Id not exist or Frame Id, Engine Id existed!");
                }
            }
            if(choice == 11) {
                if(list.saveCar()) {
                    System.out.println("Cars saved!");
                }
                else {
                    System.out.println("There was an error saving Cars!");
                }
            }
            System.out.println("================================================================");
            try {
                reader.readLine();
            }
            catch(Exception e) {}
        }

        System.out.println("Bye!");
        try {
            reader.close();
        }
        catch(Exception e) {}
    }
}
