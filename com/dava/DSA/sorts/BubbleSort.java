package com.dava.DSA.sorts;
import java.util.Arrays;

class BubbleSort {
  public static void main(String[] args) {
    int[] arr = {5, 2, 42, 6, 1, 3, 2};
    bubbleSort(arr);
    System.out.println(Arrays.toString(arr));
  }
  public static void bubbleSort(int[] arr) {
    for (int i = 0; i < arr.length - 1; i++) {
      boolean swap = false;
      for (int j  = 0; j < arr.length - 1 - i; j++) {
        if (arr[j] > arr[j + 1]) {
          int temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
          swap = true;
        }
      }
      if (!swap) {
        break;
      }
    }
  }
}