package com.dava.DSA.bitwise;

public class BitwiseOperators {
  public static void main(String[] args) {
    // odd or even
    int n = 89;
    System.out.println(isOdd(n));
    // unique
    int arr[] = {2, -2, -2, 4, 6, 4, 6, 8, 8, 10, 10};
    System.out.println(unique(arr));
    // unique
    int arr2[] = {2,2,3,2,7,7,8,7,8,8,8};
    System.out.println(unique2(arr2));
    // find the lengtnh of the bit
    int a = 10;
    System.out.println(findTheOfTheBit(a));
    // find the lengtnh of the number base on log
    System.out.println(findTheOfTheBitUsingLog(10, 2));
    // power of two
    System.out.println(powerOfTwo(2));
  }
  static boolean isOdd(int n) {
    return (n & 1) == 1;
  }
  static int unique(int[] arr) {
    int uniqueNum = 0;
    for (int n : arr) {
      uniqueNum ^= n;
    }
    return uniqueNum;
  }
  static int unique2(int[] arr) {
    int ones = 0, twos = 0;
    for(int num : arr) {
      ones = (ones ^ num) & ~twos; 
      twos = (twos ^ num) & ~ones;
    }
    return ones;
  }
  static int findTheOfTheBit(int n) {
    int len = 0;
    while (n > 0) { 
      n = n >> 1;
      len += 1;
    }
    return len;
  }
  static int findTheOfTheBitUsingLog(int n, int base) {
    int ans = (int)(Math.log(n) / Math.log(base)) + 1;
    return ans;
  }
  static boolean powerOfTwo(int n) {
    return (n > 0) && ((n & (n - 1)) == 0);
  }
}
