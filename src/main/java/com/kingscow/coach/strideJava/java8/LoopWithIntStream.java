package com.kingscow.coach.strideJava.java8;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LoopWithIntStream {
    public static void main(String[] args) {
        //Replace traditional for (int i=0;... loop with IntStreams
        IntStream.of(1, 2, 3).forEach(System.out::print);
        System.out.println();
        IntStream.range(1, 3).forEach(element -> System.out.print(element));
        System.out.println();
        IntStream.rangeClosed(1, 3).forEach(element -> System.out.print(element + 1));

        IntStream.iterate(0, i -> i + 2).limit(5).forEach(System.out::print);
        System.out.println();
        IntStream.generate(() -> ThreadLocalRandom.current().nextInt(10)).limit(3).forEach(System.out::print);
        System.out.println();

//        Stream<Integer> stream = IntStream.range(1, 5).boxed();
        DoubleStream stream = IntStream.range(1, 5).mapToDouble(i -> i);
        stream.forEach(element -> System.out.print(element));
        System.out.println();

        Boolean any = IntStream.range(1, 5).anyMatch(i -> i % 2 == 0);
        System.out.println(any);
        Boolean all = IntStream.range(1, 5)
                .filter(i -> i % 2 == 0)
                .allMatch(i -> i % 2 == 0);
        System.out.println(all);
        Boolean none = IntStream.range(1, 5)
                .filter(i -> i % 2 == 0)
                .noneMatch(i -> i % 2 != 0);
        System.out.println(none);

        System.out.println(IntStream.range(1, 5).max().getAsInt());
        System.out.println(IntStream.range(1, 5).reduce(1, (x, y) -> x * y));

        IntStream.range(1, 5).parallel().forEach(i -> System.out.print(i));
    }
}
