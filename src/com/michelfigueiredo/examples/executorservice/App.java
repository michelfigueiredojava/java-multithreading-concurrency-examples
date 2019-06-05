package com.michelfigueiredo.examples.executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(50);

        executor.submit(new Task());

        executor.shutdown();

    }
}
