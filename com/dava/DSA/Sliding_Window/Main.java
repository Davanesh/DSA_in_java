package com.dava.DSA.Sliding_Window;

public class Main {
    public static void main(String[] args) {
        int[] arr1 = {1,12,-5,-6,50,3};
        int k = 4;
        int[] arr2 = {1,5,1,7,10};
        int sum = 14;
        System.out.println(slidingWindow(arr1, k));
    }
    private static int slidingWindow(int[] nums, int k) {
        int maxWindow = 0;
        for (int i = 0; i < k; i++) {
            maxWindow += nums[i];
        }
        int left = 0;
        int right = k-1;
        int window = maxWindow;
        while(right < nums.length) {
           maxWindow += nums[++right] - nums[left++];
           window = Math.max(window, maxWindow);
        }
        return window;
    }
}
