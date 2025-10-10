package com.dava.DSA.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class UnDirectedGraph {
    int size;
    public ArrayList<ArrayList<Integer>> node;
    public UnDirectedGraph(int size) {
        this.size = size;
        node = new ArrayList<>();
        for(int i = 0; i <= size; i++) node.add(new ArrayList<>());
    }
    public void link(int from, int to) {
        node.get(from).add(to);
        node.get(to).add(from);
    }
    public void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[size + 1];
        queue.offer(start);
        visited[start] = true;
        while(!queue.isEmpty()) {
            int curr = queue.poll();
            System.out.print(curr + " ");
            for(int neighbor : node.get(curr)) {
                if(!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }
    }
    public void dfs(int start) {
        boolean[] visited = new boolean[size + 1];
        dfsHelper(start, visited);
    }
    private void dfsHelper(int curr, boolean[] visited) {
        visited[curr] = true;
        System.out.print(curr + " ");
        for (int neighbor : node.get(curr)) {
            if(!visited[neighbor]) {
                dfsHelper(neighbor, visited);
            }
        }
    }

    public boolean isCycleBFS(ArrayList<ArrayList<Integer>> graph, int node) {
        
    }
}
