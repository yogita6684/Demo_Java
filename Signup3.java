package swiftcash.atm.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

// Signup2 screen for SwiftCash ATM System.
public class Signup3 extends JFrame implements ActionListener {

    // UI component declarations
    JRadioButton r1, r2, r3, r4;

    JCheckBox c1, c2, c3, c4, c5, c6, c7;

    JButton submit, back;

    String formno;

    public Signup3(String formno) {

        this.formno = formno;
        setTitle("APPLICATION FORM ");

        // Account details UI controls: Account type, card number, PIN, and service checkboxes etc
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(110, 110, Image.SCALE_DEFAULT);
        JLabel image = new JLabel(new ImageIcon(i2));
        image.setBounds(50, 20, 100, 100);
        add(image);

        JLabel l1 = new JLabel("Page 3");
        l1.setFont(new Font("Raleway", Font.BOLD, 20));
        l1.setBounds(365, 30, 600, 30);
        l1.setForeground(new Color(30, 41, 59));
        add(l1);

        JLabel l2 = new JLabel("Account Details");
        l2.setFont(new Font("Raleway", Font.BOLD, 20));
        l2.setBounds(325, 60, 600, 30);
        l2.setForeground(new Color(30, 41, 59));
        add(l2);

        JLabel l12 = new JLabel("Form No :");
        l12.setFont(new Font("Raleway", Font.BOLD, 14));
        l12.setBounds(700, 10, 200, 30);
        l12.setForeground(new Color(30, 41, 59));
        add(l12);

        JLabel l13 = new JLabel(formno);
        l13.setFont(new Font("Raleway", Font.BOLD, 12));
        l13.setBounds(760, 10, 60, 30);
        add(l13);

        JLabel l3 = new JLabel("Account Type :");
        l3.setFont(new Font("Raleway", Font.BOLD, 18));
        l3.setBounds(100, 140, 200, 30);
        l3.setForeground(new Color(30, 41, 59));
        add(l3);

        r1 = createRadio("Saving Account", 100, 180, 220);
        r2 = createRadio("Fixed Deposit Account", 350, 180, 300);
        r3 = createRadio("Current Account", 100, 220, 220);
        r4 = createRadio("Recurring Deposit Account", 350, 220, 300);

        ButtonGroup groupaccount = new ButtonGroup();
        groupaccount.add(r1);
        groupaccount.add(r2);
        groupaccount.add(r3);
        groupaccount.add(r4);

        JLabel l4 = new JLabel("Card Number :");
        l4.setFont(new Font("Raleway", Font.BOLD, 18));
        l4.setBounds(100, 280, 200, 30);
        l4.setForeground(new Color(30, 41, 59));
        add(l4);

        JLabel l5 = new JLabel("XXXX-XXXX-XXXX-2609");
        l5.setFont(new Font("Raleway", Font.BOLD, 18));
        l5.setBounds(330, 280, 300, 30);
        l5.setForeground(new Color(30, 41, 59));
        add(l5);

        JLabel l6 = new JLabel("(Your 16-digit Card Number)");
        l6.setFont(new Font("Raleway", Font.BOLD, 12));
        l6.setBounds(100, 310, 200, 20);
        l6.setForeground(new Color(30, 41, 59));
        add(l6);

        JLabel l7 = new JLabel("(It would appear on ATM Card/Cheque Book and Statements)");
        l7.setFont(new Font("Raleway", Font.BOLD, 12));
        l7.setBounds(330, 310, 500, 20);
        l7.setForeground(new Color(30, 41, 59));
        add(l7);

        JLabel l8 = new JLabel("PIN :");
        l8.setFont(new Font("Raleway", Font.BOLD, 18));
        l8.setBounds(100, 360, 200, 30);
        l8.setForeground(new Color(30, 41, 59));
        add(l8);

        JLabel l9 = new JLabel("XXXX");
        l9.setFont(new Font("Raleway", Font.BOLD, 18));
        l9.setBounds(330, 360, 200, 30);
        l9.setForeground(new Color(30, 41, 59));
        add(l9);

        JLabel l10 = new JLabel("(4-digit Password)");
        l10.setFont(new Font("Raleway", Font.BOLD, 12));
        l10.setBounds(100, 390, 200, 20);
        l10.setForeground(new Color(30, 41, 59));
        add(l10);

        JLabel l11 = new JLabel("Services Required :");
        l11.setFont(new Font("Raleway", Font.BOLD, 18));
        l11.setBounds(100, 440, 200, 30);
        l11.setForeground(new Color(30, 41, 59));
        add(l11);

        c1 = createCheckBox("ATM CARD", 100, 480);
        c2 = createCheckBox("Internet Banking", 350, 480);
        c3 = createCheckBox("Mobile Banking", 100, 520);
        c4 = createCheckBox("EMAIL Alerts", 350, 520);
        c5 = createCheckBox("Cheque Book", 100, 560);
        c6 = createCheckBox("E-Statement", 350, 560);

        c7 = new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge.", true);
        c7.setFont(new Font("Raleway", Font.BOLD, 12));
        c7.setBounds(100, 600, 600, 20);
        c7.setOpaque(false);
        c7.setForeground(new Color(30, 41, 59));
        add(c7);

        back = new JButton("Back");
        back.setFont(new Font("Raleway", Font.BOLD, 14));
        back.setBackground(new Color(30, 41, 59));
        back.setForeground(Color.WHITE);
        back.setBounds(250, 640, 110, 30);
        back.addActionListener(this);
        add(back);

        submit = new JButton("Submit");
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setBackground(new Color(30, 41, 59));
        submit.setForeground(Color.WHITE);
        submit.setBounds(420, 640, 110, 30);
        submit.addActionListener(this);
        add(submit);

        setLayout(null);
        setSize(850, 750);
        setLocation(450, 80);
        getContentPane().setBackground(new Color(173, 211, 253));
        setUndecorated(true);
        setVisible(true);
    }

