package carpark;


import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class DateTime {
    /*
    I made the variables protected in order to calculate the ticket in another class within this package.
    */
  protected int day, month, year, d, m,y= 0;
  protected int hour,minute, h,min=0;
  protected int lhour, lminute,lh,lmin=0;
  Scanner sc = new Scanner(System.in);
  public void setTimeOfEntry(){
      System.out.println("Hour:");
      h = sc.nextInt();
       if(h >= 24){h = 0;}
      hour =h;
      String.format("%02d", hour);
      System.out.println("Minute: ");
      min = sc.nextInt();
      if(min >= 60){min = 0; h = h+1;}
      minute = min;
      String.format("%02d", minute);
  }
  public void setLeaveTime(){
      System.out.println("Hour: ");
      lhour = sc.nextInt();
      if(lhour >= 24){lhour = 0;
       day = day + 1;}
      lh = lhour;
     String.format("%02d", lh);
      System.out.println("Minute: ");
      lminute = sc.nextInt();
      if(lminute >= 60){min = 0; lhour = lhour+1; if(lhour >= 24){lhour = 0;
       day = day + 1;}}
      lmin = lminute;
      String.format("%02d", lmin);
  }
  public void setDay(){
     System.out.println("Todays Date: ");
     d = sc.nextInt();
     if(d > 31){System.out.println("Please enter accurate day.");}
    day = day + d;
    String.format("%02d", day);
 }
 public void setMonth(){
     System.out.println("Month: ");
     m = sc.nextInt();
     if(m > 12){System.out.println("Please enter accurate month.");}
     month = month + m;
     String.format("%02d", month);
 }
 public void setYear(){
     System.out.println("Current Year: ");
     y = sc.nextInt();
     year = year + y;
 }
 public int getDay(){
     return day;
 }
 public int getMonth(){
     return month;
 }
 public int getYear(){
     return year;
 }
 public void setDate(){
d = day;
m = month;
y = year;
 }
 public String getDate(){
     return Integer.toString(day)+"/" + Integer.toString(month)+"/"+Integer.toString(year);
 }
 public String getEntryTime(){
     if(hour == 0 || hour <=9){
         return "0"+Integer.toString(hour) + ":" + Integer.toString(minute);
     } else{
         return Integer.toString(hour) + ":" + Integer.toString(minute);
     } 
  }
 public String getLeaveTime(){
     if(lh == 0 || lh <=9){
         return "0"+Integer.toString(lh) + ":" + Integer.toString(lmin);
     } else {
         return Integer.toString(lh) + ":" + Integer.toString(lmin);
     }
     
 }
    @Override
 public String toString(){
     return getDate() + " " + getEntryTime() + " " +getLeaveTime();
 }
 
}
