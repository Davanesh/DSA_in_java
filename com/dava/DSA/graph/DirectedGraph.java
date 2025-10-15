package com.dava.DSA.graph;

import java.util.*;

public class DirectedGraph extends Graph {
    public DirectedGraph(int size) {
        super(size);
    }
    public void link(int from, int to) {
        node.get(from).add(to);
    }
    // Perform DFS-based topological sort
    public ArrayList<Integer> topologicalSortDFS() {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[size];
        for (int i = 0; i < size; i++) {
            if(!visited[i]) {
                dfsTopoUtil(visited, i, stack);
            }
        }
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        return result;
    }
    private void dfsTopoUtil(boolean[] visited, int i, Stack<Integer> stack) {
        visited[i] = true;
        for(int neig : node.get(i)) {
            if(!visited[neig]) {
                dfsTopoUtil(visited, neig, stack);
            }
        } stack.push(i);
    }

    // Perform BFS-based topological sort
    public ArrayList<Integer> topologicalSortBFS() {
        int[] indegree =  new int[size];
        for (int i = 0; i < size; i++) {
            for(int j : node.get(i)) {
                indegree[j]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            if(indegree[i] == 0) {
                queue.offer(i);
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            result.add(cur);
            for(int neig : node.get(cur)) {
                indegree[neig]--;
                if(indegree[neig] == 0) queue.offer(neig);
            }
        } return result;
    }

    // isCycle using DFS
    public boolean isCycleDFS() {
        boolean[] visited = new boolean[size];
        boolean[] pathVis = new boolean[size];
        for(int i = 0; i < size; i++) {
            if(!visited[i]) {
                if(isCycleDFSHelper(visited, pathVis, i)) return true;
            }
        }
        return false;
    }
    private boolean isCycleDFSHelper(boolean[] visited, boolean[] pathVis, int i) {
        visited[i] = true;
        pathVis[i] = true;
        for(int neig : node.get(i)) {
           if(!visited[neig]) {
               if(isCycleDFSHelper(visited, pathVis, neig)) {
                   return true;
               }
           } else if(pathVis[neig]) {
                return true;
           }
        }
        pathVis[i] = false;
        return false;
    }

    // isCycle using BFS
    public boolean isCycleBFS() {
        return topologicalSortBFS().size() != size;
    }
}
