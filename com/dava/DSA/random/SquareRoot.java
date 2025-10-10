public class SquareRoot {
  public static void main(String[] args) {
    int n = 40;
    int p = 3;
    System.out.println(squareRoot(n));
    System.out.println(squareRoot(n, p));
  }
  static int squareRoot(int n) {
    int left = 1, right = n;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (mid * mid == n) {
        return mid;
      } else if (mid * mid < n) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return right;
  }
  static double squareRoot(int n, int p) {
    int s = 0;
    int e = n;
    double root = 0.0;
    while(e >= s) {
      int m = s + (e - s) / 2;
      if(m * m == n) {
        return m;
      } else if(m * m > n) {
        e = m - 1;
      } else {
        s = m + 1;
      }
    }
    double incr = 0.1;
    for (int i = 0; i <= p; i++) {
      while(root * root <= n) {
        root += incr;
      }
      root -= incr;
      root /= 10;
    }
    return root;
  }
}
