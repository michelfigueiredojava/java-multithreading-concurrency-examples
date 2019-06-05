package com.michelfigueiredo.examples.executor;

/**
 * @author mfigueiredo
 */
class Task implements Runnable {
    @Override
    public void run() {
        System.out.println("Task.run");
    }
}
