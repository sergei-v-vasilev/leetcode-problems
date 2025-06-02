package concurrency;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 1114. Print in Order
 */
class Foo {

    private AtomicInteger counter;
    private Lock lock;
    private Condition condition;

    public Foo() {
        this.counter = new AtomicInteger(0);
        this.lock = new ReentrantLock();
        this.condition = lock.newCondition();
    }

    public void first(Runnable printFirst) throws InterruptedException {
        function(0, 1, printFirst);
    }

    public void second(Runnable printSecond) throws InterruptedException {
        function(1, 2, printSecond);
    }

    public void third(Runnable printThird) throws InterruptedException {
        function(2, 0, printThird);
    }

    private void function(int check, int next, Runnable printFunction) throws InterruptedException {
        lock.lock();
        try {
            while (counter.get() != check) {
                condition.await();
            }
            printFunction.run();
            counter.set(next);
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }
}