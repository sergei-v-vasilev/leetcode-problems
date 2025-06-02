package concurrency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 1115. Print FooBar Alternately
 */
class FooBar {
    private int n;
    private Lock lock;
    private Condition condition;
    private boolean wasFoo = false;

    public FooBar(int n) {
        this.n = n;
        this.lock = new ReentrantLock();
        this.condition = lock.newCondition();
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            lock.lock();
            try {
                while (wasFoo) {
                    condition.await(100, TimeUnit.MILLISECONDS);
                }

                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                wasFoo = true;
                condition.signal();
            } finally {
                lock.unlock();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            lock.lock();
            try {
                while (!wasFoo) {
                    condition.await(100, TimeUnit.MILLISECONDS);
                }
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                wasFoo = false;
                condition.signal();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        Runnable foo = () -> {
            System.out.println("foo");
        };
        Runnable bar = () -> {
            System.out.println("bar");
        };
        FooBar fooBar = new FooBar(10);
        Thread fooThread = new Thread(() -> {
            try {
                fooBar.foo(foo);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread barThread = new Thread(() -> {
            try {
                fooBar.bar(bar);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        fooThread.start();
        barThread.start();

    }
}