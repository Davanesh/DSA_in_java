package com.dava.DSA.graph;

import com.dava.introToOOPs.access.A;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
////        //adjest matrix
////        int n = 5, m = 5;
////        int[][] adj = new int[n+1][m+1];
////
////        // 1 <--> 4
////        adj[1][4] = 1;
////        adj[4][1] = 1;
////
////        // 2 <--> 3
////        adj[2][3] = 1;
////        adj[3][2] = 1;
////
////        for (int[] arr : adj) {
////            System.out.print(Arrays.toString(arr));
////            System.out.println();
////        }
//        int len = 5;
//        ArrayList<ArrayList<Integer>> adj2 = new ArrayList<>();
//
//        // initialize adjacency list
//        for (int i = 0; i <= len; i++) {
//            adj2.add(new ArrayList<>());
//        }
//
//        // 1 <--> 4
//        adj2.get(1).add(4);
//        adj2.get(4).add(1);
//
//        // 2 <--> 3
//        adj2.get(2).add(3);
//        adj2.get(3).add(2);
//
//        // print adjacency list
//        for (int i = 1; i <= len; i++) {
//            System.out.print(i + " -> ");
//            for (int j = 0; j < adj2.get(i).size(); j++) {
//                System.out.print(adj2.get(i).get(j) + " ");
//            }
//            System.out.println();
//        }
//        // WEIGHTED GRAPH
//        ArrayList<HashMap<Integer, Integer>> weighted = new ArrayList<>();
//        int node = 5;
//        for (int i = 0; i <= node; i++) weighted.add(new HashMap<>());
//         // 1 -> 2, 3
//        weighted.get(1).put(2, 3);
//        // 1 -> 3, 2
//        weighted.get(1).put(3, 2);
//        // 4 -> 3
//        weighted.get(4).put(3, 5);
//        // 2 -> 4
//        weighted.get(2).put(4, 7);
//        // 2 -> 5, 7
//        weighted.get(2).put(5, 7);
//        // 4 -> 5, 2
//        weighted.get(4).put(5, 2);
//
////        for (int i = 1; i < node; i++) {
////            System.out.print(i + "->");
////            for(int )
////        }
        UnDirectedGraph graph = new UnDirectedGraph(9);
        graph.link(1,2);
        graph.link(1,6);
        graph.link(2,3);
        graph.link(2,4);
        graph.link(6,7);
        graph.link(6,9);
        graph.link(4,5);
        graph.link(7,8);
        graph.link(5,8);
        graph.bfs(1);
        System.out.println();
        graph.dfs(1);
    }
}