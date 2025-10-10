import java.util.Scanner;

public class Ceiling {
  public static void main(String[] args) {
      try (Scanner sc = new Scanner(System.in)) {
        int[] arr = {-2, 0, 1, 5, 6, 8, 12, 17, 19, 24, 36};
        System.out.print("Enter the value u wanna search: ");
        int target = sc.nextInt();
        System.out.print("The index of the target no is: " + ceiling(arr, target));
      }
  }
  static int ceiling(int[] arr, int target){
    int start = 0;
    int end = arr.length - 1;
    while(start <= end){
      int mid = start + (end - start) / 2;
      if (target < arr[mid]){
        end = mid -1;
      } else if (target > arr[mid]) {
        start = mid + 1;
      } else {
        return mid;
      }
    }
    return start;
  }
}