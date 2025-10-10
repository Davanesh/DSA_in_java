package com.dava.revision.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LC22 {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
    public static List<String> generateParenthesis(int n) {
        List<String> li = new ArrayList<>();
        back(li, "", 0, 0, n);
        return li;
    }
    public static void back(List<String> li, String s, int o, int c, int n) {
        if (s.length() == n*2) {
            li.add(s);
            return;
        }
        if (o < n) {
            back(li, s+"(", o+1, c, n);
        }
        if (c < o) {
            back(li, s+")", o, c+1, n);
        }
    }
}
