package travel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class ViewCustomer extends JFrame implements ActionListener {

    JButton b2;

    ViewCustomer(String username) {
        setBounds(500, 200, 920, 600);
        setLocationRelativeTo(null); // Centers the window
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setResizable(false);

        JLabel l1 = new JLabel("Username : ");
        l1.setBounds(40, 50, 150, 25);
        l1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(l1);

        JLabel l11 = new JLabel();
        l11.setBounds(220, 50, 150, 25);
        l11.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(l11);

        JLabel l2 = new JLabel("ID : ");
        l2.setBounds(40, 110, 150, 25);
        l2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(l2);

        JLabel l12 = new JLabel();
        l12.setBounds(220, 110, 150, 25);
        l12.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(l12);

        JLabel l3 = new JLabel("ID Number : ");
        l3.setBounds(40, 170, 150, 25);
        l3.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(l3);

        JLabel l13 = new JLabel();
        l13.setBounds(220, 170, 150, 25);
        l13.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(l13);

        JLabel l4 = new JLabel("Name : ");
        l4.setBounds(40, 230, 150, 25);
        l4.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(l4);

        JLabel l14 = new JLabel();
        l14.setBounds(220, 230, 150, 25);
        l14.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(l14);

        JLabel l5 = new JLabel("Gender : ");
        l5.setBounds(40, 290, 150, 25);
        l5.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(l5);

        JLabel l15 = new JLabel();
        l15.setBounds(220, 290, 150, 25);
        l15.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(l15);

        JLabel l6 = new JLabel("Country : ");
        l6.setBounds(500, 50, 150, 25);
        l6.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(l6);

        JLabel l16 = new JLabel();
        l16.setBounds(690, 50, 150, 25);
        l16.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(l16);

        JLabel l7 = new JLabel("Address : ");
        l7.setBounds(500, 110, 150, 25);
        l7.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(l7);

        JLabel l17 = new JLabel();
        l17.setBounds(690, 110, 150, 25);
        l17.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(l17);

        JLabel l8 = new JLabel("Phone : ");
        l8.setBounds(500, 170, 150, 25);
        l8.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(l8);

        JLabel l18 = new JLabel();
        l18.setBounds(690, 170, 150, 25);
        l18.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(l18);

        JLabel l9 = new JLabel("Email : ");
        l9.setBounds(500, 230, 150, 25);
        l9.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(l9);

        JLabel l19 = new JLabel();
        l19.setBounds(690, 230, 150, 25);
        l19.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(l19);

        b2 = new JButton("BACK");
        b2.setBackground(new Color(135, 195, 235));
        b2.setForeground(Color.BLACK);
        b2.setBounds(620, 290, 150, 35);
        b2.setFont(new Font("Tahoma", Font.BOLD, 18));
        b2.addActionListener(this);
        add(b2);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/viewall.jpg"));
        Image i2 = i1.getImage().getScaledInstance(630, 170, Image.SCALE_DEFAULT);
        JLabel l10 = new JLabel(new ImageIcon(i2));
        l10.setBounds(120, 400, 650, 150);
        add(l10);

        // Populate fields from database
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("SELECT * FROM customer WHERE username = '" + username + "'");
            if (rs.next()) {
                l11.setText(rs.getString("username"));
                l12.setText(rs.getString("id_type"));  // make sure column name matches DB
                l13.setText(rs.getString("id_number"));
                l14.setText(rs.getString("name"));
                l15.setText(rs.getString("gender"));
                l16.setText(rs.getString("country"));
                l17.setText(rs.getString("address"));
                l18.setText(rs.getString("phone"));
                l19.setText(rs.getString("email"));
            } else {
                JOptionPane.showMessageDialog(null, "Customer not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error loading customer data");
        }
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b2) {
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new ViewCustomer("").setVisible(true);
    }
}
