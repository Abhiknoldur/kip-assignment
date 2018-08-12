package com.knoldus;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MovieFunction {
    static List<Movie> movieList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("***********Welcome to Movie Application*************");

        while (true) {
            System.out.println("Choose below Option:");
            System.out.println("1.To Add movies " +
                    "\n2.To Get a Movie " +
                    "\n3.Get List Of Movies " +
                    "\n4.To delete a movie" +
                    "\n5.To Update a movie " +
                    "\n6.To Limit number of function of movies with an offset" +
                    "\n7.Get Movie based on the rating i.e movie with rating greater than 8 and director name " +
                    "\n8.Get Movie on the basis of Director" +
                    "\n9.Get a list movies where releaseyear lies between startYear and endYear" +
                    "\n10.Get a list movies where releaseDate lies between startDate and endDate");

            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    addMovies();
                    break;
                case 2:
                    getMovie();
                    break;
                case 3:
                    getList();
                    break;
                case 4:
                    removeMovie();
                    break;
                case 5:
                    updateMovie();
                    break;
                case 6:
                    getonRating();
                    break;
                case 7:
                    getOnDirector();
                    break;
                case 8:
                    getonReleasedate();
                    break;
                case 9:
                    getonReleaseyearbetwen();
                    break;
                case 10:
                    getonReleasedatebetween();
                    break;
                default:
                    System.exit(0);
            }
        }

    }

    public static void addMovies() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter id of the movie:");
        int id = sc.nextInt();
        List querylist1 = movieList.stream()
                .filter(m -> m.id == id)
                .collect(Collectors.toList());
        if (querylist1.isEmpty()) {
            System.out.println("Enter name of the movies:");
            String name = sc.next();
            System.out.println("Enter Release Date:");
            int date = sc.nextInt();
            System.out.println("Enter Release Year:");
            int year = sc.nextInt();
            System.out.println("Enter Rating:");
            int rating = sc.nextInt();
            System.out.println("Enter Actor Of the Movie:");
            String actor = sc.next();
            System.out.println("Enter Director of the movie");
            String director = sc.next();
            movieList.add(new Movie(id, name, date, year, rating, actor, director));
        } else {
            System.out.println("ID should be unique!\n");
        }


    }

    public static void getMovie() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name of the movie you want to get");
        String queryMovie = sc.next();
        List<String> querylist1 = movieList.stream()
                .filter(m -> m.name.equals(queryMovie))
                .map(m -> m.id + " " + m.name + " " + m.releaseDate + " " + m.releaseYear + " " + m.rating + " " + m.actor + " " + m.director)
                .collect(Collectors.toList());
        System.out.println(querylist1);

    }

    public static void getList() {
        System.out.println(movieList);
    }

    public static void removeMovie() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Movie to be removed:");
        String queryMovie = sc.next();
        List querylist1 = movieList.stream()
                .filter(m -> m.name.equals(queryMovie))
                .collect(Collectors.toList());
        movieList.removeAll(querylist1);
    }

    public static void updateMovie() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Movie to be updated:");
        String value = sc.next();
        System.out.println("Enter updated name");
        String updatedMovie = sc.next();
        movieList.stream()
                .filter(u -> u.name.equals(value))
                .map(u -> u.name = updatedMovie);
        System.out.println(movieList);
    }

    public static void getonRating() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Movie to be updated:");
        String dirctor = sc.next();
        List<String> querylist7 = movieList.stream()
                .filter(m -> m.rating > 8 && m.director.equals(dirctor))
                .map(m -> m.id + " " + m.name + " " + m.releaseDate + " " + m.releaseYear + " " + m.rating + " " + m.actor + " " + m.director)
                .collect(Collectors.toList());
        System.out.println(querylist7);
    }

    public static void getOnDirector() {
        Scanner sc = new Scanner(System.in);
        String director = sc.next();
//        Map<String, String> queryMap = movieList.stream()
//                .filter(d -> d.director.equals(director))
//                .map(m -> m.director.)
//                .collect(Collectors.toMap(e->));
    }

    public static void getonReleasedate() {
        int passedDate = LocalDate.now().getDayOfMonth();

        List<String> querylist9 = movieList.stream()
                .filter(m -> m.releaseDate < passedDate)
                .map(m -> m.id + " " + m.name + " " + m.releaseDate + " " + m.releaseYear + " " + m.rating + " " + m.actor + " " + m.director)
                .collect(Collectors.toList());
        System.out.println(querylist9);
    }

    public static void getonReleaseyearbetwen() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter start year:");
        int startYear = sc.nextInt();
        System.out.println("Enter End year:");
        int endYear = sc.nextInt();
        List<String> querylist10 = movieList.stream()
                .filter(m -> m.releaseYear >= startYear && m.releaseYear <= endYear)
                .map(m -> m.id + " " + m.name + " " + m.releaseDate + " " + m.releaseYear + " " + m.rating + " " + m.actor + " " + m.director)
                .collect(Collectors.toList());
        System.out.println(querylist10);

    }

    public static void getonReleasedatebetween() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter start date:");
        int startDate = sc.nextInt();
        System.out.println("Enter End date:");
        int endDate = sc.nextInt();
        List<String> querylist11 = movieList.stream()
                .filter(m -> m.releaseDate >= startDate && m.releaseYear <= endDate)
                .map(m -> m.id + " " + m.name + " " + m.releaseDate + " " + m.releaseYear + " " + m.rating + " " + m.actor + " " + m.director)
                .collect(Collectors.toList());
        System.out.println(querylist11);

    }

}
