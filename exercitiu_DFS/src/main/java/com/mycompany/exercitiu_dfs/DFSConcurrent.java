/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.exercitiu_dfs;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *
 * @author rebec
 */
public class DFSConcurrent {
    private final boolean[][] adjacencyMatrix;
    private final boolean[] visited;
    private final ExecutorService executor;

    public DFSConcurrent(boolean[][] adjacencyMatrix, int numThreads) {
        this.adjacencyMatrix = adjacencyMatrix;
        this.visited = new boolean[adjacencyMatrix.length];
        this.executor = Executors.newFixedThreadPool(numThreads);
    }

    public boolean hasCycle() {
        try {
            for (int i = 0; i < adjacencyMatrix.length; i++) {
                if (!visited[i]) {
                    Future<Boolean> future = executor.submit(new DFSTask(i));
                    if (future.get()) {
                        return true;
                    }
                }
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
        return false;
    }

    private class DFSTask implements Callable<Boolean> {
        private final int startNode;

        public DFSTask(int startNode) {
            this.startNode = startNode;
        }

        @Override
        public Boolean call() {
            return dfs(startNode, -1);
        }

        private boolean dfs(int node, int parent) {
            visited[node] = true;
            for (int i = 0; i < adjacencyMatrix[node].length; i++) {
                if (adjacencyMatrix[node][i]) {
                    if (!visited[i]) {
                        if (dfs(i, node)) {
                            return true;
                        }
                    } else if (i != parent) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
