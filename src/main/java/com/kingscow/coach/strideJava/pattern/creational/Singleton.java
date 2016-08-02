package com.kingscow.coach.strideJava.pattern.creational;

class China {
    private static China instance = new China();

    //make the constructor private so that this class cannot be instantiated by other class
    private China(){}

    public static China getInstance(){
        return instance;
    }

    public void language(){
        System.out.println("Chinese");
    }
}

public class Singleton {
    public static void main(String[] args) {
        China object = China.getInstance();
        object.language();
    }
}
