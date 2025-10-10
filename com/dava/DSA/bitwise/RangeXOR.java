package com.dava.DSA.bitwise;

public class RangeXOR {
  public static void main(String[] args) {
    int start = 3;
    int end = 9;
    System.out.println(rangeXOR(end) ^ rangeXOR(start - 1));
  }
  static int rangeXOR(int n) {
    if (n % 4 == 0) return n;
    if (n % 4 == 1) return 1;
    if (n % 4 == 2) return n + 1;
    return 0;
  } 
}
