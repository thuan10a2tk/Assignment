
package model;

public class Vehicle {
    private String idVehicle;
    private String nameVehicle;
    private String colorVehicle;
    private double priceVehicle;
    private String brandVehicle;
    
    public Vehicle() {
    }

    public Vehicle(String idVehicle, String nameVehicle, String colorVehicle, double priceVehicle, String brandVehicle) {
        setIdVehicle(idVehicle);
        this.nameVehicle = nameVehicle;
        this.colorVehicle = colorVehicle;
        this.priceVehicle = priceVehicle;
        this.brandVehicle = brandVehicle;
    }
    
    public String getIdVehicle() {
        return idVehicle;
    }

    public final void setIdVehicle(String idVehicle) {
        if(idVehicle.matches("^[CB]\\d{4}$")) this.idVehicle = idVehicle;
        else this.idVehicle = null;
    }
    public String getNameVehicle() {
        return nameVehicle;
    }

    public void setNameVehicle(String nameVehicle) {
        this.nameVehicle = nameVehicle;
    }

    public String getColorVehicle() {
        return colorVehicle;
    }

    public void setColorVehicle(String colorVehicle) {
        this.colorVehicle = colorVehicle;
    }

    public String getBrandVehicle() {
        return brandVehicle;
    }

    public void setBrandVehicle(String brandVehicle) {
        this.brandVehicle = brandVehicle;
    }

    public double getPriceVehicle() {
        return priceVehicle;
    }

    public void setPriceVehicle(double priceVehicle) {
        this.priceVehicle = priceVehicle;
    }

    @Override
    public String toString() {
        return String.format("%-20s | %-20s | %-20s | %-20.2f | %-20s ", this.idVehicle,
                this.nameVehicle, this.colorVehicle, this.priceVehicle, this.brandVehicle);
    }
    
    
    
    
}
