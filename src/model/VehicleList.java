
package model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class VehicleList {
    ArrayList<Vehicle> list;

    public VehicleList() {
        list = new ArrayList<>();
    }

    public ArrayList<Vehicle> getList() {
        return list;
    }
    public void storeDataToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("vehicles.txt"))) {
            for (Vehicle vehicle : list) {
                writer.write(vehicle.toString());
                writer.newLine();
            }
            System.out.println("Data has been written to vehicles.txt successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }
    public void displayAll(List<Vehicle> L) {
            System.out.println("List of Vehicle" );
            System.out.printf("%-20s | %-20s | %-20s | %-20s | %-20s | %-20s \n","Type", "ID", "Name","Color","Price","Brand");
            System.out.println("---------------------");
            for (Vehicle vi : L) {
                if(vi instanceof Car)
                System.out.println(vi.toString());
                else if(vi instanceof Motorbike){
                    System.out.println(vi.toString());
                } else System.out.println(vi);
            }
            System.out.println("---------------------");
            System.out.println("Total : " + L.size() + " vehicle");
        
    }
    public void sortByPrice(){
        list.sort((o1,o2)->Double.compare(o2.getPriceVehicle(), o1.getPriceVehicle()));
    }
}
