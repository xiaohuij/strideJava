package com.kingscow.coach.strideJava.java8;

import com.kingscow.coach.strideJava.common.Employee;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

public class BasicStream {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(0, 40, "man", "Good", "Mao"));
        employees.add(new Employee(1, 66, "man", "Nice", "Yi"));
        employees.add(new Employee(2, 30, "woman", "Ya", "Mi"));
        employees.add(new Employee(3, 22, "woman", "Ao", "Kai"));
        employees.add(new Employee(4, 25, "man", "Ye", "Si"));
        employees.add(new Employee(4, 25, "man", "Ye", "Si"));

        //函数式数据处理
        //  没有显式的循环迭代，循环过程被Stream的方法隐藏了
        //  提供了声明式的处理函数，比如filter，它封装了数据过滤的功能，而传统代码是命令式的，需要一步步的操作指令
        //  流畅式接口，方法调用链接在一起，清晰易读

        //流定义了很多数据处理的基本函数，对于一个具体的数据处理问题，
        // 解决的主要思路就是组合利用这些基本函数，实现期望的功能，
        // 这种思路就是函数式数据处理思维，相比直接利用容器类API的命令式思维，思考的层次更高。


        //中间操作(intermediate operation)
        //filter, map, distinct, sorted, skip, limit, peek,
        //mapToLong, mapToInt, mapToDouble, flatMap

        //filter
//        List<Employee> above30List = new ArrayList<>();
//        for (Employee t : employees) {
//            if (t.getAge() > 30) {
//                above30List.add(t);
//            }
//        }
        List<Employee> above30List = employees.stream()
                .filter(t -> t.getAge() > 30)
                .collect(Collectors.toList());
        System.out.println(above30List.size());

        //map
//        List<String> nameList = new ArrayList<>(employees.size());
//        for (Employee t : employees) {
//            nameList.add(t.getName());
//        }
        List<String> employeeList = employees.stream()
                .map(Employee::toString)
                .collect(Collectors.toList());
        for (String t : employeeList) {
            System.out.println(t);
        }
        System.out.println("==============");

        //distinct sorted skip limit peek
        employees.stream()
                .distinct()
                .sorted(Comparator.comparing(Employee::getAge)
                        .reversed()
                        .thenComparing(Employee::getGender))
                .peek(System.out::println)
                .skip(1)
                .limit(3)
                .forEach(System.out::println);
        System.out.println("==============");

        //mapToInt
        Integer ageSum = employees.stream()
                .mapToInt(Employee::getAge)
                .sum();
        System.out.println(ageSum);
        System.out.println("==============");

        //flatMap stream to stream
        List<String> lines = Arrays.asList(new String[]{
                "hello abc",
                "老马  编程"
        });
        List<String> words = lines.stream()
                .flatMap(line -> Arrays.stream(line.split("\\s+")))
                .collect(Collectors.toList());
        System.out.println(words);
        System.out.println("==============");


        //终端操作(terminal operation)
        //max, min, count, allMatch, anyMatch, noneMatch,
        //findFirst, findAny, forEach, toArray, reduce, collect

        //max-min
        Employee student = employees.stream()
                .max(Comparator.comparing(Employee::getAge).reversed())
                .get();
        System.out.println(student);
        System.out.println("==============");

        //count
        long above30Count = employees.stream()
                .filter(t->t.getAge()>30)
                .count();
        System.out.println(above30Count);
        System.out.println("==============");

        //allMatch
        boolean allPass = employees.stream()
                .allMatch(t->t.getAge()>=60);
        System.out.println(allPass);
        System.out.println("==============");

        //findAny
        Optional<Employee> resignEmployee = employees.stream()
                .filter(t->t.getAge()>60)
                .findAny();
        if(resignEmployee.isPresent()){
            System.out.println(resignEmployee.get());
            System.out.println("==============");
        }

        //forEachOrdered
        employees.stream()
                .filter(t->t.getAge()>30)
                .forEach(System.out::println);
        System.out.println("==============");

        //reduce
        Employee topEmployee = employees.stream().reduce((accu, t) -> {
            if (accu.getAge() >= t.getAge()) {
                return accu;
            } else {
                return t;
            }
        }).get();
        System.out.println(topEmployee);
        System.out.println("==============");

        double sumAge = employees.stream().reduce(0d,
                (sum, t) -> sum += t.getAge(),
                (sum1, sum2) -> sum1 += sum2
        );
        System.out.println(sumAge);
        System.out.println("==============");

        File[] files = new File(".").listFiles();
        Arrays.stream(files)
                .filter(File::isFile)
                .map(File::getName)
                .forEach(System.out::println);

    }
}