    private JRadioButton createRadio(String text, int x, int y, int width) {
        JRadioButton rb = new JRadioButton(text);
        rb.setFont(new Font("Raleway", Font.BOLD, 14));
        rb.setBounds(x, y, width, 30);
        rb.setOpaque(false);
        rb.setForeground(new Color(30, 41, 59));
        add(rb);
        return rb;
    }

    private JCheckBox createCheckBox(String text, int x, int y) {
        JCheckBox cb = new JCheckBox(text);
        cb.setFont(new Font("Raleway", Font.BOLD, 14));
        cb.setBounds(x, y, 200, 30);
        cb.setOpaque(false);
        cb.setForeground(new Color(30, 41, 59));
        add(cb);
        return cb;
    }

    // Handle Submit button click to complete account registration and display generated card details
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            setVisible(false);
            new Signup2(formno).setVisible(true);
            return;
        }

        if (e.getSource() == submit) {
            String accountType = null;
            if (r1.isSelected()) accountType = "Saving Account";
            else if (r2.isSelected()) accountType = "Fixed Deposit Account";
            else if (r3.isSelected()) accountType = "Current Account";
            else if (r4.isSelected()) accountType = "Recurring Deposit Account";

            if (accountType == null) {
                JOptionPane.showMessageDialog(null, "Select an Account Type");
                return;
            }

            if (!c1.isSelected() && !c2.isSelected() && !c3.isSelected() &&
                    !c4.isSelected() && !c5.isSelected() && !c6.isSelected()) {
                JOptionPane.showMessageDialog(null, "Please select at least one required service");
                return;
            }

            if (!c7.isSelected()) {
                JOptionPane.showMessageDialog(null, "Please check the declaration box");
                return;
            }

            Random random = new Random();
            String cardNumber = "" + Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);
            String pin = "" + Math.abs((random.nextInt() % 9000) + 1000);

            String facility = "";
            if (c1.isSelected()) facility += " ATM CARD";
            if (c2.isSelected()) facility += " Internet Banking";
            if (c3.isSelected()) facility += " Mobile Banking";
            if (c4.isSelected()) facility += " EMAIL Alerts";
            if (c5.isSelected()) facility += " Cheque Book";
            if (c6.isSelected()) facility += " E-Statement";

            try {
                Con c1 = new Con();

                String q1 = "insert into signup values('" + SignupData.formno + "', '" + SignupData.name + "', '" + SignupData.fname + "', '" + SignupData.dob + "', '" + SignupData.gender + "', '" + SignupData.email + "', '" + SignupData.phone + "', '" + SignupData.marital + "', '" + SignupData.address + "', '" + SignupData.city + "', '" + SignupData.pin + "', '" + SignupData.state + "')";

                String q2 = "insert into signuptwo values('" + SignupData.formno + "', '" + SignupData.religion + "', '" + SignupData.category + "', '" + SignupData.income + "', '" + SignupData.education + "', '" + SignupData.occupation + "', '" + SignupData.pan + "', '" + SignupData.aadhar + "', '" + SignupData.seniorcitizen + "', '" + SignupData.existingaccount + "')";

                String q3 = "insert into signupthree values('" + SignupData.formno + "', '" + accountType + "', '" + cardNumber + "', '" + pin + "', '" + facility + "')";

                String q4 = "insert into login values('" + SignupData.formno + "', '" + cardNumber + "', '" + pin + "')";

                c1.statement.executeUpdate(q1);
                c1.statement.executeUpdate(q2);
                c1.statement.executeUpdate(q3);
                c1.statement.executeUpdate(q4);

                JOptionPane.showMessageDialog(null, "Card Number: " + cardNumber + "\n PIN: " + pin);

                setVisible(false);
                new main_Class(pin).setVisible(true);

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                JOptionPane.showMessageDialog(null,"Database Error:"+ ex.toString());
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Signup3("");
    }
}