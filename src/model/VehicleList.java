
package model;

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
        list.sort((o1,o2)->Double.compare(o1.getPriceVehicle(), o2.getPriceVehicle()));
    }
}
