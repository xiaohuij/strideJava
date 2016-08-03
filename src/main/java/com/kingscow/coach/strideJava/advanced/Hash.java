package com.kingscow.coach.strideJava.advanced;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;

/**
 * Hashtable is basically a data structure to retain values of key-value pair.
 * 1. It does not allow null for both key and value. It will throw NullPointerException.
 * 2. Hashtable does not maintain insertion order. The order is defined by the Hash function.
 * So only use this if you do not need data in order.
 * 3. It is synchronized. It is slow. Only one thread can access in one time.
 * HashTable is thread safe.
 * 4. HashTable uses Enumerator to iterate through elements.

 * HashMap also accepts key value pair.
 * 1. It allows null for both key and value.
 * 2. HashMap does not maintain insertion order. The order is defined by the Hash function.
 * 3. It is not synchronized. It will have better performance.
 * HashMap are not thread safe, but you can use Collections.synchronizedMap(new HashMap<K,V>())

 * HashSet does not allow duplicate values.
 * 1. It provides add method rather put method.
 * 2. You also use its contain method to check whether the object is already available in HashSet.
 * 3. HashSet can be used where you want to maintain a unique list.

 */
public class Hash {
    public static void main(String[] args) {
        Hashtable<Integer,String> myTable= new Hashtable<Integer,String>();
        myTable.put(1, "John");
        myTable.put(2, "Cena");
//        myTable.put(3, null); /* NullPointerEcxeption at runtime*/
        System.out.println("\nHashTable Example:");
        System.out.println(myTable.get(1));
        System.out.println(myTable.get(2));

        HashMap<Integer,String> myMap= new HashMap<Integer,String>();
        myMap.put(1, "First");
        myMap.put(2, "Second");
        myMap.put(3, null);
        System.out.println("\nHashMap Example:");
        System.out.println(myMap.get(3));
        System.out.println(myMap.size());


        HashSet<String> mySet= new HashSet<String>();
        mySet.add("First");
        mySet.add("Second");
        mySet.add("Third");
        mySet.add("First");
        System.out.println("\nHashSet Example:");
        if(mySet.contains("First")){
            System.out.println("The Set already contains First");
        }
        System.out.println(mySet.size());

    }
}
