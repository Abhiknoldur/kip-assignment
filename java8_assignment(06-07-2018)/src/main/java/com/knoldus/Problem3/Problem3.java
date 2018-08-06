package com.knoldus.Problem3;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Problem3 {

    public static void main(String[] args) {

        String input = "My name is Deepak  Deepak is My name. ";
        Map<String, Long> countResult = Arrays.stream(input.trim().split(" ")).map(word -> word.replaceAll("[^a-zA-Z]", "").trim()).filter(word -> !word.isEmpty())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        List result = (countResult.keySet().stream().map(key -> Arrays.asList(key, countResult.get(key))).collect(Collectors.toList()));
        System.out.println(result);
    }
}