package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Signup extends JFrame implements ActionListener {
    JButton b1, b2;
    JTextField t1, t2, t3, t4;
    Choice c1;

    Signup() {
        setSize(900, 400);
        setLocationRelativeTo(null); // Center the frame
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JPanel p1 = new JPanel();
        p1.setBackground(new Color(132, 192, 232));
        p1.setBounds(0, 0, 500, 400);
        p1.setLayout(null);
        add(p1);

        JLabel l1 = new JLabel("UserName");
        l1.setBounds(40, 30, 125, 25);
        l1.setFont(new Font("Tahoma", Font.BOLD, 14));
        l1.setForeground(Color.BLACK);
        p1.add(l1);

        t1 = new JTextField();
        t1.setBounds(190, 30, 180, 25);
        t1.setBorder(BorderFactory.createEmptyBorder());
        p1.add(t1);

        JLabel l2 = new JLabel("Name");
        l2.setBounds(40, 80, 125, 25);
        l2.setFont(new Font("Tahoma", Font.BOLD, 14));
        l2.setForeground(Color.BLACK);
        p1.add(l2);

        t2 = new JTextField();
        t2.setBounds(190, 80, 180, 25);
        t2.setBorder(BorderFactory.createEmptyBorder());
        p1.add(t2);

        JLabel l3 = new JLabel("Password");
        l3.setBounds(40, 130, 125, 25);
        l3.setFont(new Font("Tahoma", Font.BOLD, 14));
        l3.setForeground(Color.BLACK);
        p1.add(l3);

        t3 = new JTextField();
        t3.setBounds(190, 130, 180, 25);
        t3.setBorder(BorderFactory.createEmptyBorder());
        p1.add(t3);

        JLabel l4 = new JLabel("Security Question");
        l4.setBounds(40, 180, 150, 25);
        l4.setFont(new Font("Tahoma", Font.BOLD, 14));
        l4.setForeground(Color.BLACK);
        p1.add(l4);

        c1 = new Choice();
        c1.add("Fav Anime character");
        c1.add("Fav Marvel Superhero");
        c1.add("Your Lucky Number");
        c1.add("Your Nickname");
        c1.setBounds(190, 180, 180, 25);
        p1.add(c1);

        JLabel l5 = new JLabel("Answer");
        l5.setBounds(40, 230, 125, 25);
        l5.setFont(new Font("Tahoma", Font.BOLD, 14));
        l5.setForeground(Color.BLACK);
        p1.add(l5);

        t4 = new JTextField();
        t4.setBounds(190, 230, 180, 25);
        t4.setBorder(BorderFactory.createEmptyBorder());
        p1.add(t4);

        b1 = new JButton("Create");
        b1.setBounds(80, 280, 100, 30);
        b1.setBackground(Color.WHITE);
        b1.setForeground(Color.BLACK);
        b1.setFont(new Font("Tahoma", Font.BOLD, 14));
        b1.addActionListener(this);
        p1.add(b1);

        b2 = new JButton("Back");
        b2.setBounds(240, 280, 100, 30);
        b2.setBackground(Color.WHITE);
        b2.setForeground(Color.BLACK);
        b2.setFont(new Font("Tahoma", Font.BOLD, 14));
        b2.addActionListener(this);
        p1.add(b2);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/signup.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l6 = new JLabel(i3);
        l6.setBounds(600, 65, 200, 200);
        add(l6);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            String username = t1.getText();
            String name = t2.getText();
            String password = t3.getText();
            String security = c1.getSelectedItem();
            String answer = t4.getText();

            String query = "INSERT INTO a"
                    + "ccount VALUES('" + username + "','" + name + "','" + password + "','" + security + "','" + answer + "');";

            try {
                Conn c = new Conn();
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Account created successfully");
                this.setVisible(false);
                new Login().setVisible(true);
            } catch (Exception e) {
                e.printStackTrace(); // For debugging
            }

        } else if (ae.getSource() == b2) {
            new Login().setVisible(true);
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Signup().setVisible(true);
    }
}
