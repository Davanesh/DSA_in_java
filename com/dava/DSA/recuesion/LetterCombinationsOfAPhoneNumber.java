import java.util.ArrayList;

public class LetterCombinationsOfAPhoneNumber {
  public static void main(String[] args) {
    pad("", "23");
    System.out.println(pad2("", "24"));
  }
  static void pad(String p, String up) {
    if(up.isEmpty()) {
      System.out.println(p);
      return;
    }
    int dig = up.charAt(0) - '0';
    for(int i = (dig - 1) * 3; i < dig * 3; i++) {
      char ch = (char)('a' + i);
      pad(p + ch, up.substring(1));
    }
  }
  //usig ArrayList
  static ArrayList<String> pad2(String p, String up) {
    if(up.isEmpty()) {
      ArrayList<String> ans = new ArrayList<>();
      ans.add(p);
      return ans;
    }
    ArrayList<String> ans = new ArrayList<>();
    int dig = up.charAt(0) - '0';
    for(int i = (dig - 1)* 3; i < dig * 3; i++) {
      char ch = (char)('a' +  i);
      ans.addAll(pad2(p + ch, up.substring(1)));
    }
    return ans;
  }
}
