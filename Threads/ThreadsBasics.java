package Threads;
// Threads are lightweight, independent, sub programs of a main program that shares memory and 
// resources of the main program along with other threads of the program.
/*
 New born is the initializing stage of a thread.
 This is when a thread object is created but the start() method has not yet been called.

 In the active state, one thread will be running always and the rest will be in the runnable state.
 The thread scheduler picks one thread from the runnable pool to run.

 Ready Queue:
 Threads that are ready to run but are waiting for CPU time are placed in the ready queue.
 The thread scheduler selects a thread from this queue based on scheduling algorithms.
 The rest threads will be in runnable in the ready queue.

 Blocked state:
 A thread enters the blocked state when it is waiting to acquire a lock or waiting for I/O, 
 or if it calls sleep(), wait(), or join() on another thread. It cannot proceed until the condition is resolved.

 Dead state:
 A thread enters the dead state when its run() method finishes executing or it is terminated manually.
 Once a thread is dead, it cannot be started again.
 */

class ThreadA extends Thread{
    public void run(){  // overriding
        for(int i = 1; i <= 5; i++){
            System.out.println("Thread A is: " + i);
        }
    }
}

class ThreadB extends Thread{
    public void run(){  // overriding
        for(int i = 1; i <= 5; i++){
            System.out.println("Thread B is: " + i);
        }
    }
}

class ThreadC extends Thread{
    public void run(){  // overriding
        for(int i = 1; i <= 5; i++){
            System.out.println("Thread C is: " + i);
        }
    }
}

class ThreadsBasics{
    public static void main(String args[]){
        ThreadA thread1 = new ThreadA(); // New Born state
        ThreadB thread2 = new ThreadB();
        ThreadC thread3 = new ThreadC();
        thread1.run();  // Active state, it'll invoke overrided run function
        thread3.run();
        
        try{
            ThreadB.sleep(5000);
        } catch(InterruptedException e){} // or we can use throws keyword in this method 
        thread2.run();
    }
}
