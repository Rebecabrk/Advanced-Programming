/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab7;

import java.util.Vector;

/**
 *
 * @author rebec
 */
public class Player implements Runnable {

    private String name;
    private Game game;
    private Vector<Token> tokens;
    private static int index = 0;
    private int playerIndex;
    private boolean running = true;
    private int points = 0;

    public Player(String name) {
        tokens = new Vector<>();
        this.name = name;
        playerIndex = index;
        index += 1;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public int getPlayerIndex() {
        return playerIndex;
    }

    @Override
    public synchronized void run() {
        while (running) {
            Token new_token = game.getBag().pick(playerIndex);
            if (new_token != null) {
                this.tokens.add(new_token);
                //createSequence();
                try {
                    Thread.sleep(1000); 
                } catch (InterruptedException e) {
                    System.out.println("Sleep was interrupted");
                }
            } else {
                running = false;
            }

        }
        System.out.println(name + " : " + tokens);
        points();
        game.winner();
    }
    
    private void createSequence(){
        
    }
    private void points(){
        for(Token t : tokens){
            points += t.first_number + t.second_number;
        }
    }

    public int getPoints() {
        return points;
    }

    @Override
    public String toString() {
        return name + ", \ntokens=" + tokens + ", \nplayerIndex=" + playerIndex + ", \npoints=" + points + '}';
    }
    
}
