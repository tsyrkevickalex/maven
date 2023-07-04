package org.example;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person {


    private final int id;
    private String name;

    public Person(int id) {
        this.id = id;
    }
}
