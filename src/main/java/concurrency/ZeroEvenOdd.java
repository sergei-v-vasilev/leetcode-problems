package concurrency;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/**
 * 1116. Print Zero Even Odd
 */
class ZeroEvenOdd {
    private int n;
    private AtomicInteger state;
    private Lock lock;
    private Condition condition;

    public ZeroEvenOdd(int n) {
        this.n = n;
        this.state = new AtomicInteger(0); 
        this.lock = new ReentrantLock();
        this.condition = lock.newCondition();
    }

    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            lock.lock();
            try {
                while (state.get() != 0) {
                    condition.await();
                }
                printNumber.accept(0);
                state.set((i % 2 == 0) ? 1 : 2);
                condition.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            lock.lock();
            try {
                while (state.get() != 2) {
                    condition.await();
                }
                printNumber.accept(i);
                state.set(0);
                condition.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            lock.lock();
            try {
                while (state.get() != 1) {
                    condition.await();
                }
                printNumber.accept(i);
                state.set(0);
                condition.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }
}
