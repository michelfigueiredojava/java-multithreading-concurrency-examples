/**
 * ScheduledExecutorService is a similar interface to ExecutorService, but it can perform tasks periodically.
 * Executor and ExecutorService‘s methods are scheduled on the spot without introducing any artificial delay.
 * Zero or any negative value signifies that the request needs to be executed instantly.
 * We can use both Runnable and Callable interface to define the task.
 *
 * @author mfigueiredo
 */
package com.michelfigueiredo.examples.scheduledexecutorservice;
