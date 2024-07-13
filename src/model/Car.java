
package model;

import java.time.Year;

public class Car extends Vehicle{
    private String typeVehicle;
    private Year yearOfManufacture;

    public Car() {
        super();
    }

    
    public Car(String idVehicle, String nameVehicle, String colorVehicle, double priceVehicle, String brandVehicle, String typeVehicle, Year yearOfManufacture) {
        super(idVehicle, nameVehicle, colorVehicle, priceVehicle, brandVehicle);
        this.typeVehicle = typeVehicle;
        this.yearOfManufacture = yearOfManufacture;
    }

    public String getTypeVehicle() {
        return typeVehicle;
    }

    public Year getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setTypeVehicle(String typeVehicle) {
        this.typeVehicle = typeVehicle;
    }

    public void setYearOfManufacture(Year yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    @Override
    public String toString() {
        return super.toString() + "Car{" + "typeVehicle=" + typeVehicle + ", yearOfManufacture=" + yearOfManufacture + '}';
    }

    

    
}
