/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carpark;
import java.util.*;
/**
 *
 * @author Admin
 */
public class CarPark {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      CarParkManager sys = new WestminsterCarParkManager(20);
      boolean exit = false;
      do{
          sys.runMenu();
      }while(!exit);

    }
    
}
