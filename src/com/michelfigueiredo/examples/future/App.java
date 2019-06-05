package com.michelfigueiredo.examples.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author mfigueiredo
 */
public class App {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        Future<String> future = executorService.submit(() -> {
            Thread.sleep(2000);
            return "future content is here";
        });


        System.out.println("keep working...");
        while (!future.isDone() && !future.isCancelled()) {
            System.out.println("waiting future");
        }

        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        executorService.shutdown();
    }
}
