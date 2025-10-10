import java.util.Arrays;

public class SB {
  public static void main(String[] args) {
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < 26; i++) {
      char alpha = (char) ('a' + i);
      builder.append(alpha);
      System.out.println(builder + " ");
    }
    String name = "dava nesh";
    System.out.println(Arrays.toString(name.split(" ")));
  }
}
