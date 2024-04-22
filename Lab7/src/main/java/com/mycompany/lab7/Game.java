/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab7;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 *
 * @author rebec
 */
public class Game {

    private Bag bag;
    private List<Player> players;
    private final int largest_number = 3;

    public Game(Player... pls) {
        players = new ArrayList<>();
        bag = new Bag(largest_number, this);
        this.bag = bag;
        if (pls.length > 1) {
            for (Player p : pls) {
                p.setGame(this);
                players.add(p);
            }
        } else {
            System.out.println("You need more players (>=2)");
            return;
        }

    }

    public void play() {
        int numberOfPlayers = players.size();
        CountDownLatch latch = new CountDownLatch(numberOfPlayers);

        for (Player p : players) {
            new Thread(() -> {
                try {
                    p.run();
                } finally {
                    latch.countDown();
                }
            }).start();
        }

        try {
            latch.await();

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        winner();
    }

    public Bag getBag() {
        return bag;
    }

    public int getLargest_number() {
        return largest_number;
    }

    public int getNumberOfPlayers() {
        return players.size();
    }

    public void winner() {
        int aux_max = 0;
        Player winner = new Player("");
        for (Player p : players) {
            if (p.getPoints() > aux_max) {
                aux_max = p.getPoints();
                winner = p;
            }
        }
        System.out.println("The winner is: " + winner);
    }
}
