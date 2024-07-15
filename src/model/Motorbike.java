
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
    public String getYesNo(){
        if(this.license.equals("require license")) return "yes";
        else return "no";
    }
    public void updateSpeed(String speed){
        try {
            if(!speed.equals("")) this.speedVehicle = Integer.parseInt(speed);
        } catch (NumberFormatException e) {
        }
    }
    public void updateLicense(String yn){
        if(!yn.equals("")){
            if(yn.equalsIgnoreCase("yes")) this.license = "require license";
            else if(yn.equalsIgnoreCase("no")) this.license = "not require";
        }
    }
    @Override
    public String toString() {
        return "MOTORBIKE            |" + super.toString()+"| " + "(speedVehicle:" + speedVehicle + ",license:" + license +",Sound:"+MAKE_SOUND+ ')';
    }
    
    
    
}
