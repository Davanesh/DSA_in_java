package com.dava.DSA.DP;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums = {2, 7, 3, 3, 4, 4};
        int len = Arrays.stream(nums).max().getAsInt();
        int[] freq = new int[len+1];
        for(int num : nums) {
            freq[num]++;
        }
        System.out.println(Arrays.toString(freq));
    }
}
