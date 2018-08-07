package com.knoldus.Problem5;

class Movie {
  public  String name;
  public  int realeseYear;
  public  int rating;
  public  String genre;

    Movie(String name, int realeseYear, int rating, String genre) {
        this.name = name;
        this.realeseYear = realeseYear;
        this.rating = rating;
        this.genre = genre;
    }
    public String toString() {
        return String.format(name+" "+realeseYear+" "+rating+" "+genre);
    }

}
