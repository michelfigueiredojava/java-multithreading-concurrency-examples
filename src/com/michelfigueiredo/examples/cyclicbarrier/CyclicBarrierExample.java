package com.michelfigueiredo.examples.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;
import java.util.stream.Stream;

/**
 * @author mfigueiredo
 */
public class CyclicBarrierExample {

    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, () -> {
            System.out.println("we have enough to go, don't need to wait anymore");
        });

        System.out.println("creating the threads");
        Stream.generate(() -> new Thread(new Task(cyclicBarrier)))
            .limit(15)
            .filter(thread -> !cyclicBarrier.isBroken())
            .forEach(Thread::start);

        System.out.println("finished creating the threads");

    }

}
