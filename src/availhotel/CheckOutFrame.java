package availhotel;

/**
* PROGRAM DESCRIPTION: TO CREATE A CHECK OUT FRAME FOR AVAIL HOTEL BOOKING SYSTEM
*
* IDZHAM
* 19 APRIL 2024
*/


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckOutFrame extends JFrame {

    public CheckOutFrame(String selectedRoom, String[] selectedAmenities, String name, String age, String contact, double totalPrice, int numberOfNights) {
        
        //create title for CheckOutFrame
        setTitle("Check Out");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1000, 500);
        setLayout(null);

        //create JLabel for selected RoomLabel
        JLabel selectedRoomLabel = new JLabel("Selected Room: " + selectedRoom);
        selectedRoomLabel.setBounds(50, 30, 300, 30);
        
        //adding selectedRoomLabel to JFrame
        add(selectedRoomLabel);
        
        //create JLabel for nightsLabel
        JLabel nightsLabel = new JLabel("Number of Nights: " + numberOfNights);
        nightsLabel.setBounds(50, 70, 300, 30);
        
        //adding nightsLabel to JFrame
        add(nightsLabel);

        //create JLabel for nameLabel
        JLabel nameLabel = new JLabel("Name: " + name);
        nameLabel.setBounds(50, 110, 300, 30);
        
        //adding nameLabel to JFrame
        add(nameLabel);

        //create JLabel for ageLabel
        JLabel ageLabel = new JLabel("Age: " + age);
        ageLabel.setBounds(50, 150, 300, 30);
        
        //adding ageLabel to JFrame
        add(ageLabel);

        //create JLabel for contactLabel
        JLabel contactLabel = new JLabel("Contact No: " + contact);
        contactLabel.setBounds(50, 190, 300, 30);
        
        //adding contactLabel to JFrame
        add(contactLabel);

        //create JLabel for totalPriceLabel
        JLabel totalPriceLabel = new JLabel("Total Price: RM" + totalPrice);
        totalPriceLabel.setBounds(50, 230, 300, 30);
        
        //adding totalPriceLabel to JFrame
        add(totalPriceLabel);

        //create JButton for payButton
        JButton payButton = new JButton("Pay Now");
        payButton.setBounds(150, 300, 100, 30);
        
        //Register to Listener
        payButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform payment processing here
                JOptionPane.showMessageDialog(null, "Payment successful!\nEnjoy your stay!");
                dispose(); // Close the current window
            }//end of method
        });
        
        //adding payButton to JFrame
        add(payButton);

        setVisible(true);
    }//end of constructor
}//end of class
