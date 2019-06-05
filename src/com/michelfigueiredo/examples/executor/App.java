package com.michelfigueiredo.examples.executor;

/**
 * @author mfigueiredo
 */
public class App {
    public static void main(String[] args) {
        Invoker invoker = new Invoker();
        invoker.execute(new Task());
    }
}
