public class PrimeNum {
  public static void main(String[] args) {
    for (int i = 1; i <= 10; i++) {
      System.out.println(i + " is " + isPrime(i));
    }
  }
  static boolean isPrime(int n) {
    if(n <= 1) return false;
    int c = 2;
    while(c * c <= n) {
      if (n % c == 0) {
        return false;
      }
      c++;
    }
    return true;
  }
}