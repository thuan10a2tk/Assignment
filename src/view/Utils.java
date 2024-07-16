package view;

import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Utils {
    private static final String ID_VALID = "^[BC]\\d{3}$";
    Scanner sc;
    public Utils() {
       sc =  new Scanner(System.in);
    }
     public String checkString(){
        while(true){
            String str = sc.nextLine().trim();
            if(!str.isEmpty())
                return str;
        }
    }
    public String getString(String s){
        System.out.print(s);
        return sc.nextLine();
    }
    public String getId(String s){
        while(true){
            System.out.print(s);
            String res = checkString();
            if(res.matches(ID_VALID))
                return res;
            else{
                System.out.println("Please enter the correct ID(start with B or C and contains four character digit).");
            }
        }
    }
    
    public String getName(String s){
        String res="";
        while(true){
            System.out.print(s);
            res = sc.nextLine();
            if(!res.isEmpty()) break;
        }     
        return res;
    }
    public double getPrice(String s){
        while(true){
            try {
                System.out.print(s);
                double res = Double.parseDouble(sc.nextLine());
                return res;
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public int getSpeed(String s){
        while(true){
            try {
                System.out.print(s);
                int res = Integer.parseInt(sc.nextLine());
                if(res>0)
                return res;
                else System.out.println("Speed must be > 0! Enter again: ");
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    
    public String getYesNo(String s){
        while (true) {
            System.out.print(s);
            String res = checkString();
            if(res.equalsIgnoreCase("yes")) return "yes";
            else if (res.equalsIgnoreCase("no")) return "no";
            else  System.out.println("Must be enter yes or no: ");
        }
    }
    
    public Year getYear(String s) {
        while(true){
            System.out.print(s);
            String str = checkString();
            try {
                DateTimeFormatter format =  DateTimeFormatter.ofPattern("yyyy");
                return Year.parse(str, format);
            } catch (DateTimeParseException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static String checkID(String s){
        if(s.matches(ID_VALID))
            return s;
        else return null;
    }
}