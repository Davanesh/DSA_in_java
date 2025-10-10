
import java.util.Scanner;

public class MagicNumber {
  @SuppressWarnings("ConvertToTryWithResources")
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    int base = 5;
    int ans = 0;
    while (n > 0) { 
      int lastNum = n & 1;
      n = n >> 1;
      ans += lastNum * base;
      base = base * 5;
    }
    System.out.println(ans);
    scan.close();
  }
}
