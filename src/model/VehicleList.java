
package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import view.Utils;

public class VehicleList {
    ArrayList<Vehicle> list;

    public VehicleList() {
        list = new ArrayList<>();
        
    }

    public ArrayList<Vehicle> getList() {
        return list;
        
    }
    public void loadDataFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    String[] part = line.split(",");
                if(Utils.checkID(part[0])== null | !searchByLambda(ve->ve.getIdVehicle().equals(part[0])).isEmpty())  throw new Exception("Id invalid or Id existed!");
                else if(part[0].matches("^C\\d{3}$")){
                    Car car = new Car(part[0], part[1], part[2], Double.parseDouble(part[3]), part[4], part[5], Integer.parseInt(part[6]));
                    list.add(car);
                } else {
                    Motorbike motorbike = new Motorbike(part[0],part[1],part[2],Double.parseDouble(part[3]),part[4],Integer.parseInt( part[5]),part[6]);
                    list.add(motorbike);
                }
                } catch (Exception e) {
                }
            }
        } catch (IOException e) {
        }
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
            System.out.printf("%-20s | %-20s | %-25s | %-20s | %-20s | %-20s | %-20s \n","Type", "ID", "Name","Color","Price","Brand","Private attribute");
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
    
    public List<Vehicle> searchByLambda(Predicate<Vehicle> ve){
        return list.stream().filter(ve).collect(Collectors.toList());
    }
    public List<Vehicle> sortByName(List<Vehicle>li ){
        li.sort((o1,o2)->o2.getNameVehicle().compareTo(o1.getNameVehicle()));
        return li;
    }
    public void addNewCar(Car e){
        list.add(e);
    }
    public void addNewMotorbike(Motorbike e){
        list.add(e);
    }
}
