
package controller;

import java.text.ParseException;
import java.util.Scanner;
import model.Car;
import model.Motorbike;
import model.Vehicle;
import model.VehicleList;
import view.Menu;
import view.Utils;

public class VehicleManagement extends Menu<String> implements I_FunctionList{
    
    VehicleList vl = new VehicleList();
    Utils utils = new Utils();
    
    public VehicleManagement(String td, String[] mc) {
        super(td, mc);
    }
    
    public static void main(String[] args) {
        final String[] option={"Load all data from file","Add new vehicle",
            "Update vehicle","Delete vehicle","Search vehicle",
            "Show vehicle list","Store data to file","Quit app"
        };
        VehicleManagement vm = new VehicleManagement("VEHICLE MANAGEMENT APP", option);
        vm.run();
    }
    
    @Override
    public void execute(int n) {
        switch (n) {
            case 1: loadFromFile(); break;
            case 2: addNewVehicle(); break;
            case 3: updateVehicle(); break;
            case 4: deleteVehicle(); break;
            case 5: searchVehicle(); break;
            case 6: deleteVehicle(); break;
            case 7: storeDataToFile(); break;
            default: System.exit(0);
        }
    }

    @Override
    public void loadFromFile() {
        vl.displayAll(vl.getList());
    }

    @Override
    public void addNewVehicle() {
        System.out.println("Choose vehicle type: 1. Car 2. Motorbike");
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.print("Enter your choice (1 or 2): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next(); // Đọc và loại bỏ giá trị không phù hợp
            }
            choice = scanner.nextInt();
        } while (choice < 1 || choice > 2);
        if (choice == 1) {
            Car car = new Car();
            System.out.print("Enter car ID (C000): ");
            String id = utils.checkString();
            if (!id.matches(id) || vl.getList().stream().anyMatch(b -> b.getIdVehicle().equals(id))) {
                System.out.println("The car with this ID already exists.");
                return;
            }
            car.setIdVehicle(id);
            System.out.print("Enter car name: ");
            car.setNameVehicle(utils.checkString());
            System.out.print("Enter car color: ");

            car.setColorVehicle(utils.checkString());
            car.setPriceVehicle(utils.getPrice("Enter car price: "));
            System.out.print("Enter the brand: ");

            car.setBrandVehicle(utils.checkString());
            System.out.print("Enter car type: ");

            car.setTypeVehicle(utils.checkString());
            try {
                car.setYearOfManufacture(utils.getYear("Enter car year of manufacture (yyyy): ").toString());
            } catch (ParseException ex) {
                System.out.println(ex.getMessage());
            }
            vl.getList().add(car);
            System.out.println("New car added successfully.");
        } else {
            Motorbike motorbike = new Motorbike();
            System.out.print("Enter car ID (B000): ");
            String id = utils.checkString();
            if (!id.matches(id) || vl.getList().stream().anyMatch(b -> b.getIdVehicle().equals(id))) {
                System.out.println("The motorbike with this ID already exists.");
                return;
            }
            motorbike.setIdVehicle(id);
            System.out.print("Enter motorbike name: ");

            motorbike.setNameVehicle(utils.checkString());
            System.out.print("Enter motorbike color: ");

            motorbike.setColorVehicle(utils.checkString());
            motorbike.setPriceVehicle(utils.getPrice("Enter motorbike price: "));
            System.out.print("Enter motorbike brand: ");

            motorbike.setBrandVehicle(utils.checkString());
            motorbike.setSpeedVehicle(utils.getSpeed("Enter motorbike speed (km/h) : "));
            motorbike.setLicense(utils.getYesNo("Require license (yes/no): "));
            vl.getList().add(motorbike);
            System.out.println("New motorbike added successfully.");
        }
    }


    @Override
    public void updateVehicle() {
        String id = utils.getId("Enter the vehicle ID to update: ");
        Vehicle vehicle = vl.getList().stream().filter(v -> v.getIdVehicle().equals(id)).findFirst().orElse(null);
        
        if (vehicle == null) {
            System.out.println("Vehicle does not exist.");
            return;
        }

        System.out.println("Leave blank to keep current value.");
        
        String name = utils.getName("Enter new name (current: " + vehicle.getNameVehicle() + "): ");
        if (!name.isEmpty()) vehicle.setNameVehicle(name);
        
        String color = utils.getName("Enter new color (current: " + vehicle.getColorVehicle() + "): ");
        if (!color.isEmpty()) vehicle.setColorVehicle(color);
        
        String priceStr = utils.getName("Enter new price (current: " + vehicle.getPriceVehicle() + "): ");
        if (!priceStr.isEmpty()) vehicle.setPriceVehicle(Double.parseDouble(priceStr));
        
        String brand = utils.getName("Enter new brand (current: " + vehicle.getBrandVehicle() + "): ");
        if (!brand.isEmpty()) vehicle.setBrandVehicle(brand);
        
        // Handle specific fields for Car and Motorbike if needed
        if(vehicle instanceof Car) {
            Car car = (Car) vehicle;
            String type = utils.getName("Enter new type (current: " + car.getTypeVehicle() + "): ");
            if (!type.isEmpty()) car.setTypeVehicle(type);

            String year = utils.getName("Enter new year of manufacture (current: " + car.getYearOfManufacture() + "): ");
            if (!year.isEmpty()) car.setYearOfManufacture(year);
        }else if (vehicle instanceof Motorbike) {
            Motorbike motorbike = (Motorbike) vehicle;
            System.out.print("Enter new speed (current: " + motorbike.getSpeedVehicle() + "): ");
            String speedStr = utils.checkString();
            if (!speedStr.isEmpty()) motorbike.setSpeedVehicle(Integer.parseInt(speedStr));
            
            System.out.print("Enter new license requirement (current: " + motorbike.getLicense() + "): ");
            String license = utils.getYesNo("");
            if (!license.isEmpty()) motorbike.setLicense(license);
        }

        System.out.println("Vehicle updated successfully.");
    }

     @Override
    public void deleteVehicle() {
        System.out.print("Enter the vehicle ID to delete: ");
        String id = utils.checkString();
        Vehicle vehicle = vl.getList().stream().filter(v -> v.getIdVehicle().equals(id)).findFirst().orElse(null);
        
        if (vehicle == null) {
            System.out.println("Vehicle does not exist.");
            return;
        }
        
        System.out.print("Are you sure you want to delete this vehicle? (yes/no): ");
        String confirmation = utils.getYesNo("");
        
        if (confirmation.equalsIgnoreCase("yes")) {
            vl.getList().remove(vehicle);
            System.out.println("Vehicle deleted successfully.");
        } else {
            System.out.println("Delete operation cancelled.");
        }
    }

     @Override
    public void searchVehicle() {
        final String[] option1 = {
            "Search by name",
            "Search by id"
        };
        Menu<String> menu = new Menu<String>("Search vehicle", option1) {
            @Override
            public void execute(int n) {
                switch (n) {
                    case 1:
                        String name = utils.getName("Enter name: ");
                        utils.displayAll(vl.sortByName(vl.searchByLambda(ve->ve.getNameVehicle().contains(name))));
                        break;
                    case 2:
                        String id = utils.getId("Enter id: ");
                        utils.displayAll(vl.searchByLambda(ve->ve.getIdVehicle().equals(id)));
                        break;
                    default:   break;
                }
            }
        };
        menu.run();
    }

    @Override
    public void showVehicle() {
        final String[] option = {
            "Show all",
            "Show all by decending by price"
        };
        Menu<String> menu = new Menu<String>("Show vehicle list", option) {
            @Override
            public void execute(int n) {
                switch (n) {
                    case 1:
                        vl.displayAll(vl.getList());
                        break;
                    case 2:
                        vl.sortByPrice();
                        vl.displayAll(vl.getList());
                        break;
                    default:   break;
                }
            }
        };
        menu.run();
    }

    @Override
    public void storeDataToFile() {
        vl.storeDataToFile();
    }
    
}
