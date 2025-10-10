import java.util.ArrayList;

public class Combination {
  public static void main(String[] args) {
    String a = "abc";
    combination(a, "");
    System.out.println(" ");
    permutation("", a);
    System.out.println(" ");
    System.out.println(permutationList("", a));
  }
  static void combination(String up, String p) {
    if(up.isEmpty()) {
      System.out.println(p);
      return;
    }
    char ch = up.charAt(0);
    combination(up.substring(1), p + ch);
    combination(up.substring(1), p);
  }
  static void permutation(String p, String up) {
    if (up.isEmpty()) {
      System.out.println(p);
      return;
    }
    char ch = up.charAt(0);
    for (int i = 0; i <= p.length(); i++) {
      String f = p.substring(0, i);
      String s = p.substring(i, p.length());
      permutation(f + ch + s, up.substring(1));
    }
  }
  //usig ArrayList
  static ArrayList<String> permutationList(String p, String up) {
    if (up.isEmpty()) {
      ArrayList<String> list = new ArrayList<>();
      list.add(p);
      return list;
    }
    ArrayList<String> ans = new ArrayList<>();
    char ch = up.charAt(0);
    for (int i = 0; i <= p.length(); i++) {
      String f = p.substring(0, i);
      String s = p.substring(i, p.length());
      ans.addAll(permutationList(f + ch + s, up.substring(1)));
    }
    return ans;
  }
}
