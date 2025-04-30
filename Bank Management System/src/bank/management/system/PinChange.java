package bank.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;

import javax.swing.*;

public class PinChange extends JFrame implements ActionListener {

    JLabel text, pinText, rePinText;
    JPasswordField pinTextField, rePinTextField;
    JButton change, back;
    String pinnumber;

    PinChange(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        text = new JLabel("CHANGE YOUR PIN");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(260, 300, 500, 20);
        image.add(text);

        pinText = new JLabel("New PIN");
        pinText.setForeground(Color.WHITE);
        pinText.setFont(new Font("System", Font.BOLD, 16));
        pinText.setBounds(165, 340, 180, 20);
        image.add(pinText);

        pinTextField = new JPasswordField();
        pinTextField.setForeground(Color.BLACK);
        pinTextField.setFont(new Font("Raleway", Font.BOLD, 25));
        pinTextField.setBounds(330, 340, 180, 25);
        image.add(pinTextField);

        rePinText = new JLabel("Re-Enter New PIN");
        rePinText.setForeground(Color.WHITE);
        rePinText.setFont(new Font("System", Font.BOLD, 16));
        rePinText.setBounds(165, 380, 180, 20);
        image.add(rePinText);

        rePinTextField = new JPasswordField();
        rePinTextField.setForeground(Color.BLACK);
        rePinTextField.setFont(new Font("Raleway", Font.BOLD, 25));
        rePinTextField.setBounds(330, 380, 180, 25);
        image.add(rePinTextField);

        change = new JButton("CHANGE");
        change.setBounds(355, 485, 150, 30);
        change.addActionListener(this);
        image.add(change);

        back = new JButton("BACK");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);

        setSize(900, 900);
        setLocation(540, 60);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed (ActionEvent ae) {
        if (ae.getSource() == change) {
            try {
                String npin = pinTextField.getText();
                String rpin = rePinTextField.getText();
                
                if (npin.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter new PIN");
                    return;
                }
                if (!npin.matches("\\d{4}")) {
                    JOptionPane.showMessageDialog(null, "PIN must be exactly 4 digits and numeric");
                    return;
                }
                if (rpin.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please Re-enter new PIN");
                    return;
                }
                if (!npin.equals(rpin)) {
                    JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                    return;
                }

                Conn c = new Conn();
                String query1 = "update bank set pin = '"+rpin+"' where pin='"+pinnumber+"'";
                String query2 = "update login set pin = '"+rpin+"' where pin='"+pinnumber+"'";
                String query3 = "update signupthree set pin = '"+rpin+"' where pin='"+pinnumber+"'";

                int result1 = c.s.executeUpdate(query1);
                int result2 = c.s.executeUpdate(query2);
                int result3 = c.s.executeUpdate(query3);

                if (result1 == 0 && result2 == 0 && result3 == 0) {
                    JOptionPane.showMessageDialog(null, "No records were updated. Please check your current PIN or database.");
                    return;
                }

                PreparedStatement ps1 = c.c.prepareStatement("UPDATE bank SET pin = ? WHERE pin = ?");
                ps1.setString(1, rpin);
                ps1.setString(2, pinnumber);
                ps1.executeUpdate();

                PreparedStatement ps2 = c.c.prepareStatement("UPDATE login SET pin = ? WHERE pin = ?");
                ps2.setString(1, rpin);
                ps2.setString(2, pinnumber);
                ps2.executeUpdate();

                PreparedStatement ps3 = c.c.prepareStatement("UPDATE signupthree SET pin = ? WHERE pin = ?");
                ps3.setString(1, rpin);
                ps3.setString(2, pinnumber);
                ps3.executeUpdate();

                JOptionPane.showMessageDialog(null, "PIN changed successfully");
                
                setVisible(false);
                new Transactions(rpin).setVisible(true);
            } 
            catch (Exception e) {
                e.printStackTrace();
            }
        }  
        else {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new PinChange("").setVisible(true);
    }
}