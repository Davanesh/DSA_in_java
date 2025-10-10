public class RecursionBinarySearch {
  public static void main(String[] args) {
    int[] arr = {-2, 0, 1, 5, 6, 8, 12, 17, 19, 23, 36};
    int target = 1;
    int start = 0;
    int end = arr.length - 1;
    
    System.out.println(binarySearch(arr, target, start, end));
  }

  static int binarySearch(int[] arr, int target, int start, int end) {
    if (start > end) return -1;

    int mid = start + (end - start) / 2;

    if (arr[mid] == target) return mid;
    else if (arr[mid] > target) return binarySearch(arr, target, start, mid - 1);
    else return binarySearch(arr, target, mid + 1, end);
  }
}
