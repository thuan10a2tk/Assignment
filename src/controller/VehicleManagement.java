
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
        final String[] option={""};
        VehicleManagement vm = new VehicleManagement("", option);
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void storeDataToFile() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
