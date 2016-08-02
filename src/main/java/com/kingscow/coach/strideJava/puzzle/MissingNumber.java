package com.kingscow.coach.strideJava.puzzle;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * You have an array of numbers from 1 to 100 (both inclusive).
 * The size of the array is 100. The numbers are randomly added to the array, but there is one random empty
 * slot in the array. What is the quickest way to find that slot as well as the number that should
 * be put in the slot?
 */
public class MissingNumber {
    private static Set initMissingSet(int base) {
        Set numberSet = new HashSet();
        for(int i=0; i<=base; i++){
            numberSet.add(i);
        }

        int i =  (new Random()).nextInt(base);
        System.out.println(" Removing number -->" + i);
        numberSet.remove(i);
        return numberSet;
    }

    public static void main(String...strings){
        int base = 50;
        Set missingSet = initMissingSet(base);

        int sum =0;
        for(Object m : missingSet){
            sum= sum + (int)m;
        }
        int l = ((base)*((base+1))/2)- sum; //low=1 && (low+high)*(high-low+1)/2 = (1+high)*high/2
        System.out.println(" Missing number -->"+l);
    }
}