/**
 Jasurbek Mamurov
 U2010164
 Assignment #4
 Abstract Class and Interface
**/

// interface for comparing objects
interface GeometricComparable{
    public boolean equalTo(Object o);
}

class Circle implements GeometricComparable {

    // data fields
    private double radius;
    public static int numberOfCircle = 0;

    // default constructor
    Circle(){
        this(0);
    }

    // parametrized constructor
    Circle(double radius){
        this.radius = radius;
        numberOfCircle++;
    }

    // for creating from an existing object
    Circle(Circle t){
        this.radius = t.radius;
        numberOfCircle++;
    }

    // Getting the radius
    public double getRadius() {
        return this.radius;
    }

    // Setting the radius
    public void setRadius(double radius) {
        this.radius = radius;
    }

    // Getting the Area
    public double getArea() {
        return (3.14 * this.radius * this.radius);
    }

    // Setting the number of circles
    public static int getNumberOfCircle() {
        return numberOfCircle;
    }

    // for comparing objects
    public boolean equalTo(Object o){
         Circle cir = (Circle) o;
         return this.radius == cir.radius;
    }

}

// Driver class

public class InterfaceDemo
{
    public static void main(String[] args)
    {
        // 1st circle object creation
        Circle cir1 = new Circle ();
        System.out.println ("\nCircle object number: "+Circle.getNumberOfCircle());
        System.out.println("And it's area: "+cir1.getArea());

        // 2nd circle object creation
        Circle cir2 = new Circle (10.4);
        System.out.println ( "\nCircle object number: "+Circle.getNumberOfCircle());
        System.out.println("And it's area: "+cir2.getArea());

        // 3rd circle object creation from 1st circle object
        Circle cir3 = new Circle (cir1);
        System.out.println ( "\nCircle object number: "+Circle.getNumberOfCircle());
        System.out.println("And it's area: "+cir3.getArea());

        // Are circles equal?
        System.out.println ( "\nCircle object circle1 and circle2 are equal: " + cir1.equalTo(cir2));
        System.out.println ( "Circle object circle1 and circle3 are equal: " + cir1.equalTo(cir3));

    }
}


