/*
 * PROJECT I: Circle.java
 *
 * This file contains a template for the class Circle. Not all methods are
 * implemented. Make sure you have carefully read the project formulation
 * before starting to work on this file. You will also need to have completed
 * the Point class.
 *
 * Remember not to change the names, parameters or return types of any
 * variables in this file!
 *
 * The function of the methods and instance variables are outlined in the
 * comments directly above them.
 */

public class Circle {

    /*
     * Here, you should define private variables that represent the radius and
     * centre of this particular Circle. The radius should be of type double,
     * and the centre should be of type Point.
     */
     
     private double r;
     private Point A;

    // =========================
    // Constructors
    // =========================
    /**
     * Default constructor - performs no initialization.
     */
    public Circle() {
        // This method is complete.
    }
    
    /**
     * Alternative constructor, which sets the circle up with x and y
     * co-ordinates representing the centre, and a radius. Remember you should
     * not store these x and y co-ordinates explicitly, but instead create a
     * Point to hold them for you.
     *
     * @param xc   x-coordinate of the centre of the circle
     * @param yc   y-coordinate of the centre of the circle
     * @param rad  radius of the circle
     */
    public Circle(double xc, double yc, double rad) {
        // You need to fill in this method.
        
        if (rad <= Point.GEOMTOL) {
               // if radius is less than tolerance, an error is given
           throw new IllegalArgumentException("Not a circle. R < Tolerance.");
        }
       else {
           
           this.A = new Point(xc,yc);
           this.r = rad;
       }
    }

    /**
     * Alternative constructor, which sets the circle up with a Point
     * representing the centre, and a radius.
     *
     * @param center  Point representing the centre
     * @param rad     Radius of the circle
     */
    
    public Circle(Point center, double rad) {
        // You need to fill in this method.
        
        if (rad <= Point.GEOMTOL) {
            // if radius is less than tolerance, an error is given
            throw new IllegalArgumentException("Not a circle. R < Tolerance"); 
        }
        
        else {
            this.A = center;
            this.r = rad;
        }
    }

    // =========================
    // Setters and Getters
    // =========================

    /**
     * Setter - sets the co-ordinates of the centre.
     *
     * @param xc  new x-coordinate of the centre
     * @param yc  new y-coordinate of the centre
     */   
    public void setCenter(double xc, double yc) {
        // You need to fill in this method.
        this.A = new Point (xc, yc);
    }

    /**
     * Setter - sets the centre of the circle to a new Point.
     *
     * @param p  A Point representing the new centre of the circle.
     */   
    public void setCenter(Point p) {
        // You need to fill in this method.
        this.A = p;
    }
    
    /**
     * Setter - change the radius of this circle.
     *
     * @param rad  New radius for the circle.
     */   
    public void setRadius(double rad) {
        // You need to fill in this method.
        this.r = rad;
    }
    
    /**
     * Getter - returns the centre of this circle.
     *
     * @return The centre of this circle (a Point).
     */   
    public Point getCenter(){
        // You need to fill in this method.
        return A;
    }

    /**
     * Getter - extract the radius of this circle.
     *
     * @return The radius of this circle.
     */   
    public double getRadius(){
        // You need to fill in this method.
        return r;
    }

    // =========================
    // Convertors
    // =========================

    /**
     * Calculates a String representation of the Circle.
     *
     * @return A String of the form: "[Ax,Ay], r=Radius" where Ax and Ay are
     *         numerical values of the coordinates, and Radius is a numerical
     *         value of the radius.
     */
    public String toString() {
        // You need to fill in this method.
        String output = getCenter() + " , " + getRadius();
        return output;
    }
    
    // ==========================
    // Service routines
    // ==========================
    
