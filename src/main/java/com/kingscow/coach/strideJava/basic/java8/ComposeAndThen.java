package com.kingscow.coach.strideJava.basic.java8;

//compse and andThen are provided for Function Interface

import java.util.function.Function;

public class ComposeAndThen {
    public static void main(String[] args) {
        Function<Integer, Integer> times2 = e -> e * 2;
        Function<Integer, Integer> squared = e -> e * e;
        System.out.println(times2.compose(squared).apply(4));
        System.out.println(times2.andThen(squared).apply(4));
    }
}
