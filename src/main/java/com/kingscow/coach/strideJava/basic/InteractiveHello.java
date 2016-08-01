package com.kingscow.coach.strideJava.basic;


import java.util.Scanner;

public class InteractiveHello {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your name ==> ");
        String yourName = input.nextLine();
        System.out.printf("Welcome on board, %s!!!!!\n", yourName);
    }
}
