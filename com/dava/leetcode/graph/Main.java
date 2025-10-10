package com.dava.leetcode.graph;

import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        int[][] grid = new int[][] {{2,1,1}, {1,1,0}, {2,1,2}};
        orangesRotting(grid);
    }
    public static void orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 2) {
                    queue.offer(new int[] {i, j});
                }
            }
        } while(!queue.isEmpty()) System.out.println(Arrays.toString(queue.poll()));
    }
}
