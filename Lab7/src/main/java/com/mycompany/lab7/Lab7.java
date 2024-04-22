/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.lab7;

/**
 *
 * @author rebec
 */
public class Lab7 extends Thread {

    public static void main(String args[]) {
        Player p1 = new Player("Rebeca");
        Player p2 = new Player("Mihai");
        Player p3 = new Player("Hannah");
        
        Game g = new Game(p1, p2, p3);
        g.play();
    }
}
