package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener {
    
    JTextField panTextField, aadharTextField; 
    JButton next;
    JRadioButton sYes, sNo, eYes, eNo;
    JComboBox religionComboBox, categoryComboBox, incomeComboBox, educationComboBox, occupationComboBox;
    String formno;
    
    SignupTwo(String formno) {

        this.formno = formno;

        setLayout(null);

        setTitle("NEW ACOUNT APPLICATION FORM - PAGE 2");
        
        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(290, 80, 400, 30);
        add(additionalDetails);

        JLabel religion = new JLabel("Religion: ");
        religion.setFont(new Font("Raleway", Font.BOLD, 20));
        religion.setBounds(100, 140, 100, 30);
        add(religion);

        String valReligion[] = {"Select Religion", "Muslim", "Hindu", "Sikh", "Christian", "Others"};
        religionComboBox = new JComboBox(valReligion);
        religionComboBox.setBounds(300, 140, 400, 30);
        religionComboBox.setBackground(Color.WHITE);
        add(religionComboBox);

        JLabel category = new JLabel("Category: ");
        category.setFont(new Font("Raleway", Font.BOLD, 20));
        category.setBounds(100, 190, 200, 30);
        add(category);

        String valCategory[] = {"Select Category", "General", "OBC", "SC", "ST", "Others"};
        categoryComboBox = new JComboBox(valCategory);
        categoryComboBox.setBounds(300, 190, 400, 30);
        categoryComboBox.setBackground(Color.WHITE);
        add(categoryComboBox);

        JLabel income = new JLabel("Income: ");
        income.setFont(new Font("Raleway", Font.BOLD, 20));
        income.setBounds(100, 240, 200, 30);
        add(income);

        String valIncome[] = {"Select Income", "Null", "Less than 1,50,000", "Less than 2,50,000", "Less than 5,00,000", "Less than 10,00,000", "More than 10,00,000"};
        incomeComboBox = new JComboBox(valIncome);
        incomeComboBox.setBounds(300, 240, 400, 30);
        incomeComboBox.setBackground(Color.WHITE);
        add(incomeComboBox);

        JLabel educational = new JLabel("Educational");
        educational.setFont(new Font("Raleway", Font.BOLD, 20));
        educational.setBounds(100, 290, 200, 30);
        add(educational);
        JLabel qualification = new JLabel("Qualification: ");
        qualification.setFont(new Font("Raleway", Font.BOLD, 20));
        qualification.setBounds(100, 315, 200, 30);
        add(qualification);

        String valEcudation[] = {"Select Education Qualification", "Non-Graduate", "Graduate", "Post-Graduate", "Doctorate", "Others"};
        educationComboBox = new JComboBox(valEcudation);
        educationComboBox.setBounds(300, 315, 400, 30);
        educationComboBox.setBackground(Color.WHITE);
        add(educationComboBox);

        JLabel occupation = new JLabel("Occupation: ");
        occupation.setFont(new Font("Raleway", Font.BOLD, 20));
        occupation.setBounds(100, 390, 200, 30);
        add(occupation);

        String valOccuation[] = {"Select Occupation", "Salaried", "Self-Employed", "Business", "Student", "Retired", "Others"};
        occupationComboBox = new JComboBox(valOccuation);
        occupationComboBox.setBounds(300, 390, 400, 30);
        occupationComboBox.setBackground(Color.WHITE);
        add(occupationComboBox);

        JLabel pan = new JLabel("PAN Number: ");
        pan.setFont(new Font("Raleway", Font.BOLD, 20));
        pan.setBounds(100, 440, 200, 30);
        add(pan);

        panTextField = new JTextField();
        panTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        panTextField.setBounds(300, 440, 400, 30);
        add(panTextField);

        JLabel aadhar = new JLabel("Aadhar Number: ");
        aadhar.setFont(new Font("Raleway", Font.BOLD, 20));
        aadhar.setBounds(100, 490, 200, 30);
        add(aadhar);
        
        aadharTextField = new JTextField();
        aadharTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        aadharTextField.setBounds(300, 490, 400, 30);
        add(aadharTextField);

        JLabel senior = new JLabel("Senior Citizen: ");
        senior.setFont(new Font("Raleway", Font.BOLD, 20));
        senior.setBounds(100, 540, 200, 30);
        add(senior);

        sYes = new JRadioButton("Yes");
        sYes.setBounds(300, 540, 120, 30);
        sYes.setBackground(Color.WHITE);
        add(sYes);

        sNo = new JRadioButton("No");
        sNo.setBounds(450, 540, 120, 30);
        sNo.setBackground(Color.WHITE);
        add(sNo);

        ButtonGroup seniorGroup = new ButtonGroup();
        seniorGroup.add(sYes);
        seniorGroup.add(sNo);

        JLabel exist = new JLabel("Existing Account: ");
        exist.setFont(new Font("Raleway", Font.BOLD, 20));
        exist.setBounds(100, 590, 200, 30);
        add(exist);

        eYes = new JRadioButton("Yes");
        eYes.setBounds(300, 590, 120, 30);
        eYes.setBackground(Color.WHITE);
        add(eYes);

        eNo = new JRadioButton("No");
        eNo.setBounds(450, 590, 120, 30);
        eNo.setBackground(Color.WHITE);
        add(eNo);

        ButtonGroup existGroup = new ButtonGroup();
        existGroup.add(eYes);
        existGroup.add(eNo);


        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);

        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850, 800);
        setLocation(540, 150);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {

        String religion =(String) religionComboBox.getSelectedItem(); 
        String category = (String) categoryComboBox.getSelectedItem();
        String income = (String) incomeComboBox.getSelectedItem();
        String education = (String) educationComboBox.getSelectedItem();
        String occupation = (String) occupationComboBox.getSelectedItem();
        String senior = null;

        if (sYes.isSelected()) {
            senior = "Yes";
        }
        else if (sNo.isSelected()) {
            senior = "No";
        }

        String exist = null;

        if (eYes.isSelected()) {
            exist = "Yes";
        }
        else if (eNo.isSelected()) {
            exist = "No";
        }
        
        String pan = panTextField.getText();
        String aadhar = aadharTextField.getText();

        try {
            if (religion.equals("Select Religion")) {
                JOptionPane.showMessageDialog(null, "Religion is Required!");
            } 
            else if (category.equals("Select Category")) {
                JOptionPane.showMessageDialog(null, "Category is Required!");
            }
            else if (income.equals("Select Income")) {
                JOptionPane.showMessageDialog(null, "Income is Required!");
            }
            else if (education.equals("Select Ecucation")) {
                JOptionPane.showMessageDialog(null, "Ecucation is Required!");
            }
            else if (occupation.equals("Select Occupation")) {
                JOptionPane.showMessageDialog(null, "Occupation is Required!");
            }
            else if (pan.equals("")) {
                JOptionPane.showMessageDialog(null, "PAN Number is Required!");
            }
            else if (aadhar.equals("")) {
                JOptionPane.showMessageDialog(null, "Aadhar Number is Required!");
            }
            else if (!aadhar.matches("\\d{12}")) {
                JOptionPane.showMessageDialog(null, "Aadhar must be a 12-digit number!");
            }
            else if (senior == null) {
                JOptionPane.showMessageDialog(null, "Select Senior Citizen!");
            }
            else if (exist == null) {
                JOptionPane.showMessageDialog(null, "Select Existing Account!");
            }
            else {
                Conn c = new Conn();
                String query = "insert into signuptwo values ('"+formno+"', '"+religion+"', '"+category+"', '"+income+"', '"+education+"', '"+occupation+"', '"+pan+"', '"+aadhar+"', '"+senior+"', '"+exist+"')";
                c.s.executeUpdate(query);

                setVisible(false);
                new SignupThree(formno).setVisible(true);
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String args[]) {
        new SignupTwo("");
    }
}

