package com.knoldus.problem5;

import java.time.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Leapyear {
    public static void main(String[] args) {
        List<Integer> leapYearList = IntStream.range(1900, LocalDate.now().getYear() + 1)
                .boxed()
                .filter(year -> LocalDate.now()
                        .withYear(year).isLeapYear()).collect(Collectors.toList());
        System.out.println(leapYearList);
    }
}
