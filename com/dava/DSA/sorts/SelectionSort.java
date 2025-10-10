package com.dava.DSA.sorts;
import java.util.Arrays;

public class SelectionSort {
  public static void main(String[] args) {
    int[] arr = {5, 2, 42, 6, 1, 3, 2};
    selectionSort(arr);
    System.out.println(Arrays.toString(arr));
  }
  static void selectionSort (int[] arr) {
    for (int i = 0; i < arr.length - 1; i++) {
      int last = arr.length - 1 - i;
      int maxIndex = getMaxIndex(arr, 0, last);
      swap(arr, maxIndex, last);
    }
  }
  static int getMaxIndex(int[] arr, int start, int end) {
    int max = start;
    for (int i = start; i <= end; i++) {
      if(arr[max] < arr[i]) {
        max = i;
      }
    }
    return max;
  }
  static void swap (int[] arr, int first, int second) {
    int temp = arr[first];
    arr[first] = arr[second];
    arr[second] = temp;
  }
}