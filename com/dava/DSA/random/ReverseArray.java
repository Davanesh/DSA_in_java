import java.util.Arrays;

public class ReverseArray {
  public static void main(String[] args) {
    int[] arr = {81, 56, 87, 23, 1, 78, 67};
    reverse(arr);
    System.out.println(Arrays.toString(arr));
  }
  static int[] reverse (int[] arr) {
    int start = 0;
    int end = arr.length - 1;
    while (start < end) {
      swap(arr, start, end);
      start++;
      end--;
    }
    return  arr;
  }
  static void swap(int[] arr, int first, int second) {
    int temp = arr[first];
    arr[first] = arr[second];
    arr[second] = temp;
  }
}
