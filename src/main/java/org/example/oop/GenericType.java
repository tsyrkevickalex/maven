package org.example.oop;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

public class GenericType<T> {

    private T val;

    public T getVal() {
        return val;
    }

    public void setVal(T val) {
        this.val = val;
    }
}

class Pair <K, V> {
    private K key;
    private V value;

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }

    void printPair(){
        System.out.println(key + " : " + value);
    }
}

class Test {
    public static void main(String[] args) {
        GenericType<Person> type = new GenericType<Person>();
        type.setVal(new Developer());
        type.setVal(new Tester());

        Pair<Integer, Person> pair = new Pair<Integer, Person>();
        pair.setKey(1234);
        pair.setValue(new Developer());

        List<Pair<Integer, Person>> pairs = new ArrayList<>();

        List<List<Pair<Integer, Person>>> list = new ArrayList<>();


    }
}

@Data
class Person {
    private String name;

}

class Developer extends Person {
    void code(){
        System.out.println("write code..");
    }
}

class Tester extends Person{
    void test(){
        System.out.println("write tests..");
    }
}