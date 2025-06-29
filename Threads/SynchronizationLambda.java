package Threads;

class Table {
    // A method to print the multiplication table of a number
    synchronized void printTable(int num) {
        for (int i = 1; i <= 5; i++) {
            System.out.println(num * i);
            try{
                Thread.sleep(400);
            }catch(Exception e){
                System.out.println(e);
            } 
        } 
    }
}

public class SynchronizationLambda {
    public static void main(String args[]) {
        Table obj = new Table(); // Only one object, still needed for synchronization
        
        // Using lambda expressions to define the run() method for each Thread
        Thread t1 = new Thread(new Runnable(){     // This uses an anonymous inner class
            public void run(){              
                obj.printTable(6);
            }
        });
        Thread t2 = new Thread(() -> obj.printTable(10)); // This uses a lambda expression
        
        t1.start();
        t2.start();
    }
}