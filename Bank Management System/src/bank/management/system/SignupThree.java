package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//import java.util.*;
import java.util.Random;

public class SignupThree extends JFrame implements ActionListener{

    JButton cancel, submit;
    JRadioButton r1, r2, r3, r4;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    String formno;

    SignupThree(String formno) {

        this.formno = formno;

        setLayout(null);

        setTitle("NEW ACOUNT APPLICATION FORM - PAGE 3");

        JLabel l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(280, 40, 400, 40);
        add(l1);

        JLabel type = new JLabel("Account Type: ");
        type.setFont(new Font("Raleway", Font.BOLD, 22));
        type.setBounds(100, 140, 200, 30);
        add(type);

        r1 = new JRadioButton("Savings Account");
        r1.setFont(new Font("Raleway", Font.BOLD, 16));
        r1.setBounds(100, 180, 250, 20);
        r1.setBackground(Color.WHITE);
        add(r1);

        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway", Font.BOLD, 16));
        r2.setBounds(350, 180, 250, 20);
        r2.setBackground(Color.WHITE);
        add(r2);

        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway", Font.BOLD, 16));
        r3.setBounds(100, 220, 250, 20);
        r3.setBackground(Color.WHITE);
        add(r3);

        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Raleway", Font.BOLD, 16));
        r4.setBounds(350, 220, 250, 20);
        r4.setBackground(Color.WHITE);
        add(r4);

        ButtonGroup accountGroup = new ButtonGroup();
        accountGroup.add(r1);
        accountGroup.add(r2);
        accountGroup.add(r3);
        accountGroup.add(r4);

        JLabel card = new JLabel("Card Number: ");
        card.setFont(new Font("Raleway", Font.BOLD, 22));
        card.setBounds(100, 300, 200, 30);
        add(card);

        JLabel cnumber = new JLabel("XXXX-XXXX-XXXX-1234");
        cnumber.setFont(new Font("Raleway", Font.BOLD, 22));
        cnumber.setBounds(330, 300, 300, 30);
        add(cnumber);

        JLabel cdetail = new JLabel("(Your 16 Digit Card Number)");
        cdetail.setFont(new Font("Raleway", Font.BOLD, 12));
        cdetail.setBounds(100, 330, 300, 20);
        add(cdetail);

        JLabel pin = new JLabel("PIN: ");
        pin.setFont(new Font("Raleway", Font.BOLD, 22));
        pin.setBounds(100, 370, 200, 30);
        add(pin);

        JLabel pnumber = new JLabel("XXXX");
        pnumber.setFont(new Font("Raleway", Font.BOLD, 22));
        pnumber.setBounds(330, 370, 300, 30);
        add(pnumber);

        JLabel pdetail = new JLabel("(Your 4 Digit PIN)");
        pdetail.setFont(new Font("Raleway", Font.BOLD, 12));
        pdetail.setBounds(100, 400, 300, 20);
        add(pdetail);

        JLabel services = new JLabel("Services Required: ");
        services.setFont(new Font("Raleway", Font.BOLD, 22));
        services.setBounds(100, 450, 200, 30);
        add(services);

        c1 = new JCheckBox("ATM CARD");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway", Font.BOLD, 16));
        c1.setBounds(100, 500, 200, 30);
        add(c1);
        
        c2 = new JCheckBox("INTERNET BANKING");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway", Font.BOLD, 16));
        c2.setBounds(350, 500, 200, 30);
        add(c2);

        c3 = new JCheckBox("MOBILE BANKING");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway", Font.BOLD, 16));
        c3.setBounds(100, 550, 200, 30);
        add(c3);

        c4 = new JCheckBox("EMAIL & SMS ALERTS");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway", Font.BOLD, 16));
        c4.setBounds(350, 550, 200, 30);
        add(c4);

        c5 = new JCheckBox("CHEQUE BOOK");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway", Font.BOLD, 16));
        c5.setBounds(100, 600, 200, 30);
        add(c5);

        c6 = new JCheckBox("E-STATEMENT");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway", Font.BOLD, 16));
        c6.setBounds(350, 600, 200, 30);
        add(c6);

        c7 = new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge.");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway", Font.BOLD, 12));
        c7.setBounds(100, 660, 600, 30);
        add(c7);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.setBounds(250, 720, 100, 30);
        cancel.addActionListener(this);
        add(cancel);
        
        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setBounds(420, 720, 100, 30);
        submit.addActionListener(this);
        add(submit);

        getContentPane().setBackground(Color.WHITE);

        setSize(850, 800);
        setLocation(540, 150);
        setVisible(true);
    }

    public void actionPerformed (ActionEvent ae) {
        if (ae.getSource() == submit) {
            String accountType = null;
            if (r1.isSelected()) {
                accountType = "Savings Account";
            }
            else if (r2.isSelected()) {
                accountType = "Fixed Deposit Account";
            }
            else if (r3.isSelected()) {
                accountType = "Current Account";
            }
            else if (r4.isSelected()) {
                accountType = "Reccuring Deposit Account";
            }

            Random random = new Random();

            String cardnumber = "" + Math.abs((random.nextLong() % 90000000) + 5040936000000000L);
            String pinnumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L);

            String facility = "";
            if (c1.isSelected()) {
                facility = facility + "ATM CARD, ";
            }
            if (c2.isSelected()) {
                facility = facility + "INTERNET BANKING, ";
            }
            if (c3.isSelected()) {
                facility = facility + "MOBILE BANKING, ";
            }
            if (c4.isSelected()) {
                facility = facility + "EMAIL & SMS ALERTS, ";
            }
            if (c5.isSelected()) {
                facility = facility + "CHEQUE BOOK, ";
            }
            if (c6.isSelected()) {
                facility = facility + "E-STATEMENT, ";
            }
            if (!facility.equals("")) {
                facility = facility.substring(0, facility.length() - 2);
            }
            
            try {
                if (accountType == null) {
                    JOptionPane.showMessageDialog(null, "Select Account Type!");
                }
                else if (!c7.isSelected()){
                    JOptionPane.showMessageDialog(null, "Veryfy the Information!");
                }
                else {
                    Conn c = new Conn();
                    String query1 = "insert into signupthree values ('"+formno+"', '"+accountType+"', '"+cardnumber+"', '"+pinnumber+"', '"+facility+"')";
                    String query2 = "insert into login values ('"+formno+"', '"+cardnumber+"', '"+pinnumber+"')";
                    
                    c.s.executeUpdate(query1); 
                    c.s.executeUpdate(query2); 

                    JOptionPane.showMessageDialog(null, "Card Number: " + cardnumber + "\nPIN: " + pinnumber);
                    setVisible(false);
                    new Deposit(pinnumber).setVisible(true);;
                }
            } 
            catch (Exception e) {
                e.printStackTrace();
            }

        }
        else if (ae.getSource() == cancel) {
            setVisible(false);
            new Login().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new SignupThree("");
    } 
}
