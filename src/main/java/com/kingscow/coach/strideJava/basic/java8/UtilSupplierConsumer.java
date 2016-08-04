package com.kingscow.coach.strideJava.basic.java8;

import java.util.function.Consumer;
import java.util.function.Supplier;

//Suppliers represent a function that accepts no arguments and produce a result of some arbitrary type
//Consumers represent a function that accepts a single argument of an arbitrary type and produce no result

public class UtilSupplierConsumer {
    static class Vehicle {
        public void drive() {
            System.out.println("Driving vehicle ...");
        }
    }

    static class Car extends Vehicle {
        @Override
        public void drive() {
            System.out.println("Driving car...");
        }
    }

    static void driveVehicle(Supplier<? extends Vehicle> supplier) {
        Vehicle vehicle = supplier.get();
        vehicle.drive();
    }

    public static void main(String[] args) {
        driveVehicle(() -> new Vehicle());
        driveVehicle(() -> new Car());

        driveVehicle(Vehicle::new);
        driveVehicle(Car::new);

        Consumer consumer = UtilSupplierConsumer::printNames;
        consumer.accept("Jeremy");
        consumer.accept("Paul");
        consumer.accept("Richard");
    }

    private static void printNames(Object name) {
        System.out.println(name);
    }
}
