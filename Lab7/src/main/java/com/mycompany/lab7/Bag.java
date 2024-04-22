/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab7;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author rebec
 */
public class Bag {

    private ArrayList<Token> bag;
    private int currentPlayer = 0;
    private Game game;
    public Bag(int largest_number, Game game) {
        bag = new ArrayList<>();
        this.game = game;
        init(largest_number);
    }

    private void init(int largest_number) {
        for (int a = 1; a <= 2; a++) {
            for (int i = 1; i <= largest_number; i++) {
                for (int j = 1; j <= largest_number; j++) {
                    if (i != j) {
                        bag.add(new Token(i, j));

                    }
                }
            }
        }
    }

    public synchronized Token pick(int playerIndex) {
            while (currentPlayer != playerIndex) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return null;
                }
            }
            currentPlayer = (currentPlayer + 1) % game.getNumberOfPlayers();
            notifyAll();
            if (!isEmpty()) {
                Random rand = new Random();
                int position = rand.nextInt(bag.size());
                Token t = bag.get(position);
                bag.remove(position);
                return t;
            } 
        return null;
    }

    public boolean isEmpty() {
        return bag.size() == 0;
    }
}
