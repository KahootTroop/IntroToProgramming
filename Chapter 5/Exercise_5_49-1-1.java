//Isaac Bezzant 11/13/19
import java.util.Scanner;
  class Exercise_5_49 {
    public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      int ConsonantCount = 0;
      int VowelCount = 0;
      System.out.print("Enter desired string: ");
      String user = input.nextLine();
      user = user.toUpperCase().trim();
      for(int n = 0; n < user.length(); n++) {
        char ch = user.charAt(n);
        if(ch == 'A' || ch == 'E' || ch == 'I' ||ch == 'O' ||ch == 'U') {
          VowelCount++;
        }
        else if(ch != ' ') {
          ConsonantCount++;
        }
      }    
        System.out.println("The number of Vowels is: " + VowelCount);
        System.out.println("The number of Consonants is: " + ConsonantCount);
    }
  }