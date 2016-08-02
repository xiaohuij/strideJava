package com.kingscow.coach.strideJava.basic;


public class TryStringBuilder {
    public static void main(String[] args) {
        //String object is immutable whereas StringBuffer/StringBuilder objects are mutable
        //String operations such as append would be more efficient if performed using StringBuffer/StringBuilder objects
        // than String objects
        //StringBuffer and StringBuilder have the same methods with one difference and that’s of synchronization.
        //StringBuffer is synchronized( which means it is thread safe and hence you can use it when you implement
        // threads for your methods) whereas StringBuilder is not synchronized( which implies it isn’t thread safe).

        StringBuilder sb = new StringBuilder();
        sb.append("Go Ashton");
        String forward = sb.toString();
        String reverse = sb.reverse().toString();

        System.out.println(forward);
        System.out.println(reverse);

    }
}
