package swiftcash.atm.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//forgotpwd class for the Swiftcash ATM System.
public class Forgot extends JFrame implements ActionListener {

    // UI component declarations
    JTextField cardTextField, emailTextField;

    JButton recoverButton, backButton;

    public Forgot() {
        setTitle("SwiftCash ATM - Forgot PIN");
        setLayout(null);
        getContentPane().setBackground(new Color(173, 211, 253));

        //all UI components
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(110,110, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(110,20,100,100);
        add(image);

        JLabel title = new JLabel("FORGOT YOUR PIN");
        title.setFont(new Font("System", Font.BOLD, 22));
        title.setBounds(250, 80, 300, 30);
        title.setForeground(new Color(30, 41, 59));
        add(title);

        JLabel cardNo = new JLabel("Card No  :");
        cardNo.setFont(new Font("Raleway", Font.BOLD, 14));
        cardNo.setBounds(208, 170, 120, 30);
        cardNo.setForeground(new Color(30, 41, 59));
       add(cardNo);

        cardTextField = new JTextField();
        cardTextField.setBounds(285, 170, 240, 30);
        cardTextField.setFont(new Font("Arial", Font.PLAIN, 14));
        add(cardTextField);

        JLabel email = new JLabel("Registered Email  :");
        email.setFont(new Font("Raleway", Font.BOLD, 14));
        email.setBounds(145, 220, 140, 30);
        email.setForeground(new Color(30, 41, 59));
        add(email);

        emailTextField = new JTextField();
        emailTextField.setBounds(285, 220, 240, 30);
        emailTextField.setFont(new Font("Arial", Font.PLAIN, 14));
        add(emailTextField);

        recoverButton = new JButton("RECOVER PIN");
        recoverButton.setBackground(new Color(30, 41, 59));
        recoverButton.setForeground(Color.WHITE);
        recoverButton.setFont(new Font("Raleway", Font.BOLD, 12));
        recoverButton.setBounds(195, 290, 130, 35);
        recoverButton.setFocusPainted(false);
        recoverButton.addActionListener(this);
        add(recoverButton);

        backButton = new JButton("BACK");
        backButton.setBackground(new Color(173, 211, 253));
        backButton.setForeground(new Color(30, 41, 59));
        backButton.setFont(new Font("Raleway", Font.BOLD, 12));
        backButton.setBounds(345, 290, 130, 35);
        backButton.setFocusPainted(false);
        backButton.addActionListener(this);
        add(backButton);

        // Main White Card Panel
        Forgot.ShadowPanel innerCard = new Forgot.ShadowPanel();
        innerCard.setLayout(null);
        innerCard.setBounds(55, 45, 585, 410);
        innerCard.setBackground(Color.white);
        add(innerCard);

        setSize(700, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == recoverButton) {
            String cardNo = cardTextField.getText().trim();
            String email = emailTextField.getText().trim();

            // 1. Validation: Empty Check
            if (cardNo.isEmpty() || email.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter both Card Number and Email!");
                return;
            }

            // 2. Validation: Card Number (Exactly 16 Digits)
            if (!cardNo.matches("\\d{16}")) {
                JOptionPane.showMessageDialog(this, "Please enter a valid 16-digit Card Number!");
                cardTextField.requestFocus();
                return;
            }

            // 3. Validation: Email Format
            if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[a-zA-Z]{2,}$")) {
                JOptionPane.showMessageDialog(this, "Please enter a valid Email address!");
                emailTextField.requestFocus();
                return;
            }

            // 4. Database Verification
            try {
                Con c = new Con();
                Connection conn = c.connection;

                String query = "SELECT l.pin FROM login l JOIN signup s ON l.form_no = s.form_no WHERE l.card_number = ? AND s.email = ?";

                PreparedStatement pstmt = conn.prepareStatement(query);
                pstmt.setString(1, cardNo);
                pstmt.setString(2, email);

                ResultSet rs = pstmt.executeQuery();

                if (rs.next()) {
                    String pin = rs.getString("pin");
                    JOptionPane.showMessageDialog(this, "Your PIN is: " + pin + "\n\nPlease keep your PIN secure.", "PIN Recovered", JOptionPane.INFORMATION_MESSAGE);
                    setVisible(false);
                    new Login().setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid Card Number or Email. No matching account found!", "Recovery Failed", JOptionPane.ERROR_MESSAGE);
                }

            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Database Connection Error:" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (ae.getSource() == backButton) {
            setVisible(false);
            new Login().setVisible(true);
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
        new Forgot();
}
}