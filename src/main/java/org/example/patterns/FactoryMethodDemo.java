package org.example.patterns;

public class FactoryMethodDemo {

    public static void main(String[] args) {
        Shape shape = FactoryMethod.getShape(1);








    }

}

class FactoryMethod {

    public static Shape getShape(int num){
        switch (num){
            case 1:
                return new Circle();
            case 2:
                return new Triangle();
            case 3:
                return new Rectangle();
            default:
                throw new RuntimeException("No such Shape #" + num );

        }
     }
}



interface Shape {
    void draw();
}

class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("O");
    }

}

class Triangle implements Shape {

    @Override
    public void draw() {
        System.out.println(" /\\");
        System.out.println("/__\\");
    }
}

class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("_____");
        System.out.println("|    |");
        System.out.println("|____|");

    }
}
