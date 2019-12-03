//Isaac Bezzant December 2, 2019
import java.util.Scanner;	
	class Exercise_6_3 {
		public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      int number;
      System.out.print("Enter a number: ");
      number = input.nextInt();
      System.out.println("The reverse of your number is: " + reverse(number));
      System.out.print("Your number is a palindrome: " + isPalindrome(number));
		}	
		public static int reverse(int number) {	
			int last;
			int reverse = 0;
			while(number > 0) {
				last = number % 10;
				reverse = (reverse * 10) + last;
				number = number / 10;
			}
			return reverse;
		}
		public static boolean isPalindrome(int number) {
			int reverseD, last;
      boolean isPalindrome;
			reverseD = reverse(number);
			if(reverseD == number) {
				isPalindrome = true;
			}
			else {
				isPalindrome = false;
			}
		return  isPalindrome;
		}
	}
	