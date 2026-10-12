package swiftcash.atm.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

//Mini class for the Swiftcash ATM System.
public class Mini extends JFrame implements ActionListener {

    // UI component declarations
    String pin;

    JButton exitBtn;

    public Mini(String pin) {
        this.pin = pin;

        //all UI components
        setTitle("Mini Statement");
        setLayout(null);
        getContentPane().setBackground(new Color(245, 245, 245));

        JLabel bankName = new JLabel("SWIFTCASH ATM ENGINE");
        bankName.setFont(new Font("System", Font.BOLD, 18));
        bankName.setForeground(new Color(62, 118, 211));
        bankName.setBounds(80, 20, 300, 25);
        add(bankName);

        JLabel subHeading = new JLabel("RECENT TRANSACTIONS");
        subHeading.setFont(new Font("System", Font.BOLD, 14));
        subHeading.setForeground(Color.DARK_GRAY);
        subHeading.setBounds(110, 50, 220, 20);
        add(subHeading);

        JLabel cardLabel = new JLabel();
        cardLabel.setFont(new Font("System", Font.PLAIN, 12));
        cardLabel.setBounds(20, 85, 360, 20);
        add(cardLabel);

        JLabel statementText = new JLabel();
        statementText.setVerticalAlignment(SwingConstants.TOP);
        statementText.setFont(new Font("Monospaced", Font.PLAIN, 11));
        statementText.setBounds(20, 115, 360, 230);
        add(statementText);

        JLabel balanceLabel = new JLabel();
        balanceLabel.setFont(new Font("System", Font.BOLD, 13));
        balanceLabel.setForeground(new Color(62, 118, 211));
        balanceLabel.setBounds(20, 360, 360, 25);
        add(balanceLabel);

        //Handles the password recovery or verification process for users.
        try {
            Con c = new Con();
            ResultSet rsRecent = c.statement.executeQuery("select * from login where pin = '" + pin + "'");
            while (rsRecent.next()) {
                String cardNum = rsRecent.getString("card_number");
                if (cardNum != null && cardNum.length() >= 16) {
                    cardLabel.setText("Card Number: " + cardNum.substring(0, 4) + "XXXXXXXX" + cardNum.substring(12));
                } else {
                    cardLabel.setText("Card Number: XXXX-XXXX-XXXX-" + pin);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Con c = new Con();

            ResultSet rsBalance = c.statement.executeQuery("select * from bank where pin = '" + pin + "'");
            int balance = 0;
            while (rsBalance.next()) {
                String type = rsBalance.getString("type");
                String amtStr = rsBalance.getString("amount");
                int amt = 0;
                try { amt = Integer.parseInt(amtStr); } catch (Exception ignored) {}

                if ("Deposit".equalsIgnoreCase(type)) {
                    balance += amt;
                } else {
                    balance -= amt;
                }
            }
            balanceLabel.setText("Your Current Balance is: Rs. " + balance);

            ResultSet rsRecent = c.statement.executeQuery("select * from bank where pin = '" + pin + "' order by id desc limit 5");

            StringBuilder htmlBuilder = new StringBuilder("<html><table width='340'>");

            while (rsRecent.next()) {
                String date = rsRecent.getString("date");
                String type = rsRecent.getString("type");
                String amountStr = rsRecent.getString("amount");

                String formattedDate = date;
                if (date != null && date.length() >= 20) {
                    String[] parts = date.split(" ");
                    if (parts.length >= 4) {
                        formattedDate = parts[2] + " " + parts[1] + " " + parts[3].substring(0, 5);
                    }
                }

                htmlBuilder.append("<tr>")
                        .append("<td width='120'>").append(formattedDate).append("</td>")
                        .append("<td width='100'><b>").append(type).append("</b></td>")
                        .append("<td align='right' width='80'>Rs. ").append(amountStr).append("</td>")
                        .append("</tr>");
            }
            htmlBuilder.append("</table></html>");
            statementText.setText(htmlBuilder.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
        exitBtn = new JButton("Exit");
        exitBtn.setBounds(140, 410, 100, 30);
        exitBtn.setBackground(new Color(62, 118, 211));
        exitBtn.setForeground(Color.WHITE);
        exitBtn.addActionListener(this);
        add(exitBtn);

        setSize(400, 500);
        setLocation(500, 150);
        setUndecorated(false);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
    }

    public static void main(String[] args) {
        new Mini("");
    }
}