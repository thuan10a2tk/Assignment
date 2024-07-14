
package controller;

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
        utils.displayAll(vl.getList());
    }

    @Override
    public void addNewVehicle() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void updateVehicle() {
        System.out.print("Enter the vehicle ID to update: ");
        String id = utils.checkString();
        Vehicle vehicle = vl.getList().stream().filter(v -> v.getIdVehicle().equals(id)).findFirst().orElse(null);
        
        if (vehicle == null) {
            System.out.println("Vehicle does not exist.");
            return;
        }

        System.out.println("Leave blank to keep current value.");
        System.out.print("Enter new name (current: " + vehicle.getNameVehicle() + "): ");
        String name = utils.checkString();
        if (!name.isEmpty()) vehicle.setNameVehicle(name);
        
        System.out.print("Enter new color (current: " + vehicle.getColorVehicle() + "): ");
        String color = utils.checkString();
        if (!color.isEmpty()) vehicle.setColorVehicle(color);
        
        System.out.print("Enter new price (current: " + vehicle.getPriceVehicle() + "): ");
        String priceStr = utils.checkString();
        if (!priceStr.isEmpty()) vehicle.setPriceVehicle(Double.parseDouble(priceStr));
        
        System.out.print("Enter new brand (current: " + vehicle.getBrandVehicle() + "): ");
        String brand = utils.checkString();
        if (!brand.isEmpty()) vehicle.setBrandVehicle(brand);
        
        // Handle specific fields for Car and Motorbike if needed
        if(vehicle instanceof Car) {
            Car car = (Car) vehicle;
            System.out.print("Enter new type (current: " + car.getTypeVehicle() + "): ");
            String type = utils.checkString();
            if (!type.isEmpty()) car.setTypeVehicle(type);

            System.out.print("Enter new year of manufacture (current: " + car.getYearOfManufacture() + "): ");
            String year = utils.checkString();
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
