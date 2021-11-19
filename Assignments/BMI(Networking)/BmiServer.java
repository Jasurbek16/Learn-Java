/*
        * Jasurbek Mamurov
        * U2010164
        * Assignment #9
        * BMI calculator (Networking)
        * Server app
        *
* */

import java.io.*;
import java.net.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;

public class BmiServer extends JFrame {

    // Text area for displaying contents
    private JTextArea jta = new JTextArea();

    public static void main(String[] args) {
        new BmiServer();
    }

    public BmiServer() {
        // Place text area on the frame
        setLayout(new BorderLayout());
        add(new JScrollPane(jta), BorderLayout.CENTER);

        setTitle("Server Side");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame
        setVisible(true); // It is necessary to show the frame here!

        try {
            // Create a server socket
            ServerSocket serverSocket = new ServerSocket(8000);
            jta.append("Server started at " + new Date() + '\n');

            // Listen for a connection request
            Socket socket = serverSocket.accept();

            // Create data input and output streams
            DataInputStream inputFromClient = new DataInputStream(
                    socket.getInputStream());
            DataOutputStream outputToClient = new DataOutputStream(
                    socket.getOutputStream());

            while (true) {
                // Receive weight and height from the client
                double weight = inputFromClient.readDouble();
                double height = inputFromClient.readDouble();

                // Compute BMI
                double BMI = weight / Math.pow(height, 2);

                // Send BMI back to the client
                outputToClient.writeDouble(BMI);

                // Display the result
                jta.append(">>> Weight received from client: " + weight + '\n');
                jta.append(">> Height received from client: " + height + '\n');
                jta.append("> BMI found: " + BMI + '\n' + '\n');
            }
        }
        catch(IOException ex) {
            System.err.println(ex);
        }
    }
}