// Lambda only works for functional interface
// Functional interface -> Single Abstract Method
// But if we are having a default method in the interface, it will still work
// We can have multiple default methods in the interface and can be overriden
// We can have multiple static methods in the interface
// We can have multiple methods in the interface, but only one abstract method

interface Details{
    String printDetails(String name);
    
    static int printAge(int age){
        return age;
    }
}

public class LambdaFunctions {
    public static void main(String args[]){
        // When we apply lambda it won't create byte code for anonymous class
        Details d = (name)->  name;
        System.out.println("Your name is: " + d.printDetails("Ben Gregory John"));
        System.out.println("Your age is: " + Details.printAge(19));
    }
}
