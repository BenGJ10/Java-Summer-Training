interface Calculator{
    // Abstract method (must be implemented)
    public abstract int add(int a, int b);

    // Default method (can be inherited or overriden)
    default int subtract(int a, int b){
        return a - b;
    }

    // Static method (belongs to the interface, cannot be overriden)
    static int multiply(int a, int b){
        return a * b;
    }

    // Another static utility method
    static double divide(double a, double b){
        if(b == 0){
            throw new IllegalArgumentException("Cannot divide by zero!");
        }
        return (a / b);
    }

}

class BasicCalulator implements Calculator{
    @Override
    public int add(int a, int b){
        return a + b;
    }

    // BasicCalculator doesn't need to implement subtract(), multiply() and divide()
}

public class DefaultInterface {
    public static void main(String args[]){
        BasicCalulator bc = new BasicCalulator();
        System.out.println("Addition: " + bc.add(10, 6));

        System.out.println("Subtraction: " + bc.subtract(10, 6));
        
        // Calling static methods directly through interface name
        System.out.println("Multiplication: " + Calculator.multiply(10, 6));
        System.out.println("Division: " + Calculator.divide(10.0, 6.0));
        
        // If we don't handle the exception ourself, JVM will handle it. And it'll terminate the program.
        try{
            System.out.println("Division: " + Calculator.divide(15.0,0.0));
        } catch(IllegalArgumentException e){
            System.out.println(e); 
            
            e.printStackTrace(); // it'll print exception like JVM 
        }
        
        System.out.println("This should run at any cost!");
    }

}
