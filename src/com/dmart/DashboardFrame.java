package com.dmart;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DashboardFrame extends JFrame {
    private String role;
    private String username;

    public DashboardFrame(String role, String username){
        this.role = role;
        this.username = username;

        setTitle(role + " Dashboard");
        setSize(500,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());


        JLabel welcomeLabel = new JLabel("Welcome, "+ username +" (" + role + ")" );
        welcomeLabel.setFont(new Font("Arial",Font.BOLD, 18 ));
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        welcomeLabel.setBorder(BorderFactory.createEmptyBorder(20,0,20,0));
        add(welcomeLabel, BorderLayout.NORTH);

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridLayout(3,2,10,10));
        contentPanel.setBorder(BorderFactory.createEmptyBorder(20,50,20,50));
        
        if(role.equals("Admin")){
            contentPanel.add(new JButton("Manage Managers"));
            contentPanel.add(new JButton("Manage Products"));
            contentPanel.add(new JButton("view Reports"));
            contentPanel.add(new JButton("Settings"));
        } else if (role.equals("Managers")) {
            contentPanel.add(new JButton("Add Items"));
            contentPanel.add(new JButton("Remove Items"));
            contentPanel.add(new JButton("Inventory status"));
        } else if (role.equals("Receptionist")) {
            contentPanel.add(new JButton("Customer Billing"));
            contentPanel.add(new JButton("Product Lookup"));
        }

        add(contentPanel, BorderLayout.CENTER);

        JButton logoutButton = new JButton("Logout");
        logoutButton.setBackground(Color.RED);
        logoutButton.setForeground(Color.WHITE);
        logoutButton.addActionListener(e ->  {
        dispose();
        new loginFrame();
        });
        add(logoutButton, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args){
        new  DashboardFrame("Admin", "admin1");
    }
}
