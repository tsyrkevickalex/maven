package org.example.exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Tester {

    static void tryWithFinally(String str){
        Resource resource1 = null;
        try {
            resource1 = new Resource();
            System.out.println("try block");
            System.out.println(str.length());

        } catch (Exception e){
            System.out.println("catch block");
            e.printStackTrace();
        } finally {
            try {
                resource1.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("finally block");
        }
    }

    static void  tryWithResources(){
        try(Resource resource1 = new Resource();
            Resource resource2 = new Resource();
            Resource resource3 = new Resource()){
            System.out.println(resource1.toString());
        } catch (Exception e){
            System.out.println("catch block");
            e.printStackTrace();
        }
    }

    String field = "John";

    public static void main(String[] args) {
        tryWithFinally("TEST");
        System.out.println("******");
        tryWithResources();

//
//
//     Tester t = new Tester();
//     int arr[] = new int[3]; // {0, 0, 0}
//
//        System.out.println("Begin.");
//        int a = 4;
//        int b = 2;
//
//        try {
//            int val = arr[2];
//            System.out.println(t.field.length());
//            System.out.println(a/b);
//            calculator();
//        } catch (ArithmeticException e){ //
//            System.out.println("Error is here:" + e.getMessage());
//            e.printStackTrace();
//        } catch (NullPointerException e){ // extra
//            System.out.println("NULL is here:" + e.getMessage());
//            e.printStackTrace();
//        } catch (Exception e){ //
//            e.printStackTrace();
//        }



        System.out.println("End.");
    }

    /**
     * Basic math operations.
     *
     * @throws IllegalArgumentException
     *       in case if wrong operator specified
     */
    static void calculator() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input number #1:");
        try {
            int num1 = sc.nextInt();
            System.out.println("Input number #2:");
            int num2 = sc.nextInt();

            System.out.println("Choose operation (+,-,/,*) :");
            String operator = sc.next().trim();
            switch (operator){
                case "+":
                    System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
                    break;
                case "-":
                    System.out.println(num1 + " - " + num2 + " = " + (num1 - num2));
                    break;
                case "/":
                    if(num2 == 0){
                        throw new IllegalArgumentException(" number #2 is 0. ");
                    }
                    System.out.println(num1 + " / " + num2 + " = " + (num1 / num2));
                    break;
                case "*":
                    System.out.println(num1 + " * " + num2 + " = " + (num1 * num2));
                    break;

                default:
                    //
                    throw new IllegalArgumentException("Incorrect operator has been specified.");
            }


        } catch (InputMismatchException e){
            String msg = e.getMessage();
            System.err.println("Please input correct Integer. (" + (msg != null ? msg : "") +")");
            e.printStackTrace();
        }

    }

}



