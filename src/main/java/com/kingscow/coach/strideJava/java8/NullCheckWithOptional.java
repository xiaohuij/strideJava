package com.kingscow.coach.strideJava.java8;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class NullCheckWithOptional {
    public static void main(String[] args) {
//        avoiding NullPointerException

//        opt = Optional.of(notNull);
//        opt = Optional.ofNullable(mayBeNull);
//        opt = Optional.empty();

//        if (x != null) {
//            print(x);
//        }
        String mayBeNull = null;
        Optional<String> opt = Optional.ofNullable(mayBeNull);
        opt.ifPresent(System.out::println);

        mayBeNull = "good";
        opt = Optional.ofNullable(mayBeNull);
        opt.ifPresent(x -> System.out.println(x));


//        if (x != null && x.contains("ab")) {
//            print(x);
//        }
        opt.filter(x -> x.contains("go")).ifPresent(System.out::println);

        if (opt.isPresent() && opt.get().contains("god")) {
            System.out.println(opt.get());
        }

//        if (x != null) {
//            String t = x.trim();
//            if (t.length() > 1) {
//                print(t);
//            }
//        }
        mayBeNull = " good arvo ";
        opt = Optional.ofNullable(mayBeNull);
        opt.map(String::trim).filter(t -> t.length() > 8).
                ifPresent(System.out::println);
        opt.map(String::length).ifPresent(System.out::println);

//        int len = (x != null)? x.length() : -1;
        mayBeNull = null;
        opt = Optional.ofNullable(mayBeNull);
        int len = opt.map(String::length).orElse(-1);
        System.out.println(len);

        List<String> list = collect(opt, Collectors.toList());
        System.out.println(list);

        mayBeNull = " good arvo ";
        opt = Optional.ofNullable(mayBeNull);
        Set<String> set = collect(opt, Collectors.toSet());
        System.out.println(set);

        List<String> easyList = toList(opt);
        System.out.println(easyList);

    }

    public char firstChar(String str) {
//            if(str != null&& !str.isEmpty())
//                return str.charAt(0);
//            else
//                throw new IllegalArgumentException();
        Optional<String> opt = Optional.ofNullable(str);
        return opt.filter(s -> !s.isEmpty()).map(s -> s.charAt(0)).
                orElseThrow(IllegalArgumentException::new);
    }

    //Optional to List
    public static<T> List<T> toList(Optional<T> option) {
        return option.
                map(Collections::singletonList).
                orElse(Collections.emptyList());
    }

    public static<T> List<T> toClearList(Optional<T> option) {
        if(option.isPresent())
            return Collections.singletonList(option.get());
        else
            return Collections.emptyList();
    }

    public static<R, A, T> R collect(Optional<T> option, Collector<? super T, A, R> collector) {
        final A container = collector.supplier().get();
        option.ifPresent(v -> collector.accumulator().accept(container, v));
        return collector.finisher().apply(container);
    }
}
