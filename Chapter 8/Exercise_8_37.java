import java.util.Scanner;
class Exercise_8_37 {
  public static void main(String[] args) {
    Scanner user = new Scanner(System.in);
    String stateCap [][] = new String [10][2];
    String cap [] = new String [10];
    Boolean ans [] = new Boolean [10];
    int score = 0;
    stateCap[0][0] = "ALABAMA";
    stateCap[0][1] = "MONTGOMERY";
    stateCap[1][0] = "ALASKA";
    stateCap[1][1] = "JUNEAU";
    stateCap[2][0] = "ARIZONA";
    stateCap[2][1] = "PHEONIX";
    stateCap[3][0] = "ARKANSAS";
    stateCap[3][1] = "LITTLE ROCK";
    stateCap[4][0] = "CALIFORNIA";
    stateCap[4][1] = "SACRAMENTO";
    stateCap[5][0] = "COLORADO";
    stateCap[5][1] = "DENVER";
    stateCap[6][0] = "CONNECTICUT";
    stateCap[6][1] = "HARTFORD";
    stateCap[7][0] = "DELAWARE";
    stateCap[7][1] = "DOVER";
    stateCap[8][0] = "IDAHO";
    stateCap[8][1] = "BOISE";
    stateCap[9][0] = "KANSAS";
    stateCap[9][1] = "TOPEKA";
    for(int i = 0; i < cap.length; i++) {
      System.out.println("Question " + (i + 1) + " What is the capital of " + stateCap[i][0].toLowerCase() + ": " );
      cap[i] = user.nextLine().toUpperCase();
    }
    System.out.println();
    for(int i = 0; i < ans.length; i++) {
      if(cap[i].equals(stateCap[i][1])) {
        ans[i] = true;
      }
      else {
        ans[i] = false;
      }
    }
    for(int i = 0; i < ans.length; i++) {
      if(ans[i] == true) {
        score++;
      }
    }
    for(int i = 0; i < ans.length; i++) {
      if(ans[i] == true) {
        System.out.println("Question " + (i + 1) + ": Correct");
      }
      else {
        System.out.println("Question " + (i + 1) + ": Incorrect " + "(" + stateCap[i][1] + ")");
      }
    }
    System.out.println("Score: " + score +"/10" );
  }
}