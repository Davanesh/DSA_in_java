// import java.util.Scanner;

// public class SmallestLetter {

//   public static void main(String[] args) {
//     Scanner sc = new Scanner(System.in);
//     char[] letters = ['c','f','j'];
//     System.out.print("Enter the value u wanna search: ");
//     char target = sc.next();
//     System.out.print("The index of the target no is: " + nextGreatestLetter(letters, target));
//     sc.close();
//   }
//   static  char nextGreatestLetter(char[] letters, char target) {
//     int start = 0;  
//     int end = letters.length - 1;
//     while(start <= end){
//       int mid = start + (end - start) / 2;
//       if (target < letters[mid]){
//         end = mid - 1;
//       } else {
//         start = mid + 1;
//       } 
//     }
//     return letters[start % letters.length];
//   }
// }