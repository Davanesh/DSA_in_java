package com.dava.DSA.searching;

import java.util.Scanner;

public class AgosticBinarySearch {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int[] arr = {36, 33, 29, 27, 25, 22, 19, 15, 12, 8, 5, 3, 2, 1};
      System.out.print("Enter the value u wanna search: ");
      int target = sc.nextInt();
      if (arr[0] > arr[arr.length - 1]){
        System.out.print("The index of the target no is: " + agosticbinarysearch(arr, target));
      } 
    }
  }
  static int agosticbinarysearch(int arr[], int target){
    int start = 0;
    int end = arr.length - 1;
    while (start <= end){
      int mid = start + (end - start) / 2;
      if (target > arr[mid]){
        end = mid - 1;
      } else if (target < arr[mid]){
          start = mid + 1;
      } else {
        return mid;
      }
    }
    return -1;
  }
}