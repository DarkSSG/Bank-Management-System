package bank.management.system;

import java.awt.event.*;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Date;

import javax.swing.*;
import java.awt.*;

public class FastCash extends JFrame implements ActionListener {

    JButton amount1, amount2, amount3, amount4, amount5, amount6, back;
    String pinnumber;

    FastCash(String pinnumber) {

        this.pinnumber = pinnumber;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("Select withdrawal amount");
        text.setBounds(210, 300, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        amount1 = new JButton("Rs. 100");
        amount1.setBounds(160, 415, 150, 30);
        amount1.addActionListener(this);
        image.add(amount1);

        amount2 = new JButton("Rs. 500");
        amount2.setBounds(160, 450, 150, 30);
        amount2.addActionListener(this);
        image.add(amount2);

        amount3 = new JButton("Rs. 1,000");
        amount3.setBounds(160, 485, 150, 30);
        amount3.addActionListener(this);
        image.add(amount3);

        amount4 = new JButton("Rs. 2,000");
        amount4.setBounds(360, 415, 150, 30);
        amount4.addActionListener(this);
        image.add(amount4);

        amount5 = new JButton("Rs. 5,000");
        amount5.setBounds(360, 450, 150, 30);
        amount5.addActionListener(this);
        image.add(amount5);

        amount6 = new JButton("Rs. 10,000");
        amount6.setBounds(360, 485, 150, 30);
        amount6.addActionListener(this);
        image.add(amount6);

        back = new JButton("BACK");
        back.setBounds(360, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);

        setSize(900, 900);
        setLocation(550, 100);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        } else {
            String amount = ((JButton) ae.getSource()).getText().replace("Rs. ", "").replace(",", "").trim();
            Conn c = new Conn();
            try {
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '" + pinnumber + "'");
                NumberFormat nf = NumberFormat.getNumberInstance();
                int balance = 0;
                while (rs.next()) {
                    int amt = nf.parse(rs.getString("amount")).intValue();
                    if (rs.getString("type").equals("Deposit")) {
                        balance += amt;
                    } else {
                        balance -= amt;
                    }
                }
                if (ae.getSource() != back && balance < Integer.parseInt(amount)) {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }
                Date date = new Date();
                DecimalFormat df = new DecimalFormat("#,##0.00");
                String formattedAmount = df.format(Double.parseDouble(amount));
                String query = "insert into bank values('" + pinnumber + "', '" + date + "', 'Withdraw', '" + formattedAmount + "')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs. " + formattedAmount + " Debited Successfully");
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new FastCash("");
    }
}
