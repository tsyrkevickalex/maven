package org.example.swing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class TestForm {
    private JButton testButton;
    private JPanel myPanel;


    public TestForm() {
        myPanel.setLayout(null);
        myPanel.setVisible(true);
        myPanel.setSize(500, 500);

        testButton = new JButton();
        testButton.setText("Go!");
        myPanel.add(testButton);
        testButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(new Date());
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        //frame.setLayout(null);
        frame.setBounds(200, 200, 500, 300);
        frame.setName("My App");
        frame.setTitle("My App");
        frame.setContentPane(new TestForm().myPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

