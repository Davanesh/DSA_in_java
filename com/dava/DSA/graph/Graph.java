package com.dava.DSA.graph;

import java.util.ArrayList;

public class Graph {
    int size;
    public ArrayList<ArrayList<Integer>> node;
    public Graph(int size) {
        this.size = size;
        node = new ArrayList<>();
        for(int i = 0; i <= size; i++) node.add(new ArrayList<>());
    }
}
