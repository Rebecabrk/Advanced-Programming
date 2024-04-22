/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab7;

/**
 *
 * @author rebec
 */
public class Token {
    int first_number;
    int second_number;
    
    public Token(int n1, int n2){
        first_number = n1;
        second_number = n2;
    }

    public int getFirst_number() {
        return first_number;
    }

    public int getSecond_number() {
        return second_number;
    }

    @Override
    public String toString() {
        return "(" + first_number + ", " + second_number + ')';
    }
    
}
