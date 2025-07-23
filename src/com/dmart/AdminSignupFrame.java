package com.dmart;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;

public class AdminSignupFrame extends JFrame {

    private final JTextField nameField;
    private final JTextField usernameField;
    private final JPasswordField passwordField;
    private final JTextField gstField;

    private final String VALID_GST = "22AAAA0000A1Z5";

    public AdminSignupFrame(){

        setTitle("Admin Signup");
        setSize(400,300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel nameLabel = new JLabel("Full Name");
        nameLabel.setBounds(20,25,60,20);

        nameField = new JTextField();
        nameField.setBounds(100,25,250,20);

        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(20,55,80,20);

        usernameField = new JTextField();
        usernameField.setBounds(100,55,250,20);

        JLabel passwordLabel = new JLabel("password");
        passwordLabel.setBounds(20,90,80,20);

        passwordField = new JPasswordField();
        passwordField.setBounds(100,90,250,20);

        JLabel gstLabel = new JLabel("GST Code:");
        gstLabel.setBounds(20,120,60,20);

        gstField = new JTextField();
        gstField.setBounds(100,120,250,20);

        JButton signupButton = new JButton("Create Account");
        signupButton.setBounds(100,170,150,30);

        JLabel statusLabel = new JLabel("");
        statusLabel.setBounds(100,200,100,20);

        add(nameLabel);
        add(nameField);
        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(gstLabel);
        add(gstField);
        add(signupButton);
        add(statusLabel);

        signupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                handleSignup(statusLabel);
            }
        });
        setVisible(true);
    }

    private void handleSignup(JLabel statusLabel){
        String name = nameField.getText().trim();
        String username = usernameField.getText().trim();
        String password = new String(passwordField.getPassword());
        String gst = gstField.getText().trim();

        if (name.isEmpty() || username.isEmpty() || password.isEmpty() || gst.isEmpty()) {
            statusLabel.setText("Please fill all fields.");
            return;
        }

        if (!gst.equals(VALID_GST)){
            statusLabel.setText("Invalid GST Code!");
            return;
        }

        try{
            FileWriter writer = new FileWriter("admin_data.txt", true);
            writer.write(username + ","+ password+ ","+ name+"\n");
            writer.close();
        }catch (IOException e){
            statusLabel.setText("Failed to save data.");
            return;
        }
        JOptionPane.showMessageDialog(this, "Admin registered successfully!");
        dispose();
    }

    public static void main(String[] args){
        new AdminSignupFrame();
    }

}
