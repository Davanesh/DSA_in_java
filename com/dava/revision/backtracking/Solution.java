package com.dava.revision.backtracking;

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        System.out.println(pad3("", "12", new ArrayList<>()));
    }
    private static void pad(String p, String up) {
        if(up.isEmpty()) {
            System.out.println(p);
            return;
        }
        int dig = up.charAt(0) - '0';
        for(int i = (dig - 1) * 3; i < dig * 3; i++) {
            char ch = (char) ('a' + i);
            pad(ch + p, up.substring(1));
        }
    }
    private static ArrayList<String> pad2(String p, String up) {
        if(up.isEmpty()) {
            ArrayList<String> ans = new ArrayList<>();
            ans.add(p);
            return ans;
        }
        int dig = up.charAt(0) - '0';
        ArrayList<String> ans = new ArrayList<>();
        for(int i = (dig - 1) * 3; i < dig * 3; i++) {
            char ch = (char) ('a' + i);
            ans.addAll(pad2(ch + p, up.substring(1)));
        }
        return ans;
    }
    static ArrayList<String> ans = new ArrayList<>();
    private static ArrayList<String> pad3(String p, String up, ArrayList<String> ans) {
        if(up.isEmpty()) {
            ans.add(p);
            return ans;
        }
        int dig = up.charAt(0) - '0';
        for(int i = (dig - 1) * 3; i < dig * 3; i++) {
            char ch = (char) ('a' + i);
            ans.addAll(pad3(ch + p, up.substring(1), ans));
        }
        return ans;
    }
}
