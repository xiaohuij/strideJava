package com.kingscow.coach.strideJava.java8;

import com.kingscow.coach.strideJava.common.Employee;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class basicCollect {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(0, 40, "man", "Good", "Mao"));
        employees.add(new Employee(1, 66, "man", "Nice", "Yi"));
        employees.add(new Employee(2, 30, "woman", "Ya", "Mi"));
        employees.add(new Employee(3, 22, "woman", "Ao", "Kai"));
        employees.add(new Employee(4, 25, "man", "Ye", "Si"));

        //Thinking SQL

        Map<String, Integer> nameScoreMap = employees.stream().collect(
                Collectors.toMap(Employee::getFirstName, Employee::getAge));
        System.out.println(nameScoreMap.toString());

        Map<Integer, Employee> byIdMap = employees.stream().collect(
                Collectors.toMap(Employee::getId, t -> t));
        System.out.println(byIdMap.toString());

        Map<Integer, Employee> fromIdMap = employees.stream().collect(
                Collectors.toMap(Employee::getId, Function.identity()));
        System.out.println(fromIdMap.toString());

        Map<String, Integer> strLenMap = Stream.of("abc", "hello", "abc").collect(
                Collectors.toMap(Function.identity(),
                        t -> t.length(), (oldValue, value) -> value));
        System.out.println(strLenMap.toString());

        String result = Stream.of("abc", "老马", "hello")
                .collect(Collectors.joining(",", "[", "]"));
        System.out.println(result);

//        Map<String, List<Employee>> groups = new HashMap<>();
//        for (Employee t : employees) {
//            String key = t.getGender();
//            List<Employee> container = groups.get(key);
//            if (container == null) {
//                container = new ArrayList<>();
//                groups.put(key, container);
//            }
//            container.add(t);
//        }
//        System.out.println(groups);
        Map<String, List<Employee>> _groups = employees.stream()
                .collect(groupingBy(Employee::getGender));
        System.out.println(_groups);

        Map<String, Long> ageCountMap = employees.stream().collect(
                groupingBy(Employee::getGender, counting()));
        System.out.println(ageCountMap);

        Map<String, Long> wordCountMap =
                Stream.of("hello", "world", "abc", "hello").collect(
                        groupingBy(Function.identity(), LinkedHashMap::new, counting()));
        System.out.println(wordCountMap);

        Map<String, Optional<Employee>> topEmployeeMap = employees.stream().collect(
                groupingBy(Employee::getGender,
                        maxBy(Comparator.comparing(Employee::getAge))));
        System.out.println(topEmployeeMap);

        Map<String, Employee> topEmployeeMapObject = employees.stream().collect(
                groupingBy(Employee::getGender,
                        collectingAndThen(
                                maxBy(Comparator.comparing(Employee::getAge)),
                                Optional::get)
                ));
        System.out.println(topEmployeeMapObject);

        Map<String, DoubleSummaryStatistics> genderAgeStat =
                employees.stream().collect(
                        groupingBy(Employee::getGender,
                                summarizingDouble(Employee::getAge)));
        System.out.println(genderAgeStat);

        Map<String, Double> gradeScoreStat =
                employees.stream().collect(
                        groupingBy(Employee::getGender,
                                averagingDouble(Employee::getAge)));
        System.out.println(gradeScoreStat);

        Map<String, List<String>> gradeNameMap =
                employees.stream().collect(
                        groupingBy(Employee::getGender,
                                mapping(Employee::getFirstName, toList())));
        System.out.println(gradeNameMap);

        Map<Boolean, List<Employee>> avgAgeList = employees.stream().collect(
                partitioningBy(t->t.getAge()>=30));
        System.out.println(avgAgeList);

        Map<Boolean, Double> avgAgeMap = employees.stream().collect(
                partitioningBy(t->t.getAge()>=30,
                        averagingDouble(Employee::getAge)));
        System.out.println(avgAgeMap);

        Map<String, Map<Boolean, List<Employee>>> multiGroup =
                employees.stream().collect(
                        groupingBy(Employee::getGender,
                                partitioningBy(t->t.getAge()>=30)));
        System.out.println(multiGroup);
    }
}
