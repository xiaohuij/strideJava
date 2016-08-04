package com.kingscow.coach.strideJava.basic.java8;

//The limitation of interface can not add method makes it almost impossible to extend/improve the
// existing interfaces and APIs. The same challenge was faced while enhancing the Collections API
// in Java 8 to support lambda expressions in the API. To overcome this limitation a new concept is
// introduced in Java 8 called default methods which is also referred to as Defender Methods or
// Virtual extension methods.

//Default methods are those methods which have some default implementation and helps in evolving the
// interfaces without breaking the existing code

public class DefaultMethod {

    interface InterfaceWithDefaultMethod {
        public void someMethod();
        default public void someOtherMethod(){
            System.out.println("Defaultod implementation in the interface");
        }
    }

    static class DefaultMethodSample implements InterfaceWithDefaultMethod {

        @Override
        public void someMethod() {
            System.out.println("Interface implementation in the class");
        }
    }

    public static void main(String[] args) {
        DefaultMethodSample def1 = new DefaultMethodSample();
        def1.someMethod();
        def1.someOtherMethod();
    }
}
