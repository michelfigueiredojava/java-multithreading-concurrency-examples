package com.michelfigueiredo.examples.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

/**
 * @author mfigueiredo
 */
public class App {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, () -> {
            System.out.println("we have enough to go, don't need to wait anymore");
        });


        System.out.println("creating the threads");
        for (int i = 0; i < 10; i++) {
            if (!cyclicBarrier.isBroken()) {
                new Thread(new Task(cyclicBarrier)).start();
            }
        }
        System.out.println("finished creating the threads");

    }

}
