/**
 * The Semaphore is used for blocking thread level access to some part of the physical or logical resource. A semaphore
 * contains a set of permits; whenever a thread tries to enter the critical section, it needs to check the semaphore if
 * a permit is available or not.
 * <p>
 * If a permit is not available (via tryAcquire()), the thread is not allowed to jump into the critical section; however,
 * if the permit is available the access is granted, and the permit counter decreases.
 * <p>
 * Once the executing thread releases the critical section, again the permit counter increases (done by release() method).
 * <p>
 * We can specify a timeout for acquiring access by using the tryAcquire(long timeout, TimeUnit unit) method.
 * <p>
 * We can also check the number of available permits or the number of threads waiting to acquire the semaphore.
 *
 * @author mfigueiredo
 */
package com.michelfigueiredo.examples.semaphore;
