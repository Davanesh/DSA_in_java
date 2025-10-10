import java.util.ArrayList;

public class DiceThrow {
  public static void main(String[] args) {
    diceThrow("", 4);
    System.out.println(dice("", 4));
  }
  static void diceThrow(String p, int target) {
    if(target == 0) {
      System.out.println(p);
      return;
    }
    for (int i = 1; i <= 6 && i <= target; i++){
     diceThrow(p + i, target - i); 
    }
  }
  // using ArrayList
  static ArrayList<String> dice(String p, int target) {
    ArrayList<String> list = new ArrayList<>();
    if(target == 0) {
      list.add(p);
      return list;
    }
    for (int i = 1; i <= 6 && i <= target; i++) {
      list.addAll(dice(p + i, target - i));
    }
    return list;
  }
}
