public class NKnight {
  public static void main(String[] args) {
    int n = 4; // Size of the board and number of knights
    boolean[][] board = new boolean[n][n];
    System.out.println("Total arrangements: " + knight(board, 0, 0, n));
  }

  static int knight(boolean[][] board, int row, int col, int knightsLeft) {
    // ✅ Base case: all knights are placed
    if (knightsLeft == 0) {
      display(board);
      System.out.println();
      return 1;
    }

    // ❌ Out of bounds
    if (row >= board.length) {
      return 0;
    }

    // 🤙 Move to next row if column exceeds
    if (col >= board.length) {
      return knight(board, row + 1, 0, knightsLeft);
    }

    int count = 0;

    // 🛡️ Only place knight if safe
    if (isSafe(board, row, col)) {
      board[row][col] = true;
      count += knight(board, row, col + 1, knightsLeft - 1); // Move forward with knight placed
      board[row][col] = false; // 🔄 Backtrack
    }

    // 🚫 Try skipping this cell
    count += knight(board, row, col + 1, knightsLeft);
    return count;
  }

  private static boolean isSafe(boolean[][] board, int row, int col) {
    // Only check positions where previously placed knights could attack current cell
    int[][] dangerSpots = {
      {-2, -1}, {-2, +1},
      {-1, -2}, {+1, -2}
    };

    for (int[] move : dangerSpots) {
      int newRow = row + move[0];
      int newCol = col + move[1];

      if (newRow >= 0 && newCol >= 0 && newRow < board.length && newCol < board.length) {
        if (board[newRow][newCol]) {
          return false; // 🛑 Knight in attack range
        }
      }
    }

    return true; // ✅ Safe spot
  }

  private static void display(boolean[][] board) {
    for (boolean[] row : board) {
      for (boolean cell : row) {
        System.out.print(cell ? "K " : ". ");
      }
      System.out.println();
    }
  }
}
