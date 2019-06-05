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
        CountDownLatch countDownLatch = new CountDownLatch(20);

        Stream.generate(
            () -> new Thread(new Player(countDownLatch, outputs)))
            .limit(20)
            .forEach(thread -> thread.start());

        outputs.add("messing up with the threads control");

        countDownLatch.await();

        outputs.add("this one didn't mess up anything");

        outputs.forEach(s -> System.out.println(s));
    }
}
