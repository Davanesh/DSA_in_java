public class Sorted {
  public static void main(String[] args) {
    int[] arr = {1,3,5,7,8,10,12};
    int[] arr2 = {1,2,4,3,5};
    System.out.println(sorted(arr, 0));
    System.out.println(sorted(arr2, 0));
  }
  static boolean sorted(int[] arr, int index) {
    if(index == arr.length -  1) {
      return true;
    }
    return arr[index] < arr[index + 1] && sorted(arr, index + 1);
  }
}
