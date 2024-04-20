package availhotel;

/**
* PROGRAM DESCRIPTION: TO CREATE A ROOM SELECTION PAGE FOR AVAIL HOTEL BOOKING SYSTEM
*
* KHAI
* 19 APRIL 2024
*/

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class RoomSelection extends JFrame {

    //Declaration variables
    private JButton proceed, back;
    private JRadioButton standardRadio, deluxeRadio, suiteRadio;
    private JSpinner nightsSpinner;

    public RoomSelection() {
        
        //create title for RoomSelection
        setTitle("ROOM SELECTION");
        setSize(1000, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame

        //create Jpanel for mainPanel
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.WHITE);

        //create JPanel for panel
        JPanel panel = new JPanel(new GridLayout(5, 1)); // Increased row count for adding nights spinner
        panel.setBackground(Color.WHITE);
        mainPanel.add(panel, BorderLayout.CENTER);

        //create JLabel for text
        JLabel text = new JLabel("SELECT YOUR ROOM");
        text.setHorizontalAlignment(JLabel.CENTER);
        text.setFont(new Font("MV Boli", Font.BOLD, 30));
        text.setForeground(Color.BLACK);
        
        //adding text to mainPanel
        mainPanel.add(text, BorderLayout.NORTH);

        //create JRadioButton for standardRadio
        standardRadio = new JRadioButton("Standard (RM100 per night)");
        standardRadio.setHorizontalAlignment(SwingConstants.CENTER);
        
        //create JRadioButton for deluxeRadio
        deluxeRadio = new JRadioButton("Deluxe (RM150 per night)");
        deluxeRadio.setHorizontalAlignment(SwingConstants.CENTER);
        
        //create JRadioButton for suiteRadio
        suiteRadio = new JRadioButton("Suite (RM200 per night)");
        suiteRadio.setHorizontalAlignment(SwingConstants.CENTER);

        //create ButtonGroup for roomGroup
        ButtonGroup roomGroup = new ButtonGroup();
        
        //adding standardRadio, deluxeRadio and suiteRadio to roomGroup
        roomGroup.add(standardRadio);
        roomGroup.add(deluxeRadio);
        roomGroup.add(suiteRadio);

        //adding standardRadio, deluxeRadio and suiteRadio to panel
        panel.add(standardRadio);
        panel.add(deluxeRadio);
        panel.add(suiteRadio);

        // Add spinner for selecting number of nights
        JLabel nightsLabel = new JLabel("For how many nights you plan to stay?");
        nightsLabel.setHorizontalAlignment(JLabel.CENTER);
        
        //adding nigthsLabel to panel
        panel.add(nightsLabel);
        
        //create JSpinner for nightsSpinner
        nightsSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 30, 1)); // Default, min, max, step
        
        //adding nightsSpinner to panel
        panel.add(nightsSpinner);

        //create JButton for proceed
        proceed = new JButton("Proceed");
        back = new JButton("Back");

        //create JPanel for buttonPanel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.setBackground(Color.WHITE);
        
        //adding back and proceed to buttonPanel
        buttonPanel.add(back);
        buttonPanel.add(proceed);
        
        //adding buttonPanel to mainPanel
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        //Register to Listener
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new DestinationSelection();
            }
        });//end of method

        //Register to Listener
        proceed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedRoom = getSelectedRoom();
                if (selectedRoom != null) {
                    int numberOfNights = (int) nightsSpinner.getValue();
                    new ReceiptPage(selectedRoom, numberOfNights);
                    dispose(); // Close the current window
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a room.");
                }
            }
        });//end of method

        //adding mainPanel to JFrame
        add(mainPanel);
        
        setVisible(true);
    }//end of constructor

    private String getSelectedRoom() {
        if (standardRadio.isSelected()) {
            return "Standard";
        } else if (deluxeRadio.isSelected()) {
            return "Deluxe";
        } else if (suiteRadio.isSelected()) {
            return "Suite";
        } else {
            return null;
        }//end of else if else
    }//end of method

    public static void main(String[] args) {
        new RoomSelection();
    }//end of main
}//end of class
