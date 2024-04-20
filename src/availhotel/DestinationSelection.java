package availhotel;

/**
* PROGRAM DESCRIPTION: TO CREATE A DESTINATION SELECTION PAGE FOR AVAIL HOTEL BOOKING SYSTEM
*
* AQIL
* 19 APRIL 2024
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DestinationSelection extends JFrame implements ActionListener {

    //Declaration variables
    private JButton pickRoomButton, backButton;
    private JComboBox<String> destinationComboBox;

    public DestinationSelection() {
        
        //create title for DestinationSelection Frame
        setTitle("DESTINATION SELECTION");
        setSize(1000, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame

        //create JPanel for mainPanel
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.WHITE);

        //create JLabel for titleLabel
        JLabel titleLabel = new JLabel("CHOOSE YOUR DESTINATION");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(new Font("MV Boli", Font.BOLD, 30));
        titleLabel.setForeground(Color.BLACK);

        //create JPanel for centerPanel
        JPanel centerPanel = new JPanel(new GridLayout(2, 1));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        centerPanel.setBackground(Color.WHITE);

        //create Jpanel for comboBoxPanel
        JPanel comboBoxPanel = new JPanel();
        comboBoxPanel.setBackground(Color.WHITE);
       
        //create JLabel for destinationLabel
        JLabel destinationLabel = new JLabel("Destination:");
        
        //create JComboBox for destinationComboBox
        destinationComboBox = new JComboBox<>(new String[]{"Melaka", "Kedah", "Terengganu", "Sabah", "Selangor"});
        
        //adding destinationLabel to comboBoxPanel
        comboBoxPanel.add(destinationLabel);
        
        //adding destinationComboBox to comboBoxPanel
        comboBoxPanel.add(destinationComboBox);

        //create  JPanel for buttonPanel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        pickRoomButton = new JButton("Pick Your Room");
        pickRoomButton.setForeground(Color.BLUE);
        
        //Register to a Listener
        pickRoomButton.addActionListener(this);
        
        //create JButton for backButton
        backButton = new JButton("Back");
        backButton.setForeground(Color.BLUE);
        
        //Register to a Listener
        backButton.addActionListener(this);
        
        //adding backButton to buttonPanel
        buttonPanel.add(backButton);
        
        //adding pickRoomButton to buttonPanel
        buttonPanel.add(pickRoomButton);

        //adding comboBoxPanel to centerPanel
        centerPanel.add(comboBoxPanel);
        
        //adding buttonPanel to centerPanel
        centerPanel.add(buttonPanel);

        //adding titleLable to mainPanel
        mainPanel.add(titleLabel, BorderLayout.NORTH);
        
        //adding centerPanel to mainPanel
        mainPanel.add(centerPanel, BorderLayout.CENTER);

        //adding mainPanel to JFrame
        add(mainPanel);
        
        setVisible(true);
    }//end of constructor

    // Method overriding
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == pickRoomButton) {
            dispose();
            new RoomSelection();
        } else if (e.getSource() == backButton) {
            dispose();
            new WelcomePage();
        }//end of if
    }//end of method

    public static void main(String[] args) {
        new DestinationSelection();
    }//end of main
}//end of class

