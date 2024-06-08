/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.exercitiu_dfs;

/**
 *
 * @author rebec
 */
public class Exercitiu_DFS {

    public static void main(String[] args) {
        boolean adjMatrix[][] = {
            {false, true, false, false, true},
            {true, false, true, false, false},
            {false, true, false, true, false},
            {false, false, true, false, true},
            {true, false, false, true, false}
        };
        
        DFSConcurrent ex = new DFSConcurrent(adjMatrix, 8);
        boolean result = ex.hasCycle();
        
        System.out.println(result);
    }
}
