package com.dmart;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class loginFrame extends JFrame{

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JRadioButton receptionistBtn,adminBtn,managerBtn;
    private ButtonGroup roleGroup;
    private JLabel createAdminLable;

    public loginFrame(){
        setTitle("D-mart Login");
        setSize(450,350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);


        JLabel userLabel = new JLabel("User-Name:");
        userLabel.setBounds(60,40,100,25);
        add(userLabel);

        usernameField = new JTextField(15);
        usernameField.setBounds(140,40,180,25);
        add(usernameField);

        JLabel passwordLabel = new JLabel("password:");
        passwordLabel.setBounds(60,80,100,25);
        add(passwordLabel);

        passwordField = new JPasswordField(15);
        passwordField.setBounds(140,80,180,25);
        add(passwordField);


        JLabel roleLavel = new JLabel("Kindley! Enter your Role");
        roleLavel.setBounds(50,160,250,25);
        add(roleLavel);

        JRadioButton adminBtn = new JRadioButton("Admin");
        adminBtn.setBounds(50,190,90,25);
        add(adminBtn);

        JRadioButton managerBtn = new JRadioButton("Mananger");
        managerBtn.setBounds(140,190,100,25);
        add(managerBtn);

        JRadioButton receptionistBtn = new JRadioButton("Receptionist");
        receptionistBtn.setBounds(250,190,150,25);
        add(receptionistBtn);

        ButtonGroup roleGroup = new ButtonGroup();
        roleGroup.add(adminBtn);
        roleGroup.add(managerBtn);
        roleGroup.add(receptionistBtn);

         JLabel createAdminLable = new JLabel("<HTML><U>Don't have an Admin Account? create one? clicl here</U></HTML>");
        createAdminLable.setForeground(Color.BLUE);
        createAdminLable.setCursor(new Cursor(Cursor.HAND_CURSOR));
        createAdminLable.setBounds(50,220,350,30);
        createAdminLable.setVisible(false);

        adminBtn.addActionListener(e -> {
                    createAdminLable.setVisible(true);
        });
        managerBtn.addActionListener(e -> {
            createAdminLable.setVisible(false);
        });
        receptionistBtn.addActionListener(e -> {
            createAdminLable.setVisible(false);
        });


        createAdminLable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new AdminSignupFrame();
                dispose();
            }
        });

        JButton loginBtn = new JButton("Login");
        loginBtn.setBounds(350,260,70,20);
        loginBtn.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Login attempt...(logic not implemented)");
        });


        add(createAdminLable);
        add(loginBtn);


        setVisible(true);
    }

}


