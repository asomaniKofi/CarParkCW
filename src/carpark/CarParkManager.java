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
public interface CarParkManager {
    public abstract void addVehicle(Vehicle v);
    public abstract void printVehicles();
    public abstract void removeVehicles();
    public abstract void statistics();
    public abstract boolean runMenu(); 
}
