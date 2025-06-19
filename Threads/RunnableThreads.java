package Threads;

class ThreadA extends Thread{ 
    public void run(){  // overriding
        for(int i = 1; i <= 5; i++){
            System.out.println("Thread A is: " + i);
        }
    }
}
/* We follow this particular approach to implement threads, as we can also extends one class while 
   we are still implementing it using Runnable interface. */

class ThreadB implements Runnable{ // it is a functional interface -> single abstract method(SAM)
    public void run(){  // overriding
        for(int i = 1; i <= 5; i++){
            System.out.println("Thread B is: " + i);
        }
    }
}

class ThreadC implements Runnable{
    public void run(){  // overriding
        for(int i = 1; i <= 5; i++){
            System.out.println("Thread C is: " + i);
        }
    }
}

public class RunnableThreads {
    public static void main(String args[]){
        ThreadA t1 = new ThreadA(); // New Born state
        
        ThreadB objB = new ThreadB();
        Thread t2 = new Thread(objB);
        
        ThreadC objC = new ThreadC();
        Thread t3 = new Thread(objC);

        // Lets give priority to ThreadC, just because it is getting priority, it doesn't mean it'll excecute fully.
        t3.setPriority(Thread.MAX_PRIORITY);
        
        t1.start(); // Starts a new thread and executes run() in threadA
        t2.start();
        t3.start();
        
    }
}

