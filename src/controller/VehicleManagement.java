
package controller;

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
            case 7: searchVehicle(); break;
            default: System.exit(0);
        }
    }

    @Override
    public void loadFromFile() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void addNewVehicle() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void updateVehicle() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteVehicle() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void searchVehicle() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void showVehicle() {
        final String[] option = {
            "Show all",
            "Show all by decending by price"
        };
        Menu<String> menu = new Menu<String>(title, option) {
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
