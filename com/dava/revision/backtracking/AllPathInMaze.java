package com.dava.revision.backtracking;

public class AllPathInMaze {
    public static void main(String[] args) {
        boolean[][] maze = new boolean[][] {
                {true, true, true},
                {true, true, true},
                {true, true, true},
        };
        allPath("", maze, 0, 0);
        printAllPath("", maze, 0, 0, 1);
//        System.out.println(countAllPath("", maze, 0, 0));
    }
    static void allPath(String p, boolean[][] maze, int r, int c) {
        if(r == maze.length - 1  && c == maze[0].length - 1) {
            System.out.println(p);
            return;
        }
        if(!maze[r][c]) return;
        maze[r][c] = false;
        if (r < maze.length - 1) allPath(p + 'D', maze, r + 1, c); // down
        if (c < maze[0].length - 1) allPath(p + 'R', maze, r, c + 1); // right
        if (r > 0) allPath(p + 'U', maze, r - 1, c); // up
        if (c > 0) allPath(p + 'L', maze, r, c - 1); // left
        maze[r][c] = true;
    }
    static int countAllPath(String p, boolean[][] maze, int r, int c) {
        if(r == maze.length - 1  && c == maze[0].length - 1) {
            System.out.println(p);
            return 1;
        }
        int count = 0;
        if(!maze[r][c]) return 0;
        maze[r][c] = false;
        if (r < maze.length - 1) count += countAllPath(p + 'D', maze, r + 1, c); // down
        if (c < maze[0].length - 1) count += countAllPath(p + 'R', maze, r, c + 1); // right
        if (r > 0) count += countAllPath(p + 'U', maze, r - 1, c); // up
        if (c > 0) count += countAllPath(p + 'L', maze, r, c - 1); // left
        maze[r][c] = true;
        return count;
    }
    static void printAllPath(String p, boolean[][] maze, int r, int c, int level) {
        if(r == maze.length - 1  && c == maze[0].length - 1) {
            System.out.println(p);
            return;
        }
        if(!maze[r][c]) return;
        maze[r][c] = false;
        if (r < maze.length - 1) printAllPath(p + level, maze, r + 1, c, level+1); // down
        if (c < maze[0].length - 1) printAllPath(p + level, maze, r, c + 1, level+1); // right
        if (r > 0) printAllPath(p + level, maze, r - 1, c, level+1); // up
        if (c > 0) printAllPath(p + level, maze, r, c - 1, level+1); // left
        maze[r][c] = true;
    }
}
