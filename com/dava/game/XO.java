package com.dava.game;

import java.util.Scanner;

public class XO {
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = ' ';
            }
        }
        char player = 'X';
        boolean gameOver = false;

        Scanner scan = new Scanner(System.in);

        while (!gameOver) {
            printBoard(board);
            System.out.println("Player " + player + " enter: ");
            int row = scan.nextInt();
            int col = scan.nextInt();
            if (board[row][col] == ' ') {
                board[row][col] = player;
                gameOver = haveWon(board, player);
                if(gameOver) {
                    System.out.println("Player" + player + "won the match");
                } else {
                    player = (player == 'X') ? 'O' : 'X';
                }
            } else {
                System.out.println("Invalid move, try again");
            }
        }
        printBoard(board);
    }

    public static boolean haveWon(char[][] board, char player) {
        //check the rows
        for (int row = 0; row < board.length; row++) {
            if(board[row][0] == player && board[row][1] == player && board[row][2] == player) {
                return true;
            }
        }
        //check the cols
        for (int col = 0; col < board.length; col++) {
            if(board[0][col] == player && board[1][col] == player && board[2][col] == player) {
                return true;
            }
        }
        //right digonal
        if(board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        //left digonal
        if(board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }
        return false;
    }

    public static void printBoard(char[][] board) {
        System.out.println("Current Board:");
        for (int row = 0; row < board.length; row++) {
            System.out.print(" ");
            for (int col = 0; col < board[row].length; col++) {
                System.out.print(board[row][col]);
                if (col < board[row].length - 1) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (row < board.length - 1) {
                System.out.println("---+---+---");
            }
        }
        System.out.println();
    }
}