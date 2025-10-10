package com.dava.DSA.sorts;
import java.util.Arrays;

public class MergeSort {
  public static void main(String[] args) {
    int[] arr = {2,4,5,1,6,3};
    System.out.println(Arrays.toString(mergeSort(arr)));
    mergeSortInPlace(arr, 0, arr.length);
    System.out.println(Arrays.toString(arr));
  }
  static int[] mergeSort(int[] arr) {
    if(arr.length == 1) {
      return arr;
    }
    int mid = arr.length / 2;
    int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
    int[] rigth = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));
    return merge(left, rigth);
  }
  static int[] merge(int[] first, int[] second) {
    int[] mix = new int[first.length + second.length];
    int i = 0, j = 0, k = 0;
    while (i < first.length && j < second.length) { 
      if(first[i] < second[j]) {
        mix[k] = first[i];
        i++;
      } else {
        mix[k] = second[j];
        j++;
      }
      k++;
    }
    while(i < first.length) {
      mix[k] = first[i];
      i++;
      k++;
    }
    while(j < second.length) {
      mix[k] = second[j];
      j++;
      k++;
    }
    return mix;
  }
  //in-place
  static void mergeSortInPlace(int[] arr, int s, int e) {
    if(e - s == 1) {
      return;
    }
    int m = s + e / 2;
    mergeSortInPlace(arr, s, m);
    mergeSortInPlace(arr, m, e);
    mergeInPlace(arr, s, m, e);
  }
  static void mergeInPlace(int[] arr, int s, int m, int e) {
    int[] mix = new int[arr.length];
    int i = 0, j = 0, k =0;
    while(i < m && j < e) {
      if(arr[i] < arr[j]) {
        mix[k] = arr[i];
        i++;
      } else {
        mix[k] = arr[j];  
        j++;
      }
      k++;
    }
    while(i < m) {
      mix[k] = arr[i];
      i++;
      k++;
    }
    while(j < e) {
      mix[k] = arr[j];
      j++;
      k++;
    }
    for(int l = 0; l < mix.length; l++) {
      arr[s+1] = mix[l];
    }
  }
}
