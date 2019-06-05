package com.michelfigueiredo.examples.executorservice;

/**
 * @author mfigueiredo
 */
class Task implements Runnable {
    @Override
    public void run() {
        System.out.println("Task.run");
    }
}
