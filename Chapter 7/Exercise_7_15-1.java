//Isaac Bezzant Febuary 6, 2020
import java.util.Arrays;
import java.util.Scanner;
class Exercise_7_15 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int[] userList = new int[10];
    int[] returnList = new int[10];
    int count = 0;
    int unique = 0;
    System.out.println("Enter 10 numbers seperated by a space" );
    for(int i = 0; i < userList.length -1; i++) {
      userList[i] = input.nextInt();
    }
    Arrays.sort(userList);
    returnList = eliminateDuplicates(userList);
    for(int i = 0; i < returnList.length; i++) {
      if(returnList[i] == 0) {
        count += 1;
      }
    }
    for(int i = 0; i < returnList.length; i++) {
      if(returnList[i] != 0) {
        unique += 1;
      }
    }
    System.out.println("There are " + unique + " unique numbers");  
    System.out.print("The Array without duplicates: ");
    for(int i = 0; i < returnList.length; i++) {
      if(returnList[i] != 0) {
        System.out.print(returnList[i] + " ");
      }
    }
  }
  
  public static int[] eliminateDuplicates(int[] userList) {
    int[] newList = new int[10];
    int counter = 0;
    int i;
    for(i = 1; i < userList.length; i++) {
      if(userList[i] != userList[i - 1]) {
        newList[i] = userList[i];
      }
    }
  return newList;
  }
}