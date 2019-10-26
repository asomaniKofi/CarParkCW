package carpark;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class Car extends Vehicle{
    protected int doors;
    protected String color;
    public Car(String VID, String Brand,DateTime entry,int ticket,int doors, String color){
        super(VID, Brand,entry,ticket);
        this.doors = doors;
        this.color = color;
    }
    public void setDoorNum(int d){
        doors =d;
    }
    public void setColor(String color){
        this.color = color;
    }
    public int getDoorNum(){
        return doors;
    }
    public String getColor(){
        return color;
    }
    public String toString(){
        return "Car ";
    }
    public String getID(){
        return super.VehicleID;
    }
    public String getBrand(){
        return super.Brand;
    }
    public String getVehicle(){
        return toString();
    }
}
