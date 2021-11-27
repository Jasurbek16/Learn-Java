/*
* Jasurbek Mamurov
* U2010164
* Lab #10
* JDBC
* */

import java.sql.*;
import java.util.Scanner;

public class BMI_Database {

    // displaying the menu
    public static void showOptions(){
        System.out.println("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println(">> 1.Show data in the table");
        System.out.println(">> 2.Insert data into the table");
        System.out.println(">> 3.Update data in the table");
        System.out.println(">> 4.Delete data from the table");
        System.out.println(">> 5.Exit");
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    }


    public static void main(String[] args)  throws SQLException, ClassNotFoundException {

        // variables
        int option, weight, height, id;
        String name;
        Scanner scanner = new Scanner(System.in);
        ResultSet table;

        // Get the driver
        Class.forName("com.mysql.jdbc.Driver");

        // Establish a connection
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bmi_db", "xxxx", "xxxx");

        // Creating a statement for data retrieval
        PreparedStatement statement_select = connection.prepareStatement("select * from bmi", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        // ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE <-- are added since I want the table to be iterable in reverse direction as well (in the reverse direction to .next())
        // Creating a statement for data retrieval after checking
        PreparedStatement statement_select_where = connection.prepareStatement("select * from bmi where PersonID = ?");
        // Creating a statement for data insertion
        PreparedStatement statement_insert = connection.prepareStatement("insert into bmi values(?,?,?,?)");
        // Creating a statement for data updating
        PreparedStatement statement_update = connection.prepareStatement("update bmi set PersonName = ?, Weight = ?, Height=? where PersonID = ?");
        // Creating a statement for data deletion
        PreparedStatement statement_delete = connection.prepareStatement("delete from bmi where PersonID = ?");

        // intro
        System.out.println("\n\nHello and welcome to the BMI_DB Management");
        showOptions();
        System.out.print("Please, choose one operation you want: ");
        option = scanner.nextInt();
        while(option!=5){
            switch(option){
                case 1:
                    // executing "retrieval of data"
                    table = statement_select.executeQuery();

                    // if data exists
                    if (table.next()) {
                        table.beforeFirst(); // for going one step back to get data
                        while (table.next()) {
                            System.out.println("---------------------------------");
                            System.out.println("ID: " + table.getInt(1) +
                                    " " + "Weight: " + table.getInt(3) +
                                    " " + "Height: " + table.getInt(4) +
                                    " " + "Name: " + table.getString(2));
                            System.out.println("---------------------------------");
                        }
                    }
                    else
                        System.out.println("No data available in the database!");
                    break;
                case 2:
                    // performing "insertion of data"
                    System.out.println("\nEnter the followings: ");
                    System.out.println("ID: ");id = scanner.nextInt();
                    // check whether there's already a person with this or not
                    statement_select_where.setInt(1,id);
                    table = statement_select_where.executeQuery();
                    if (!table.next()) {
                        System.out.println("Name: ");
                        name = scanner.next();
                        System.out.println("Weight: ");
                        weight = scanner.nextInt();
                        System.out.println("Height: ");
                        height = scanner.nextInt();

                        // insert
                        statement_insert.setInt(1, id);
                        statement_insert.setString(2, name);
                        statement_insert.setInt(3, weight);
                        statement_insert.setInt(4, height);
                        statement_insert.executeUpdate();
                        System.out.println("Successfully inserted!!!");
                    }
                    else
                        System.out.println("The ID entered exists in the database!");
                    break;
                case 3:
                    // updating data
                    // search for data
                    table = statement_select.executeQuery();

                    // if there exists data
                    if(table.next()) {

                        System.out.println("\nWhich ID holder has to be changed?");
                        System.out.println("Enter the ID of that person: ");
                        id = scanner.nextInt();
                        statement_select_where.setInt(1,id);
                        // search for the person
                        table = statement_select_where.executeQuery();

                        // if the person exits
                        if (table.next()) {
                            System.out.println("Enter the name: ");
                            name = scanner.next();
                            System.out.println("Enter the weight: ");
                            weight = scanner.nextInt();
                            System.out.println("Enter the height: ");
                            height = scanner.nextInt();

                            // updating
                            statement_update.setInt(4, id);
                            statement_update.setString(1, name);
                            statement_update.setInt(2, weight);
                            statement_update.setInt(3, height);
                            statement_update.executeUpdate();
                            System.out.println("Successfully updated!!!");
                        }
                        else
                            System.out.println("There is no such kind of ID in the database!");
                    }
                    else
                        System.out.println("There is info in the database!");
                    break;
                case 4:
                    // deleting data with validation
                    // search for data
                    table = statement_select.executeQuery();

                    // if any data exists
                    if(table.next()) {
                        System.out.println("\nWhich person info would be deleted?");
                        System.out.println("Enter the ID: ");
                        id = scanner.nextInt();
                        statement_select_where.setInt(1, id);
                        // search for the person
                        table = statement_select_where.executeQuery();

                        // if there's a person with the ID entered
                        if (table.next()) {
                            statement_delete.setInt(1, id);
                            // delete
                            statement_delete.executeUpdate();
                            System.out.println("Successfully deleted!!!");
                        }
                        else
                            System.out.println("This ID is not assigned to anyone!");
                    }
                    else
                        System.out.println("There is info in the database!");
                    break;
            }

            // choosing one of the options again
            showOptions();
            System.out.print("Please, choose one operation you want: ");
            option = scanner.nextInt();
        }
        // closing the connecting after using
        connection.close();
    }
}
