package org.example.abs;

import java.util.Date;
import java.util.Objects;


public class Film implements Cloneable, Comparable<Film>, Playable {

    private long id;
    private String name;
    private String descr;
    private double imdbRate;
    private Date releaseDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return id == film.id &&
                Double.compare(film.imdbRate, imdbRate) == 0 &&
                Objects.equals(name, film.name) &&
                Objects.equals(descr, film.descr) &&
                Objects.equals(releaseDate, film.releaseDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, descr, imdbRate, releaseDate);
    }

    public Film(){}

    public Film(long id, String name, String descr, double imdbRate, Date releaseDate) {
        this.id = id;
        this.name = name;
        this.descr = descr;
        this.imdbRate = imdbRate;
        this.releaseDate = releaseDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public double getImdbRate() {
        return imdbRate;
    }

    public void setImdbRate(double imdbRate) {
        this.imdbRate = imdbRate;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Film{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", descr='").append(descr).append('\'');
        sb.append(", imdbRate=").append(imdbRate);
        sb.append(", releaseDate=").append(releaseDate);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public Film clone ()  {
        try {
            return (Film)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public int compareTo(Film film) {
        System.out.println(this.id + " compareTo with : " + film.id);
        if(this.imdbRate == film.imdbRate){
            return 0;
        } else if(this.imdbRate > film.imdbRate){
            return 1;
        } else {
            return -1;
        }
    }

    public void play() {
        System.out.println("Start playing Film " + name);

    }
}
