package org.example.abs;

import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

public class Actor {

    private long uid;
    private String name;
    private String lastName;
    private double rate;

    private long price;

    public Actor(long uid, String name, String lastName, double rate, long price) {
        this.uid = uid;
        this.name = name;
        this.lastName = lastName;
        this.rate = rate;
        this.price = price;
    }

    public Actor(){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Actor actor = (Actor) o;
        return uid == actor.uid &&
                actor.rate == rate &&
                price == actor.price &&
                Objects.equals(this.name, actor.name) &&
                Objects.equals(lastName, actor.lastName) &&
                Arrays.equals(films, actor.films);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(uid, name, lastName, rate, price);
        result = 31 * result + Arrays.hashCode(films);
        return result;
    }

    private Film [] films;

    public void setFilms(Film[] films) {
        this.films = films;
    }
}

class Tester {
    public static void main(String[] args) {


        Actor a1 = new Actor(222, "John", "Johnson", 7.8, 10000);

        Actor a2 = new Actor(223, "Bob", "Johnson", 8.8, 15000);
        Actor a3 = new Actor(223, "Bob", "Johnson", 8.8, 15000);

        // '==' -
        System.out.println(a1 == a2);
        System.out.println(a2 == a3);
        System.out.println(a1 == a3);

//        Actor a10 = null;
//        Actor a11 = null;
//        a10.equals(a11);

        System.out.println("===== EQUALS =====");
        System.out.println(a1.equals(a2));
        System.out.println(a2.equals(a3));
        System.out.println(a1.equals(a3));

        Actor a4 = a2;
        System.out.println(a2.equals(a4));

        System.out.println(a1.hashCode());
        System.out.println(a2.hashCode());
        System.out.println(a3.hashCode());

        System.out.println(new Actor().hashCode());
        System.out.println(new Actor().hashCode());

        System.out.println(a2.hashCode() == a3.hashCode());


        // I EQUALS always the same for the same object as well as HASH CODE
        Actor a50 = new Actor(888, "Mike", "M", 5.5, 80200);
        System.out.println(a50.hashCode());
        System.out.println(a50.hashCode());
        System.out.println(a50.hashCode());
        System.out.println(a50.hashCode());

        Actor a50copy = a50;
        System.out.println(a50copy.equals(a50));
        System.out.println(a50.equals(a50copy));
        System.out.println(a50.equals(a50copy));

        //
        Actor a60 = new Actor(888, "Mike", "M", 5.5, 80200);
        System.out.println(a60.equals(a50));
        System.out.println(a60.equals(a50));

        System.out.println(a60.hashCode());
        System.out.println(a50.hashCode());

        Film film = new Film();
        film.setId(154);
        film.setName("Bad Boys");
        film.setImdbRate(7.2);
        film.setDescr("Action");


        Film film2 = new Film();
        film2.setId(154);
        film2.setName("Bad Boys 3");
        film2.setImdbRate(7.2);
        film2.setDescr("Action");


        Film film3 = new Film();
        film3.setId(154);
        film3.setName("Bad Boys 2");
        film3.setImdbRate(7.2);
        film3.setDescr("Action");


        Film[] films1 = {film, film2};
        a50.setFilms(films1);

        Film filmCopy = new Film();
        filmCopy.setId(154);
        filmCopy.setName("Bad Boys 3");
        filmCopy.setImdbRate(7.2);
        filmCopy.setDescr("Action");


        Film[] films2 = {film, filmCopy};
        a60.setFilms(films2);



        System.out.println(a60.equals(a50));
    }
}