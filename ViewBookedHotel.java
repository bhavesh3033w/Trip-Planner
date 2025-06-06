package travel.management.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class ViewBookedHotel extends JFrame implements ActionListener {
    JButton b1;

    ViewBookedHotel(String username) {
        setTitle("View Booked Hotel Details");
        setSize(1000, 540);
        setLocationRelativeTo(null);  // <-- Center the frame
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/bookedDetails.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l110 = new JLabel(i3);
        l110.setBounds(450, 30, 500, 400);
        add(l110);

        JLabel heading = new JLabel("VIEW HOTEL DETAILS");
        heading.setBounds(80, 0, 300, 25);
        heading.setFont(new Font("Yu Mincho", Font.BOLD, 21));
        add(heading);

        String[] labels = {
            "Username", "Hotel", "Total Persons", "Total Days", "Swimming Pool",
            "Food Included", "ID", "Number", "Phone", "Total Cost"
        };

        JLabel[] labelFields = new JLabel[labels.length];
        int y = 50;
        for (int i = 0; i < labels.length; i++) {
            JLabel label = new JLabel(labels[i] + " : ");
            label.setBounds(30, y, 150, 30);
            label.setFont(new Font("Tahoma", Font.PLAIN, 16));
            add(label);

            labelFields[i] = new JLabel();
            labelFields[i].setBounds(250, y, 200, 30);
            labelFields[i].setFont(new Font("Tahoma", Font.PLAIN, 16));
            add(labelFields[i]);

            y += 40;
        }

        // Insert test data if not present
        try {
            Conn c = new Conn();
            ResultSet check = c.s.executeQuery("SELECT * FROM bookhotel WHERE username = '" + username + "'");
            if (!check.next()) {
                String query = "INSERT INTO bookhotel VALUES ('" + username + "', 'Taj Palace', 2, 3, 'Yes', 'Yes', 'Passport', 'A1234567', '9876543210', '₹15000')";
                c.s.executeUpdate(query);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Load booking data
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("SELECT * FROM bookhotel WHERE username = '" + username + "'");
            if (rs.next()) {
                for (int i = 0; i < labelFields.length; i++) {
                    labelFields[i].setText(rs.getString(i + 1));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        b1 = new JButton("BACK");
        b1.setBounds(150, 450, 150, 25);
        b1.setFont(new Font("Tahoma", Font.PLAIN, 17));
        b1.setBackground(new Color(135, 195, 235));
        b1.addActionListener(this);
        add(b1);
    }

    public void actionPerformed(ActionEvent ae) {
        this.setVisible(false);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ViewBookedHotel("testuser").setVisible(true);
        });
    }
}
