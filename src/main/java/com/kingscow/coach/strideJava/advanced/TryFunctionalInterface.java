package com.kingscow.coach.strideJava.advanced;

//Functional interface is one that only one method declared in interface definition
//Single Abstract Method interfaces (SAM Interfaces)
//Used for creating Anonymous Inner classes
//Lambda expressions can be used for invoking the functional interface methods

//@TryFunctionalInterface can be used for compiler level errors when the interface you have annotated
// is not a valid Functional Interface

public class TryFunctionalInterface {

    @FunctionalInterface
    interface SimpleFuncInterface {
        public void doWork();
        public boolean equals(Object o);
        default public void doSomeOtherWork(){
            System.out.println("Do work default functional interface method...");
        }
    }

    public static void main(String[] args) {
        carryOutWork(new SimpleFuncInterface() {
            @Override
            public void doWork() {
                System.out.println("Do work impl method in common way...");
            }
        });
        carryOutWork(() -> System.out.println("Do work impl method in lambda exp..."));
    }

    public static void carryOutWork(SimpleFuncInterface sfi) {
        sfi.doWork();
    }
}
