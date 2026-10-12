package swiftcash.atm.system;

import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.regex.Pattern;

// Signup screen for SwiftCash ATM System.
public class Signup extends JFrame implements ActionListener{

    // UI component declarations
    JRadioButton  radio1, radio2, m1, m2, m3;

    JButton next, back;

    JTextField textName ,textFName ,textEmail, textPhone, textCity, textPin, textState;

    JTextArea textAdd;

    JDateChooser dateChooser;

    Random ran = new Random();

    long first4 = (ran.nextLong() % 9000L) +1000L;

    String first = " " + Math.abs(first4);

    public Signup(){

        super("APPLICATION FORM");

        // UI components: Labels, input text fields, radio buttons, and buttons
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(110,110, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(50,20,100,100);
        add(image);

        JLabel label1 = new JLabel("APPLICATION FORM NO."+ first);
        label1.setBounds(200,20,600,35);
        label1.setFont(new Font("Raleway",Font.BOLD,28));
        label1.setForeground(new Color(30, 41, 59));
        add(label1);

        JLabel label2 = new JLabel("Page 1");
        label2.setFont(new Font("Raleway",Font.BOLD,18));
        label2.setForeground(new Color(30, 41, 59));
        label2.setBounds(375,60,600,20);
        add(label2);

        JLabel label3 = new JLabel("Personal Details");
        label3.setFont(new Font("Raleway",Font.BOLD,18));
        label3.setForeground(new Color(30, 41, 59));
        label3.setBounds(340,85,600,25);
        add(label3);

        JLabel labelName = new JLabel("Full Name   :");
        labelName.setFont(new Font("Raleway",Font.BOLD,15));
        labelName.setForeground(new Color(30, 41, 59));
        labelName.setBounds(163,125,130,30);
        add(labelName);

        textName = new JTextField();
        textName.setFont(new Font("Raleway", Font.BOLD,14));
        textName.setBounds(275,125,400,30);
        add(textName);

        JLabel labelfName = new JLabel("Father's Name   :");
        labelfName.setFont(new Font("Raleway",Font.BOLD,15));
        labelfName.setForeground(new Color(30, 41, 59));
        labelfName.setBounds(130,170,130,30);
        add(labelfName);

        textFName = new JTextField();
        textFName.setFont(new Font("Raleway", Font.BOLD,14));
        textFName.setBounds(275,170,400,30);
        add(textFName);

        JLabel DOB = new JLabel("Date of Birth   :");
        DOB.setFont(new Font("Raleway",Font.BOLD,15));
        DOB.setForeground(new Color(30, 41, 59));
        DOB.setBounds(145,215,400,30);
        add(DOB);

        dateChooser = new JDateChooser();
        dateChooser.setForeground(new Color(30,41,59));
        dateChooser.setBounds(275,215,200,30);
        dateChooser.getCalendarButton().setMargin(new java.awt.Insets(0,0,0,0));
        dateChooser.getCalendarButton().setPreferredSize(new java.awt.Dimension(30,30));
        add(dateChooser);

        JLabel labelG = new JLabel("Gender   :");
        labelG.setFont(new Font("Raleway", Font.BOLD,15));
        labelG.setForeground(new Color(30, 41, 59));
        labelG.setBounds(180,260,130,30);
        add(labelG);

        radio1 = new JRadioButton("Female");
        radio1.setFont(new Font("Raleway",Font.BOLD,14));
        radio1.setForeground(new Color(30, 41, 59));
        radio1.setBounds(275,260,100,30);
        radio1.setOpaque(false);
        radio1.setFocusPainted(false);
        add(radio1);

        radio2 = new JRadioButton("Male");
        radio2.setFont(new Font("Raleway",Font.BOLD,14));
        radio2.setForeground(new Color(30, 41, 59));
        radio2.setBounds(375,260,100,30);
        radio2.setOpaque(false);
        radio2.setFocusPainted(false);
        add(radio2);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radio1);
        buttonGroup.add(radio2);

        JLabel labelEmail = new JLabel("Email address   :");
        labelEmail.setFont(new Font("Raleway",Font.BOLD,15));
        labelEmail.setForeground(new Color(30, 41, 59));
        labelEmail.setBounds(130,305,130,30);
        add(labelEmail);

        textEmail = new JTextField();
        textEmail.setFont(new Font("Raleway", Font.BOLD,14));
        textEmail.setBounds(275,305,400,30);
        add(textEmail);

        JLabel labelPhone = new JLabel("Mobile No   :");
        labelPhone.setFont(new Font("Raleway",Font.BOLD,15));
        labelPhone.setForeground(new Color(30, 41, 59));
        labelPhone.setBounds(163,350,130,30);
        add(labelPhone);

        textPhone = new JTextField();
        textPhone.setFont(new Font("Raleway", Font.BOLD,14));
        textPhone.setBounds(275,350,400,30);
        add(textPhone);

        JLabel labelMs = new JLabel("Marital Status   :");
        labelMs.setFont(new Font("Raleway",Font.BOLD,15));
        labelMs.setBounds(135,395,130,30);
        labelMs.setForeground(new Color(30, 41, 59));
        add(labelMs);

        m1 = new JRadioButton("Married");
        m1.setBounds(275,395,100,30);
        m1.setFont(new Font("Raleway",Font.BOLD,14));
        m1.setForeground(new Color(30, 41, 59));
        m1.setOpaque(false);
        m1.setFocusPainted(false);
        add(m1);

        m2 = new JRadioButton("Unmarried");
        m2.setBounds(375,395,110,30);
        m2.setFont(new Font("Raleway",Font.BOLD,14));
        m2.setForeground(new Color(30, 41, 59));
        m2.setOpaque(false);
        m2.setFocusPainted(false);
        add(m2);

        m3 = new JRadioButton("Other");
        m3.setBounds(500,395,100,30);
        m3.setForeground(new Color(30, 41, 59));
        m3.setFont(new Font("Raleway",Font.BOLD,14));
        m3.setOpaque(false);
        m3.setFocusPainted(false);
        add(m3);

        ButtonGroup buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(m1);
        buttonGroup1.add(m2);
        buttonGroup1.add(m3);

        JLabel labelAdd = new JLabel("Address   :");
        labelAdd.setFont(new Font("Raleway",Font.BOLD,15));
        labelAdd.setForeground(new Color(30, 41, 59));
        labelAdd.setBounds(173,440,130,30);
        add(labelAdd);

        textAdd = new JTextArea();
        textAdd.setFont(new Font("Raleway", Font.BOLD,14));
        textAdd.setLineWrap(true);
        textAdd.setWrapStyleWord(true);
        textAdd.setBounds(275,440,400,60);
        add(textAdd);

        JLabel labelCity = new JLabel("City   :");
        labelCity.setFont(new Font("Raleway",Font.BOLD,15));
        labelCity.setForeground(new Color(30, 41, 59));
        labelCity.setBounds(204,515,130,30);
        add(labelCity);

        textCity = new JTextField();
        textCity.setFont(new Font("Raleway", Font.BOLD,14));
        textCity.setBounds(275,515,400,30);
        add(textCity);

        JLabel labelPin = new JLabel("Pin Code   :");
        labelPin.setFont(new Font("Raleway",Font.BOLD,15));
        labelPin.setForeground(new Color(30, 41, 59));
        labelPin.setBounds(165,560,130,30);
        add(labelPin);

        textPin = new JTextField();
        textPin.setFont(new Font("Raleway", Font.BOLD,14));
        textPin.setBounds(275,560,400,30);
        add(textPin);

        JLabel labelState = new JLabel("State   :");
        labelState.setFont(new Font("Raleway",Font.BOLD,15));
        labelState.setForeground(new Color(30, 41, 59));
        labelState.setBounds(195,605,130,30);
        add(labelState);

        textState = new JTextField();
        textState.setFont(new Font("Raleway", Font.BOLD,14));
        textState.setBounds(275,605,400,30);
        add(textState);

        back = new JButton("Back");
        back.setFont(new Font("Raleway",Font.BOLD,14));
        back.setForeground(Color.white);
        back.setBackground(new Color(30, 41, 59));
        back.setFocusable(false);
        back.setBounds(310,650,100,30);
        back.addActionListener(e ->{
            setVisible(false);
            new Login().setVisible(true);
        });
        add(back);

        next = new JButton("Next");
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setForeground(Color.white);
        next.setBackground(new Color(30, 41, 59));
        next.setBounds(450,650,100,30);
        next.setFocusable(false);
        next.addActionListener(this);
        add(next);

        textName.setText(SignupData.name);
        textFName.setText(SignupData.fname);
        ((JTextField)dateChooser.getDateEditor().getUiComponent()).setText(SignupData.dob);
        textEmail.setText(SignupData.email);
        textPhone.setText(SignupData.phone);
        textAdd.setText(SignupData.address);
        textCity.setText(SignupData.city);
        textPin.setText(SignupData.pin);
        textState.setText(SignupData.state);

        if("Male".equalsIgnoreCase(SignupData.gender)){
            radio1.setSelected(true);
        } else if("Female".equalsIgnoreCase(SignupData.gender)){
            radio2.setSelected(true);
        }

        if("Married".equalsIgnoreCase(SignupData.marital)){
            m1.setSelected(true);
        } else if("Unmarried".equalsIgnoreCase(SignupData.marital)){
            m2.setSelected(true);
        } else if("Other".equalsIgnoreCase(SignupData.marital)){
            m3.setSelected(true);
        }

        getContentPane().setBackground(new Color(173, 211, 253));
        setLayout(null);
        setSize(850,750);
        setLocation(360,40);
        setUndecorated(true);
        setVisible(true);
    }

