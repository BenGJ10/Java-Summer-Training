package Threads;

class Table {
    void printTable(int num) { 
        for (int i = 1; i <= 5; i++) {
            System.out.println(num * i);
            try{
                Thread.sleep(2000);
            }catch (Exception e){
                System.out.println(e);
            }
        }
    }
}

class ThreadX extends Thread {
    Table t;
    ThreadX(Table t) {
        this.t = t;
    }

    public void run() {
        t.printTable(5);
    }
}

class ThreadY extends Thread {
    Table t;
    ThreadY(Table t) {
        this.t = t;
    }

    public void run() {
        t.printTable(100);
    }
}

public class NonSynchronizedThreads {
    public static void main(String args[]) {
        Table obj = new Table(); 

        ThreadX t1 = new ThreadX(obj);
        ThreadY t2 = new ThreadY(obj);
        t1.start();
        t2.start();
    }
}



