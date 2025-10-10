import java.util.ArrayList;
import java.util.Arrays;

public class Maze {
  public static void main(String[] args) {
    int ans = count(3, 3);
    System.out.println(ans);
    path("", 3, 3);
    System.out.println(pathDiagonal("", 3, 3));

    boolean[][] board = 
    {
      {true, true, true},
      {true, false, true},
      {true, true, true},

    };

    pathWithRiver("", board, 0, 0);

    boolean[][] maze = 
    {
      {true, true, true},
      {true, true, true},
      {true, true, true},
    };
    
    System.out.println("find all path");

    findAllPath("", maze, 0, 0);
    System.out.println("path steps");
    int[][] path = new int[maze.length][maze[0].length];
    allPathStep("", maze, 0, 0, path, 1);
  }
  static int count(int r, int c) {
    if(r == 1 || c == 1) {
      return 1;
    }
    int left = count(r - 1, c);
    int right = count(r, c - 1);
    return left + right;
  }
  static void path(String p, int r, int c) {
    if(r == 1 && c == 1) {
      System.out.println(p);
      return;
    }
    if(r > 1) {
      path(p + 'D', r-1, c);
    }  
    if(c > 1) {
      path(p + 'R', r, c-1);
    }
  }
  static ArrayList<String> pathDiagonal(String p, int r, int c) {
    if(r == 1 && c == 1) {
      ArrayList<String> list = new ArrayList<>();
      list.add(p);
      return list;
    }
    ArrayList<String> list = new ArrayList<>();
    if(r > 1) {
      list.addAll(pathDiagonal(p + 'V', r-1, c));
    }
    if(c > 1) {
      list.addAll(pathDiagonal(p + 'H', r, c-1));
    }
    if(c > 1 && r > 1) {
      list.addAll(pathDiagonal(p + "D", r-1, c-1));
    }
    return list;
  }
  static void pathWithRiver(String p, boolean[][] maze, int r, int c) {
    if(r == maze.length - 1 && c == maze[0].length - 1) {
      System.out.println(p);
      return;
    }
    if(!maze[r][c]) {
      return;
    }
    if(r < maze.length - 1) {
      pathWithRiver(p + 'D', maze, r+1, c);
    }
    if(c < maze[0].length - 1) {
      pathWithRiver(p + 'R', maze, r, c+1);
    }
  }
  static void findAllPath(String p, boolean[][] maze, int r, int c) {
    if(r == maze.length - 1 && c == maze[0].length - 1) {
      System.out.println(p);
      return;
    }
    //if already visited
    if(!maze[r][c]) {
      return;
    }
    // Mark the current cell as visited
    maze[r][c] = false;
    // move right
    if(c < maze[0].length - 1) {
      findAllPath(p + 'R', maze, r, c+1);
    }
    //move down
    if(r < maze.length - 1) {
      findAllPath(p + 'D', maze, r+1, c);
    }
    //move left
    if(c > 0) {
      findAllPath(p + 'L', maze, r, c-1);
    }
    //move up
    if(r > 0) {
      findAllPath(p + 'U', maze, r-1, c);
    }
    maze[r][c] = true;
  }
  //print the steps of path
  static void allPathStep(String p, boolean[][] maze, int r, int c, int[][] path,  int step) {
    if(r == maze.length - 1 && c == maze[0].length - 1) {
      path[r][c] = step;
      for(int[] arr : path) {
        System.out.println(Arrays.toString(arr));
      }
      System.out.println(p);
      System.out.println("");
      return;
    }
    //if already visited
    if(!maze[r][c]) {
      return;
    }
    // Mark the current cell as visited
    maze[r][c] = false;
    path[r][c] = step;
    // move right
    if(c < maze[0].length - 1) {
      allPathStep(p + 'R', maze, r, c+1, path, step+1);
    }
    //move down
    if(r < maze.length - 1) {
      allPathStep(p + 'D', maze, r+1, c, path, step+1);
    }
    //move left
    if(c > 0) {
      allPathStep(p + 'L', maze, r, c-1, path, step+1);
    }
    //move up
    if(r > 0) {
      allPathStep(p + 'U', maze, r-1, c, path, step+1);
    }
    maze[r][c] = true;
    path[r][c] = 0;
  } 
}
