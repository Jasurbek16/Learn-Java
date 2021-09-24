package com.JavaLearn;

import java.awt.*;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {

// Part 1 Data Types

// Primitive
//        byte age = 30;
//        Date now = new Date();
//        System.out.println(now);

// Primitive .vs Reference
//          byte x = 1;
//          byte y = x;
//          x = 0;
//          System.out.println(x);
// both are independent and changin' one would not affect the other

//        Point point1 = new Point(1, 2);
//        Point point2 = point1;
//        point1.x = 0;
//        System.out.println(point2);
// both are dependent and changin' one would affect the other

// Strings
//        String message = "Hi, how are you?" + "??";
//        System.out.println(message);
//        System.out.println(message.length());
//        System.out.println(message.replace("?", "..."));
        // ^ would not replace the original val but return only a modified string

// Escape Sequences
//        String message = "Hi, how are \"you\"?" + "??";
//        System.out.println(message);

// Arrays
        //1st way
//         int[] numbers = new int[5];
//         numbers[0] = 1;
//         numbers[1] = 2;
        //2nd way
//         int[] numbers = {3,2,6,1,0,7,4};
//         Arrays.sort(numbers);
//         System.out.println(Arrays.toString(numbers));

// Multi-dimensional Arrays
        // 1st way
//        int[][][] numbers = new int[2][3][5];
//        numbers[0][0][0] = 1;
//        System.out.println(Arrays.deepToString(numbers));

        // 2nd way
//        int[][] numbers = { {1,2,3}, {4,5,6} };
//        System.out.println(Arrays.deepToString(numbers));

// Constants
        // final float E = 2.71F;
        // E = 5; <- !!! we cannot change since that's constant

// Casting
        // Implicit casting
        //double quotient = (double)5/(double)2;

        // Implicit casting
        // byte > short > int > long > float > double
//        short x = 1;
//        int y = x + 2;
//        System.out.println(y);

        // Str to num
//        String x = "1";
//        int y = Integer.parseInt(x) + 2; // Integer is the wrapper class for the prim type int
        //       ^ according to the class, that returns that type after parsing
//        System.out.println(y);

// The Math Class
//        int result = (int)Math.pow(5, 7);
//        long rand_num = Math.round(Math.random() * 10);
//        System.out.println(result);
//        System.out.println(rand_num);

        // Tricky part
//        int trick_num = (int) (Math.random() * 100);
        // we need the ()s for calcing the multiplication and then convert
//         System.out.println(trick_num);

// Formatting num.s
        // Currency
//        NumberFormat currency = NumberFormat.getCurrencyInstance();
//        String result = currency.format(123456.354); // returns a formatted string of num.s
//        System.out.println(result);

        // Percents with method chaining
//        String result_perc = NumberFormat.getPercentInstance().format(0.1); // returns a formatted string of num.s
//        System.out.println(result_perc);

// Getting an input
//        Scanner scanner = new Scanner(System.in); // System.in <- getting an input from the terminal
//        System.out.print("Your name was... ");
//        String name = scanner.nextLine().trim(); // trim() <- coz any space is considered w/ nextLine()
//        System.out.println("Thanks for joining " + name + " !");

//-------------------------------------------------------------------------------------------
/* ---------------------
----------------------------
Project: Mortgage Calculator
----------------------------
   ---------------------
//*/
//        final byte MONTHS_IN_YEAR = 12;
//        final byte PERCENT = 100;
//
//        System.out.println(" **** Mortgage Calculator **** ");
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.print("Principal: ");
//        double principal = scanner.nextDouble();
//
//        System.out.print("Annual Interest Rate: ");
//        float annualInterest = scanner.nextFloat();
//        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
//
//        System.out.print("Period (Years): ");
//        byte years = scanner.nextByte();
//        int numOfPayments = years * MONTHS_IN_YEAR;
//
//        double mortgage = principal
//                * (monthlyInterest * Math.pow(1 + monthlyInterest, numOfPayments))
//                / (Math.pow(1 + monthlyInterest, numOfPayments) - 1);
//
//        String str_mortgage = NumberFormat.getCurrencyInstance().format(mortgage);
//        System.out.print("Mortgage: " + str_mortgage);
//-------------------------------------------------------------------------------------------

// Logical operators
//        int temperature = 22;
//        boolean isWarm = temperature > 20 && temperature <= 30;
//        System.out.println(isWarm);

// "if" statements
//        int temperature = 32;
//
//        if (temperature > 30){
//            System.out.println("U should drink some water?");
//        }
//        else if (temperature > 20)
//            System.out.println("Enjoy the day");
//        else {
//            System.out.println("Cold day");
//            System.out.println("Wear more clothes");

// Simplifying "if" statements
//        float gpa = 4.5f;
//        boolean hasHighGPA = (gpa > 4.2);

// Ternary operators
//        float gpa = 4.5f;
//        String nextSemester;
//        nextSemester = gpa > 4.0 ? "Scholarship" : "Contract";
//        System.out.println("You're going to study on " + nextSemester + " the next semester");

// Switch statements
//        String status = "admin";
//
//        System.out.println("You can: ");
//        switch (status) {
//            case "admin":
//                System.out.println("> Delete other users\n> Add other users\n> Change settings of the group");
//                break;
//            case "user":
//                System.out.println("> Add users\n> Delete your own messages\n> Create Polls");
//                break;
//
//            default:
//                System.out.println("> Just look at the group info");
// -------------------------------------------------------------------------------------------------------------------
//  FizzBuzz
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.print("Number: ");
//        int number = scanner.nextInt();
//
//        if (number % 5 == 0){
//            if (number % 3 == 0)
//                System.out.println("FizzBuzz");
//            else
//                System.out.println("Fizz");
//        }
//        else if (number % 3 == 0)
//            System.out.println("Buzz");
//        else
//            System.out.println(number);
// -------------------------------------------------------------------------------------------------------------------

// For loops
//        for(int i = 0; i < 10; i++)
//            System.out.print(i+1 + " ");

// While loops
//        int i = 0;
//        while (i < 10){
//            System.out.print(i+1 + " ");
//            i++;
//        }

        //!!! Tricky part
//        Scanner scanner = new Scanner(System.in);
//        String input = "";
//
//        while (!input.equals("quit")) { // < since reference types contain addresses to obj.s, we use .equals()
//            System.out.print("Input: ");
//            input = scanner.next().toLowerCase();
//            System.out.println(input);
//        }

// Do...While loops
//        Scanner scanner = new Scanner(System.in);
//        String input = "";
//
//        do {
//            System.out.print("Input: ");
//            input = scanner.next().toLowerCase();
//            System.out.println(input);
//        }while(!input.equals("quit"));

    }

}



////////////////////////////
/**
 Jasurbek Mamurov
 U2010164
 Assignment #2
 Creating a Student class
**/

package com.company;

import java.util.Scanner;

class Student {

    // data fields
    private int StudentID;
    private String StudentName;
    private int Age;

    Student(){
        this.StudentID = 12345678;
        this.StudentName = "Tony";
        this.Age = 10;
    }

    Student(int StudentID, String StudentName, int Age){
        this.StudentID = StudentID;
        this.StudentName = StudentName;
        this.Age = Age;
    }

    // Getting the studentID
    public int getStudentID() {
        return StudentID;
    }

    // Setting the studentID
    public void setStudentID(int StudentID) {
        while(StudentID < 0){
            System.out.println("Invalid input, please try again...");

        }
    }

    // Getting the studentName
    public String getStudentName() {
        return StudentName;
    }

    // Setting the studentName
    public void setStudentName(String StudentName) {
        this.StudentName = StudentName;
    }

    // Getting the age
    public int getAge(){
        return Age;
    }

    // Setting the age
    public void setAge(int Age){
        this.Age = Age;
    }


}

public class StudentDemo {


    public static void main(String[] args) {

    }
}


