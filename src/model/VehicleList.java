
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

public class VehicleList {
    ArrayList<Vehicle> list;

    public VehicleList() {
        list = new ArrayList<>();
        loadDataFromFile("vehicle.txt");
    }

    public ArrayList<Vehicle> getList() {
        return list;
        
    }
    private void loadDataFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 7) {
                    int id = Integer.parseInt(data[0]);
                    String name = data[1];
                    String color = data[2];
                    double price = Double.parseDouble(data[3]);
                    String brand = data[4];
                    String type = data[5];
                    int yearOfManufacture = Integer.parseInt(data[6]);

                    // Create and add a new Car to the list
                    Car car = new Car(Integer.toString(id), name, color, price, brand, type, Year.of(yearOfManufacture));
                    list.add(car);
                } else if (data.length >= 8) {
                    int id = Integer.parseInt(data[0]);
                    String name = data[1];
                    String color = data[2];
                    double price = Double.parseDouble(data[3]);
                    String brand = data[4];
                    int speed = Integer.parseInt(data[5]);
                    String license = data[6];

                    // Create and add a new Motorbike to the list
                    Motorbike motorbike = new Motorbike(Integer.toString(id), name, color, price, brand, speed, license);
                    list.add(motorbike);
                }
            }
            System.out.println("Data loaded successfully from file.");
        } catch (IOException e) {
            System.out.println("Error loading data from file: " + e.getMessage());
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
    
    public List<Vehicle> searchByLambda(Predicate<Vehicle> ve){
        return list.stream().filter(ve).collect(Collectors.toList());
    }
    public List<Vehicle> sortByName(List<Vehicle>li ){
        li.sort((o1,o2)->o2.getNameVehicle().compareTo(o1.getNameVehicle()));
        return li;
    }
}
