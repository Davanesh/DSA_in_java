package com.dava.revision.backtracking;

import java.util.ArrayList;

public class Maze {
    public static void main(String[] args) {
//        ArrayList<String> ans = new ArrayList<>();
//        pathret2("", 3, 3, ans);
//        System.out.println(ans);
//        path("", 3,3);
//        diagonal("", 3, 3);
        boolean[][] maze = new boolean[][] {
            {true, true, true, true},
            {true, false, true, true},
            {true, true, true, true},
            {false, true, true, true}
        };
        obstacles("", maze, 0, 0);
    }
    static int count(int r, int c) {
        if(r == 1 || c == 1) {
            return 1;
        }
        int left = count(r-1, c);
        int right = count(r, c-1);
        return left + right;
    }
    static void path(String p, int r, int c) {
        if(r == 1 && c == 1) {
            System.out.println(p);
            return;
        }
        if(r > 1) path(p + 'D', r-1, c);
        if(c > 1) path(p + 'R', r, c-1);
    }
    static ArrayList<String> pathret(String p, int r, int c) {
        ArrayList<String> ans = new ArrayList<>();
        if(r == 1 && c == 1) {
            ans.add(p);
            return ans;
        }
        if(r > 1) ans.addAll(pathret(p + 'D', r-1, c));
        if(c > 1) ans.addAll(pathret(p + 'R', r, c-1));
        return ans;
    }
    static void pathret2(String p, int r, int c, ArrayList<String> ans) {
        if(r == 1 && c == 1) {
            ans.add(p);
            return;
        }
        if(r > 1) pathret2(p + 'D', r-1, c, ans);
        if(c > 1) pathret2(p + 'R', r, c-1, ans);
    }
    static void diagonal(String p, int r, int c) {
        if(r == 1 && c == 1) {
            System.out.println(p);
            return;
        }
        if(r > 1) diagonal(p + 'D', r - 1, c);
        if(c > 1) diagonal(p + 'R', r, c - 1);
        if(r > 1 && c > 1) diagonal(p + 'S', r - 1, c - 1);
    }
    static void obstacles(String p, boolean[][] maze, int r, int c) {
        if(r == maze.length - 1  && c == maze[0].length - 1) {
            System.out.println(p);
            return;
        }
        if(!maze[r][c]) {
            return;
        }
        if(r < maze.length - 1) obstacles(p + 'D', maze, r + 1, c);
        if(c < maze[0].length - 1) obstacles(p + 'R', maze, r, c + 1);
        if(r < maze.length - 1 && c < maze[0].length - 1) obstacles(p + 'S', maze, r + 1, c + 1);
    }
}
