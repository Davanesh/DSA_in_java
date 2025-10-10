import java.util.Scanner;

class Game {
  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
      System.out.println("----------------------------------");
      System.out.println("Welcome to the Odd or Even game!");
      System.out.println("----------------------------------");
      System.out.print("Enter your choice (odd or even): ");
      String playerChoice = scanner.nextLine();
      System.out.println("You chose: " + playerChoice);
      System.out.print("Enter your number(1-10):");
      int playerNumber = scanner.nextInt();
      int computerNumber = (int) (Math.random() * 10) + 1;
      System.out.println("You chose: " + playerNumber);
      System.out.println("Computer chose: " + computerNumber);
      int sum = playerNumber + computerNumber;

      if (sum % 2 == 0 && playerChoice.equals("even")) {
        System.out.println("its even");
        System.out.println("Batting or Bowling!?");
        String playerChose = scanner.nextLine();
        if (playerChose.equals("batting")) {
          playerBatting();
        } else {
          playerBowling();
        }
      }
      else if (sum % 2 != 0 && playerChoice.equals("odd")) {
        System.out.println("its odd");
        System.out.println("Batting or Bowling!?");
        String playerChose = scanner.nextLine();
        if (playerChose.equals("batting")) {
          playerBatting();
        } else {
          playerBowling();
        }
      } else {
        int computerChoice = (int) (Math.random() * 2);
        if (computerChoice == 0) {
          System.out.println("Computer chose to bat");
          compBatting();
        } else {
          System.out.println("Computer chose to bowl");
          compBowling();
        }
        System.out.println("----------------------------------");
      }
    }
  }
  
  public static void playerBowling() {
    try (Scanner scanner = new Scanner(System.in)) {
      System.out.println("computer is bowling");
      int compScore = 0;
      int compRun = (int) (Math.random() * 10);
      System.out.print("Enter your ball(1-10)");
      int playerrun = scanner.nextInt();
      if (compRun == playerrun) {
        System.out.println("Computer is out");
        System.out.println("Computer Score: " + compScore);
        System.out.println("----------------------------------");
      } else {
        compScore += compRun;
        System.out.println("Computer Score: " + compScore);
        System.out.println("----------------------------------");

      }
    }
  }

  public static void playerBatting() {
    try (Scanner scanner = new Scanner(System.in)) {
      System.out.println("Computer are batting");
      int playerRun = 0;
      int compRun = (int) (Math.random() * 10);
      System.out.print("Enter your run(1-10)");
      int playerScore = scanner.nextInt();
      if (compRun == playerRun) {
        System.out.println("You are out");
        System.out.println("Your Score: " + playerRun);
        System.out.println("----------------------------------");

      } else {
        playerRun += playerScore;
        System.out.println("Your Score: " + playerRun);
        System.out.println("----------------------------------");
      }
    }
  }

  public static void compBatting() {
    System.out.println("You are bowling");
    int compScore = 0;
    boolean out = true;
    while (out) { 
      int compRun = (int) (Math.random() * 10);
      System.out.print("Enter your ball(1-10): ");
      try (Scanner scanner = new Scanner(System.in)) {
        int playerball = scanner.nextInt();
        System.out.println("Computer: " + compRun);
        if (compRun == playerball) {
          out = false;
          System.out.println("Computer is out");
          System.out.println("Computer Score: " + compScore);
          System.out.println("----------------------------------");

        } else {
          compScore += compRun;
          System.out.println("Computer Score: " + compScore);
          System.out.println("----------------------------------");
        }
      }
    }
  }

  public static void  compBowling() {
    System.out.println("You are batting");
    int playerScore = 0;
    boolean out = true;
    while (out) {
      try (Scanner scanner = new Scanner(System.in)) {
        System.out.print("Enter your run(1-10): ");
        int playerRun = scanner.nextInt();
        int compScore = (int) (Math.random() * 10);
        System.out.println("Computer: " + compScore);
        if (playerRun == compScore) {
          out = false;
          System.out.println("You are out");
          System.out.println("Your Score: " + playerScore);
          System.out.println("----------------------------------");
        } else {
          playerScore += playerRun;
          System.out.println("Your Score: " + playerScore);
          System.out.println("----------------------------------");
        }
      }
    }
  }
}