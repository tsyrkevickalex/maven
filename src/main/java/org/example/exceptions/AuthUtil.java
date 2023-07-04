package org.example.exceptions;


import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AuthUtil {
    private static final String EMAIL_REGEX = "^(.+)@(\\S+)$";

    static boolean login(String login, String pwd, String pwd2 ) throws LoginException {

        if(StringUtils.isBlank(login)){
            throw new LoginException("Empty login " + login);
        }

        if(!Pattern.compile(EMAIL_REGEX).matcher(login).matches()){
            throw new InvalidEmailException(login);
        }

//        Password must contain at least one digit [0-9].
//                Password must contain at least one lowercase Latin character [a-z].
//        Password must contain at least one uppercase Latin character [A-Z].
//                Password must contain at least one special character like ! @ # & ( ).
//                Password must contain a length of at least 8 characters and a maximum of 20 characters.

        if(!pwd.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$")) {
            throw new LoginException("Password rules: " +
                    "1.        Password must contain at least one digit [0-9].\n" +
                    "2.               Password must contain at least one lowercase Latin character [a-z].\n" +
                    "3.        Password must contain at least one uppercase Latin character [A-Z].\n" +
                    "4.               Password must contain at least one special character like ! @ # & ( ).\n" +
                    "5.                Password must contain a length of at least 8 characters and a maximum of 20 characters.");
        }

        if(!pwd.equals(pwd2)){
            throw new LoginException("Passwords are not equal");
        }

        return true;

    }

    public static void main(String[] args) {
        System.out.println("App begin.");

        String login = "test@gmail";
        String pwd = "12345678aB!";
        String pwd2 = "12345678aB!";
        try {
            login(login, pwd, pwd2);
        } catch (LoginException e) {
            e.printStackTrace();
        }

        System.out.println("App end.");
    }
}

class LoginException extends Exception {
    public LoginException(){
        super("Login error");
    }

    public LoginException(String details){
        super(details);
    }

    public LoginException(String details, Exception cause){
        super(details, cause);
    }
}

class InvalidEmailException extends LoginException {

    public InvalidEmailException(String details){
        super(details);
    }

    public InvalidEmailException(String details, Exception cause){
        super(details, cause);
    }
}

