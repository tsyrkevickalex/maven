package org.example.init;

public class SuperParent {
    public static int sp;
    private int sp2;

    int r = 0;


    {
        System.out.println("Non Static Block of SuperParent: "  + sp2);
        sp2 = 3;
        System.out.println("Non Static Block of SuperParent: "  + sp2);
    }






    public SuperParent(){
        super();
        sp2 = 2;
        System.out.println("Constructor of SuperParent: "  + sp2);
    }



    public static void m(){
        sp = 2;
        System.out.println("Static Method of SuperParent: " + sp);
    }

    public void m2(){
        sp2 = 4;
        System.out.println("Non Static Method of SuperParent: " + sp);
    }




    static {
        System.out.println("static block of SuperParent: " + sp);
        sp = 1;
        System.out.println("static block of SuperParent: " + sp);
    }

}
