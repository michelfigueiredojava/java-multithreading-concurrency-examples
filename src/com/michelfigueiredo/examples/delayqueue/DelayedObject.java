package com.michelfigueiredo.examples.delayqueue;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author mfigueiredo
 */
public class DelayedObject implements Delayed {
    private Integer num;
    private long startTime;

    public DelayedObject(Integer num, long delayInMilliseconds) {
        this.num = num;
        this.startTime = System.currentTimeMillis() + delayInMilliseconds;
    }

    public Integer getNum() {
        return num;
    }

    @Override
    public int compareTo(Delayed o) {
        if (this.startTime < ((DelayedObject) o).startTime) {
            return -1;
        }
        if (this.startTime > ((DelayedObject) o).startTime) {
            return 1;
        }
        return 0;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        long diff = startTime - System.currentTimeMillis();
        return unit.convert(diff, TimeUnit.MILLISECONDS);
    }
}
