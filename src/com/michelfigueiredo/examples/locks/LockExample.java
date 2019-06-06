package com.michelfigueiredo.examples.locks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Stream;

/**
 * @author mfigueiredo
 */
public class LockExample {

    static Lock lock = new ReentrantLock();

    public static void main(String[] args) {

        Task sharedTask = new Task();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Stream.generate(() -> new Thread(sharedTask))
            .limit(9)
            .forEach(task -> executorService.submit(task));

        executorService.shutdown();
    }

    public static class Task implements Runnable {
        @Override
        public void run() {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " Blocked");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.unlock();
        }
    }

}
