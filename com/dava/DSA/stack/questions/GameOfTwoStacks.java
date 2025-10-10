package com.dava.DSA.stack.questions;

import java.util.Arrays;

public class GameOfTwoStacks {
    public static void main(String[] args) {
        int[] first = {1,6,4,2,4};
        int[] second = {5,8,1,2};
        System.out.println(gameOfTwoStacks(10, first, second, 0, 0));
    }

    private static int gameOfTwoStacks(int x, int[] first, int[] second, int sum, int count) {
        if(sum > x) {
            return count;
        }

        if(first.length == 0 || second.length == 0) {
            return count;
        }

        int ans1 = gameOfTwoStacks(x, Arrays.copyOfRange(first, 1, first.length), second, sum + first[0],count+1);
        int ans2 = gameOfTwoStacks(x, first, Arrays.copyOfRange(second, 1, second.length), sum + second[0], count+1);

        return Math.max(ans1, ans2);
    }
}
