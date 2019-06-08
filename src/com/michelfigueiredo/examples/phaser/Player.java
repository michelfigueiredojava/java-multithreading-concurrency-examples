package com.michelfigueiredo.examples.phaser;

import java.util.concurrent.Phaser;

class Player implements Runnable {
    private final Integer number;
    private final Phaser phaser;
    private final Integer gamePhases;

    public Player(Integer number, Phaser phaser, Integer gamePhases) {
        this.number = number;
        this.phaser = phaser;
        this.gamePhases = gamePhases;
    }

    @Override
    public void run() {
        phaser.register();
        System.out.println("player " + number + " just joined.");

        for (int i = 0; i < gamePhases; i++) { //simulating a dynamic amount of phases
            //arriving at phase i
            try {
                Thread.sleep((long) (Math.random() * 1000)); //simulating the time the player takes to click on the button
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if ((Math.random() < 0.5) == true) { //random condition to simulate the player was killed and is out of this game
                System.out.println("Player " + number + " was killed");
                phaser.arriveAndDeregister();
                break;
            } else {
                System.out.println("Player " + number + " is at phase " + phaser.getPhase() + " now waiting to advance to next phase");
                phaser.arriveAndAwaitAdvance();
            }
        }

    }
}
