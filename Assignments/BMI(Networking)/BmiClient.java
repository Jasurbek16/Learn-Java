/*
 * Jasurbek Mamurov
 * U2010164
 * Assignment #9
 * BMI calculator (Networking)
 * Client Side
 * */

import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BmiClient extends JFrame {

    // Text field for receiving weight and height
    private JTextField weight = new JTextField();
    private JTextField height = new JTextField();

    // Button to calculate the BMI
    JButton btn = new JButton("Calculate");

    // Text area to display contents
    private JTextArea display = new JTextArea();

    // IO streams
    private DataOutputStream toServer;
    private DataInputStream fromServer;

    public static void main(String[] args) {
        new BmiClient();
    }

    public BmiClient() {
        // Main Panel to hold the inner panel p
        JPanel mainPanel = new JPanel(new GridLayout(3, 1));
        // Inner panel p to hold the label and text field
        JPanel p = new JPanel();
        // setting properties of the inner panel p
        p.setLayout(new GridLayout(2, 2));
        p.add(new JLabel("Enter weight"));
        p.add(weight);
        p.add(new JLabel("Enter height"));
        p.add(height);
        // setting properties of the main panel
        mainPanel.add(p);
        mainPanel.add(new JScrollPane(display));
        mainPanel.add(btn);

        // set properties of the frame
        setLayout(new BorderLayout());
        add(mainPanel, BorderLayout.CENTER);

        btn.addActionListener(new ButtonListener()); // Register listener for the button

        setTitle("Client Side");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame
        setVisible(true); // It is necessary to show the frame here!

        try {
            // Create a socket to connect to the server
            Socket socket = new Socket("localhost", 8000);

            // Create an input stream to receive data from the server
            fromServer = new DataInputStream(
                    socket.getInputStream());

            // Create an output stream to send data to the server
            toServer =
                    new DataOutputStream(socket.getOutputStream());
        }
        catch (IOException ex) {
            display.append(ex.toString() + '\n');
        }
    }

    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                // Get the radius from the text field
                double weight_from_cl = Double.parseDouble(weight.getText().trim());
                double height_from_cl = Double.parseDouble(height.getText().trim());

                // Send the radius to the server
                toServer.writeDouble(weight_from_cl);
                toServer.writeDouble(height_from_cl);
                toServer.flush();

                // Get area from the server
                double BMI = fromServer.readDouble();

                // Display to the text area
                display.append("Weight is " + weight_from_cl + "\n");
                display.append("Height is " + height_from_cl + "\n");
                display.append("BMI received from the server is "
                        + BMI + '\n');
            }
            catch (IOException ex) {
                System.err.println(ex);
            }
        }
    }
}