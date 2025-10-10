package com.dava.DSA.searching;

class BinarySearchIn2DArray {
  public static void main(String[] args) {
    // create a 2D array
    int[][] arr = new int[3][3];
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        arr[i][j] = i * 3 + j + 1;
      }
    }
    // display the 2D array
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        System.out.print(arr[i][j] + " ");
      }
      System.out.println();
    }
    binarySearchIn2DArray(arr, 5);
  }
  // binary search in 2D array
  static int[] binarySearchIn2DArray(int[][] arr, int target) {
    int r = 0;
    int c = arr.length - 1;
    while (r < arr.length && c > 0) {
      if (arr[r][c] == target) {
        return new int[]{r, c};
      }
      if (arr[r][c] < target) {
        r++;
      } else {
        c--;
      }
    }
    return new int[]{-1, -1};
  }
}