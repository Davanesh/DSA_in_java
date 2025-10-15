package com.dava.DSA.graph;

import java.util.ArrayList;
import java.util.Stack;

public class DirectedGraph extends Graph {
    public DirectedGraph(int size) {
        super(size);
    }
    public void link(int from, int to) {
        node.get(from).add(to);
    }
    // Perform DFS-based topological sort
    public ArrayList<Integer> topologicalSort() {
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
    private void dfsTopoUtil(
            boolean[] visited,
            int i,
            Stack<Integer> stack
    ) {
        visited[i] = true;
        for(int neig : node.get(i)) {
            if(!visited[neig]) {
                dfsTopoUtil(visited, neig, stack);
            }
        } stack.push(i);
    }
}
