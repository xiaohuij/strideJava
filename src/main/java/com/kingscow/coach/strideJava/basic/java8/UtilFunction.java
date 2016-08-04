package com.kingscow.coach.strideJava.basic.java8;

import com.kingscow.coach.strideJava.common.Job;
import com.kingscow.coach.strideJava.common.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UtilFunction {

    static void updateValue(int oldValue, Function<Integer, Integer> function) {
        int newValue = function.apply(oldValue);
        System.out.println(newValue);
    }

    static Function<Person, Job> mapPersonToJob = new Function<Person, Job>() {
        public Job apply(Person person) {
            Job job = new Job(person.getName(), person.getJob());
            return job;
        }
    };

    public static void main(String[] args) {
        int value = 15;
        updateValue(value, val -> val * 10);
        updateValue(value, val -> val - 100);
        updateValue(value, val -> "xiaohuiji".length() + val - 100);

        //double brace initialization
        List<Person> persons = new ArrayList<Person>() {{
            add(new Person("Tom", "cat", "Pet"));
            add(new Person("Daddy", "Ma", "Dad"));
            add(new Person("Leo", "Yang", "Software engineer"));
            add(new Person("Maxx", "Cheng", "Adjunct instructor"));
            add(new Person("Ike", "Lin", "Pepperoni hanger"));
        }};

        List<Job> jobs = persons.stream().map(mapPersonToJob)
                .collect(Collectors.toList());
        System.out.println(jobs);
    }
}
