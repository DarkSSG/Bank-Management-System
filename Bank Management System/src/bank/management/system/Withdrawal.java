package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;

public class Withdrawal extends JFrame implements ActionListener {

    JButton withdrawal, back;
    JTextField amountTextField;
    String pinnumber;

    Withdrawal(String pinnumber) {

        this.pinnumber = pinnumber;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("Enter the amount you want to withdraw");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(190, 300, 400, 20);
        image.add(text);

        amountTextField = new JTextField();
        amountTextField.setFont(new Font("Raleway", Font.BOLD, 22));
        amountTextField.setBounds(190, 350, 290, 30);
        image.add(amountTextField);

        withdrawal = new JButton("Withdraw");
        withdrawal.setBounds(355, 485, 150, 30);
        withdrawal.addActionListener(this);
        image.add(withdrawal);

        back = new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);

        setSize(900, 900);
        setLocation(540, 60);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == withdrawal) {
            String amount = amountTextField.getText();
            Date date = new Date();
            if (amount.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please Enter an Amount");
            } else if (!amount.matches("\\d+(\\.\\d{1,2})?")) {
                JOptionPane.showMessageDialog(null, "Amount must be a numeric value (e.g., 500 or 500.00)");
            } else {

                try {
                    // Remove commas from the input before parsing
                    String amountWithoutCommas = amount.replace(",", "");

                    // Parse the cleaned amount
                    double amountDouble = Double.parseDouble(amountWithoutCommas);

                    // Check if the amount exceeds the maximum withdraw limit
                    if (amountDouble > 10000) {
                        JOptionPane.showMessageDialog(null, "The maximum withdraw amount is Rs. 10,000.");
                        return; // Exit method if amount is too large
                    }

                    // Format the number with commas and two decimal places
                    DecimalFormat df = new DecimalFormat("#,###.00");
                    String formattedAmount = df.format(amountDouble); // Format it as a string with commas and decimals

                    // Insert the withdraw into the database
                    insertWithdrawToDatabase(formattedAmount, date);

                    // Show confirmation with formatted amount
                    JOptionPane.showMessageDialog(null, "Rs. " + formattedAmount + " Withdrawn Successfully");
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                } catch (SQLException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage());
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid amount format. Please enter a valid number.");
                }
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }

    // Method to insert withdraw record into database
    private void insertWithdrawToDatabase(String formattedAmount, Date date) throws SQLException {
        // Format the date for storage
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = sdf.format(date);

        Conn c = new Conn();
        String query = "INSERT INTO bank VALUES('" + pinnumber + "', '" + formattedDate + "', 'Withdraw', '" + formattedAmount + "')";
        c.s.executeUpdate(query);
    }

    public static void main(String[] args) {
        new Withdrawal("");
    }
}
