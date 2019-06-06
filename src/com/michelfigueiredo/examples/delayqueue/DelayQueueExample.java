package com.michelfigueiredo.examples.delayqueue;

import java.util.concurrent.*;

/**
 * @author mfigueiredo
 */
public class DelayQueueExample {

    /**
     * Note: the following logic can be applied in case we want to use a specific start time instead of a fixed delay
     * this.startTime = System.currentTimeMillis() + delayInMilliseconds
     */

    public static void main(String[] args) throws InterruptedException {

        BlockingQueue<DelayedObject> queue = new DelayQueue<>();

        //Producer
        ExecutorService producer = Executors.newSingleThreadExecutor();
        producer.submit(() -> {
                for (int i = 0; i < 10; i++) {
                    System.out.println(i + " inserted in the queue");
                    queue.offer(new DelayedObject(i, 1000 * i));
                }
            }

        );
        producer.shutdown();

        //Consumer
        ExecutorService consumer = Executors.newSingleThreadExecutor();
        consumer.submit(() ->
            {
                for (int i = 0; i < 10; i++) {
                    try {
                        DelayedObject delayedObject = queue.poll(3000, TimeUnit.MILLISECONDS);
                        System.out.println(delayedObject.getNum() + " removed from the queue");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        );
        consumer.shutdown();

    }
}
