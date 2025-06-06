package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Payment extends JFrame implements ActionListener
{
    JButton b1, b2;

    Payment()
    {
        setSize(800, 600);
        setLocationRelativeTo(null);  // Center the JFrame on the screen
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/paytm.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(0, 0, 800, 600);
        add(l1);

        b1 = new JButton("PAY");
        b1.setBounds(320, 0, 80, 40);
        b1.addActionListener(this);
        b1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        b1.setForeground(Color.BLACK);
        l1.add(b1);

        b2 = new JButton("BACK");
        b2.setBounds(420, 0, 80, 40);
        b2.addActionListener(this);
        b2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        b2.setForeground(Color.BLACK);
        l1.add(b2);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource() == b1)
        {
            this.setVisible(false);
            new Paytm().setVisible(true);  // Assuming Paytm class exists
        }
        else if (ae.getSource() == b2)
        {
            this.setVisible(false);
            // You may want to open previous window here or exit
        }
    }

    public static void main(String[] args)
    {
        new Payment().setVisible(true);
    }
}

// Stub for Paytm class if you don't have it already
class Paytm extends JFrame {
    Paytm() {
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Paytm Payment");
        JLabel label = new JLabel("Paytm Payment Gateway");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        add(label);
    }
}
