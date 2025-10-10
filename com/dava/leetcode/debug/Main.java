package com.dava.leetcode.debug;

public class Main {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println(ans.numDecodings("122016"));
    }
}
class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        Integer[] dp = new Integer[n];
        return count(s, 0, dp);
    }
    private int count(String s, int index, Integer[] dp) {
        if(index == s.length()) return 1;
        if(s.charAt(index) == '0') return 0;
        if(dp[index] != null) return dp[index];
        int ans = count(s, index + 1, dp);
        if(index + 1 < s.length()) {
            int num = Integer.parseInt(s.substring(index, index + 2));
            if(num >= 10 && num <= 26) {
                ans += count(s, index + 2, dp);
            }
        }
        return dp[index] = ans;
    }
}
