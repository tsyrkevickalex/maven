package org.example.abs;

import java.util.Arrays;
import java.util.Date;

public class FilmsManager {

    public static void main(String[] args) {
        Film film = new Film();
        film.setId(154);
        film.setName("Bad Boys 2");
        film.setImdbRate(7.2);
        film.setDescr("Action");
        film.setReleaseDate(new Date());

        System.out.println(film);

        Film filmCopy = new Film();
        filmCopy.setId(film.getId());
        filmCopy.setName(film.getName());
        filmCopy.setImdbRate(film.getImdbRate());
        filmCopy.setDescr(film.getDescr());
        filmCopy.setReleaseDate(film.getReleaseDate());

        film.setImdbRate(9.5);

        System.out.println(filmCopy.getImdbRate());

        Film copy2 = film.clone();

        film.setName("Bad boys 3");

        System.out.println(copy2);


        Film film1 = new Film();
        film1.setId(165);
        film1.setName("Bad Boys");
        film1.setImdbRate(6.2);
        film1.setDescr("Action");
        film1.setReleaseDate(new Date());

        Film film2 = new Film();
        film2.setId(200);
        film2.setName("Bad Boys3");
        film2.setImdbRate(6.1);
        film2.setDescr("Action");
        film2.setReleaseDate(new Date());

        Film [] films = {film1, film2, film, filmCopy};
        System.out.println("Before sorting:");

        for (Film f: films) {
            System.out.println(f);
        }
        Arrays.sort(films);

        System.out.println("After sorting:");
        for (Film f: films) {
            System.out.println(f);
        }



        Player player = new Player();
        player.start(films[films.length - 1]);






        String [] strings = {"BB", "AA", "AZ", "AB", "XX", "X1" };
        System.out.println("Before sorting:");
        for (String s: strings) {
            System.out.println(s);
        }
        Arrays.sort(strings);
        System.out.println("After sorting:");
        for (String s: strings) {
            System.out.println(s);
        }


        String str1 = "TEST";
        String str2 = new String("TEST");
        str2 = str1;

        System.out.println(str1 == str2);
        System.out.println(str1.equals(str2));
        System.out.println(str1.compareTo(str2) == 0);
        System.out.println(str1.hashCode());
        System.out.println(str2.hashCode());

    }
}
