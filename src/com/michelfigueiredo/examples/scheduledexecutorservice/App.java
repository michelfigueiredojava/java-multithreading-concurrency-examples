package com.michelfigueiredo.examples.scheduledexecutorservice;

import java.util.concurrent.*;

public class App {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

        Future<String> future = executorService.schedule(
            () -> "Future",
            0,
            TimeUnit.SECONDS
        );

        ScheduledFuture<String> scheduledFuture = executorService.schedule(
            () -> "ScheduledFuture",
            4,
            TimeUnit.SECONDS
        );

        executorService.scheduleAtFixedRate(
            () -> System.out.println("fixedRate"),
            1,
            2,
            TimeUnit.SECONDS
        );

        executorService.scheduleWithFixedDelay(
            () -> System.out.println("WithFixedDelay"),
            2,
            3,
            TimeUnit.SECONDS
        );

        System.out.println(future.get());
        System.out.println(scheduledFuture.get());

        executorService.awaitTermination(10, TimeUnit.SECONDS);
        executorService.shutdown();

    }
}
