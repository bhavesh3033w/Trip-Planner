package travel.management.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class ViewPackage extends JFrame implements ActionListener {
    JButton b1;

    ViewPackage(String username) {
        setTitle("View Package");
        setSize(900, 450);
        setLocationRelativeTo(null); // Center the window
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/bookedDetails.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l10 = new JLabel(i3);
        l10.setBounds(450, 20, 500, 400);
        add(l10);

        JLabel heading = new JLabel("VIEW PACKAGE DETAILS");
        heading.setBounds(75, 0, 400, 25);
        heading.setForeground(Color.BLACK);
        heading.setFont(new Font("Yu Mincho", Font.BOLD, 21));
        add(heading);

        String[] labels = {"Username :", "Package :", "Persons :", "ID :", "Number :", "Phone :", "Price :"};
        JLabel[] staticLabels = new JLabel[labels.length];
        JLabel[] dynamicLabels = new JLabel[labels.length];

        for (int i = 0; i < labels.length; i++) {
            staticLabels[i] = new JLabel(labels[i]);
            staticLabels[i].setBounds(30, 50 + i * 40, 100, 30);
            staticLabels[i].setForeground(Color.BLACK);
            staticLabels[i].setFont(new Font("Tahoma", Font.PLAIN, 16));
            add(staticLabels[i]);

            dynamicLabels[i] = new JLabel();
            dynamicLabels[i].setBounds(150, 50 + i * 40, 250, 30); // wider label for long text
            dynamicLabels[i].setForeground(Color.BLACK);
            dynamicLabels[i].setFont(new Font("Tahoma", Font.PLAIN, 16));
            add(dynamicLabels[i]);
        }

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("SELECT * FROM bookPackage WHERE username = '" + username + "'");
            if (rs.next()) {
                for (int i = 0; i < labels.length; i++) {
                    dynamicLabels[i].setText(rs.getString(i + 1));
                }
            } else {
                JOptionPane.showMessageDialog(null, "No package found for username: " + username);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        b1 = new JButton("BACK");
        b1.setBackground(new Color(135, 195, 235));
        b1.setForeground(Color.BLACK);
        b1.setBounds(150, 340, 150, 30);
        b1.setFont(new Font("Tahoma", Font.PLAIN, 17));
        b1.addActionListener(this);
        add(b1);
    }

    public void actionPerformed(ActionEvent ae) {
        this.setVisible(false);
    }

    public static void main(String[] args) {
        new ViewPackage("testuser").setVisible(true);
    }
}
