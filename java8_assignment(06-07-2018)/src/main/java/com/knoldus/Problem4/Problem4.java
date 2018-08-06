package com.knoldus.Problem4;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem4 {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 2, 4, 5, 7, 9);
        List<Integer> list2 = Arrays.asList(1, 2, 4, 5, 7, 9);
        int smallList = Math.min(list1.size(), list2.size());
        List<Integer> multipliedLists =IntStream.range(0, smallList).boxed().map(index -> list1.get(index) * list2.get(index)).collect(Collectors.toList());
        System.out.println(multipliedLists);


    }
}