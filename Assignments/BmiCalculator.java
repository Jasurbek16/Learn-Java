/*
* Jasurbek Mamurov
* U2010164
* Assignment #1
* BMI calculator
* */

import java.util.Scanner;

import static java.lang.System.exit;

public class BmiCalculator{

    // A function for displaying unit choices
    public static void unitChoice(){
        System.out.println("1. Kilograms and Meters");
        System.out.println("2. Pounds and Inches");
        System.out.print("Please, choose measurement units(weight)(height): ");
    }

    public static void main(String[] args) {
        // Intro
        System.out.println("<><><><><><><><><>");
        System.out.println("BMI\nCalculator");
        System.out.println("<><><><><><><><><>\n");

        // All variables used in the program
        int unit_choice, menu_choice;
        double weight, height;
        double BMI; // for storing BMI
        final int CONVERSION_FACTOR = 703;

        Scanner scanner = new Scanner(System.in); // taking an input from the cmd

        do {
            unitChoice(); // unit choice menu
            unit_choice = scanner.nextInt(); // choosing one of the units from the menu
            // validation
            while (true) {
                if (unit_choice < 1 || unit_choice > 2){
                    System.out.print("Try again: ");
                    unit_choice = scanner.nextInt();
                }
                else
                    break;
            }


            // main menu
            System.out.println("\n1. Start Calculation");
            System.out.println("2. Exit");
            System.out.print("... ");
            menu_choice = scanner.nextInt();
            // validation
            while (true){
                if (menu_choice < 1 || menu_choice > 2){
                    System.out.print("Try again: ");
                    menu_choice = scanner.nextInt();
                }
                else
                    break;
            }


            if(menu_choice == 1){
                // calculating with kg and m
                if (unit_choice == 1) {
                    System.out.println("\nChosen: Kilograms and Meters");

                    System.out.print("Enter the weight(kg): ");
                    weight = scanner.nextDouble();

                    System.out.print("Enter the height(m): ");
                    height = scanner.nextDouble();

                    // validation for negatives
                    if (weight < 0 || height < 0){
                        System.out.println("Invalid input. Try again!\n");

                        System.out.print("Enter the weight(kg): ");
                        weight = scanner.nextDouble();

                        System.out.print("Enter the height(m): ");
                        height = scanner.nextDouble();
                    }
                    BMI = weight / Math.pow(height, 2); // calculating the BMI
                }
                // calculating with lb and in
                else {
                    System.out.println("\nChosen: Pounds and Inches\n");

                    System.out.print("Enter the weight(lb): ");
                    weight = scanner.nextDouble();

                    System.out.print("Enter the height(in): ");
                    height = scanner.nextDouble();

                    // validation for negatives
                    if (weight < 0 || height < 0){
                        System.out.println("Invalid input. Try again!\n");

                        System.out.print("Enter the weight(kg): ");
                        weight = scanner.nextDouble();

                        System.out.print("Enter the height(m): ");
                        height = scanner.nextDouble();
                    }
                    BMI = (weight / Math.pow(height, 2)) * CONVERSION_FACTOR; // calculating the BMI
                }
                // printing the BMI
                System.out.print("BMI: ");
                System.out.println(String.format("%.2f", BMI));
            }
            // exiting from the program
            else {
                System.out.println("\n\nWritten by Jasurbek Mamurov");
                exit(0);
            }
            // asking whether to continue or exit after calculating the BMI
            System.out.println("\nAny number to continue..."); // to continue
            System.out.println("2. Exit"); // to exit
            menu_choice = scanner.nextInt();
            if (menu_choice == 2)
                System.out.println("\n\nWritten by Jasurbek Mamurov");
        }
        while(menu_choice != 2); // when we press 2, we exit from the program
    }
}