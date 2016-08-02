package com.kingscow.coach.strideJava.pattern.creational;

//Prototype pattern helps create duplicate object with better performance.
//In Prototype Pattern a clone of an existing object is returned instead of creating new one.

import java.util.Hashtable;

abstract class Person implements Cloneable {

    protected String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    abstract void say();

    public Object clone() {
        Object clone = null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }
}

class Leo extends Person {

    public Leo(){
        name = "Leo";
    }

    @Override
    public void say() {
        System.out.println("Name:"+getName()+" Age:"+getAge());
    }
}

class Maxx extends Person {

    public Maxx(){
        name = "Maxx";
    }

    @Override
    public void say() {
        System.out.println("Name:"+getName()+" Age:"+getAge());
    }
}

class PersonProtoType{
    private static Hashtable<String, Person> personMap
            = new Hashtable<String, Person>();

    public static Person getPerson(String personId) {
        Person cachedPerson = personMap.get(personId);
        return (Person) cachedPerson.clone();
    }
    public static void loadCache() {
        Leo leo = new Leo();
        leo.setAge(10);
        personMap.put(leo.getName(), leo);

        Maxx maxx = new Maxx();
        maxx.setAge(20);
        personMap.put(maxx.getName(), maxx);
    }
}

public class Prototype {
    public static void main(String[] args) {
        PersonProtoType.loadCache();

        Person clonedPerson1 = PersonProtoType.getPerson("Leo");
        clonedPerson1.say();

        Person clonedPerson2 = PersonProtoType.getPerson("Maxx");
        clonedPerson2.say();
    }
}
