package swiftcash.atm.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Signup2 screen for SwiftCash ATM System.
public class Signup2 extends JFrame implements ActionListener {

    // UI component declarations
    JComboBox comboBox, comboBox2, comboBox3, comboBox4, comboBox5;

    JTextField textPan, textAdhaar;

    JRadioButton r1,r2,e1,e2;

    JButton next, back;

    String formno;

    public Signup2(String formno){

        super("APPLICATION FORM");
        this.formno = formno;

        // Additional details UI controls: Category, Religion, Income, Education, and Occupation fields etc
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(110,110, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(50,20,100,100);
        add(image);

        JLabel l1 = new JLabel(("Page 2"));
        l1.setFont(new Font("Raleway", Font.BOLD,20));
        l1.setBounds(365,30,600,30);
        l1.setForeground(Color.white);
        add(l1);

        JLabel l2 = new JLabel("Additional Details");
        l2.setFont(new Font("Raleway",Font.BOLD,20));
        l2.setForeground(Color.white);
        l2.setBounds(325,60,600,30);
        add(l2);

        JLabel l3 = new JLabel("Religion  :");
        l3.setFont(new Font("Raleway",Font.BOLD,16));
        l3.setBounds(210,150,100,30);
        l3.setForeground(Color.white);
        add(l3);

        String religion[] = {"Hindu","Muslim","Sikh","Christian","Other"};
        comboBox = new JComboBox(religion);
        comboBox.setForeground(new Color(30, 41, 59));
        comboBox.setBackground(Color.white);
        comboBox.setFont(new Font("Raleway", Font.BOLD,14));
        comboBox.setBounds(310,150,300,30);
        add(comboBox);

        JLabel l4 = new JLabel("Category  :");
        l4.setFont(new Font("Raleway",Font.BOLD,16));
        l4.setBounds(202,200,100,30);
        l4.setForeground(Color.white);
        add(l4);

        String Category [] = {"General","OBC","SC","ST","Other"};
        comboBox2 = new JComboBox(Category);
        comboBox2.setForeground(new Color(30, 41, 59));
        comboBox2.setBackground(Color.white);
        comboBox2.setFont(new Font("Raleway", Font.BOLD,14));
        comboBox2.setBounds(310,200,300,30);
        add(comboBox2);

        JLabel l5 = new JLabel("Income  :");
        l5.setFont(new Font("Raleway",Font.BOLD,16));
        l5.setBounds(215,250,100,30);
        l5.setForeground(Color.white);
        add(l5);

        String income [] = {"Null","<1,50,000","<2,50,000","5,00,000","Upto 10,00,000","Above 10,00,000"};
        comboBox3 = new JComboBox(income);
        comboBox3.setForeground(new Color(30,41,59));
        comboBox3.setBackground(Color.white);
        comboBox3.setFont(new Font("Raleway", Font.BOLD,14));
        comboBox3.setBounds(310,250,300,30);
        add(comboBox3);

        JLabel l6 = new JLabel("Educational  :");
        l6.setFont(new Font("Raleway",Font.BOLD,16));
        l6.setBounds(182,300,110,30);
        l6.setForeground(Color.white);
        add(l6);

        String educational [] = {"Non Graduate","Graduate","Post-Graduate","Doctrate","Others"};
        comboBox4 = new JComboBox(educational);
        comboBox4.setForeground(new Color(30,41,59));
        comboBox4.setBackground(Color.white);
        comboBox4.setFont(new Font("Raleway", Font.BOLD,14));
        comboBox4.setBounds(310,300,300,30);
        add(comboBox4);

        JLabel l7 = new JLabel("Occupation  :");
        l7.setFont(new Font("Raleway",Font.BOLD,16));
        l7.setBounds(183,350,150,30);
        l7.setForeground(Color.white);
        add(l7);

        String occupation [] = {"Salaried","Self-Employed","Buisness","Student","Retired","Others"};
        comboBox5 = new JComboBox(occupation);
        comboBox5.setForeground(new Color(30,41,59));
        comboBox5.setBackground(Color.white);
        comboBox5.setFont(new Font("Raleway", Font.BOLD,14));
        comboBox5.setBounds(310,350,300,30);
        add(comboBox5);

        JLabel l8 = new JLabel("PAN Number  :");
        l8.setFont(new Font("Raleway",Font.BOLD,16));
        l8.setBounds(176,400,150,30);
        l8.setForeground(Color.white);
        add(l8);

        textPan = new JTextField();
        textPan.setFont(new Font("Raleway",Font.BOLD,14));
        textPan.setBounds(310,400,300,30);
        textPan.setForeground(new Color(30,41,59));
        textPan.setBackground(Color.white);
        add(textPan);

        JLabel l9 = new JLabel("Adhaar Number  :");
        l9.setFont(new Font("Raleway",Font.BOLD,16));
        l9.setBounds(155,450,150,30);
        l9.setForeground(Color.white);
        add(l9);

        textAdhaar = new JTextField();
        textAdhaar.setFont(new Font("Raleway",Font.BOLD,14));
        textAdhaar.setBounds(310,450,300,30);
        textAdhaar.setForeground(new Color(30,41,59));
        textAdhaar.setBackground(Color.white);
        textAdhaar.setCaretColor(Color.white);
        add(textAdhaar);

        JLabel l10 = new JLabel("Senior Citizen  :");
        l10.setFont(new Font("Raleway",Font.BOLD,16));
        l10.setBounds(169,500,150,30);
        l10.setForeground(Color.white);
        add(l10);

        r1 = new JRadioButton("Yes");
        r1.setFont(new Font("Raleway",Font.BOLD,14));
        r1.setBounds(310,500,100,30);
        r1.setForeground(Color.white);
        r1.setBackground(new Color(30,41,59));
        r1.setOpaque(false);
        r1.setFocusPainted(false);
        add(r1);

        r2 = new JRadioButton("NO");
        r2.setFont(new Font("Raleway",Font.BOLD,14));
        r2.setBackground(new Color(30,41,59));
        r2.setBounds(440,500,100,30);
        r2.setForeground(Color.white);
        r2.setOpaque(false);
        r2.setFocusPainted(false);
        add(r2);

        ButtonGroup scGroup = new ButtonGroup();
        scGroup.add(r1);
        scGroup.add(r2);

        JLabel l11 = new JLabel("Existing Account  :");
        l11.setFont(new Font("Raleway",Font.BOLD,16));
        l11.setBounds(145,550,180,30);
        l11.setForeground(Color.white);
        add(l11);

        e1 = new JRadioButton("Yes");
        e1.setFont(new Font("Raleway",Font.BOLD,14));
        e1.setBackground(new Color(30,41,59));
        e1.setForeground(Color.white);
        e1.setBounds(310,550,100,30);
        e1.setOpaque(false);
        e1.setFocusPainted(false);
        add(e1);

        e2 = new JRadioButton("NO");
        e2.setFont(new Font("Raleway",Font.BOLD,14));
        e2.setBackground(new Color(30,41,59));
        e2.setForeground(Color.white);
        e2.setBounds(440,550,100,30);
        e2.setOpaque(false);
        e2.setFocusPainted(false);
        add(e2);

        ButtonGroup eaGroup = new ButtonGroup();
        eaGroup.add(e1);
        eaGroup.add(e2);

        JLabel l12 = new JLabel("Form No :");
        l12.setFont(new Font("Raleway",Font.BOLD,14));
        l12.setBounds(700,10,200,30);
        l12.setForeground(Color.white);
        add(l12);

        JLabel l13 = new JLabel(formno);
        l13.setFont(new Font("Raleway",Font.BOLD,12));
        l13.setBounds(770,10,60,30);
        l13.setForeground(Color.white);
        add(l13);

        back = new JButton("BACK");
        back.setFont(new Font("Raleway", Font.BOLD,14));
        back.setForeground(new Color(30, 41, 59));
        back.setBackground(new Color(173, 211, 253));
        back.setBounds(285,640,100,30);
        back.addActionListener(this);
        add(back);

        next = new JButton("Next");
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setForeground(new Color(30, 41, 59));
        next.setBackground(new Color(173, 211, 253));
        next.setBounds(415,640,100,30);
        next.addActionListener(this);
        add(next);

        textPan.setText(SignupData.pan);
        textAdhaar.setText(SignupData.aadhar);

        if(!SignupData.religion.isEmpty()){
            comboBox.setSelectedItem(SignupData.religion);
        }

        if(!SignupData.category.isEmpty()){
            comboBox2.setSelectedItem(SignupData.category);
        }

        if(!SignupData.education.isEmpty()){
            comboBox4.setSelectedItem(SignupData.education);
        }

        if("Yes".equalsIgnoreCase(SignupData.seniorcitizen)){
            r1.setSelected(true);
        }else if("No".equalsIgnoreCase(SignupData.seniorcitizen)){
            r2.setSelected(true);
        }

        if("Yes".equalsIgnoreCase(SignupData.existingaccount)){
            e1.setSelected(true);
        }else if("No".equalsIgnoreCase(SignupData.existingaccount)){
            e2.setSelected(true);
        }

        if(SignupData.income != null && ! SignupData.income.isEmpty()){
            comboBox3.setSelectedItem(SignupData.income);
        }

        setLayout(null);
        setSize(850,750);
        setLocation(450,80);
        getContentPane().setBackground(new Color(30, 41, 59));
        setUndecorated(true);
        setVisible(true);
    }

    // Handle Next button click to proceed to Signup Page 3 (Account Details)
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == next) {

            String pan = textPan.getText().trim();
            String aadhar = textAdhaar.getText().trim();

            String income = (String) comboBox3.getSelectedItem();
            if(income.equalsIgnoreCase("Null")){
                JOptionPane.showMessageDialog(null,"Please Select a valid Income option!");
                return;
            }

            String scitizen = "";
            if (r1.isSelected()) {
                scitizen = "Yes";
            } else if (r2.isSelected()) {
                scitizen = "No";
            }

            String eaccount = "";
            if (e1.isSelected()) {
                eaccount = "Yes";
            } else if (e2.isSelected()) {
                eaccount = "No";
            }

            if (pan.isEmpty() || aadhar.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill all the text fields!");
                return;
            }

            if (!pan.matches("^[A-Z0-9]{10}$")) {
                JOptionPane.showMessageDialog(null, "Invalid PAN Number! (Must be 10 characters)");
                return;
            }

            if (!aadhar.matches("^\\d{12}$")) {
                JOptionPane.showMessageDialog(null, "Invalid Aadhaar Number! (Must be 12 digits)");
                return;
            }

            if (scitizen.isEmpty() || eaccount.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please select Senior Citizen and Existing Account status!");
                return;
            }

            SignupData.religion = (String) comboBox.getSelectedItem();
            SignupData.category = (String) comboBox2.getSelectedItem();
            SignupData.income = (String) comboBox3.getSelectedItem();
            SignupData.education = (String) comboBox4.getSelectedItem();
            SignupData.occupation = (String) comboBox5.getSelectedItem();
            SignupData.pan = pan;
            SignupData.aadhar = aadhar;
            SignupData.seniorcitizen = scitizen;
            SignupData.existingaccount = eaccount;

            new Signup3(formno).setVisible(true);
            setVisible(false);

        } else if (e.getSource() == back) {

            SignupData.pan = textPan.getText().trim();
            SignupData.aadhar = textAdhaar.getText().trim();
            SignupData.religion = (String) comboBox.getSelectedItem();
            SignupData.category = (String) comboBox2.getSelectedItem();
            SignupData.income = (String) comboBox3.getSelectedItem();
            SignupData.education = (String) comboBox4.getSelectedItem();
            SignupData.occupation = (String) comboBox5.getSelectedItem();

            if (r1.isSelected()) SignupData.seniorcitizen = "Yes";
            else if (r2.isSelected()) SignupData.seniorcitizen = "No";

            if (e1.isSelected()) SignupData.existingaccount = "Yes";
            else if (e2.isSelected()) SignupData.existingaccount = "No";

            new Signup().setVisible(true);
            setVisible(false);
        }
    }

    public static void main(String[] args){
        new Signup2("");
    }
}