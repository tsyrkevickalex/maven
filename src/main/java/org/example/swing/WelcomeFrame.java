package org.example.swing;

import javax.swing.*;

public class WelcomeFrame extends JFrame {
    private JLabel msgLbl = new JLabel("");


    public WelcomeFrame(String msg){
        setTitle("Welcome Page");
        msgLbl.setBounds(80, 65, 200, 20 );
        msgLbl.setText(msg);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(300, 300, 500, 500);
        setLayout(null);
        add(msgLbl);

        setVisible(true);
    }
}
