/*
In Java, AtomicInteger is a class in the java.util.concurrent.atomic package that provides an int
value which can be updated atomically. This means that operations on an AtomicInteger are
guaranteed to be performed as a single, indivisible unit, even in a multithreaded environment,
without the need for explicit synchronized blocks or locks.
 */

package Threads;
import java.util.concurrent.atomic.AtomicInteger;
public class AtomicCounterExample {
    public static void main(String[] args) throws InterruptedException {
        final AtomicInteger atomicCounter = new AtomicInteger(0);
        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                atomicCounter.incrementAndGet(); // Atomic increment
            }
        };
        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        Thread t3 = new Thread(task);

        t1.start();
        t2.start();
        t3.start();
        t1.join(); // Wait for thread 1 to finish
        t2.join(); // Wait for thread 2 to finish
        t3.join(); // Wait for thread 3 to finish
        System.out.println("Final count (using AtomicInteger): " + atomicCounter.get());
    }
}
/*
In this example, atomicCounter.incrementAndGet() ensures that each increment operation is
atomic, preventing lost updates and guaranteeing that the final count will be 3000 (1000 increments * 3 threads).
*/

/*
When to use AtomicInteger:
    • Counters: When you need a shared counter that is safely incremented or decremented by multiple threads.
    • Shared state updates: For simple, single-variable updates that need to be thread-safe without the overhead of explicit locking.
    • Non-blocking algorithms: As a building block for implementing more complex nonblocking data structures and algorithms using the compareAndSet operation.

Key advantages of AtomicInteger over synchronized for simple updates:
    • Performance: Generally performs better than synchronized for highly contended updates, as it avoids the overhead of acquiring and releasing locks.
    • Reduced contention: Threads don't block each other as much, leading to better throughput.
    • No deadlocks: Since there are no locks to acquire, there's no risk of deadlocks.
    • Simplicity: For simple atomic operations
 */