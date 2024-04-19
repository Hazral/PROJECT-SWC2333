package availhotel;

/**
* PROGRAM DESCRIPTION: TO CREATE A RECEIPT PAGE FOR AVAIL HOTEL BOOKING SYSTEM
*
* ARAL
* 19 APRIL 2024
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ReceiptPage extends JFrame {

    //Declaration variables
    private JButton proceed, back;
    private JTextField nameTextField, ageTextField, contactTextField;
    private int numberOfNights; // Variable to store the number of nights
    private List<String> selectedAmenitiesList; // List to store selected amenities

    public ReceiptPage(String selectedRoom, int numberOfNights) {
        
        // Assign the value of numberOfNights
        this.numberOfNights = numberOfNights; 
        
        //create title for ReceiptPage
        setTitle("RECEIPT");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1000, 500);
        setLayout(null);

        //create JLabel for roomLabel
        JLabel roomLabel = new JLabel("Selected Room:");
        roomLabel.setBounds(50, 30, 150, 30);
        add(roomLabel);

        //create JLabel nigthsLabel
        // Display number of nights
        JLabel nightsLabel = new JLabel("Number of Nights: " + numberOfNights);
        nightsLabel.setBounds(50, 360, 150, 30);
        
        //adding nightsLabel to JFrame
        add(nightsLabel);
        
        //create JLabel for selectedRoomLable
        JLabel selectedRoomLabel = new JLabel(selectedRoom);
        selectedRoomLabel.setBounds(200, 30, 150, 30);
        
        //adding selectedRoomLabel
        add(selectedRoomLabel);

        //create JLabel for amenitiesLabel
        JLabel amenitiesLabel = new JLabel("Select Amenities:");
        amenitiesLabel.setBounds(50, 70, 150, 30);
        
        //adding amenitiesLabe1 to JFrame
        add(amenitiesLabel);

        //create JCheckBox for wifiCheckBox
        JCheckBox wifiCheckbox = new JCheckBox("Wi-Fi");
        wifiCheckbox.setBounds(200, 70, 100, 30);
        
        //adding wifiCheckBox to JFrame
        add(wifiCheckbox);

        //create JCheckBox for breakfastCheckBox
        JCheckBox breakfastCheckbox = new JCheckBox("Breakfast");
        breakfastCheckbox.setBounds(300, 70, 100, 30);
        
        //adding breakfastCheckBox to JFrame
        add(breakfastCheckbox);

        //JCheckBox for gymCheckBox
        JCheckBox gymCheckbox = new JCheckBox("Gym Access");
        gymCheckbox.setBounds(400, 70, 120, 30);
        
        //adding gymCheckBox to JFrame
        add(gymCheckbox);

        //create JLabel for nameLabel
        JLabel nameLabel = new JLabel("Name :");
        nameLabel.setBounds(50, 200, 100, 30);
        
        //adding nameLabel to JFrame
        add(nameLabel);

        //create JTextField for nameTextField
        nameTextField = new JTextField();
        nameTextField.setBounds(200, 200, 150, 30);
        
        //adding nameTextField to JFrame
        add(nameTextField);

        //create JLabel for ageLabel
        JLabel ageLabel = new JLabel("Age :");
        ageLabel.setBounds(50, 240, 100, 30);
        
        //adding ageLabel to JFrame
        add(ageLabel);

        //create JTextField for ageTextField
        ageTextField = new JTextField();
        ageTextField.setBounds(200, 240, 150, 30);
        
        //adding age TextField to JFrame
        add(ageTextField);
        
        //create JLabel for contactLabel
        JLabel contactLabel = new JLabel("Contact No :");
        contactLabel.setBounds(50, 280, 100, 30);
        
        //adding contactLabel to JFrame
        add(contactLabel);

        //create JTextField for contactTextField
        contactTextField = new JTextField();
        contactTextField.setBounds(200, 280, 150, 30);
        
        //adding contactTextField to JFrame
        add(contactTextField);

        //create JButton for proceed
        proceed = new JButton("Checkout");
        proceed.setForeground(Color.BLUE);
        proceed.setBounds(800, 400, 150, 50);
        
        //Register to Listener
        proceed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameTextField.getText();
                String age = ageTextField.getText();
                String contact = contactTextField.getText();
                
                // Collect selected amenities
                selectedAmenitiesList = new ArrayList<>();
                if (wifiCheckbox.isSelected()) {
                    selectedAmenitiesList.add("Wi-Fi");
                }
                if (breakfastCheckbox.isSelected()) {
                    selectedAmenitiesList.add("Breakfast");
                }
                if (gymCheckbox.isSelected()) {
                    selectedAmenitiesList.add("Gym Access");
                }//end of if
                // Pass the total price with nights to CheckOutFrame
                double totalPrice = calculateTotalPrice(selectedRoom);
                new CheckOutFrame(selectedRoom, selectedAmenitiesList.toArray(new String[0]), name, age, contact, totalPrice, numberOfNights);
                dispose(); // Close the current window
            }//end of method
        });
        
        //adding proceed to JFrame
        add(proceed);

        //create JButton for back
        back = new JButton("Back");
        back.setForeground(Color.BLUE);
        back.setBounds(100, 400, 100, 50);
        
        //Register to Listener
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RoomSelection();
                dispose(); // Close the current window
            }//end of method
        });
        
        //adding back to JFrame
        add(back);

        setVisible(true);
    }//end of constructor

    
    private double getRoomPrice(String selectedRoom) {
        if (selectedRoom.equals("Standard")) {
            return 100.0;
        } else if (selectedRoom.equals("Deluxe")) {
            return 150.0;
        } else if (selectedRoom.equals("Suite")) {
            return 200.0;
        }
        return 0;
    }

    
    private double calculateTotalPrice(String selectedRoom) {
        double roomPrice = getRoomPrice(selectedRoom);
        double totalNights = roomPrice * numberOfNights;
        double amenitiesPrice = getAmenitiesPrice(selectedAmenitiesList.toArray(new String[0]));
        return totalNights + amenitiesPrice;
    }//end of method

    private double getAmenitiesPrice(String[] selectedAmenities) {
        double totalPrice = 0;
        for (String amenity : selectedAmenities) {
            switch (amenity) {
                case "Wi-Fi":
                    totalPrice += 10.0;
                    break;
                case "Breakfast":
                    totalPrice += 20.0;
                    break;
                case "Gym Access":
                    totalPrice += 30.0;
                    break;
            }//end of switch case
        }//end of for
        return totalPrice;
    }//end of method
}//end of class
