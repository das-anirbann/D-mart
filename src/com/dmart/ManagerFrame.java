package com.dmart;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ManagerFrame extends JFrame {
    private JTextField nameField, gstField, buyPriceField, selPriceField, discountField, finalPriceField, barcodeField;
    private JButton addButton, clearButton;

    public ManagerFrame(String username){
        setTitle("Manager Dashboard - welcome" + username);
        setSize(500,450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10,10,10,10);
        gbc.anchor = GridBagConstraints.WEST;

        JLabel nameLabel = new JLabel("Product Name");
        nameField = new JTextField(20);

        JLabel gstLabel = new JLabel("Product Name");
        gstField = new JTextField(20);

        JLabel buyLabel = new JLabel("Product Name");
        buyPriceField = new JTextField(20);

        JLabel selLabel = new JLabel("Product Name");
        selPriceField = new JTextField(20);

        JLabel discountLabel = new JLabel("Product Name");
        discountField = new JTextField(20);

        JLabel finalPriceLabel = new JLabel("Product Name");
        finalPriceField = new JTextField(20);

        JLabel barcodeLabel = new JLabel("Product Name");
        barcodeField = new JTextField(20);

        addButton = new JButton("Add products");
        clearButton = new JButton("Clear");

        addButton.addActionListener(e -> addProduct());
        clearButton.addActionListener(e -> clearFields());

        selPriceField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                calculateFinalprice();
            }
        });

        discountField.addKeyListener(new KeyAdapter(){
            @Override
            public void keyReleased(KeyEvent e) {
                calculateFinalprice();
            }
        });

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(nameLabel, gbc);
        gbc.gridx=1;
        add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(gstLabel, gbc);
        gbc.gridx=1;
        add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(buyLabel, gbc);
        gbc.gridx=1;
        add(buyPriceField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(selLabel, gbc);
        gbc.gridx=1;
        add(selPriceField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(discountLabel, gbc);
        gbc.gridx=1;
        add(discountField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(finalPriceLabel, gbc);
        gbc.gridx=1;
        add(finalPriceField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(barcodeLabel, gbc);
        gbc.gridx=1;
        add(barcodeField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(addButton, gbc);
        gbc.gridx=1;
        add(clearButton, gbc);

        setVisible(true);
    }

    private void calculateFinalprice(){
        try{
            double sell = Double.parseDouble(sellPriceField.getText());
            double discount = Double.parseDouble(discountField.getText());
            double discountedPrice = sell - (sell * (discount / 100));
            finalPriceField.setText(String.format("%.2f", discountedPrice));
        }catch (Exception e){
            finalPriceField.setText("");
        }
    }

    private  void addProduct(){
        String name =nameField.getText().trim();
        String gst = gstField.getText().trim();
        String buy = buyPriceField.getText().trim();
        String sell = selPriceField.getText().trim();
        String discount = discountField.getText().trim();
        String finalPrice = finalPriceField.getText().trim();

        if (name.isEmpty() || gst.isEmpty() || buy.isEmpty() || sell.isEmpty() || discount.isEmpty() || finalPrice.isEmpty()){
           JOptionPane.showMessageDialog(this, "Please fill all fields!");
           return;
        }
    }
}
