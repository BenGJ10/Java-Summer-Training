// Three byte codes will be created for this program (.class)
// One for the main class, one for the interface, and one for the anonymous class
// The anonymous class will be created at runtime, and it will implement the interface
// The anonymous class will have the same name as the interface, but it will be in a different package 

interface Addition{ 
    int sum(int a, int b);
}

public class Anonymous {
    public static void main(String args[]){
        Addition addition = new Addition(){ 
            public int sum(int a, int b){
                return (a + b);
            }
        };
        System.out.println("Addition of two numbers: " + addition.sum(1, 2));
    }
}
