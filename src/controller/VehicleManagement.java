
package controller;

import java.time.Year;
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
            case 1 -> loadFromFile();
            case 2 -> addNewVehicle();
            case 3 -> updateVehicle();
            case 4 -> deleteVehicle();
            case 5 -> searchVehicle();
            case 6 -> deleteVehicle();
            case 7 -> storeDataToFile();
            default -> System.exit(0);
        }
    }

    @Override
    public void loadFromFile() {
        vl.loadDataFromFile("vehicles.txt");
        vl.displayAll(vl.getList());
    }

    @Override
    public void addNewVehicle() {
        final String[] opion = {
            "Add Car",
            "Add Motorbike"
        };
        Menu<String> menu = new Menu<String>("Add Vehicle", opion) {
            @Override
            public void execute(int n) {
                switch (n) {
                    case 1 -> {
                        String id = utils.getId("Enter car ID (C000): ");
                        if(id.matches("^C\\d{3}$")&&!vl.searchByLambda(ve->ve.getIdVehicle().equals(id)).isEmpty())
                            System.out.println("ID exist!");
                        String name = utils.getName("Enter name of car: ");
                        String color = utils.getName("Enter color of car: ");
                        double price = utils.getPrice("Enter price of car: ");
                        String brand = utils.getName("Enter brand of car: ");
                        String type = utils.getName("Enter type of car: ");
                        Year year = utils.getYear("Enter year of manufacture: ");
                        vl.addNewCar(new Car(id, name, color, price, brand, type, year));
                    }
                        
                    case 2 -> { 
                        String id1 = utils.getId("Enter car ID (C000): ");
                        if(id1.matches("^B\\d{3}$")&&!vl.searchByLambda(ve->ve.getIdVehicle().equals(id1)).isEmpty())
                            System.out.println("ID exist!");
                        String name1 = utils.getName("Enter name of motorbike: ");
                        String color1 = utils.getName("Enter color of motorbike: ");
                        double price1 = utils.getPrice("Enter price of motorbike: ");
                        String brand1 = utils.getName("Enter brand of motorbike: ");
                        int speed = utils.getSpeed("Enter speed of motorbike: ");
                        String license = utils.getYesNo("Enter licence require(yes/no): ");
                        vl.addNewMotorbike(new Motorbike(id1, name1, color1, price1, brand1, speed, license));
                    }
                }
            }
        };
        menu.run();
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
        
        vehicle.updateName(utils.getString("Enter new name (current: " + vehicle.getNameVehicle() + "): "));
        vehicle.updateColor(utils.getString("Enter new color (current: " + vehicle.getColorVehicle() + "): "));
        vehicle.updatePrice(utils.getString("Enter new price (current: " + vehicle.getPriceVehicle() + "): "));
        vehicle.updateBrand(utils.getString("Enter new brand (current: " + vehicle.getBrandVehicle() + "): "));
        
        if(vehicle instanceof Car car) {
            car.updateType(utils.getString("Enter new type (current: " + car.getTypeVehicle() + "): "));
            car.updateYear(utils.getString("Enter new year of manufacture (current: " + car.getYearOfManufacture().getValue() + "): "));
        }
        if (vehicle instanceof Motorbike motorbike) {
            motorbike.updateSpeed("Enter new speed (current: " + motorbike.getSpeedVehicle() + "): ");
            motorbike.updateLicense("Enter new license requirement (current: " + motorbike.getLicense() + "): ");
        }

        System.out.println("Vehicle updated successfully.");
    }

     @Override
    public void deleteVehicle() {
        String id = utils.getId("Enter the vehicle ID to delete: ");
        Vehicle vehicle = vl.getList().stream().filter(v -> v.getIdVehicle().equals(id)).findFirst().orElse(null);
        
        if (vehicle == null) {
            System.out.println("Vehicle does not exist.");
            return;
        }
        
        String confirmation = utils.getYesNo("Are you sure you want to delete this vehicle? (yes/no): ");
        
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
                    case 1 -> {
                        String name = utils.getName("Enter name: ");
                        vl.displayAll(vl.sortByName(vl.searchByLambda(ve->ve.getNameVehicle().contains(name))));
                    }
                    case 2 -> {
                        String id = utils.getId("Enter id: ");
                        vl.displayAll(vl.searchByLambda(ve->ve.getIdVehicle().equals(id)));
                    }
                    default -> {
                    }
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
                    case 1 -> vl.displayAll(vl.getList());
                    case 2 -> {
                        vl.sortByPrice();
                        vl.displayAll(vl.getList());
                    }
                    default -> {
                    }
                }
            }
        };
        menu.run();
    }

    @Override
    public void storeDataToFile() {
        vl.storeDataToFile("vehicles.txt");
    }
    
}
