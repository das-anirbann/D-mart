package com.dmart;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ReceptionistFrame extends JFrame {

    private JTextField scanField, quantityField;
    private JButton addButton, generateBillButton;
    private JTable billTable;
    private DefaultTableModel billTableModel;
    private JLabel totalLabel;
    private double total = 0.0;

    public ReceptionistFrame(){
        setTitle("Receptionist panel- D-Mart");
        setSize(700,500);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel scanLabel = new JLabel("Scan product (barcode)");
        scanLabel.setBounds(30,30,160,25);
        add(scanLabel);

        scanField = new JTextField();
        scanField.setBounds(200,30,200,25);
        add(scanField);

        JLabel quantityLabel = new JLabel("Quantity");
        quantityLabel.setBounds(500,30,50,25);
        add(quantityField);

        addButton = new JButton("Add to Bill");
        addButton.setBounds(270,70,130,30);
        add(addButton);

        String[] columns ={"product", "price", "Quantity", "subtotal"};
        billTableModel = new DefaultTableModel( columns,0);
        billTable = new JTable(billTableModel);
        JScrollPane scrollPane = new JScrollPane(billTable);
        scrollPane.setBounds(30,120,620,220);
        add(scrollPane);

        totalLabel = new JLabel("Total: ₹0.00");
        totalLabel.setBounds(30,350,200,30);
        add(totalLabel);

        generateBillButton = new JButton("Generate Bill");
        generateBillButton.setBounds(500,390,150,40);
        add(generateBillButton);

        addButton.addActionListener(e -> addToBill());
        generateBillButton.addActionListener(e -> showBillSummary());

        setVisible(true);
    }
}
