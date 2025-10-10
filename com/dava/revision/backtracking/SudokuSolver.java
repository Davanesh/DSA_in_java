package com.dava.revision.backtracking;

public class SudokuSolver {
    public static void main(String[] args) {

    }
    static boolean isSafe(char[][] board, int row, int col, char num) {
        for (int i = 0; i < board.length; i++) {
            if(board[i][col] == num || board[row][i] == num) {
                return false;
            }
        }
        int boxRow = row * (row % 3);
        int boxCol = col * (col % 3);
        for (int i = boxRow; i < boxRow + 3; i++) {
            for (int j = boxCol; j < boxCol + 3; j++) {
                if(board[boxRow][boxCol] == num) {
                    return false;
                }
            }
        } return true;
    }
}
