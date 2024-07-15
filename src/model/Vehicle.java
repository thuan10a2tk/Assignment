
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
        if(idVehicle.matches("^[CB]\\d{3}$")) this.idVehicle = idVehicle;
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

    public void updatePrice(String priceVehicle) {
        if(!priceVehicle.equals(""))
        this.priceVehicle = Double.parseDouble(priceVehicle);
    }
    public void updateColor(String color) {
        if(!color.equals("")) this.colorVehicle = color;
    }
    public void updateBrand(String brandVehicle) {
        if(!brandVehicle.equals(""))
        this.brandVehicle = brandVehicle;
    }
    public void updateName(String name) {
        if(!name.equals(""))
        this.nameVehicle = name;
    }

    
    @Override
    public String toString() {
        return String.format(" %-20s | %-25s | %-20s | %-20.2f | %-20s ", this.idVehicle,
                this.nameVehicle, this.colorVehicle, this.priceVehicle, this.brandVehicle);
    }
    
    
    
    
}
