/**
 * CyclicBarrier works almost same as CountDownLatch except that we can reuse it. Unlike CountDownLatch, it allows multiple
 * threads to wait for each other using await() method(known as barrier condition) before invoking the final task
 *
 * @author mfigueiredo
 */
package com.michelfigueiredo.examples.cyclicbarrier;
