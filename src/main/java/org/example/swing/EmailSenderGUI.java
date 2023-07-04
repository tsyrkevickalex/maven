package org.example.swing;

import javax.mail.MessagingException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmailSenderGUI extends JFrame {
    private JTextField recipientsEmail = new JTextField();
    private JTextField emailsSubject = new JTextField();
    private JTextArea message = new JTextArea();
    private JButton sentEmailButton = new JButton("Sent email");

    //private J test


    public EmailSenderGUI(){
        setTitle("Email");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(300, 300, 600, 400);
        setLayout(null);

        recipientsEmail.setBounds(5,5, 575, 20);
        emailsSubject.setBounds(5,30, 575, 20);
        message.setBounds(5,55, 575, 200);
        sentEmailButton.setBounds(250, 260, 100, 30);

        //test.setBounds(50, 260, 100, 20);




        add(recipientsEmail);
        add(emailsSubject);
        add(message);
        add(sentEmailButton);
        //add(test);

        setVisible(true);
    }

    {
        sentEmailButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                   EmailSender.sentEmail(recipientsEmail.getText(), emailsSubject.getText(), message.getText());
                } catch (MessagingException mex){
                        mex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Oops! something go wrong!");
                }
            }
        });
    }
}

class EmailSenderTester{
    public static void main(String[] args) {
        EmailSenderGUI emailSenderGUI = new EmailSenderGUI();
    }
}
