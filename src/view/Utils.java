package view;

import java.text.ParseException;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class Utils {
    private final String ID_VALID = "^[BC]\\d{4}$";
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
    public String getId(String s){
        while(true){
            System.out.println(s);
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
            System.out.println(s);
            res = sc.nextLine();
            if(!res.isEmpty()) break;
        }     
        return res;
    }
    public double getPrice(String s){
        while(true){
            try {
                System.out.println(s);
                double res = Double.parseDouble(sc.nextLine());
                return res;
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    
    public String getYesNo(String s){
        while (true) {
            System.out.println(s);
            String res = checkString();
            if(res.equalsIgnoreCase("yes")) return "yes";
            else if (res.equalsIgnoreCase("no")) return "no";
            else  System.out.println("Must be enter yes or no: ");
        }
    }
    
    public Year getYear(String s) throws ParseException{
        while(true){
            System.out.println(s);
            String str = checkString();
            try {
                DateTimeFormatter format =  DateTimeFormatter.ofPattern("yyyy");
                return Year.parse(str, format);
            } catch (DateTimeParseException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String checkID(String s){
        if(s.matches(ID_VALID))
            return s;
        else return null;
    }
    public <O> void displayAll(List<O> L) {
            System.out.println("List of ...." );
            System.out.printf("%-15s | %-20s | %-15s | %-15s | %-15s \n","", "","","","");
            System.out.println("---------------------");
            for (O obj : L) {
                System.out.println(obj);
            }
            System.out.println("---------------------");
            System.out.println("Total : " + L.size() + " ...");
        
    }
}