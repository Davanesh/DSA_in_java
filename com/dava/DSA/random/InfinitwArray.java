class InfinitwArray {
  public static void main(String[] args) {
    int[] arr = {-2, 0, 1, 5, 6, 8, 12, 17, 19, 24, 36, 44, 45, 46, 47, 50, 51, 56, 57, 60};
    int target = 5;
    System.out.println("The index of the target no is: " + ans(arr, target));
  }
  static int ans(int[] nums, int target) {
    int start = 0;
    int end = 1;
    while (target > nums[end]) {
      int temp = end + 1;
      end = end + (end - start + 1) * 2;
      start = temp;
    }
    return binarysearch(nums, target, start, end);
  }
  static int binarysearch(int[] arr, int target, int start, int end){
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
    return -1;
  }
} 