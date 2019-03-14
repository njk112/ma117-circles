import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
/*
 * PROJECT I: Project1.java
 *
 * As in project 0, this file - and the others you downloaded - form a
 * template which should be modified to be fully functional.
 *
 * This file is the *last* file you should implement, as it depends on both
 * Point and Circle. Thus your tasks are to:
 *
 * 1) Make sure you have carefully read the project formulation. It contains
 *    the descriptions of all of the functions and variables below.
 * 2) Write the class Point.
 * 3) Write the class Circle
 * 4) Write this class, Project1. The Results() method will perform the tasks
 *    laid out in the project formulation.
 */
public class Project1 {
    // -----------------------------------------------------------------------
    // Do not modify the names of the variables below! This is where you will
    // store the results generated in the Results() function.
    // -----------------------------------------------------------------------
    public int    circleCounter; // Number of non-singular circles in the file.
    public int    posFirstLast;  // Indicates whether the first and last
                                 // circles overlap or not.
    public double maxArea;       // Area of the largest circle (by area).
    public double minArea;       // Area of the smallest circle (by area).
    public double averageArea;   // Average area of the circles.
    public double stdArea;       // Standard deviation of area of the circles.
    public double medArea;       // Median of the area.
    public int    stamp=472143;
    // -----------------------------------------------------------------------
    // You may implement - but *not* change the names or parameters of - the
    // functions below.
    // -----------------------------------------------------------------------

    /**
     * Default constructor for Project1. You should leave it empty.
     */
    public Project1() {
        // This method is complete.
    }

    /**
     * Results function. It should open the file called FileName (using
     * Scanner), and from it generate the statistics outlined in the project
     * formulation. These are then placed in the instance variables above.
     *
     * @param fileName  The name of the file containing the circle data.
     */
    public void results(String fileName){
        // You need to fill in this method.
        int lineCount = 0;
        int i=0;
        double x,y,rad;
        
        ArrayList <Circle> circleList = new ArrayList<Circle>();
        ArrayList <Double> areaList = new ArrayList<Double>();
        
        try {
            Scanner scanner = new Scanner(new BufferedReader(new FileReader(fileName))); 
            
            while(scanner.hasNext()) {
            //Read the three valies on each line of the file
            x = scanner.nextDouble();
            y = scanner.nextDouble();
            rad = scanner.nextDouble();
            
            if (rad >= Point.GEOMTOL) {
                //Using ArrayList because array requires a specific size, which is not known.
                Circle insert_new = new Circle(x,y,rad);
                circleList.add(insert_new);
                areaList.add(insert_new.area());
            }
            
            lineCount +=1;
        }
        
        } 
        
          catch(Exception e) {
          System.err.println("An error has occured. See below for details");
          e.printStackTrace();
        }
        
        //Area sorting
        Collections.sort(areaList);
        
        //Area MAX & MIN
        if (areaList.isEmpty() == false) {
            this.maxArea =areaList.get(areaList.size()-1);
            this.minArea =areaList.get(0);
        }
        
        //average area 
        // Converting ArrayList to Array because the given method average area and area standardeviation are already pre-built
        // and use Circle Arrays
        Circle [] finalCircle = circleList.toArray(new Circle[circleList.size()]);
        this.averageArea = averageArea(finalCircle);
        
        //circle counter
        this.circleCounter = circleList.size();
        
        //std area
        this.stdArea = areaStandardDeviation(finalCircle);
        
        // posFirstLast
        this.posFirstLast = circleList.get(0).overlap(circleList.get(circleList.size()-1));
        //this.posFirstLast = finalCircle[0].overlap(finalCircle[circleCounter-1]);
        System.out.println("Circle overalping:" + posFirstLast);
        
        
        
        
            
        //Median of the area
        if (areaList.size() %2 !=0 ) {
            this.medArea = (areaList.get((areaList.size())/2));
        }
        else {
            this.medArea = (areaList.get(areaList.size()/2) + areaList.get(areaList.size()/2 - 1))/2;
            
        }
        
    }
    
    /**
     * A function to calculate the avarage area of circles in the array provided. 
     *
     * @param circles  An array if Circles
     */
    public double averageArea(Circle[] circles) {
      // You need to fill in this method and remove the return 0.0 statement.
        double sum = 0;
        for (Circle c : circles) {
            sum += c.area();
        }
        double aveArea = sum/circles.length;
        return aveArea;
    }
    
    /**
     * A function to calculate the standart deviation of areas in the circles in the array provided. 
     *
     * @param circles  An array of Circles
     */
    public double areaStandardDeviation(Circle[] circles) {
    // You need to fill in this method and remove the return 0.0 statement.
      double mean = averageArea(circles);
      double sum = 0;
      for (Circle c : circles) {
          sum = sum + Math.pow(c.area() - mean,2);
      }
      double sd = Math.sqrt(sum/circles.length);
      return sd;
    }
  
    // =======================================================
    // Tester - tests methods defined in this class
    // =======================================================

    /**
     * Your tester function should go here (see week 14 lecture notes if
     * you're confused). It is not tested by BOSS, but you will receive extra
     * credit if it is implemented in a sensible fashion.
     */
    public static void main(String args[]){
        // You need to fill in this method.
        Project1 a = new Project1();
		a.results("Project1.data");
		System.out.println("The max "+ a.maxArea);
		System.out.println("The min "+ a.minArea);
		System.out.println("The average "+ a.averageArea);
		System.out.println("The std "+ a.stdArea);
		System.out.println("The median "+ a.medArea);
		System.out.println("The posfirstlast "+ a.posFirstLast);
		System.out.println("Circle counter "+ a.circleCounter);

    }
}

