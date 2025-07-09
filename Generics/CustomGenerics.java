package Generics;

import java.util.*;

public class CustomGenerics {
    public static void main(String args[]){
        Printer<Integer> intPrinter = new Printer<>(10);    // We don't need to specify the type again
        intPrinter.print();

        Printer<Double> doublePrinter = new Printer<>(4.5);
        doublePrinter.print();

        // When we are using generics, no need for explicit casting
        // Also it uses compiler checks to ensure type safety
        // If we try to add a String to the ArrayList, it will give a compile-time error
        ArrayList<Name> names = new ArrayList<>();
        Name name1 = new Name("Ben Gregory");
        Name name2 = new Name("Wilson George");

        names.add(name1);
        names.add(name2);

        for(Name name: names){
            System.out.println(name);
        }
    }
}

class Printer<T>{
    T printObj;
    public Printer(T printObj){
        this.printObj = printObj;
    }
    public void print(){
        System.out.println("The value is: " + printObj);
    }
}

class Name {
    String name;
    public Name(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return "Your name is: " + name;
    }
}
