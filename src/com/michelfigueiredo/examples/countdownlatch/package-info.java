/**
 * CountDownLatch (introduced in JDK 5) is a utility class which blocks a set of threads until some operation completes.
 * <p>
 * A CountDownLatch is initialized with a counter(Integer type); this counter decrements as the dependent threads
 * complete execution. But once the counter reaches zero, other threads get released.
 * <p>
 * Essentially, by using a CountDownLatch we can cause a thread to block until other threads have completed a given task.
 *
 * @author mfigueiredo
 */
package com.michelfigueiredo.examples.countdownlatch;
