package org.example.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class LoginFrame extends JFrame {

    private JButton loginButton = new JButton("ENTER");
    private JButton regMeButton = new JButton("REG ME");

    private JTextField loginTextFiled = new JTextField();
    private JTextField pwdTextFiled = new JPasswordField();
    private JLabel loginLbl = new JLabel("Login:");
    private JLabel pwdLbl = new JLabel("Password:");
    private JLabel msgLbl = new JLabel("");

    // in-memory user
    private static final String USER_NAME = "Admin";
    private static final String USER_PWD = "123";

    {
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Trying to login. " + new Date());
                String userName = loginTextFiled.getText().trim();
                String userPwd = pwdTextFiled.getText();

                if(!userName.equalsIgnoreCase(USER_NAME)){
                    msgLbl.setText("Incorrect User name!");
                    regMeButton.setVisible(true);
                } else if(!userPwd.equals(USER_PWD)){
                    msgLbl.setText("Incorrect password!");
                    regMeButton.setVisible(true);
                    JOptionPane.showMessageDialog(null, "Incorrect password!");
                } else {
                    System.out.println("Login success! " + new Date());
                    WelcomeFrame wf = new WelcomeFrame("Welcome back, dear " + userName);
                    setVisible(false);
                }

            }
        });

        regMeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegistryFrame rFrame = new RegistryFrame();
                setVisible(false);
            }
        });
    }

    public LoginFrame(){
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(300, 300, 300, 400);
        setLayout(null);
        msgLbl.setBounds(80, 65, 200, 20 );
        loginLbl.setBounds(80, 90, 100, 20 );
        pwdLbl.setBounds(80, 135, 100, 20 );
        loginTextFiled.setBounds(80, 120, 100, 20 );
        pwdTextFiled.setBounds(80, 160, 100, 20 );
        loginButton.setBounds(80, 250, 100, 20 );

        regMeButton.setBounds(200, 250, 100, 20 );
        regMeButton.setVisible(false);

        add(msgLbl);
        add(loginTextFiled);
        add(pwdTextFiled);
        add(loginButton);
        add(regMeButton);

        add(loginLbl);

        add(pwdLbl);
        setVisible(true);
    }

}

class GUITester {
    public static void main(String[] args) {
        LoginFrame login = new LoginFrame();
    }
}
