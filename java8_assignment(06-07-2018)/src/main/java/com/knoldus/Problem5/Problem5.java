package com.knoldus.Problem5;

import java.util.*;

public class Problem5 {

    public static void main(String[] args) {
        List<Movie> list = new ArrayList<>();
        list.add(new Movie("Dhadak", 2018, 7, "Romantic"));
        list.add(new Movie("The Conjuring", 2013, 6, "Horror"));
        list.add(new Movie("Avengers-Infinity War", 2018, 9, "Sci-Fi"));
        list.add(new Movie("Secret Games", 2018, 4, "Comedy"));
        list.add(new Movie("Game Of Thrones", 2016, 9, "Suspense"));
        System.out.println(list);
    }
}
