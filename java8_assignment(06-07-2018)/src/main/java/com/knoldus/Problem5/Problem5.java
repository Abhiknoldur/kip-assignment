package com.knoldus.Problem5;

import java.util.*;
import java.util.stream.Collectors;

public class Problem5 {
    public static void main(String[] args) {
        List<Movie> list = new ArrayList<>();
        list.add(new Movie("Dhadak", 2018, 7, "Romantic"));
        list.add(new Movie("The Conjuring", 2013, 6, "Horror"));
        list.add(new Movie("Avengers-Infinity War", 2018, 7, "Sci-Fi"));
        list.add(new Movie("Secret Games", 2018, 9, "Comedy"));
        list.add(new Movie("Game Of Thrones", 2016, 9, "Suspense"));

        List querylist1 = list.stream().filter(r -> r.rating > 8 && r.genre.equals("Comedy")).map(r -> r.name).collect(Collectors.toList());
        System.out.println("all the movies with rating more than 8 and genre comedy: " + querylist1);
        List querylist2 = list.stream().filter(r -> r.realeseYear > 2000 && r.rating < 8).map(r -> r.name).collect(Collectors.toList());
        System.out.println("all the movies with release year greater than 2000 and rating less than 8: " + querylist2);
        List querylist3 = list.stream().filter(r -> r.rating % 2 == 0).map(r -> r.name).collect(Collectors.toList());
        System.out.println("all the movies with rating as even number: " + querylist3);
        List querylist4 = list.stream().filter(r -> r.rating == 7 && r.genre.equals("Sci-Fi")).map(r -> r.name).collect(Collectors.toList());
        System.out.println("all the movies with rating equals to 7 and genre Sci-Fi: " + querylist4);
    }
}
