
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
        this.idVehicle = idVehicle;
        this.nameVehicle = nameVehicle;
        this.colorVehicle = colorVehicle;
        this.priceVehicle = priceVehicle;
        this.brandVehicle = brandVehicle;
    }

   

    public String getIdVehicle() {
        return idVehicle;
    }

    public void setIdVehicle(String idVehicle) {
        this.idVehicle = idVehicle;
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
        return "Vehicle{" + "idVehicle=" + idVehicle + ", nameVehicle=" + nameVehicle + ", colorVehicle=" + colorVehicle + ", priceVehicle=" + priceVehicle + ", brandVehicle=" + brandVehicle + '}';
    }
    
    
    
    
}
