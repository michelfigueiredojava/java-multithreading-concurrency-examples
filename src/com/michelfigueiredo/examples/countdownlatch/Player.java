package com.michelfigueiredo.examples.countdownlatch;

import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author mfigueiredo
 */
public class Player implements Runnable {
    private final CountDownLatch countDownLatch;
    private final List<String> output;

    public Player(CountDownLatch countDownLatch, List<String> output) {
        this.countDownLatch = countDownLatch;
        this.output = output;
    }

    @Override
    public void run() {
        System.out.println("playing");
        output.add("counted down");
        countDownLatch.countDown();
    }
}
