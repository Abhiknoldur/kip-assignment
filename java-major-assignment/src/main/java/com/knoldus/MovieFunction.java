package com.knoldus;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MovieFunction {
    static List<Movie> movieList = new ArrayList<>();

    public static void main(String[] args) {

        List<Integer> l = Arrays.asList(1,2,3,4,5,6,7,8);
        System.out.println(l.stream().filter(a -> a %2 == 0).collect(Collectors.toList()));
        Scanner sc = new Scanner(System.in);
        System.out.println("***********Welcome to Movie Application*************");
        try {
            while (true) {
                System.out.println("Choose below Option:");
                System.out.println("1.To Add movies " +
                        "\n2.To Get a Movie " +
                        "\n3.Get List Of Movies " +
                        "\n4.To delete a movie" +
                        "\n5.To Update a movie " +
                        "\n6.To Limit number of function of movies with an offset" +
                        "\n7.Get Movie based on the rating i.e movie with rating greater than 8 and director name " +
                        "\n9.Get Movie on the basis of Director" +
                        "\n10.a list movies where release date is greater than the date passed." +
                        "\n11.Get a list movies where releaseyear lies between startYear and endYear" +
                        "\n12.Get a list movies where releaseDate lies between startDate and endDate" +
                        "\n13. To exit from the Application" +
                        "\nNow Enter Your Choice------------->");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        addMovies();
                        System.out.println("Movie added Successfully...");
                        break;
                    case 2:
                        getMovie();
                        System.out.println("This is the movie you want...");
                        break;
                    case 3:
                        getList();
                        System.out.println("Above is the list of movies....");
                        break;
                    case 4:
                        removeMovie();
                        System.out.println("Movie Deleted Succesfully....");
                        break;
                    case 5:
                        updateMovie();
                        System.out.println("Movies updated Sucesfully....");
                        break;
                    case 6:
                        getlimitOnOffset();
                        System.out.println("Operation completed....");
                        break;
                    case 7:
                        getonRating();
                        System.out.println("Movie based on the rating i.e movie with rating greater than 8 and director name");
                        break;
                    case 9:
                        getOnDirector();
                        System.out.println("Movie on the basis of Director");
                        break;
                    case 10:
                        getonReleasedate();
                        System.out.println("list movies where release date is greater than the date passed");
                        break;
                    case 11:
                        getonReleaseyearbetwen();
                        System.out.println("list of movies where releaseyear lies between startYear and endYear");
                        break;
                    case 12:
                        getonReleasedatebetween();
                        System.out.println("list movies where releaseDate lies between startDate and endDate");
                        break;
                    case 13:
                        System.exit(0);
                        break;
                    default:
                        throw new MovieNotFound("Your queried Movie is not Found.......");

                }
            }
        } catch (MovieNotFound ex) {
            System.out.println(ex.getMessage());
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
        CompletableFuture<List<String>> querylist1 = CompletableFuture.supplyAsync(() -> movieList.stream()
                .filter(m -> m.name.equals(queryMovie))
                .map(m -> m.id + " " + m.name + " " + m.releaseDate + " " + m.releaseYear + " " + m.rating + " " + m.actor + " " + m.director)
                .collect(Collectors.toList()));
        System.out.println(querylist1.join());
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

    public static void getlimitOnOffset() {
        int actualLimit = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the offset");
        int offset = sc.nextInt();
        System.out.println("Enter the limit");
        int limit = sc.nextInt();           //skip -offset ,limit -limit
        System.out.println();
        if (offset > movieList.size() - 1)
            System.out.println("Offset is greater than the size of Movie List");

        else if (offset + limit > movieList.size())
            actualLimit = movieList.size();

        else
            actualLimit = offset + limit;

        int finalActualLimit = actualLimit;
        CompletableFuture<List<Movie>> querylist6 = CompletableFuture.supplyAsync(() -> IntStream.range(offset, finalActualLimit)
                .boxed()
                .map(i -> movieList.get(i))
                .collect(Collectors.toList()));
        System.out.println(querylist6.join());
    }

    public static void getonRating() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter director to be queried:");
        String dirctor = sc.next();
        CompletableFuture<List<String>> querylist7 = CompletableFuture.supplyAsync(() -> movieList.stream()
                .filter(m -> m.rating > 8 && m.director.equals(dirctor))
                .map(m -> m.id + " " + m.name + " " + m.releaseDate + " " + m.releaseYear + " " + m.rating + " " + m.actor + " " + m.director)
                .collect(Collectors.toList()));
        System.out.println(querylist7.join());
    }

    public static void getOnDirector() {
        Scanner sc = new Scanner(System.in);
        String director = sc.next();
        CompletableFuture<Map<String, Long>> queryMap = CompletableFuture.supplyAsync(() -> movieList.stream()
                .collect(Collectors.groupingBy(Movie::getDirector, Collectors.counting())));
        System.out.println(queryMap.join());
    }

    public static void getonReleasedate() {
        int passedDate = LocalDate.now().getDayOfMonth();

        CompletableFuture<List<String>> querylist9 = CompletableFuture.supplyAsync(() -> movieList.stream()
                .filter(m -> m.releaseDate < passedDate)
                .map(m -> m.id + " " + m.name + " " + m.releaseDate + " " + m.releaseYear + " " + m.rating + " " + m.actor + " " + m.director)
                .collect(Collectors.toList()));
        System.out.println(querylist9.join());
    }

    public static void getonReleaseyearbetwen() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter start year:");
        int startYear = sc.nextInt();
        System.out.println("Enter End year:");
        int endYear = sc.nextInt();
        CompletableFuture<List<String>> querylist10 = CompletableFuture.supplyAsync(() -> movieList.stream()
                .filter(m -> m.releaseYear >= startYear && m.releaseYear <= endYear)
                .map(m -> m.id + " " + m.name + " " + m.releaseDate + " " + m.releaseYear + " " + m.rating + " " + m.actor + " " + m.director)
                .collect(Collectors.toList()));
        System.out.println(querylist10.join());
    }

    public static void getonReleasedatebetween() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter start date:");
        int startDate = sc.nextInt();
        System.out.println("Enter End date:");
        int endDate = sc.nextInt();
        CompletableFuture<List<String>> querylist11 = CompletableFuture.supplyAsync(() -> movieList.stream()
                .filter(m -> m.releaseDate >= startDate && m.releaseYear <= endDate)
                .map(m -> m.id + " " + m.name + " " + m.releaseDate + " " + m.releaseYear + " " + m.rating + " " + m.actor + " " + m.director)
                .collect(Collectors.toList()));
        System.out.println(querylist11.join());
    }


}
