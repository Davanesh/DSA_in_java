package com.dava.leetcode.arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1,2,3,1,1,3};
        System.out.println(numIdenticalPairs(arr));
        System.out.println(checkIfPangram("thequickbrownfoxjumpsoverthelazydog"));
    }
    static int numIdenticalPairs(int[] nums) {
        int total = 0;
        for(int i = 0; i < nums.length - 1; i++) {
            for(int j = i+1; j < nums.length - 1 - i; j++) {
                if(nums[i] == nums[j]) {
                    total++;
                }
            }
        } return total;
    }
    static boolean checkIfPangram(String sentence) {
        for(int i = 0; i < sentence.length(); i++) {
            for(int j = 97; j < 97+26; j++) {
                if(sentence.charAt(i) != (char) j) {
                    return false;
                }
            }
        } return true;
    }
}

