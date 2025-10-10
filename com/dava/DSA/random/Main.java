class Console {
  void log(String a) {
    System.out.println(a);
  }
}

public class Main {
  public static void main(String[] args) {
    Console console = new Console();
    console.log("hello");
    // System.out.printf("%.3f", Math.PI);
    String series = "";
    for (int i = 0; i < 26; i++) {
      char alpha = (char) ('a' + i);
      System.out.print(alpha + " ");
      series = series + alpha;
      System.out.println(series);
    }
  }
}