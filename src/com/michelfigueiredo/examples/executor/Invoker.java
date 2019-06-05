package com.michelfigueiredo.examples.executor;

import java.util.concurrent.Executor;

/**
 * @author mfigueiredo
 */
class Invoker implements Executor {

    @Override
    public void execute(Runnable command) {
        command.run();
    }
}
