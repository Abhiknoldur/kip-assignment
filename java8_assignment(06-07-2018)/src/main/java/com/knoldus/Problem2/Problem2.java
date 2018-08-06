package com.knoldus.Problem2;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.io.*;
import java.util.function.Function;
import java.util.stream.Collectors;


public class Problem2 {
    public static void main(String[] args) throws IOException {
        Map<String, Long> wordCount = Files.lines(Paths.get("/home/knoldus/Documents/file.text")).flatMap(line -> Arrays.stream(line.trim().split(" ")))
                .map(word -> word.replaceAll("[^a-zA-Z]", "").toLowerCase().trim()).filter(word -> !word.isEmpty())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(wordCount);

    }
    }