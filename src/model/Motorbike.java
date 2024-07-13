
package model;

public class Motorbike extends Vehicle {
    private int speedVehicle;
    private String license;
    private static final String MAKE_SOUND = "Tin tin tin";
    
    public Motorbike() {
        super();
    }

    public Motorbike(String idVehicle, String nameVehicle, String colorVehicle, double priceVehicle, String brandVehicle, int speedVehicle, String license) {
        super(idVehicle, nameVehicle, colorVehicle, priceVehicle, brandVehicle);
        this.speedVehicle = speedVehicle;
        setLicense(license);
    }

    
    public int getSpeedVehicle() {
        return speedVehicle;
    }

    public void setSpeedVehicle(int speedVehicle) {
        this.speedVehicle = speedVehicle;
    }

    public String getLicense() {
        return license;
    }

    public final void setLicense(String yn) {
        if(yn.equalsIgnoreCase("yes")) this.license = "require license";
        else if(yn.equalsIgnoreCase("no")) this.license = "not require";
    }

    @Override
    public String toString() {
        return "MOTORBIKE" + super.toString() + "(speedVehicle:" + speedVehicle + ",license:" + license +",Sound:"+MAKE_SOUND+ ')';
    }
    
    
    
}
