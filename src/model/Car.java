
package model;

import java.text.SimpleDateFormat;
import java.time.Year;
import java.time.format.DateTimeFormatter;

public class Car extends Vehicle{
    private String typeVehicle;
    private Year yearOfManufacture;

    public Car() {
        super();
    }

    
    public Car(String idVehicle, String nameVehicle, String colorVehicle, double priceVehicle, String brandVehicle, String typeVehicle, String yearOfManufacture) {
        super(idVehicle, nameVehicle, colorVehicle, priceVehicle, brandVehicle);
        this.typeVehicle = typeVehicle;
        setYearOfManufacture(yearOfManufacture);
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

    public final void setYearOfManufacture(String yearOfManufacture){
        DateTimeFormatter time = DateTimeFormatter.ofPattern("yyyy");
        this.yearOfManufacture = Year.parse(yearOfManufacture, time);
    }

    @Override
    public String toString() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy");
        return "CAR" + super.toString() + "(Type:" + typeVehicle + ",YearofManufacture:" + format.format(yearOfManufacture) +')';
    }

    

    
}
