package com.knoldus.problem2;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Birthday {
    public static void main(String[] args) {
        LocalDate curDate=LocalDate.now();
        LocalDate birthDate=LocalDate.of(1996,12,6);

        long numOfDaysBetween = ChronoUnit.DAYS.between(birthDate, curDate);
       List dayOfWeek= IntStream.iterate(0, i -> i + 1)
                .limit(numOfDaysBetween)
                .mapToObj(birthDate::plusYears).map(LocalDate::getDayOfWeek)
                .collect(Collectors.toList());
        System.out.println(dayOfWeek);

    }
}
