package concurrency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntConsumer;

/**
 * 1195. Fizz Buzz Multithreaded
 */
public class FizzBuzz {
    private int n;
    private int value;
    private Lock lock;
    private Condition condition;

    public FizzBuzz(int n) {
        this.n = n;
        this.lock = new ReentrantLock();
        this.condition = lock.newCondition();
        this.value = 1;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        function((v) -> v % 3 != 0 || v % 5 == 0, (v) -> printFizz.run());
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        function((v) -> v % 5 != 0 || v % 3 == 0, (v) -> printBuzz.run());
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        function((v) -> v % 5 != 0 || v % 3 != 0, (v) -> printFizzBuzz.run());
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        function((v) -> v % 5 == 0 || v % 3 == 0, printNumber::accept);
    }

    private void function(Function<Integer, Boolean> check, Consumer<Integer> action) throws InterruptedException {
        while (!Thread.currentThread().isInterrupted()) {
            lock.lock();
            try {
                if (value > n) {
                    return;
                }
                if (check.apply(value)) {
                    condition.await(100, TimeUnit.MILLISECONDS);
                    continue;
                }
                action.accept(value);
                value++;
                condition.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzz(3);
        Thread threadA = new Thread(() -> {
            try {
                fizzBuzz.fizz(() -> System.out.print("fizz"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread threadB = new Thread(() -> {
            try {
                fizzBuzz.buzz(() -> System.out.print("buzz"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread threadC = new Thread(() -> {
            try {
                fizzBuzz.fizzbuzz(() -> System.out.print("fizzbuzz"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread threadD = new Thread(() -> {
            try {
                fizzBuzz.number((v) -> System.out.print(v));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();

    }
}
