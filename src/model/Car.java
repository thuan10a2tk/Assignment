
package model;

import java.time.Year;

public class Car extends Vehicle{
    private String typeVehicle;
    private Year yearOfManufacture;

    public Car() {
        super();
    }

    
    public Car(String idVehicle, String nameVehicle, String colorVehicle, double priceVehicle, String brandVehicle, String typeVehicle, int yearOfManufacture) {
        super(idVehicle, nameVehicle, colorVehicle, priceVehicle, brandVehicle);
        this.typeVehicle = typeVehicle;
        setYearOfManufacture(yearOfManufacture);
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

    public final void setYearOfManufacture(int yearOfManufacture){
        try {
         this.yearOfManufacture = Year.of(yearOfManufacture);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "CAR                  |" + super.toString() +"| "+ "(Type:" + typeVehicle + ",YearofManufacture:" + yearOfManufacture.getValue() +')';
    }

    

    
}
