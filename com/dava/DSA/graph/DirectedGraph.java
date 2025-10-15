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
    // sorting
    public ArrayList<Integer> topologicalSort() {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();


        boolean[] visited = new boolean[size];


        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        return result;
    }
}
