public class SumOfNum {
  public static void main(String[] args) {
    System.out.println(sumOfNum(123));
  }
  static int sumOfNum(int n) {
    if(n == 0) {
      return 0;
    }
    int last = n  % 10;
    return last + sumOfNum(n / 10);
  }
} 
