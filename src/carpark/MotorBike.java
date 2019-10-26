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
public class MotorBike extends Vehicle {
    protected double enginesize;
    public MotorBike(String VID, String Brand,DateTime entry,int ticket,double es){
        super(VID,Brand,entry,ticket);
        enginesize = es;
    }
    public void setSize(double size){
        enginesize = size;
    }
    public double getSize(){
        return enginesize;
    }
     public String toString(){
        return "Motorbike";
    }
    @Override
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
