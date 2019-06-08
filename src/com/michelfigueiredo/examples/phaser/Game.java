package com.michelfigueiredo.examples.phaser;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Phaser;

class Game implements Runnable {

    private static final Integer GAME_PHASES = 3;

    @Override
    public void run() {
        Phaser phaser = new Phaser(1);

        System.out.println("players can join the game now");
        this.playersJoinThisGame(phaser);

        for (int i = 0; i < GAME_PHASES; i++) {

            if (phaser.getRegisteredParties() == 1) {
                System.out.println("all players killed");
                phaser.arrive();
                break;
            } else {
                phaser.arriveAndAwaitAdvance();

            }
            report(phaser);

        }
        System.out.println("Game over");
    }

    private List<Thread> playersJoinThisGame(Phaser phaser) {
        List<Thread> players = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 5; i++) {
            Player player = new Player(i, phaser, GAME_PHASES);
            Thread thread = new Thread(player); //each player one thread
            thread.start();
            players.add(thread);
        }
        return players;
    }

    private static void report(Phaser ph) {
        System.out.println();
        System.out.println("game is in phase: " + ph.getPhase());
        System.out.println("threads (including main): " + ph.getRegisteredParties());
        System.out.println("players (one thread per player): " + (ph.getRegisteredParties() - 1));
        System.out.println();
    }
}