    // Handle button click events and navigate to the next page/login screen
    @Override
    public void actionPerformed(ActionEvent e) {

        String formno = first;
        String name = textName.getText().trim();
        String fname = textFName.getText().trim();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText().trim();
        String gender = null;
        if(radio1.isSelected()){
            gender = "Male";
        }else if(radio2.isSelected()){
            gender = "Female";
        }
        String email = textEmail.getText().trim();
        String phone = textPhone.getText().trim();
        String marital = null;
        if(m1.isSelected()){
            marital = "Married";
        }else if(m2.isSelected()){
            marital = "Unmarried";
        }else if(m3.isSelected()){
            marital = "Other";
        }
        String address = textAdd.getText().trim();
        String city = textCity.getText().trim();
        String pincode = textPin.getText().trim();
        String state = textState.getText().trim();

        if(name.isEmpty()){
            JOptionPane.showMessageDialog(null,"Full Name is Required!");
            return;
        }else if(!Pattern.matches("^[a-zA-Z\\s]+$",name)) {
            JOptionPane.showMessageDialog(null, "Full Name Shoul contain only alphabets!");
            return;
        }

        if(fname.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Father's Name is Required!");
            return;
        }else if(!Pattern.matches("^[a-zA-Z\\s]+$",fname)){
            JOptionPane.showMessageDialog(null,"Father's Name should contain only alphabets!");
            return;
        }

        if(dob.isEmpty()){
            JOptionPane.showMessageDialog(null,"Please select Date of Birth");
            return;
        }

        if(gender == null){
            JOptionPane.showMessageDialog(null,"Please select Gender!");
            return;
        }

        if (email.isEmpty()){
            JOptionPane.showMessageDialog(null,"Email Address is Required!");
            return;
        }else if (!Pattern.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$",email)){
            JOptionPane.showMessageDialog(null,"Please enter a valid Email Address(e.g., example@gmail.com)!");
            return;
        }

        if(phone.isEmpty()){
            JOptionPane.showMessageDialog(null,"Mobile Number is Required!");
            return;
        }else if(!Pattern.matches("^[6-9]\\d{9}$",phone)){
            JOptionPane.showMessageDialog(null,"Please enter a valid 10-digit Indian Mobile Number!");
            return;
        }

        if(marital == null){
            JOptionPane.showMessageDialog(null,"Please select Marital Status!");
            return;
        }

        if(address.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Address is Required!");
            return;
        }

        if(city.isEmpty()){
            JOptionPane.showMessageDialog(null,"City Name is Required!");
            return;
        }

        if(pincode.isEmpty()){
            JOptionPane.showMessageDialog(null,"Pin Code is Required!");
            return;
        }else if(!Pattern.matches("^\\d{6}$",pincode)){
            JOptionPane.showMessageDialog(null,"Pin Code must be exactly 6 digits!");
            return;
        }

        if(state.isEmpty()){
            JOptionPane.showMessageDialog(null,"State Name is Required!");
            return;
        }

        try{
            SignupData.formno = formno;
            SignupData.name = name;
            SignupData.fname = fname;
            SignupData.dob = dob;
            SignupData.gender = gender;
            SignupData.email = email;
            SignupData.phone = phone;
            SignupData.marital = marital;
            SignupData.address = address;
            SignupData.city = city;
            SignupData.pin = pincode;
            SignupData.state = state;

            setVisible(false);
            new Signup2(formno).setVisible(true);
        }catch (Exception E){
            E.printStackTrace();
        }
    }
    public static void main(String[] args){
        new Signup();
    }
}
