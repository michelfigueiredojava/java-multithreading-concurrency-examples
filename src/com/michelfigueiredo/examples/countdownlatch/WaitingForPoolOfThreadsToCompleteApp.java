package com.michelfigueiredo.examples.countdownlatch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Stream;

/**
 * @author mfigueiredo
 */
public class WaitingForPoolOfThreadsToCompleteApp {

    public static void main(String[] args) throws InterruptedException {
        List<String> outputs = Collections.synchronizedList(new ArrayList<>());
        CountDownLatch countDownLatch = new CountDownLatch(10);

        Stream.generate(
            () -> new Thread(new Player(countDownLatch, outputs)))
            .limit(10)
            .forEach(Thread::start);

        countDownLatch.await(); //wait till all threads are completed

        outputs.add("finished");

        outputs.forEach(System.out::println);
    }

    private static class Player implements Runnable {
        private final CountDownLatch countDownLatch;
        private final List<String> output;

        public Player(CountDownLatch countDownLatch, List<String> output) {
            this.countDownLatch = countDownLatch;
            this.output = output;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " playing");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            output.add(Thread.currentThread().getName() + " counted down");
            countDownLatch.countDown();

        }
    }
}

