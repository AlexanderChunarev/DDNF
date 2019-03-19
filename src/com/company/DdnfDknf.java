package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

class DdnfDknf extends JPanel {
    JButton back = new JButton(new ImageIcon("Undo.png"));
    private JButton getDDNF = new JButton("Get DDNF");
    private JButton getDKNF = new JButton("Get DKNF");
    private JTextArea resultLabel = new JTextArea();
    private JLabel textLabel = new JLabel("Enter an expression: ");
    private JLabel askLabel = new JLabel("Number of variables: ");
    private String[] comboBoxValues = {"1", "2", "3", "4", "5", "6", "7", "8"};
    private JComboBox comboBox = new JComboBox(comboBoxValues);
    private JTextField textField = new JTextField();
    List<List<Integer>> list = new ArrayList<List<Integer>>();

    DdnfDknf() {
        setLayout(null);
        fillPanel();
        addListener();
    }

    private void fillPanel() {
        askLabel.setBounds(10, 10, 130, 30);
        comboBox.setBounds(150, 10, 60, 30);
        textLabel.setBounds(10, 50, 130, 30);
        textField.setBounds(150, 50, 120, 40);
        getDDNF.setMargin(new Insets(1, 1, 1, 1));
        getDDNF.setBounds(75, 90, 60, 30);
        getDKNF.setMargin(new Insets(1, 1, 1, 1));
        getDKNF.setBounds(145, 90, 60, 30);
        back.setBounds(140, 210, 20, 20);
        back.setBorder(BorderFactory.createEmptyBorder());
        back.setContentAreaFilled(false);
        add(back);
        resultLabel.setBounds(10, 140, 260, 60);
        resultLabel.setLineWrap(true);
        add(askLabel);
        add(comboBox);
        add(textLabel);
        add(textField);
        add(getDDNF);
        add(getDKNF);
        add(resultLabel);
        textField.setText("1110111101001010");
    }

    private void addListener() {
        getDDNF.addActionListener(e -> {
            int countOfElements = Integer.parseInt((String) comboBox.getSelectedItem());
            ddnf(countOfElements);
        });

        getDKNF.addActionListener(e -> {
            int countOfElements = Integer.parseInt((String) comboBox.getSelectedItem());
            dknfBuilder(countOfElements);
        });
    }

    private void ddnf(int countOfElements) {
        String expression = textField.getText();
        String result = "";
        String DDNF = "";
        int index;
        for (int i = 0; i < expression.length(); i++) {
            index = 1;
            if (expression.charAt(i) == '1') {
                for (int j = countOfElements - 1; j >= 0; j--) {
                    int value = (i / (int) Math.pow(2, j)) % 2;
                    if (value == 0) {
                        result += ("!x" + index);
                    } else
                        result += ("x" + index);
                    index++;
                }
                DDNF += result + " + ";
                result = "";
            }
        }
        resultLabel.setText(DDNF.substring(0, DDNF.length() - 3));
    }

    private void dknfBuilder(int countOfElements) {
        String expression = textField.getText();
        String dknf = "";
        String currentValue = "";
        int index;
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '0') {
                index = 1;
                for (int j = countOfElements - 1; j >= 0; j--) {
                    int value = (i / (int) Math.pow(2, j)) % 2;
                    if (value == 1) {
                        currentValue += ("+!x" + index + "+");
                    } else
                        currentValue += ("+x" + index + "+");
                    index++;
                }
                currentValue = currentValue.replaceAll("(\\+)+", "+");
                currentValue = currentValue.substring(1, currentValue.length() - 1);
                dknf += "(" + currentValue + ")" + " * ";
                currentValue = "";
            }
        }
        resultLabel.setText(dknf.substring(0, dknf.length() - 3));
    }
}