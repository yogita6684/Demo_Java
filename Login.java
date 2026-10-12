package swiftcash.atm.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

// Login screen for SwiftCash ATM System.
public class Login extends JFrame implements ActionListener {

    // UI component declarations
    JLabel label1, label2, label3, label4;

    JTextField textField2;

    JPasswordField passwordField3;

    JButton button1, button2, button3, button4;

    Login() {

        super("Swiftcash ATM System");

        //all UI components (images,title label, input text field, and buttons)
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(110, 110, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(358, 10, 100, 100);
        add(image);

        ImageIcon ii1 = new ImageIcon(ClassLoader.getSystemResource("icon/card.png"));
        Image ii2 = ii1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon ii3 = new ImageIcon(ii2);
        JLabel iimage = new JLabel(ii3);
        iimage.setBounds(620, 310, 100, 80);
        add(iimage);

        label1 = new JLabel("WELCOME TO ATM");
        label1.setForeground(new Color(30, 41, 59));
        label1.setFont(new Font("Raleway", Font.BOLD, 28));
        label1.setBounds(280, 125, 450, 40);
        add(label1);

        label2 = new JLabel("Card No  :");
        label2.setFont(new Font("Ralway", Font.BOLD, 16));
        label2.setForeground(new Color(30, 41, 59));
        label2.setBounds(260, 190, 375, 30);
        add(label2);

        textField2 = new JTextField(15);
        textField2.setBounds(360, 190, 200, 30);
        textField2.setFont(new Font("Arial", Font.BOLD, 14));
        add(textField2);

        label3 = new JLabel("PIN          : ");
        label3.setFont(new Font("Ralway", Font.BOLD, 16));
        label3.setForeground(new Color(30, 41, 59));
        label3.setBounds(260, 250, 375, 30);
        add(label3);

        passwordField3 = new JPasswordField(15);
        passwordField3.setBounds(360, 250, 200, 30);
        passwordField3.setFont(new Font("Arial", Font.BOLD, 14));
        add(passwordField3);

        button4 = new JButton("<html><u>Forgot Your PIN?</u></html>");
        button4.setFont(new Font("Raleway", Font.BOLD, 14));
        button4.setForeground(new Color(30, 41, 59));
        button4.setBackground(new Color(30, 41, 59));
        button4.setBounds(315, 283, 290, 25);
        button4.setContentAreaFilled(false);
        button4.setBorderPainted(false);
        button4.setFocusPainted(false);
        button4.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button4.addActionListener(this);
        add(button4);

        button1 = new JButton("SIGN IN");
        button1.setFont(new Font("Raleway", Font.BOLD, 14));
        button1.setForeground(Color.white);
        button1.setBackground(new Color(30, 41, 59));
        button1.setBounds(295, 332, 100, 30);
        button1.addActionListener(this);
        add(button1);

        button2 = new JButton("CLEAR");
        button2.setFont(new Font("Raleway", Font.BOLD, 14));
        button2.setForeground(Color.white);
        button2.setBackground(new Color(30, 41, 59));
        button2.setBounds(420, 332, 100, 30);
        button2.addActionListener(this);
        add(button2);

        JLabel label4 = new JLabel("<html><i>Don't have an account?</i></html>");
        label4.setFont(new Font("Raleway", Font.BOLD, 13));
        label4.setForeground(new Color(30, 41, 59));
        label4.setBounds(295, 380, 160, 25);
        add(label4);

        button3 = new JButton("<html><u>Sign Up</u></html>");
        button3.setFont(new Font("Raleway", Font.BOLD, 14));
        button3.setForeground(new Color(30, 41, 59));
        button3.setBackground(new Color(173, 211, 253));
        button3.setBounds(425, 380, 100, 25);
        button3.setContentAreaFilled(false);
        button3.setBorderPainted(false);
        button3.setFocusPainted(false);
        button3.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button3.addActionListener(this);
        add(button3);

        // Main White Card Panel
        ShadowPanel innerCard = new ShadowPanel();
        innerCard.setLayout(null);
        innerCard.setBounds(60, 50, 730, 380);
        innerCard.setBackground(Color.white);
        add(innerCard);

        setLayout(null);
        setSize(850, 480);
        setLocation(450, 200);
        getContentPane().setBackground(new Color(30, 41, 59));
        setUndecorated(true);
        setVisible(true);
    }

    // Handle button click events and user actions
    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            if(e.getSource() == button1){
                String cardno = textField2.getText().trim();
                String pin = new String(passwordField3.getPassword()).trim();
                if(cardno.isEmpty() || pin.isEmpty()){
                    JOptionPane.showMessageDialog(this,"Please fill in all fields!");
                    return;
                }

                Con c = new Con();
                String q = "select * from login where card_number = '"+cardno+"' and pin = '"+pin+"'";
                ResultSet resultSet = c.statement.executeQuery(q);
                if(resultSet.next()){
                    setVisible(false);
                    new main_Class(pin);
                } else {
                    JOptionPane.showMessageDialog(this,"Incorrect Card Number or PIN");
                }
            }else if(e.getSource() == button2){
                textField2.setText("");
                passwordField3.setText("");
            }else if(e.getSource() == button3) {
                new Signup();
                setVisible(false);
            }else if(e.getSource() == button4){
                new Forgot();
                setVisible(false);
            }
        }catch(Exception E){
            E.printStackTrace();
        }

    }
    static class ShadowPanel extends JPanel {
        private final int shadowSize = 8;
        private final Color shadowColor = new Color(0,0,0,80);

        public ShadowPanel() {
            setOpaque(false);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(shadowColor);
            g2.fillRoundRect(shadowSize, shadowSize, getWidth() - shadowSize, getHeight() - shadowSize, 20, 20);
            g2.setColor(getBackground());
            g2.fillRoundRect(0, 0, getWidth() - shadowSize, getHeight() - shadowSize, 20, 20);
            g2.dispose();
        }
    }
    public static void main(String[] args){

        new Login();

    }

}