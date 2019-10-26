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
public class Van extends Vehicle{
    protected double CargoVolume;
    public Van(String VID, String Brand, DateTime entry,int ticket,double CV){
        super(VID,Brand,entry,ticket);
        CargoVolume = CV;
    }
    public void setVolume(double cv){
        CargoVolume = cv;
    }
    public double getVolume(){
        return CargoVolume;
    }
     public String toString(){
        return "Van ";
    }
     public String getVehicle(){
        return toString();
    }
     public String getID(){
        return super.VehicleID;
    }
    public String getBrand(){
        return super.Brand;
    }
}
