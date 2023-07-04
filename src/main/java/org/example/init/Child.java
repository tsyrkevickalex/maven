package org.example.init;

public class Child extends Parent {
    public static int sp;
    static {
        sp = 1;
        System.out.println("static block of Child: " + sp);
    }

    private int sp2;

    public Child(){
        sp2 = 2;
        System.out.println("Constructor of Child: "  + sp2);
    }

    {
        sp2 = 3;
        System.out.println("Non Static Block of Child: "  + sp2);
    }

    public static void m(){
        sp = 2;
        System.out.println("Static Method of Child: " + sp);
    }

    public void m2(){
        sp2 = 4;
        System.out.println("Non Static Method of Child: " + sp);
    }
}
