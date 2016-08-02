package com.kingscow.coach.strideJava.puzzle;

import java.util.HashMap;
import java.util.Map;

//Suppose you have a large file with lots of words. How would you find the unique words and their count?
public class WordFrequency {
    public static void main(String[] args) {
        Map m = new HashMap();  // best performance will be using hash function
        for (String a : args) {
            Integer freq = (Integer) m.get(a);
            m.put(a, (freq == null) ? 1 : freq + 1);
        }
        System.out.println(m.size() + " distinct words:");
        System.out.println(m);
    }
}
