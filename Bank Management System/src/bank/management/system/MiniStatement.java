package bank.management.system;

import java.awt.*;
import java.sql.ResultSet;
import java.text.NumberFormat;

import javax.swing.*;

public class MiniStatement extends JFrame {

    JLabel bank, card, mini, balance;
    String pinnumber;

    MiniStatement(String pinnumber) {

        this.pinnumber = pinnumber;

        setTitle("MiniStatement");
        ;

        setLayout(null);

        mini = new JLabel();

        add(mini);

        bank = new JLabel("XYZ Bank");
        bank.setBounds(160, 30, 100, 20);
        bank.setFont(new Font("Raleway", Font.BOLD, 20));
        add(bank);

        card = new JLabel();
        card.setBounds(20, 90, 300, 20);
        card.setFont(new Font("Raleway", Font.BOLD, 14));
        add(card);

        balance = new JLabel();
        balance.setBounds(20, 400, 300, 20);
        balance.setFont(new Font("Raleway", Font.BOLD, 14));
        add(balance);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from login where pin = '" + pinnumber + "'");
            while (rs.next()) {
                card.setText("Card Number: " + rs.getString("CARD_NO").substring(0, 4) + "-XXXX-XXXX-"
                        + rs.getString("CARD_NO").substring(rs.getString("CARD_NO").length() - 4));
                //card.setFont(new Font("Raleway", Font.BOLD, 14));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        
        try {
            Conn c = new Conn();
            int totalBalance = 0;
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '" + pinnumber + "'");
            NumberFormat nf = NumberFormat.getNumberInstance();
            while (rs.next()) {
                int amt = nf.parse(rs.getString("amount")).intValue();
                if (rs.getString("type").equals("Deposit")) {
                    totalBalance += amt;
                } else {
                    totalBalance -= amt;
                }
            }
            balance.setText("Your current account balance is Rs. " + totalBalance);
        }
        catch (Exception e) {
            e.printStackTrace();
        } 

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("SELECT * FROM bank WHERE pin = '"+pinnumber+"' ORDER BY date DESC LIMIT 10");
        
            StringBuilder table = new StringBuilder("<html><pre>");
            table.append("Date                 Type       Amount\n");
            table.append("------------------------------------------\n");
        
            while (rs.next()) {
                String date = rs.getString("date");
                String type = rs.getString("type");
                String amount = rs.getString("amount");
        
                // Format each line with padding (fixed-width style)
                table.append(String.format("%-20s %-10s %s\n", date, type, amount));
            }
        
            table.append("</pre></html>");
            mini.setFont(new Font("Courier New", Font.PLAIN, 12));  // Use monospaced font
            mini.setText(table.toString());
        
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        mini.setBounds(20, 140, 400, 200);
        setSize(400, 600);
        setLocation(800, 200);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MiniStatement("");
    }
}