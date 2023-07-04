package org.example.patterns;


/**
 * Lazy implementation.
 */
public class Singleton {

    private static Singleton instance;

    private Singleton (){
        System.out.println("Singleton has been created");

    }

    public static Singleton getInstance(){
        if(instance == null)
            instance = new Singleton();
        return instance;
    }

}



class Client {
    public static void main(String[] args) {
        EagerSingleton.val = 77;
        EagerSingleton obj = EagerSingleton.getInstance();
    }
}


/**
 * Eager implementation.
 */
class EagerSingleton {

    public static int val = 55;
    private static EagerSingleton instance;

     static {
         System.out.println("Begin");
         instance = new EagerSingleton();
         System.out.println("End.");
    }
    private EagerSingleton (){
        System.out.println("EagerSingleton has been created");

    }

    public static EagerSingleton getInstance(){
        return instance;
    }

}






