package Generics;

import java.util.*;

class Person implements Comparable<Person> {
    String name;
    int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Person other){
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString(){
        return name + " (" + age + ")";
    }
}

public class ComparatorExample {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();

        people.add(new Person("Ben", 19));
        people.add(new Person("Wilson", 50));
        people.add(new Person("Blessy", 45));

       System.out.println("Original:");
        for (Person p : people) System.out.println(p);

        // Sort using compareTo (by name)
        Collections.sort(people);
        
        System.out.println("\nSorted by name (Comparable):");
        for (Person p : people) System.out.println(p);
    }
}
