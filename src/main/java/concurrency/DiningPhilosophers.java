package concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 1226. The Dining Philosophers
 */
class DiningPhilosophers {
    //eating
    private final Lock lock;
    //taking forks
    private final Lock[] locks;

    public DiningPhilosophers() {
        lock = new ReentrantLock();
        locks = new ReentrantLock[5];
        for (int i = 0; i < locks.length; i++) {
            locks[i] = new ReentrantLock();
        }
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        lock.lock();
        try {
            if (philosopher == 4) {
                rightLeftRun(4, pickLeftFork, pickRightFork, eat, putLeftFork, putRightFork);
            } else {
                leftRightEat(philosopher, pickLeftFork, pickRightFork, eat, putLeftFork, putRightFork);
            }
        } finally {
            lock.unlock();
        }
    }

    private void leftRightEat(int i,
                              Runnable pickLeftFork,
                              Runnable pickRightFork,
                              Runnable eat,
                              Runnable putLeftFork,
                              Runnable putRightFork
    ) {
        locks[i].lock();
        try {
            pickLeftFork.run();
            int j = i == 4 ? 0 : i + 1;
            locks[j].lock();
            try {
                pickRightFork.run();
                eat.run();
            } finally {
                locks[j].unlock();
                putRightFork.run();
            }
        } finally {
            locks[i].unlock();
            putLeftFork.run();
        }
    }

    private void rightLeftRun(int i,
                              Runnable pickLeftFork,
                              Runnable pickRightFork,
                              Runnable eat,
                              Runnable putLeftFork,
                              Runnable putRightFork
    ) {
        int j = i == 4 ? 0 : i + 1;
        locks[j].lock();
        try {
            pickRightFork.run();
            locks[i].lock();
            try {
                pickLeftFork.run();
                eat.run();
            } finally {
                locks[i].unlock();
                putLeftFork.run();
            }
        } finally {
            locks[j].unlock();
            putRightFork.run();
        }
    }
}