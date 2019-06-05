package com.michelfigueiredo.examples.threadfactory;

import java.util.concurrent.ThreadFactory;

/**
 * @author mfigueiredo
 */
public class ThreadFactoryExample implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        System.out.println("Thread " + thread.getName() + " created.");
        return thread;
    }

    public static void main(String[] args) {
        ThreadFactoryExample threadFactoryExample = new ThreadFactoryExample();

        for (int i = 0; i < 10; i++) {
            Thread thread = threadFactoryExample.newThread(() -> {
                System.out.println("new runnable created");
            });
            thread.start();
        }
    }
}
