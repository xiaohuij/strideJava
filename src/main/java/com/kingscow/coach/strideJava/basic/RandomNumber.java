package com.kingscow.coach.strideJava.basic;

import java.util.Random;

public class RandomNumber {
    public static void main(String[] args) {

        Random generator = new Random();
        // 0 is the "seed" the same seed will
        // generate the same random sequence
        // Random() will use a random "seed"

        int i = generator.nextInt(10);      // pick a random number between 0 and 9
        System.out.println(i);

        i = generator.nextInt(10);
        System.out.println(i);

        i = generator.nextInt(10);
        System.out.println(i);
    }
}
