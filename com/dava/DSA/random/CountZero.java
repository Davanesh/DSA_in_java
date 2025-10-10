public class CountZero {
  public static void main(String[] args) {
    System.out.println(countZero(1023040));
  }
  static int countZero(int n) {
    return helper(n, 0);
  }
  static int helper(int n, int c) {
    if (n == 0) {
      return c;
    }
    int last = n % 10;
    if (last == 0) {
      helper(n/10, ++c);
    }
    return helper(n/10, c);
  }
}
