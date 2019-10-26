/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carpark;
/**
 *
 * @author Admin
 */
public abstract class Vehicle {
  protected String VehicleID;
  protected String Brand;
  protected int ticket;
  protected DateTime entry = new DateTime();
  public abstract String getVehicle();
  public abstract String getID();
  public abstract String getBrand();
  public Vehicle(String VehicleID, String Brand, DateTime entry, int ticket){
      this.VehicleID = VehicleID;
      this.Brand = Brand;
      this.entry = entry;
      this.ticket = ticket;
  }
  public void setID(String VehicleID){
      this.VehicleID = VehicleID;
  }
  public void setBrand(String Brand){
      this.Brand = Brand;
  }
  public void setEntry(){
      entry.setTimeOfEntry();
  }
  public void setLeave(){
      entry.setLeaveTime();
  }
 public String getEntry(){
     return entry.getEntryTime();
 }
 public String getLeaveTime(){
     return entry.getLeaveTime();
 }
  public String getDateTime(){
      return entry.getDate();
  }
  public String toString(){
      return "ID: " + VehicleID + "Brand: " + Brand + "Time of Entry: " + entry.getEntryTime() + "Time left: " + entry.getLeaveTime();
  } 
   public void setCharge(){
       /*Once this method is called removing a Vehicle we take the hour of removal and take it away from the hour of entry which.
       The result of that is then passed through 24 (24 hours) if statements to set my ticket variable to the right price 
       thus successfully and accurately calculated how long they spent in the carpark
       */
    int charge = entry.hour - entry.lhour;
       if(charge == 1 || charge == -1){
           ticket = 3;
       }
       if(charge == 2|| charge == -2){
           ticket = 6;
       }
if(charge == 3 || charge == -3){
           ticket = 9;
       }
if(charge == 4|| charge == -4){
           ticket = 10;
       }
if(charge == 5 || charge == -5){
           ticket = 11;
       }
if(charge == 6 || charge == -6){
           ticket = 12;
       }
if(charge == 7 || charge == -7){
           ticket = 13;
       }
if(charge == 8 || charge == -8){
           ticket = 14;
       }
if(charge == 9|| charge == -9){
           ticket = 15;
       }
if(charge == 10|| charge == -10){
           ticket = 16;
       }
if(charge == 11|| charge == -11){
           ticket = 17;
       }
if(charge == 12|| charge == -12){
           ticket = 18;
       }
if(charge == 13|| charge == -13){
           ticket = 19;
       }
if(charge == 14|| charge == -14){
           ticket = 20;
       }
if(charge == 15|| charge == -15){
           ticket = 21;
       }
if(charge == 16|| charge == -16){
           ticket = 22;
       }
if(charge == 17|| charge == -17){
           ticket = 23;
       }
if(charge == 18|| charge == -18){
           ticket = 24;
       }
if(charge == 19|| charge == -19){
           ticket = 25;
       }
if(charge == 20|| charge == -20){
           ticket = 26;
       }
if(charge == 21|| charge == -21){
           ticket = 27;
       }
if(charge == 22|| charge == -22){
           ticket = 28;
       }
if(charge == 23|| charge == -23){
           ticket = 29;
       }
if(charge == 24 || charge == -24){
           ticket = 30;
       }
   }
      public int getCharge(){
          /*Once the charge is calulated the variable is returned to an instance of a Vehicle to be displayed in the console.*/
      return ticket;
  }
}
