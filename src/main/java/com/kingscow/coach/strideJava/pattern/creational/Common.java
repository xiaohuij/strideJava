package com.kingscow.coach.strideJava.pattern.creational;

interface Shape {
    void draw();
}

class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing Rectangle");
    }
}

class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing Square");
    }
}

class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing Circle");
    }
}


interface Printer{
    void print();
}

class PaperPrinter implements Printer{

    @Override
    public void print() {
        System.out.println("paper");
    }
}

class WebPrinter implements Printer{

    @Override
    public void print() {
        System.out.println("web");
    }
}

class ScreenPrinter implements Printer{

    @Override
    public void print() {
        System.out.println("screen");
    }
}

public class Common {

}
