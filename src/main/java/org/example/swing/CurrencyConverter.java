package org.example.swing;

import lombok.SneakyThrows;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CurrencyConverter extends JFrame {

    private JComboBox<String> comboBox;
    private JTextField textField;
    private JTextField textFieldResult;
    private JButton convertButton;

    public CurrencyConverter(){
        textField = new JTextField("Input BYN");
        convertButton = new JButton("Convert");
        comboBox = new JComboBox();
        comboBox.addItem("USD");
        comboBox.addItem("EUR");
        comboBox.addItem("RUB");
        textFieldResult = new JTextField();

        setTitle("Currency Converter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(300, 300, 300, 400);
        setLayout(null);
        add(comboBox);
        add(textField);
        add(convertButton);
        add(textFieldResult);

        textFieldResult.setBounds(160, 150, 100, 20);
        convertButton.setBounds(100, 200, 80, 20);
        textField.setBounds(50, 150, 100, 20);
        comboBox.setBounds(100, 100, 60, 20);

        textFieldResult.setVisible(false);

        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText("");
            }
        });

        convertButton.addActionListener(new ActionListener() {
            @SneakyThrows
            @Override
            public void actionPerformed(ActionEvent e) {
                convertButton.setEnabled(false);
                long userAmount = 0;
                try{
                   userAmount = Integer.parseInt(textField.getText().trim());
                } catch (NumberFormatException nfe){
                    JOptionPane.showMessageDialog(null, "Incorrect amount!");
                }

                if(userAmount > 0){
                    String currencyCode = comboBox.getSelectedItem().toString();
                    String value = XMLCurrencyParser.getCurrency(currencyCode);
                    Thread.sleep(1000);
                    double currencyValue = Double.parseDouble(value);

                    double result = 0.0;
                    if(currencyCode.equals("RUB")){
                        result = userAmount / currencyValue * 100;
                    } else {
                        result = userAmount / currencyValue;
                    }




                    textFieldResult.setText(String.format(" %,f2", result));
                    textFieldResult.setVisible(true);
                }

                convertButton.setEnabled(true);
            }
        });

        setVisible(true);
    }
}

class Test {
    public static void main(String[] args) {
        CurrencyConverter converter = new CurrencyConverter();
    }
}
