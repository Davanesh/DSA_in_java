package com.dava.leetcode.arrays;

import java.util.Arrays;

public class Try {
    public static void main(String[] args) {
//        String s = "ABCABCB";
//        int[] arr = new int[26];
//        for(int i = 0; i < s.length(); i++) {
//            arr[s.charAt(i) - 'A']++;
//        }
//        System.out.println(Arrays.toString(arr));
        int[] nums = {4,5,0,-2,-3,1};
        subarraysDivByK(nums, 5);
    }
    static int subarraysDivByK(int[] nums, int k) {
        int sum = 0;
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] % k == 0) count++;
            for(int j = 0; j < nums.length; j++) {
                sum += nums[j];
                if(sum % k == 0) count++;
            }
        }
        return count;
    }
}
