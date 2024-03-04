/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab1.bonus;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author rebec
 */
public class Lab1Bonus {
    static Vector<Integer>[] graph = new Vector[100000];
    public static int cyclenumber = 0;
    
    public static int[][] createWheelGraph(int x){
        
        int[][] adjacencyMatrix = new int[x][x];
        for (int i = 0; i < x - 1; i++) {
            adjacencyMatrix[i][(i + 1) % (x - 1)] = 1;
            adjacencyMatrix[(i + 1) % (x - 1)][i] = 1;
            graph[i].add( (i + 1) % (x - 1) );
            graph[ (i + 1) % (x - 1) ].add( i );
        }
        
        for (int i = 0; i < x - 1; i++) {
            adjacencyMatrix[i][x - 1] = 1;
            adjacencyMatrix[x - 1][i] = 1;
            graph[i].add( x - 1 );
            graph[x-1].add( i );
        }
        
        return adjacencyMatrix;
    }
    
    public static void prettyPrinting(int[][] out, int n){
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++)
                System.out.print(out[i][j] + " ");
            System.out.println();
        }
    }
    
    public static void dfs_cycle(int u, int p, int color[], int par[]){
 
    if (color[u] == 2) {
        return;
    }
 
    if (color[u] == 1) {
        cyclenumber++;
        
        int cur = p;
 
        while (cur != u) {
            cur = par[cur];
        }
        return;
    }
    par[u] = p;
 
    color[u] = 1;
 
    for (int v : graph[u]) {
 
        if (v == par[u]) {
            continue;
        }
        dfs_cycle(v, u, color, par);
    }
 
    color[u] = 2;
}

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int n = 6;
        int[][] matrix = createWheelGraph(n);
        
        for (int i = 0; i < n; i++)
        {
            graph[i] = new Vector<>();
        }
        
        prettyPrinting(matrix, n);
        
        int[] color = new int[1000];
	int[] par = new int[1000];
        
        dfs_cycle(1, 0, color, par);
        
        if(cyclenumber == n*n - 3*n + 3){
            System.out.println("Am gasit toate ciuclurile: " + cyclenumber);
        }else{
            System.out.println("Slab ma.");
        }
        
    }
    
}
