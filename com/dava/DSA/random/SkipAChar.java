public class SkipAChar {
  public static void main(String[] args) {
    String word = "addacd";
    for(char i : word.toCharArray()) {
      if(i == 'a'){
        continue;
      }
      System.out.print(i);
    }
    System.out.println( );
    String word2 = "asfappled";
    if(word2.contains("apple")){
      System.out.print(word2.substring(5));
    }
    skip("", word);
  }
  static void skip(String p_word, String up_word){
    if(up_word.isEmpty()) {
      System.out.println(p_word);
      return;
    }
    char ch = up_word.charAt(0);
    if(ch == 'a') {
      skip(p_word, up_word.substring(1));
    } else {
      skip(p_word + ch, up_word.substring(1));
    }
  }
}
