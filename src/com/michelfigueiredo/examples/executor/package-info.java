/**
 * Executor is an interface that represents an object that executes provided tasks.
 * It depends on the particular implementation (from where the invocation is initiated) if the task should be run on a new or
 * current thread. Hence, using this interface, we can decouple the task execution flow from the actual task execution mechanism.
 * One point to note here is that Executor does not strictly require the task execution to be asynchronous.
 * In the simplest case, an executor can invoke the submitted task instantly in the invoking thread.
 *
 * @author mfigueiredo
 */
package com.michelfigueiredo.examples.executor;


