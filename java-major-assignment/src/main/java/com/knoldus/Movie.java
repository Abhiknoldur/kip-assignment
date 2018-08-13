package com.knoldus;

public class Movie {
    long id;
    String name;
    int releaseDate;
    int releaseYear;
    int rating;
    String actor;
    String director;

    @Override
    public String toString() {
        return String.format(id+" "+name+" "+ " "+releaseDate+" "+releaseYear+" "+rating+" "+actor+" "+director);
    }


    public Movie(long id, String name, int releaseDate, int releaseYear, int rating, String actor, String director) {
        this.id = id;
        this.name = name;
        this.releaseDate = releaseDate;
        this.releaseYear = releaseYear;
        this.rating = rating;
        this.actor = actor;
        this.director = director;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Integer getReleaseDate() {
        return this.releaseDate;
    }

    public Integer getReleaseYear() {
        return this.releaseYear;
    }

    public Integer getRating() {
        return this.rating;
    }

    public String getActor() {
        return this.actor;
    }

    public String getDirector() {
        return this.director;
    }

}
