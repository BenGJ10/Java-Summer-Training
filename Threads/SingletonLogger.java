package Threads;

public class SingletonLogger {
    // Create a private static reference of the class
    private static  SingletonLogger instance;  
    
    // Making a private constructor so we don't want anyone outside of the class to access it.
    private SingletonLogger(){  // private constructor -> will work implicitly
        System.out.println("SingletonLogger instance has been created.");
    }    

    public static SingletonLogger getInstance(){    // This is a class method (static)
        // If the instance hasn't been created yet, create it
        if(instance == null){
            instance = new SingletonLogger();
        }
        // Return the existing instance
        return instance;     
    }

    // A simple method to demonstrate the logger's functionality
    public void logMessage(String message){     // This is an instance method (non-static)
        System.out.println("LOG: " + message);  // Instance methods cannot be accessed by the class directly
    }

    public static void main(String args[]){
        // Get the first instance of the SingletonLogger
        System.out.println("Attempting to get instance 1...");
        SingletonLogger logger1 = SingletonLogger.getInstance();    // logger1 -> real object
        logger1.logMessage("This is the first log message");

        // Get another instance - it will return the same instance
        System.out.println("\nAttempting to get instance 2...");
        SingletonLogger logger2 = SingletonLogger.getInstance();
        logger2.logMessage("This is the second log message");
        
        // Verify that both references point to the same object
        System.out.println("\nChecking if both instances are same: ");
        if(logger1 instanceof SingletonLogger && logger2 instanceof SingletonLogger && logger1 == logger2){
            // logger1 == logger2 checks if they're pointing to the same memory object
            System.out.println("Success! Both logger1 and logger 2 refer to the same Singleton Instance.");
        }
        else{
            System.out.println("Failure! Different instances were created.");
        }
    }
}
