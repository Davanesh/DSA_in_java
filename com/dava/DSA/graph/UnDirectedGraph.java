package com.dava.DSA.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class UnDirectedGraph extends Graph{
    public UnDirectedGraph(int size) {
        super(size);
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

    public boolean isCycleBFS(ArrayList<ArrayList<Integer>> graph) {
        int size = graph.size();
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[size];
        for(int i = 0; i < size; i++) {
            if(!visited[i]) {
                visited[i] = true;
                queue.offer(new int[] {i, -1});
                while(!queue.isEmpty()) {
                    int[] curr = queue.poll();
                    for(int neig : graph.get(curr[0])) {
                        if(!visited[neig]) {
                            visited[neig] = true;
                            queue.offer(new int[] {neig, curr[0]});
                        } else if(neig != curr[1]) {
                            return true;
                        }
                    }
                }
            }
        }   return false;
    }

    public boolean isCycleDFS(ArrayList<ArrayList<Integer>> graph) {
        boolean[] visited = new boolean[graph.size()];
        return isCycleDFShHelper(graph, visited, 0, -1);
    }
    private boolean isCycleDFShHelper(ArrayList<ArrayList<Integer>> graph, boolean[] visited, int node, int parentNode) {
        visited[node] = true;
        for(int neig : graph.get(node)) {
            if(!visited[neig]) {
                if(isCycleDFShHelper(graph, visited, neig, node)) {
                    return true;
                }
            } else if(neig != parentNode) {
                return true;
            }
        }
        return false;
    }
}