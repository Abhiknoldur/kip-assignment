package com.knoldus.Problem1;

import java.util.*;
import java.util.stream.Collectors;

public class Problem1 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList();
        Random rand = new Random();
        for (int j = 0; j < 100; j++) {
            int pick = rand.nextInt(100);

            list.add(pick);
        }
        list.stream().filter(Problem1::isPrime).collect(Collectors.toList());
        System.out.println(list);
    }

    private static boolean isPrime(int num) {
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}

