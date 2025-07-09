package Generics;

import java.util.*;

public class CustomGenerics2 {
    public static void main(String args[]){
        Summation<Integer> intSum = new Summation<>(10, 20);
        intSum.printSum();

        Summation<Float> floatSum = new Summation<>(10.2f,2.2f);
        floatSum.printSum();

        // If we try to use a String or any other non-numeric datatype, it will give complie-time error.

        ArrayList<Integer> integerSums = new ArrayList<>();
        integerSums.add(10);
        integerSums.add(20);

        Summation<Integer> sumFromIntegerSums = new Summation<>(integerSums.get(0),integerSums.get(1));
        sumFromIntegerSums.printSum();
    }    
}

class Summation<T extends Number>{
    T num1, num2;

    public Summation(T num1, T num2){
        this.num1 = num1;
        this.num2 = num2;
    }

    public void printSum(){
        if(num1 instanceof Integer && num2 instanceof Integer) {
            System.out.println("The sum is: " + (num1.intValue() + num2.intValue()));
            return;
        }
        if(num1 instanceof Float && num2 instanceof Float) {
            System.out.println("The sum is: " + (num1.floatValue() + num2.floatValue()));
            return;
        }
    }
}
