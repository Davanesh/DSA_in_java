package com.dava.DSA.recuesion;

import java.util.ArrayList;

public class SubSeq {
  public static void main(String[] args) {
    subseq("", "abc");
    System.out.println(subList("", "abc"));
    subseqASCII("", "abc");
  }
  //
  static void subseq(String p, String up) {
    if(up.isEmpty()) {
      System.out.println(p);
      return;
    }
    char ch = up.charAt(0);
    subseq(p + ch, up.substring(1));
    subseq(p, up.substring(1));
  }
  // using ArrayList
  static ArrayList<String> subList(String p, String up) {
    if(up.isEmpty()) {
      ArrayList<String> list = new ArrayList<>();
      list.add(p);
      return list;
    }
    char ch = up.charAt(0);
    ArrayList<String> left = subList(p + ch, up.substring(1));
    ArrayList<String> rigth = subList(p, up.substring(1));
    left.addAll(rigth);
    return left;
  }
  //ASCII
  static void subseqASCII(String p, String up) {
    if(up.isEmpty()) {
      System.out.println(p);
      return;
    }
    char ch = up.charAt(0);
    subseqASCII(p + ch, up.substring(1));
    subseqASCII(p, up.substring(1));
    subseqASCII(p + (ch + 0), up.substring(1));
  }
}
