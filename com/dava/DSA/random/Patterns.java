public class Patterns {
  public static void main(String[] args) {
    pattern1(5);
    System.out.println(" ");
    pattern2(5);
    System.out.println(" ");
    pattern3(5);
    System.out.println(" ");
    pattern4(5);
    System.out.println(" ");
    pattern5(5);
    System.out.println(" ");
    pattern28(5);
    System.out.println(" ");
    pattern30(5);
    System.out.println(" ");
    pattern31(4);
  }
  static void pattern1(int n){
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        System.out.print("*");
      }
      System.out.println(" ");
    }
  }
  static void pattern2(int n){
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= i; j++) {
        System.out.print("*" + " ");
      }
      System.out.println(" ");
    }
  }
  static void pattern3(int n){
    for (int i = n; i >= 1; i--) {
      for (int j = i; j >= 1; j--) {
        System.out.print("*" + " ");
      }
      System.out.println(" ");
    }
  }
  static void pattern4(int n){
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= i; j++) {
        System.out.print(j + " ");
      }
      System.out.println(" ");
    }
  }
  static void pattern5(int n){
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= i; j++) {
        System.out.print("* ");
      }
      System.out.println();
    }
    for (int i = n - 1; i >= 1; i--) {
      for (int j = i; j >= 1; j--) {
        System.out.print("* ");
      }
      System.out.println();
    }
  }
  static void pattern28(int n){
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n - i; j++) {
        System.out.print(" ");
      }
      for (int j = 1; j <= i; j++) {
        System.out.print("* ");
      }
      System.out.println();
    }
    for (int i = n - 1; i >= 1; i--) {
      for (int j = 1; j <= n - i; j++) {
        System.out.print(" ");
      }
      for (int j = i; j >= 1; j--) {
        System.out.print("* ");
      }
      System.out.println();
    }
  }
  static void pattern30(int n) {
    for (int i = 1; i <= n; i++) {
        // Print spaces
      for (int j = 1; j <= n - i; j++) {
        System.out.print(" ");
      }
        // Print decreasing numbers from i to 1
      for (int j = i; j >= 1; j--) {
        System.out.print(j + " ");
      }
        // Print increasing numbers from 2 to i
      for (int j = 2; j <= i; j++) {
        System.out.print(j + " ");
      }
      System.out.println(); // Move to next line
    }
  }
  static void pattern31(int n) {
    for (int i = 0; i < 2 * n - 1; i++) {
      for (int j = 0; j < 2 * n - 1; j++) {
        int index = Math.min(Math.min(i, j), Math.min(2 * n - 2 - i, 2 * n - 2 - j));
        System.out.print((n - index) + " ");
      }
      System.out.println();
    }
  }
}
