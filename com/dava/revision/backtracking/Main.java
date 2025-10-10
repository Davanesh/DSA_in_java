package com.dava.revision.backtracking;

import com.dava.introToOOPs.access.A;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        fun(5);
//        System.out.println(revisionFib(10));
//        System.out.println(revisionFact(5));
//        System.out.println(sum(1234));
//        System.out.println(revNum(1234));
//        System.out.println(countZero(10020, 0));
//        System.out.println(checkSort(new int[] {1,2,3,6,5}, 0));
//        removeChar("", "davanesh");
        subset("", "dava");
        System.out.println(linearSearch(new int[]{1, 2, 3, 4, 5}, 5, 0));
    }

    static void fun(int n) {
        if (n == 0) return;
        System.out.println(n);
        fun(n - 1);
    }

    static int revisionFib(int n) {
        if (n == 1 || n == 2) return 1;
        return revisionFib(n - 1) + revisionFib(n - 2);
    }

    static int revisionFact(int n) {
        if (n == 1 || n == 0) return 1;
        return revisionFact(n - 1) * n;
    }

    static int sum(int num) {
        if (num == 0) return 0;
        return num % 10 + sum(num / 10);
    }

    static int num = 0;

    static void revNum(int n) {
        if (n == 0) return;
        int rev = n % 10;
        num = num * 10 + rev;
        revNum(n / 10);
    }

    static int countZero(int n, int count) {
        if (n == 0) return count;
        int rem = n % 10;
        if (rem == 0) countZero(n / 10, ++count);
        return countZero(n / 10, count);
    }

    static boolean checkSort(int[] arr, int index) {
        if (index == arr.length - 1) return true;
        if (arr[index] <= arr[index + 1] && checkSort(arr, index + 1)) return true;
        return false;
    }

    static void removeChar(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        if (ch == 'a') {
            removeChar(p, up.substring(1));
        } else {
            removeChar(p + ch, up.substring(1));
        }
    }

    static String removeChar2(String up) {
        if (up.isEmpty()) return up;
        char ch = up.charAt(0);
        if (ch == 'a') {
            return removeChar2(up.substring(1));
        } else {
            return ch + removeChar2(up.substring(1));
        }
    }

    static void subset(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        subset(ch + p, up.substring(1));
        subset(p, up.substring(1));
    }

    //    static List<List<String>> subset(String p, String up) {
//        List<String> ans = new ArrayList<>();
//        if(up.isEmpty()) return p;
//        char ch = up.charAt(0);
//
//    }
    static int linearSearch(int[] arr, int target, int index) {
        if (index == arr.length) return -1;
        if (arr[index] == target) return index;
        return linearSearch(arr, target, index + 1);
    }

    static ArrayList<Integer> linearSearch2(int[] arr, int target, int index) {
        ArrayList<Integer> list = new ArrayList<>();
        if (index == arr.length) return list;
        if (arr[index] == target) list.add(index);
        ArrayList<Integer> ansFromBelow = linearSearch2(arr, target, index + 1);
        list.addAll(ansFromBelow);
        Arrays.copyOfRange(arr, 1, arr.length);
        return list;
    }

//    static ArrayList<String> sub(String p, String up) {
//        char ch = p.charAt(0);
//        ArrayList<String> left = sub(p, up.substring(1));
//        ArrayList<String> right = sub(ch + p, up.substring(1));
//    }

    static ArrayList<Integer> liner(int[] arr, int target, int index) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(index == arr.length) {
            return ans;
        }
        if(arr[index] == target) {
            ans.add(index);
        }
        ArrayList<Integer> ansFromBelowCalls = liner(arr, target, index+1);
        ans.addAll(ansFromBelowCalls);
        return ans;
    }
}
