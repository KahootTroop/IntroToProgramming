//Isaac Bezzant Febuary 18, 2020
import java.util.Scanner;
class Main {
	public static void main(String[] args) {
		Scanner user = new Scanner(System.in);
		String board[][] = new String[3][13];
    boolean usedSpace[][] = new boolean[3][13];
		String token[] = new String [2];
    int row;
    int col;
		token[0] = "O";
		token[1] = "X";
    for(int i = 0; i < board.length; i++) {
      for(int j = 0; j < board.length; j++) {
        usedSpace[i][j] = false;
      }
    }
    for(int i = 0; i < board.length; i++) {
      for(int j = 0; j < board[0].length; j += 4) {
        board[i][j] = "|";
      }
    }
    for(int i = 0; i < board.length; i++) {
      for(int j = 1; j < board[0].length; j+= 2) {
        board[i][j] = "_";
      }
    }
    for(int i = 0; i < board.length; i++) {
      for(int j = 2; j < board[0].length; j+= 4) {
        board[i][j] = "-";
      }
    }
    System.out.println("Tic-Tac-Toe: please enter your placement choice as the row number followed by the collumn number seperated by a space");
    System.out.println();
    for(int i = 0; i < board.length; i++) {
      for(int j = 0; j < board[0].length; j++) {
        System.out.print(board[i][j]);
      }
      System.out.println();
    }
    System.out.println();
    for(int i = 0; i < 9; i++) {
      if(i % 2 == 0) {
        do {
          System.out.print("Player X: ");
          row = user.nextInt();
          col = user.nextInt();
          System.out.println();
          if(col == 1) {
            col++;
          }
          else if(col == 2) {
            col += 4;
          }
          else if(col == 3) {
            col += 7;
          }
          if(usedSpace[row - 1][col] == false) {      
            board[row - 1][col] = "x";
            usedSpace[row - 1][col] = true; 
            for(int k = 0; k < board.length; k++) {
              for(int j = 0; j < board[0].length; j++) {
                System.out.print(board[k][j]);
              }
              System.out.println();  
            }
            System.out.println();
          }
          else if(usedSpace[row - 1][col] == true) {
              System.out.println("Incorrect selection");
              usedSpace[row - 1][col] = false; 
          }  
        } while(usedSpace[row - 1][col] == false);  
      }
      if(i % 2 == 1) {
        do {
          System.out.print("Player O: ");
          row = user.nextInt();
          col = user.nextInt();
          System.out.println();
          if(col == 1) {
            col++;
          }
          else if(col == 2) {
            col += 4;
          }
          else if(col == 3) {
            col += 7;
          }
          if(usedSpace[row - 1][col] == false) {      
            board[row - 1][col] = "o";
            usedSpace[row - 1][col] = true; 
            for(int k = 0; k < board.length; k++) {
              for(int j = 0; j < board[0].length; j++) {
                System.out.print(board[k][j]);
              }
              System.out.println();  
            }
            System.out.println();
          }
          else if(usedSpace[row - 1][col] == true) {
              System.out.println("Incorrect selection");
              usedSpace[row - 1][col] = false;
          }
        } while(usedSpace[row - 1][col] == false);  
      }
    }
  }  
}  