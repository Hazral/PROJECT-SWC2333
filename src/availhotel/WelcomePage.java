
package availhotel;

/**
* PROGRAM DESCRIPTION: TO CREATE A WELCOME PAGE FOR AVAIL HOTEL BOOKING SYSTEM
*
* VISH
* 19 APRIL 2024
*/

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class WelcomePage extends JFrame implements ActionListener {
    
    //Declaration variable
    JButton booking;
    
    WelcomePage() {
        
        //create a title for WelcomePage Frame
        setTitle("Avail Hotel");
        setBounds(100,100,1500,800);
        setLayout(null);
        
        //create ImageIcon for background image
        ImageIcon WelcomePage = new ImageIcon(ClassLoader.getSystemResource("icon/WelcomePage.jpg"));
        
        //create JLabel for image
        JLabel image = new JLabel(WelcomePage);
        image.setBounds(0,0,1500,800);
        
        //adding JLabel image to JFrame
        add(image);
        
        //create JLabel for text
        JLabel text = new JLabel("WELCOME TO AVAIL  HOTEL  BOOKING  SYSTEM");
        text.setBounds(50,620,1300,50);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Tekton Pro", Font.BOLD, 40));
        
        //adding JLabel text to JLabel image
        image.add(text);
        
        //create JButton for booking button
        booking = new JButton();
        booking.setText("Start Booking!");
        booking.setBounds(1200,620,150,50);
        booking.setBackground(Color.GREEN);
        
        //Register to a Listener
        booking.addActionListener(this);
        
        //adding JButton booking to JLabel image
        image.add(booking);
        
        setVisible(true);
       
    }//end of constructor
    
    // Method overriding
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == booking) {
            dispose();
            new DestinationSelection();
        }//end of if
    }//end of method
    
    public static void main(String[] args) {
        WelcomePage WelcomePage = new WelcomePage();
    }//end of main
    
}//end of class
