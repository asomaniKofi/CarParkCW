/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carpark;
import java.util.*;
import java.text.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
/**
 *
 * @author Admin
 */
public class WestminsterCarParkManager implements CarParkManager{
protected int numObject = 20;
List <Vehicle> VList = new ArrayList<Vehicle>(numObject);
DateTime TimeObject = new DateTime();
DateTime VnT = new DateTime();
DateTime CRTime = new DateTime();
DateTime MBT = new DateTime();
Scanner sc = new Scanner(System.in);
Predicate<Vehicle> vh; //In order to remove vehicles based on ID, I used a predicate which returns whether an object has met the condtion defined using the lambda expression.
protected double cs,ms,vs= 0;
protected char vehicle,vhicle;  
public WestminsterCarParkManager(int listLength){
    this.numObject = listLength;
    VList = new ArrayList<Vehicle>(numObject);
}     
    @Override
    public void addVehicle(Vehicle v) {
     if (VList.size() < numObject){
      VList.add(v);
      }else{
     System.out.println("No more space in the lot, Either come back another time or patiently wait for a vehicle to leave");
    }
    } 
    @Override
    public void printVehicles() {
        Collections.sort(VList, new CustomComparator());
        Collections.reverseOrder(new CustomComparator()); //I called the collections .reverseOrder in order to order vehicles with the most recent vehicle appearing first in the console.
        for(int i=0; i< VList.size(); i++){
           System.out.println("Type: " + VList.get(i).getVehicle() + 
                   " \nID: " + VList.get(i).getID() + 
                   " \nBrand: " + VList.get(i).getBrand() + 
                   " \nTime of Entry: " + VList.get(i).getEntry());
       } 
    }
    @Override
    public void removeVehicles(){
        System.out.println("ID:");
        String ID = sc.next();
        vh = (q-> q.getID().equals((ID))); //Lambda expression used to define my condition
        removeSelected(VList, vh);
    }
    public void findVehiclebyDate(){
        System.out.println("Day: ");
        int Day = sc.nextInt();
        System.out.println("Month: ");
        int Month = sc.nextInt();
        System.out.println("Year");
        int Year = sc.nextInt();
        String Date = Integer.toString(Day) + "/" + Integer.toString(Month)+ "/"+Integer.toString(Year);
        vh = (d ->d.getDateTime().equals(Date));
        findByDate(VList, vh);
        
    }
    @Override
    public void statistics(){
        /*The variables cs,ms & vs are incremented after each vehicle is added.
        Once this method is called the numbers above are divided by 20 and multiplied by 100 to attain the percentage
        of each vehicle inside the carpark.
        */
        double c = (cs/20 * 100);
        double m = (ms/20 * 100);
        double v = (vs/20 * 100);
        DecimalFormat format = new DecimalFormat("#");
        System.out.println(format.format(c) + "% Of the car park are occupied by Cars");
        System.out.println(format.format(m) + "% Of the car park are occupied by MotorBikes");
        System.out.println(format.format(v) + "% Of the car park are occupied by Vans");
    }
    @Override
    public boolean runMenu() {
        boolean exit = false;
        System.out.println("Welcome to Trumps Cark Park");
        System.out.println("N: Add New Vehicle");
        System.out.println("P: View Car Park");
        System.out.println("S: Print Statistics");
        System.out.println("R: Remove Vehicle");
        System.out.println("F: Find Vehicle");
        System.out.println("X: Exit");
        vehicle = sc.next().charAt(0);
        switch(vehicle){
            case 'N': 
                System.out.println("C: Car");
                System.out.println("M: MotorBike");
                System.out.println("V: Van");
                vhicle = sc.next().charAt(0);
                switch(vhicle){
                    case 'C':
                        DateTime CT = new DateTime();
                        CT.setDay();
                        CT.setMonth();
                        CT.setYear();
                        CT.setDate();
                        System.out.println("ID: ");
                        String ID = sc.next().toUpperCase();
                        System.out.println("Brand: ");
                        String B = sc.next();
                        System.out.println("Number of Doors: ");
                        int doors = sc.nextInt();
                        System.out.println("Color: ");
                        String c = sc.next();
                        System.out.println("Time of Entry: ");
                        CT.setTimeOfEntry();
                        int crt=0;
                        Car CR = new Car(ID,B,CT,crt,doors,c);
                        CRTime = CT;
                        this.addVehicle(CR);
                        --numObject;
                        System.out.println("Vehicle added, Remaining space: " + numObject);
                        cs = cs + 1;
                        break;
                    case 'M':
                        DateTime MT = new DateTime();
                        MT.setDay();
                        MT.setMonth();
                        MT.setYear();
                        MT.setDate();
                        System.out.println("ID: ");
                        String VID = sc.next().toUpperCase();
                        System.out.println("Brand: ");
                        String Br = sc.next();
                        System.out.println("Engine Size: ");
                        Double es = sc.nextDouble();
                        System.out.println("Time of Entry: ");
                        MT.setTimeOfEntry();
                        int mbt = 0;
                        MotorBike mb = new MotorBike(VID, Br, MT,mbt, es);
                        MBT = MT;
                        this.addVehicle(mb);
                        --numObject;
                        System.out.println("Vehicle added, Remaining space: " + numObject);
                        ms = ms + 1;
                        break;
                    case 'V':
                        DateTime VT = new DateTime();
                        VT.setDay();
                        VT.setMonth();
                        VT.setYear();
                        VT.setDate();
                        System.out.println("ID: ");
                        String vid = sc.next().toUpperCase();
                        System.out.println("Brand: ");
                        String br = sc.next();
                        System.out.println("Cargo Volume: ");
                        Double cv = sc.nextDouble();
                        System.out.println("Time of Entry: ");
                        VT.setTimeOfEntry();
                        int vnt = 0;
                        Van vn = new Van(vid,br,VT,vnt,cv);
                        VnT = VT;
                        this.addVehicle(vn);
                        numObject = numObject - 2;
                        System.out.println("Vehicle added, Remaining space: " + numObject);
                        vs = vs +2;
                        break;    
                }
            break;
            case 'A':
                System.out.println("Hopefully this tricks netbeans");
                break;
            case 'P':
               this.printVehicles();
                break;
            case 'R':
                this.removeVehicles();
                break;
            case 'S':
                this.statistics();
                break;
            case 'F':
                this.findVehiclebyDate();
                break;
            case 'X':
               exit = true;
               this.closeManager();
               break;
        }
        return exit;
    }
    public void closeManager(){
        if(vehicle == 'X'){
            System.exit(0);
        }
    }
 public class CustomComparator implements Comparator<Vehicle> {
/*
This subclass defines my function used to sort out my List of vehicles by time of entry.
*/
    @Override
    public int compare(Vehicle v1, Vehicle v2) {
        return v2.getEntry().compareTo(v1.getEntry());
    }
}
 public void removeSelected(List<Vehicle> vlist, Predicate<Vehicle> condition){
     /*
     The first if statement will test every parked vehicle against my predicate, when true The vehicle will be checked to see 
     if its an instance of a Car,Van or Motorbike, if so the user is promped to enter the time left and set the charge aswell
     as print the details and updating the number of available spaces in the parking lot.
     my removeSelected method takes in my list of vehicles as well as a predifned predicate as its parameters.
     */
for (Vehicle v : vlist) {
        if (condition.test(v)){
            if(v instanceof Car){
               System.out.println("Car");
               CRTime.setLeaveTime();
               v.setCharge(); 
                 System.out.println("Type: " + v.getVehicle() + 
                   " \nID: " + v.getID() + 
                   " \nTime of Entry: " + v.getEntry() +
                   " \nTime Left: " + v.getLeaveTime() +
                   " \nDay Left: " + v.getDateTime() +
                   "\nTicket: £" + v.getCharge()); 
                 VList.remove(v);
                 numObject= numObject +1;
           System.out.println("Vehicle removed, Remaining space: " + numObject);
           break;
            }
            if(v instanceof MotorBike){
               System.out.println("MotorBike");
               MBT.setLeaveTime();
               v.setCharge(); 
               System.out.println("Type: " + v.getVehicle() + 
                   " \nID: " + v.getID() + 
                   " \nTime of Entry: " + v.getEntry() +
                   " \nTime Left: " + v.getLeaveTime() +
                   " \nDay Left: " + v.getDateTime() +
                   "\nTicket: £" + v.getCharge()); 
                 VList.remove(v);
               numObject= numObject +1;
           System.out.println("MotorBike removed, Remaining space: " + numObject);
           break;
            }
            if(v instanceof Van){
               System.out.println("VanID");
               VnT.setLeaveTime();
               v.setCharge(); 
               System.out.println("Type: " + v.getVehicle() + 
                   " \nID: " + v.getID() + 
                   " \nTime of Entry: " + v.getEntry() +
                   " \nTime Left: " + v.getLeaveTime() +
                   " \nDay Left: " + v.getDateTime() +
                   "\nTicket: £" + v.getCharge());
                 VList.remove(v);
               numObject= numObject +2;
           System.out.println("Van removed, Remaining space: " + numObject);
           break;
            }
        }   }
}
 public void findByDate(List<Vehicle> vlist, Predicate<Vehicle> condition){
//     boolean MotorCar = false;
//     boolean Van = false;
     for(Vehicle v: vlist){
         if(condition.test(v)){
//             if(v instanceof Car || v instanceof MotorBike){
//                 MotorCar = true;
              System.out.println("Type: " + v.getVehicle() + 
                   " \nID: " + v.getID() + 
                   " \nBrand: " + v.getBrand() +
                   " \nTime of Entry: " + v.getEntry() +
                   " \nDay of Entry: " + v.getDateTime());  
//             }
//             if(v instanceof Van){
////                 Van = true;
//            System.out.println("Type: " + v.getVehicle() + 
//                   " \nID: " + v.getID() + 
//                   " \nBrand: " + v.getBrand() +
//                   " \nTime of Entry: " + v.getEntry() +
//                   " \nDay of Entry: " + v.getDateTime());
//            
//             }       
         }
//         if(MotorCar == false && Van == false){
//                 System.out.println("NO VEHICLE WAS ENTERED ON THIS DATE");   
//             }
        
     }
 }

}
    



