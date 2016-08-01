package com.kingscow.coach.strideJava.pattern.behavioral;


abstract class AbstractEmployee {
    protected String name;
    public abstract boolean isNull();
    public abstract String getName();
}

class Programmer extends AbstractEmployee {
    public Programmer(String name) {
        this.name = name;
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public boolean isNull() {
        return false;
    }
}

class NullCustomer extends AbstractEmployee {
    @Override
    public String getName() {
        return "Not Available";
    }

    @Override
    public boolean isNull() {
        return true;
    }
}

class EmployeeFactory {
    public static final String[] names = {"Rob", "Joe", "Jack"};
    public static AbstractEmployee getCustomer(String name){
        for(int i = 0; i < names.length; i++) {
            if (names[i].equalsIgnoreCase(name)){
                return new Programmer(name);
            }
        }
        return new NullCustomer();
    }
}

public class NullObject {
    public static void main(String[] args) {

        AbstractEmployee emp = EmployeeFactory.getCustomer("Rob");
        AbstractEmployee emp2 = EmployeeFactory.getCustomer("Bob");
        AbstractEmployee emp3 = EmployeeFactory.getCustomer("Jack");
        AbstractEmployee emp4 = EmployeeFactory.getCustomer("Tom");

        System.out.println(emp.getName());
        System.out.println(emp2.getName());
        System.out.println(emp3.getName());
        System.out.println(emp4.getName());
    }

}
