package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.text.NumberFormat;

public class BalanceEnquiry extends JFrame implements ActionListener{
    
    JButton back;
    String pinnumber;

    BalanceEnquiry(String pinnumber) {
        
        this.pinnumber = pinnumber;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        back = new JButton("BACK");
        back.setBounds(360, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);

        Conn c = new Conn();
        int balance = 0;

        try {
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '" + pinnumber + "'");
            NumberFormat nf = NumberFormat.getNumberInstance();
            while (rs.next()) {
                int amt = nf.parse(rs.getString("amount")).intValue();
                if (rs.getString("type").equals("Deposit")) {
                    balance += amt;
                } else {
                    balance -= amt;
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        } 

        JLabel text = new JLabel("Your Current Account Balance is Rs. " +balance);
        text.setForeground(Color.WHITE);
        text.setBounds(170, 300, 400, 30);
        text.setFont(new Font("System", Font.BOLD, 14));
        image.add(text);

        setSize(900, 900);
        setLocation(550, 100);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
    }

    public static void main(String[] args) {
        new BalanceEnquiry("");
    }
}
