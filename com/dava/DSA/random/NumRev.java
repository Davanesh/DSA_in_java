public class NumRev {
  static int sum = 0;
  static void numRev1(int n) {
    if(n == 0) {
      return;
    }
    int last = n % 10;
    sum = sum * 10 + last;
    numRev1(n/10);
  }
  static void numRev2(int n) {

  }
  public static void main(String[] args) {
    numRev1(1234);
    System.out.println(sum);
  } 
}
