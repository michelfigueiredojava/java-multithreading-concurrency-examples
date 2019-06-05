/**
 * Future is used to represent the result of an asynchronous operation. It comes with methods for checking if the asynchronous
 * operation is completed or not, getting the computed result, etc.
 * <p>
 * What’s more, the cancel(boolean mayInterruptIfRunning) API cancels the operation and releases the executing thread.
 * If the value of mayInterruptIfRunning is true, the thread executing the task will be terminated instantly.
 * <p>
 * Otherwise, in-progress tasks will be allowed to complete.
 * <p>
 * We can use below code snippet to create a future instance:
 *
 * @author mfigueiredo
 */
package com.michelfigueiredo.examples.future;