    /**
     * Similar to the equals() function in Point. Returns true if two Circles
     * are equal. By this we mean:
     * 
     * - They have the same radius (up to tolerance).
     * - They have the same centre (up to tolerance).
     * 
     * Remember that the second test is already done in the Point class!
     *
     * @return true if the two circles are equal.
     */
    public boolean equals(Circle c) {
        // You need to fill in this method.
        if (Math.abs(r - c.r) <= Point.GEOMTOL && A.equals(c.A) ) {
            return true;
        }
        else {
            return false;
        }
            
    }
    
    // -----------------------------------------------------------------------
    // Do not change the method below! It is essential for marking the
    // project, and you may lose marks if it is changed.
    // -----------------------------------------------------------------------

    /**
     * Compare this Circle with some Object, using the test above.
     *
     * @param obj  The object to compare with.
     * @return true if the two objects are equal.
     */
    public boolean equals(Object obj) {
        // This method is complete.
        
        if (obj instanceof Circle) {
            boolean test = false;
            Circle C = (Circle)obj;
            
            test = this.equals(C);

            return test;
        } else {
            return false;
        }
    }

    // ======================================
    // Implementors
    // ======================================
    
    /**
     * Computes and returns the area of the circle.
     *
     * @return  Area of the circle
     */
    public double area() {
        // You need to fill in this method.
        double circlearea = Math.PI * Math.pow(r,2);
        return circlearea;
        
    }

    /**
     * Tests whether this circle overlaps/touches/is disjoint with another
     * Circle, as set out in the project formulation.
     *
     * @return An integer describing the overlap with C:
     *         0 - disjoint; 1 - overlaps; 2 - touches; 3 - identical.
     */ 
    public int overlap(Circle C) {
        // You need to fill in this method.
        if (A.equals(C.A) && Math.abs(r - C.r) <= Point.GEOMTOL) {
            return 3;
        }
        if ((this.r + C.r) - Math.abs(this.A.distance(C.A))  <= Point.GEOMTOL ) {
            return 2;
        }
        if (A.distance(C.A) < r + C.r ) {
            return 1;
        }
        return 0;
    }


    // =======================================================
    // Tester - test methods defined in this class
    // =======================================================
    
    public static void main(String args[]) {
        // You need to fill in this method.
        Circle circle1 = new Circle(1,2,3);
        Circle circle2 = new Circle(0.4, 0.2, 0.3);
        Circle circle3 = new Circle(0.5, 0.2, 0.2);
        System.out.println("====YOUR FIRST CIRCLE====");
        System.out.println("YOUR CENTER: " + circle1.getCenter());
        System.out.println("YOUR RADIUS: " + circle1.getRadius());
        System.out.println("YOUR STRING: " + circle1.toString());
        System.out.println("====YOUR SECOND CIRCLE====");
        System.out.println("YOUR CENTER: " + circle2.getCenter());
        System.out.println("YOUR RADIUS: " + circle2.getRadius());
        System.out.println("YOUR STRING: " + circle2.toString());
        System.out.println("====YOUR THIRD CIRCLE====");
        System.out.println("YOUR CENTER: " + circle3.getCenter());
        System.out.println("YOUR RADIUS: " + circle3.getRadius());
        System.out.println("YOUR STRING: " + circle3.toString());
        System.out.println("====TESTING EQUALITY====");
        System.out.println("CIRCLE1/CIRCLE2: " + circle1.equals(circle2));
        System.out.println("CIRCLE1/CIRCLE3: " + circle1.equals(circle3));
        System.out.println("CIRCLE2/CIRCLE3: " + circle2.equals(circle3));
        System.out.println("====AREA====");
        System.out.println("CIRCLE1: " + circle1.area());
        System.out.println("CIRCLE2: " + circle2.area());
        System.out.println("CIRCLE3: " + circle3.area());
        System.out.println("====OVERLAP====");
        System.out.println("CIRCLE1/CIRCLE2: " + circle1.overlap(circle2));
        System.out.println("CIRCLE1/CIRCLE3: " + circle1.overlap(circle3));
        System.out.println("CIRCLE2/CIRCLE3: " + circle2.overlap(circle3));
 
        
        
        
        
        
     

        
        
    }
}
