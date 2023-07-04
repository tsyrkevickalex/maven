package org.example.wrappers;


import java.math.BigDecimal;
import java.math.BigInteger;

public class WrappersTester {

    public static void main(String[] args) {

        Long l;
        Boolean b;
        Character c;

        Double d;


        int num = 33;
        Integer i = new Integer(num);

        String str = "456";
        int x = Integer.parseInt(str);
        x++;
        System.out.println(x);


        System.out.println();

        System.out.println(Double.parseDouble("2.200"));

        System.out.println(Boolean.parseBoolean("TRUE"));

        BigDecimal bd;
        BigInteger bi;

        Character ch = new Character('X');
        Character ch1 = new Character('Z');
        Character ch2 = new Character('T');

        Character.isLetter('e');
        Character.isDigit('3');


//        ch.isLetter('e');

        Double d2 = 200.22;// autoboxing
        int val = d2.intValue();
        System.out.println(val);

        Boolean bool = true;
        bool.booleanValue();

        Float f = 44.4f;
        test(f);

        int ii = 550;
        Integer iiObj = ii;
        test2(iiObj);
        // (Number) new Integer(888)
        test2(888); // int -> autoboxing: Integer -> Upcasting: Number

        //Unboxing
        int intVal = iiObj;

        long lo = iiObj.longValue();

        test3(iiObj, f.intValue());

    }

    static void test(Float f){
        System.out.println(f.hashCode());
    }

    static void test2(Number num){
        System.out.println(num.doubleValue());
    }

    static void test3(int a, int b){
        System.out.println(a + b);
    }
}
