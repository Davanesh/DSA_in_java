public class Swap {
  public static void main(String[] args) {
    int arr[] = {1, 2};
    int a = 5;
    System.out.println("a:" + a);
    System.out.println("a:" + arr[0]);
    System.out.println("b:" + arr[1]);
    {
      a = 10;
      System.out.println("a:" + a);
    }
    System.out.println("a:" + a);
    swap(arr);
    System.out.println("a:" + arr[0]);
    System.out.println("b:" + arr[1]);
  }
  static int[] swap(int[] arr) {
    int temp = arr[0];
    arr[0] = arr[1];
    arr[1] = temp;
    return arr;
  }
}