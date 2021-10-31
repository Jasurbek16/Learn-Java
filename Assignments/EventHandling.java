/*
Jasurbek Mamurov
U2010164
Assignment #6
Event Handling 
*/

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;
import javax.swing.border.TitledBorder;


public class EventHandling extends JFrame implements ActionListener, ItemListener{

    //creating basic GUI components
    private JTextField email = new JTextField(20);
    private JTextField name = new JTextField(15);
    private JPasswordField password = new JPasswordField(10);
    private JButton sign_in = new JButton("Sign In");
    private JButton sign_up = new JButton("Sign Up");
    private JCheckBox remember_me = new JCheckBox("Remember me");
    private JCheckBox notifications = new JCheckBox("Notifications");
    public JRadioButton soc = new JRadioButton("SOCIE"), sol = new JRadioButton("SOL");
    
    // Choices for a combo-box
    private String[] languages = {"English", "Russian", "Uzbek"};
    private JComboBox<String> lang_choice = new JComboBox<String>(languages);

    public EventHandling() {
        
        // setting the frame's layout
        setLayout(new BorderLayout(0,0));

        // main panel containing elements
        JPanel p1 = new JPanel(new GridLayout(6, 2));
        // a panel for texts
        JPanel p2 = new JPanel(new GridLayout(3, 2));
        // radio button panel for choosing a school
        JPanel rd_btn_pnl = new JPanel(new FlowLayout());
        rd_btn_pnl.add(soc);
        rd_btn_pnl.add(sol);
        
        // grouping school radio buttons
        ButtonGroup school_btn = new ButtonGroup();
        school_btn.add(soc);
        school_btn.add(sol);

        // a language panel for combo-box
        JPanel lang_choice_pnl = new JPanel(new BorderLayout(1, 1));
        lang_choice_pnl.setBorder(new TitledBorder("Language"));
        lang_choice_pnl.add(lang_choice, BorderLayout.CENTER);

        // a panel for containing buttons
        JPanel btn_pnl = new JPanel(new FlowLayout(1));
        btn_pnl.add(sign_in);
        btn_pnl.add(sign_up);
        
        // setting a tool tip
        sign_up.setToolTipText("New User?");
        sign_in.setToolTipText("Existing User?");

        // adding listeners for the buttons
        sign_in.addActionListener(this);
        sign_up.addActionListener(this);
        
        // adding listeners for the check-boxes
        remember_me.addActionListener(this);
        remember_me.addItemListener(this);
        notifications.addActionListener(this);
        notifications.addItemListener(this);

        // adding listeners for the combo-box
        lang_choice.addActionListener(this);
        lang_choice.addItemListener(this);

        // adding listeners for the radio-buttons
        soc.addActionListener(this);
        soc.addItemListener(this);
        sol.addActionListener(this);
        sol.addItemListener(this);

	// adding listeners for the text-field
	name.addActionListener(this);
        email.addActionListener(this);
        password.addActionListener(this);
	
        // main panel manipulation
        p1.setBorder(new TitledBorder("Registration"));
        // setting a font
        p1.setFont(new Font("SansSerif", Font.BOLD, 5));

        // add fields
        p2.add(new JLabel("First Name"));
        p2.add(name);
        p2.add(new JLabel("Email"));
        p2.add(email);
        p2.add(new JLabel("Password"));
        p2.add(password);
        p1.add(p2);
        p1.add(rd_btn_pnl);
        p1.add(btn_pnl);
        p1.add(remember_me);
        p1.add(notifications);
        p1.add(lang_choice_pnl);

        // add the main panel to the frame
        add(p1, BorderLayout.CENTER);

    }

    // a method for ActionEvent handling
    public void actionPerformed(ActionEvent ae) {
        // radio buttons
        if(ae.getSource() == sign_in)
            System.out.println("-----\nSign in button is clicked\n-----");
        else if(ae.getSource() == sign_up)
            System.out.println("-----\nSign up button is clicked\n-----");
        // checkboxes
        else if(ae.getSource() == remember_me || ae.getSource() == notifications)
            System.out.println("Checkbox is clicked\n-----");
        // radio-buttons
        else if(ae.getSource() == soc || ae.getSource() == sol)
            System.out.println("Radio Button is clicked\n-----");
        // combo-box
        else if(ae.getSource() == lang_choice)
            System.out.println("Language combo-box is clicked\n-----");
	else if(ae.getSource() == name)
	// text-fields
	    System.out.println("-----\nName field worked\n-----");
	else if(ae.getSource() == email)
	    System.out.println("-----\nEmail field worked\n-----");
	else if(ae.getSource() == password)
	    System.out.println("-----\nPassword field worked\n-----");
    }

    // event handling method for ItemEvent s
    public void itemStateChanged(ItemEvent ie) {
        
        // radio buttons
        if(ie.getSource() == soc  && ie.getStateChange() == 1)
            System.out.println("-----\nSOCIE radio button is chosen");
        else if(ie.getSource() == sol && ie.getStateChange() == 1)
            System.out.println("-----\nSOL radio button is chosen");
        // checkboxes
        else if(ie.getSource() == remember_me && ie.getStateChange() == 1)
            System.out.println("-----\nRemember_me checkbox is checked");
        else if(ie.getSource() == remember_me && ie.getStateChange() == 2)
            System.out.println("-----\nRemember_me checkbox is unchecked");
        
        else if(ie.getSource() == notifications && ie.getStateChange() == 1)
            System.out.println("-----\nNotifications checkbox is checked");
        else if(ie.getSource() == notifications && ie.getStateChange() == 2)
            System.out.println("-----\nNotifications checkbox is unchecked");
        // combo-box
        else if(ie.getSource() == lang_choice && ie.getStateChange() == 1)
            System.out.println("-----\n" + ie.getItem() + " language is chosen");

    }

    public static void main(String[] args) {

        // Create a frame and set its properties
        EventHandling frame = new EventHandling();
        frame.setTitle("MyAccount.com");
        frame.setSize(350, 400);
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
