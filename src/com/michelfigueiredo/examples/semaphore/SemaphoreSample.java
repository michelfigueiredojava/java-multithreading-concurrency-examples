package com.michelfigueiredo.examples.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.stream.Stream;

/**
 * @author mfigueiredo
 */
public class SemaphoreSample {

    private final ExecutorService executor;
    private final Semaphore semaphore;

    public SemaphoreSample(ExecutorService executor, short semaphore) {
        this.executor = executor;
        this.semaphore = new Semaphore(semaphore);
    }

    public void submit(final Runnable task) throws InterruptedException {

        executor.submit(() -> {
            try {
                semaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            task.run();
            semaphore.release();
        });

    }

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executor = Executors.newCachedThreadPool();

        SemaphoreSample semaphoreSample = new SemaphoreSample(executor, (short) 5);

        Stream.generate(() -> new Thread(new Go()))
            .limit(40)
            .forEach(thread -> {
                try {
                    semaphoreSample.submit(new Go());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

        executor.shutdown();

    }

    static class Go implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " is running!");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}
