class GrandFather{  // Automatically extends Object class
    String name;
    
    GrandFather(){
        this.name = "Jacob";
        System.out.println("Hi, I am the Grandfather.");
    }
    GrandFather(String name){
        this.name = name;
        System.out.println("Hi, I am the Grandfather.");

    }
    void sentence(){
        System.out.println("My name is " + name);
    }
    void wisdom() {
        System.out.println("GrandFather: Respect everyone.");
    }
}

class Father extends GrandFather{
    String name;
    Father(){
        this.name = "George";
        System.out.println("Hi, I am the Father.");
    }
    Father(String name){
        this.name = name;
        System.out.println("Hi, I am the Father.");
    }
    void sentence(){
        System.out.println("My name is " + name);
        System.out.println("My Father's name is: " + super.name);
    }
    void responsibility() {
        System.out.println("Father: Work hard and take care of your family.");
    }
}

class Son extends Father{
    String name;
    Son(){
        this.name = "John";
        System.out.println("Hi, I am the Son.");
    }
    Son(String name){
        this.name = name;
        System.out.println("Hi, I am the Son.");
    }
    void sentence(){
        System.out.println("My name is " + name);
        System.out.println("My Father's name is: " + super.name);
    }
    void fun() {
        System.out.println("Son: Let's go play football!");
    }
}

public class TripleInheritance {
    public static void main(String args[]){
       
        System.out.println("\n--- Creating Son Object ---");
        Son s = new Son();

        System.out.println("\n--- Accessing Methods ---");
        s.wisdom();         
        s.responsibility(); 
        s.fun();            

        System.out.println("\n--- Creating Father Object ---");
        Father f = new Father("David");

        System.out.println("\n--- Accessing Methods ---");
        f.wisdom();         
        f.responsibility(); 

    }
}
