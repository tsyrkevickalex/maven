package org.example.exceptions.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class IOTester {
    public static void main(String[] args) {
        String path = "D:\\readme.txt";
        try {
            InputStream input = new FileInputStream(path);
            int b;

            while ((b = input.read()) != -1){
                char ch = (char) b;
                System.out.println(ch);
            }

        } catch (FileNotFoundException exception){
            exception.printStackTrace();
            System.err.println("File not found from : " + path);
        } catch (IOException exception){
            exception.printStackTrace();
            System.err.println("Generic I/O Exception : " + exception.getMessage());
        }
        
       
        
    }
}
