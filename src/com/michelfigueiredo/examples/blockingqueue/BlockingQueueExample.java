package com.michelfigueiredo.examples.blockingqueue;

import java.util.concurrent.*;

/**
 * @author mfigueiredo
 */
public class BlockingQueueExample {

    //simulating a consumer slightly slower then the producer

    public static void main(String[] args) throws InterruptedException {
        //our queue
        BlockingQueue<Integer> blockingQueue = new LinkedBlockingDeque<>(5);

        //our multi thread consumer
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(consumer(blockingQueue));
        executorService.submit(consumer(blockingQueue));
        executorService.shutdown();

        //our producer will run in the main thread
        //the queue will be blocked while the queue is full
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " inserted ?" + blockingQueue.offer(i, 5, TimeUnit.SECONDS));

        }

    }

    private static Runnable consumer(BlockingQueue<Integer> blockingQueue) {
        return () -> {
            try {
                Integer element;
                while ((element = blockingQueue.poll(5, TimeUnit.SECONDS)) != null) {

                    System.out.println(element + " removed");
                    Thread.sleep(3000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
    }
}
