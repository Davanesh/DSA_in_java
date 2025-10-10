import java.util.ArrayList;

public class Factors {
  public static void main(String[] args) {
    factor1(5);
    factor2(6);
    factor3(32);
  }
  //O(n)
  static void factor1(int n) {
    for(int i = 1; i <= n; i++) {
      if(n % i == 0) {
        System.out.println(i + " ");
      }
    }
  }
  //O(sqrt(n))
  static void factor2(int n) {
    for (int i = 1; i < Math.sqrt(n); i++) {
      if (n % i == 0) {
        if(n/n == n) {
          System.out.println(i + " ");
        } else {
          System.out.println(i + " ");
          System.out.println(n / i + " ");
        }
      }
    }
  }
  //time and space is O(sqrt(n))
  static void factor3(int n) {
    ArrayList<Integer> list = new ArrayList<>();
    for (int i = 1; i < Math.sqrt(n); i++) {
      if (n % i == 0) {
        if(n/n == n) {
          System.out.println(i + " ");
        } else {
          System.out.println(i + " ");
          list.add(n/i);
        }
      }
    }
    for(int i  = list.size() - 1; i >= 0; i--) {
      System.out.println(list.get(i) + " ");
    }
  }
}