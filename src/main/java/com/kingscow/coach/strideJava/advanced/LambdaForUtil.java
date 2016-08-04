package com.kingscow.coach.strideJava.advanced;

import com.kingscow.coach.strideJava.common.Person;

import java.util.Comparator;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaForUtil {

    @FunctionalInterface
    interface Fun {
        void foo();
    }

    public static void main(String[] args) throws Exception {

        System.out.println("===Predicate===");
        Predicate<String> predicate = (s) -> s.length() > 0;
        System.out.println(predicate.test("ashton"));
        System.out.println(predicate.negate().test(""));

        Predicate<Boolean> nonNull = Objects::nonNull;
        Predicate<Boolean> isNull = Objects::isNull;
        System.out.println(nonNull.test(true));
        System.out.println(isNull.test(null));

        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> isNotEmpty = isEmpty.negate();
        System.out.println(isEmpty.test(""));
        System.out.println(isNotEmpty.negate().test(""));


        System.out.println("===Function===");
        Function<String, Integer> toInteger = Integer::valueOf;
        Function<String, String> backToString = toInteger.andThen(String::valueOf);
        System.out.println(backToString.apply("123"));


        System.out.println("===Supplier===");
        Supplier<Person> personSupplier = Person::new;
        Person person = personSupplier.get();
        person.getPerson();


        System.out.println("===Consumer===");
        Consumer<Person> greeter = (p) -> System.out.println("Hello, " + p.getName());
        greeter.accept(new Person("Luke", "Skywalker"));


        System.out.println("===Comparator===");
        Comparator<Person> comparator = (p1, p2) -> p1.getFirstName().compareTo(p2.getFirstName());
        Person p1 = new Person("John", "Doe");
        Person p2 = new Person("Alice", "Wonderland");

        comparator.compare(p1, p2);
        comparator.reversed().compare(p1, p2);


        System.out.println("===Runnable===");
        Runnable runnable = () -> System.out.println(UUID.randomUUID());
        runnable.run();


        System.out.println("===Callable===");
        Callable<UUID> callable = UUID::randomUUID;
        System.out.println(callable.call());
    }
}
