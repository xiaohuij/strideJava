package com.kingscow.coach.strideJava.java8;

import java.util.stream.IntStream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

public class basicFunctional {
    public static void main(String[] args) {
        int[] array = new int[]{
                1, 1, 3, 4, 5, 6, 7, 8, 8, 8, 9, 10
        };
//
//        int sum = 0;
//        for (int j = 0; j < array.length; j++) {
//            for (int k = j + 1; k < array.length; k++) {
//                if (k != j && array[k] == array[j]) {
//                    sum = sum + array[k];
//                    System.out.println(
//                            "Duplicate found: "
//                                    + array[k]
//                                    + " "
//                                    + "Sum of the duplicate value is " + sum);
//                }
//            }
//        }

        IntStream.of(array)
                .boxed()
                .collect(groupingBy(i -> i))
                .entrySet()
                .stream()
                .filter(e -> e.getValue().size() > 1)
                .forEach(e -> System.out.println(
                        "Duplicates found for : "
                                + e.getKey()
                                + " their sum being : "
                                + e.getValue()
                                .stream()
                                .collect(summingInt(i -> i))));
    }
}
