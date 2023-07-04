package org.example.init;

public class Parent  extends SuperParent {
    public static int sp;
    static {
        sp = 1;
        System.out.println("static block of Parent: " + sp);
    }

    private int sp2;

    public Parent(){
        super();
        sp2 = 2;
        System.out.println("Constructor of Parent: "  + sp2);
    }

    {
        sp2 = 3;
        System.out.println("Non Static Block of Parent: "  + sp2);
    }

    public static void m(){
        sp = 2;
        System.out.println("Static Method of Parent: " + sp);
    }

    public void m2(){
        sp2 = 4;
        System.out.println("Non Static Method of Parent: " + sp);
    }
}
