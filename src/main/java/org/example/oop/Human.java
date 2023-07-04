package org.example.oop;

import java.util.Date;

public class Human {
    String name;
    String surname;
}

class Employee extends  Human {
    String pos;

    Employee(String n, String s, String p){
        this.name = n;
        this.surname = s;
        this.pos = p;
    }

    Department department;
    IDCard card;
    PastPosition [] pastPositions;
}

class Department {
    String name;
    Employee [] empls;
}

class IDCard {
    int id;
    Date exp;
}

class PastPosition{
    Department department;
    String name;
}

