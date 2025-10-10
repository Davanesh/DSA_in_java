package com.dava.DSA.DP;

import java.math.BigInteger;

public class Fib {
    public static void main(String[] args) {
        int n = 10000;
//        BigInteger[] dp = new BigInteger[n+1];
//        System.out.println(calFib(n, dp));
        System.out.println(fib(n));
    }
    private static BigInteger calFib(int n, BigInteger[] dp) {
        if(n < 2) return BigInteger.valueOf(n);
        if(dp[n] != null) return dp[n];
        dp[n] = calFib(n-1, dp).add(calFib(n-2, dp));
        return dp[n];
    }
    // fib using tabulation
    private static int fibUsingTablulation(int n, int[] dp) {
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
    // fib in O(1) SC and O(n) TC
    private static BigInteger fib(int n) {
        if(n < 2) return BigInteger.valueOf(n);
        BigInteger prev2 = BigInteger.ZERO;
        BigInteger prev1 = BigInteger.ONE;
        BigInteger curr = BigInteger.ZERO;
        for (int i = 2; i <= n; i++) {
            curr = prev2.add(prev1);
            prev2 = prev1;
            prev1 = curr;
        }
        return curr;
    }
}
