package com.dava.DSA.SquareRootDecomposition;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 2, 7, 6, 3, 1, 4, 8};
        int n = arr.length;
        //build a sqrt array
        int sqrt = (int) Math.sqrt(n);

        int block_id = -1;

        int[] block = new int[sqrt + 1];

        for (int i = 0; i < n; i++) {
            if(i % sqrt == 0) {
                block_id++;
            }
            block[block_id] += arr[i];
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(block));
        System.out.println(sum(block, arr, 2, 6, arr.length));
    }
    public static int sum(int[] blocks, int[] arr, int l, int r, int sqrt) {
        int ans = 0;
        // left part
        while(l % sqrt != 0 && l < r && l != 0) {
            ans += arr[l++];
        }
        // middle part
        while(l + sqrt <= r) {
            ans += blocks[l/sqrt];
            l += sqrt;
        }
        // right part
        while (l <= r) {
            ans += arr[l++];
        }
        return ans;
    }
    public void update(int[] block, int[] arr, int i, int val, int sqrt) {
        int block_id = i / sqrt;
        block[block_id] += (val - arr[i]);
        arr[i] = val;
    }
}
