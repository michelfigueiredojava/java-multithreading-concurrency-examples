/**
 * Lock is a utility for blocking other threads from accessing a certain segment of code, apart from the thread that’s
 * executing it currently.
 * <p>
 * Simply put, a lock is a more flexible and sophisticated thread synchronization mechanism than the standard synchronized block.
 * <p>
 * The Lock interface has been around since Java 1.5. It’s defined inside the java.util.concurrent.lock package and
 * it provides extensive operations for locking.
 *
 * @author mfigueiredo
 */
package com.michelfigueiredo.examples.locks;
