package com.dmart;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

import com.google.zxing.*;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

public class ManagerFrame extends JFrame {
    private JTextField nameField, gstField, buyPriceField, sellPriceField, discountField, finalPriceField, barcodeField,quantityField;
    private JButton addButton, clearButton;
    private JLabel barcodeImageLabel;

    public ManagerFrame(String username){
        setTitle("Manager Dashboard - welcome" + username);
        setSize(600,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());

//        GridBagConstraints gbc = new GridBagConstraints();
//        gbc.insets = new Insets(10,10,10,10);
//        gbc.anchor = GridBagConstraints.WEST;

        JLabel nameLabel = new JLabel("Product Name");
        nameLabel.setBounds(30,60,120,25);

        nameField = new JTextField(20);
        nameField.setBounds(160,60,200,25);

        JLabel quantityLabel = new JLabel("Quantity");
        quantityLabel.setBounds(30,100,120,25);

        quantityField = new JTextField();
        quantityField.setBounds(160,100,100,25);

        JLabel buyLabel = new JLabel("Buy Price");
        buyLabel.setBounds(30,140,120,25);

        buyPriceField = new JTextField(20);
        buyPriceField.setBounds(160,140,100,25);

        JLabel sellLabel = new JLabel("Sell Price");
        sellLabel.setBounds(30,180,120,25);

        sellPriceField = new JTextField(20);
        sellPriceField.setBounds(160,180,100,25);

        JLabel gstLabel = new JLabel("GST %");
        gstLabel.setBounds(30,220,120,25);

        gstField = new JTextField(20);
        gstField.setBounds(160,220,100,25);

        JLabel discountLabel = new JLabel("Discount %");
        discountLabel.setBounds(30,260,120,25);

        discountField = new JTextField();
        discountField.setBounds(160,260,100,25);

        JLabel finalPriceLabel = new JLabel("Final Price");
        finalPriceLabel.setBounds(30,300,120,25);

        finalPriceField = new JTextField();
        finalPriceField.setBounds(160,300,100,25);
        finalPriceField.setEditable(false);

        JButton addButton = new JButton("Add products");
        addButton.setBounds(160,380,160,30);

        clearButton = new JButton("Clear");

        barcodeImageLabel = new JLabel();
        barcodeImageLabel.setBounds(400,60,150,150);


        add(nameLabel);
        add(nameField);
        add(gstLabel);
        add(gstField);
        add(buyLabel);
        add(buyPriceField);
        add(sellLabel);
        add(sellPriceField);
        add(discountLabel);
        add(discountField);
        add(finalPriceLabel);
        add(finalPriceField);
        add(barcodeField);
        add(addButton);
        add(clearButton);
        add(barcodeImageLabel);


        addButton.addActionListener(e -> addProduct());
       // clearButton.addActionListener(e -> clearFields());

//        sellPriceField.addKeyListener(new KeyAdapter() {
//            @Override
//            public void keyReleased(KeyEvent e) {
//                calculateFinalprice();
//            }
//        });
//
//        discountField.addKeyListener(new KeyAdapter(){
//            @Override
//            public void keyReleased(KeyEvent e) {
//                calculateFinalprice();
//            }
//        });

        setVisible(true);
    }

//    private void calculateFinalprice(){
//        try{
//            double sell = Double.parseDouble(sellPriceField.getText());
//            double discount = Double.parseDouble(discountField.getText());
//            double discountedPrice = sell - (sell * (discount / 100));
//            finalPriceField.setText(String.format("%.2f", discountedPrice));
//        }catch (Exception e){
//            finalPriceField.setText("");
//        }
//    }

    private  void addProduct(){
        try{
        String name =nameField.getText().trim();
        int quantity = Integer.parseInt(quantityField.getText().trim());
        Double gst = Double.parseDouble(gstField.getText().trim());
        Double buyPrice = Double.parseDouble(buyPriceField.getText().trim());
        Double sellPrice = Double.parseDouble(sellPriceField.getText().trim());
        Double discount = Double.parseDouble(discountField.getText().trim());


        Double PriceAfterDiscount = sellPrice - (sellPrice * discount / 100);
        Double finalPrice = PriceAfterDiscount + (PriceAfterDiscount * gst / 100);
        finalPrice = Math.round( finalPrice * 100.0 ) /  100.0;
        finalPriceField.setText(String.valueOf(finalPrice));

        String barcode = UUID.randomUUID().toString().substring(0,8).toUpperCase();
        barcodeField.setText(barcode);

        BitMatrix matrix = new MultiFormatWriter().encode(BarcodeFormat.CODE_128, 200, 100);
        BufferedImage image = MatrixToImageWriter.toBufferedImage(matrix);

        ImageIcon icon = new ImageIcon(image.getScaledInstance(150, 75, Image.SCALE_SMOOTH));
        barcodeImageLabel.setIcon(icon);

        JOptionPane.showMessageDialog(this, "product add and barcode generate");

//        if (name.isEmpty() || gst.isEmpty() || buy.isEmpty() || sell.isEmpty() || discount.isEmpty() || finalPrice.isEmpty()){
//           JOptionPane.showMessageDialog(this, "Please fill all fields!");
//           return;
//        }



//        try(BufferedWriter writer = new BufferedWriter(new FileWriter("products.txt", true))){
//            writer.write(barcode + "," + name + "," + gst + "," + buy + "," + sell + "," + discount + "," + finalPrice);
//            writer.newLine();
//            JOptionPane.showMessageDialog(this, "Product Added!");
//        }
//        catch (IOException e){
//            JOptionPane.showMessageDialog(this,"Error savings product!");
//        }
//    }
//    private void clearFields(){
//        nameField.setText("");
//        gstField.setText("");
//        buyPriceField.setText("");
//        sellPriceField.setText("");
//        discountField.setText("");
//        finalPriceField.setText("");
//        barcodeField.setText("");
//    }

            }catch (Exception ex){
            JOptionPane.showMessageDialog(this, "error:"+ ex.getMessage());
        }
       public static void main(String[] args){
        SwingUtilities.invokeLater(ManagerFrame::new);
    }
}
