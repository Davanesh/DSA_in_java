package com.dava.revision.backtracking;

import java.util.ArrayList;

public class Permutations {
    public static void main(String[] args) {
        permutations("", "abc");
        System.out.print(permutations2("", "abc"));
    }
    private static void permutations(String p, String up) {
        if(up.isEmpty()) {
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        for(int i = 0; i <= p.length(); i++) {
            String f = p.substring(0,i);
            String s = p.substring(i);
            permutations(f+ch+s, up.substring(1));
        }
    }
    private static ArrayList<String> permutations2(String p, String up) {
        if(up.isEmpty()) {
            ArrayList<String> ans = new ArrayList<>();
            ans.add(p);
            return ans;
        }
        ArrayList<String> ans = new ArrayList<>();
        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String s = p.substring(i);
            ans.addAll(permutations2(f+ch+s, up.substring(1)));
        } return ans;
    }
}
