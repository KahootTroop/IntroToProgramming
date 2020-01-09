//Isaac Bezzant December 2, 2019
package jd_6_3;
import java.util.Scanner;
/** <h1> Exercise 6-3 was created to reverse a number and determine if it is a palindrome </h1>
 * <p> The user is prompted to enter a number and then the reverse of the number and whether the number is a palindrome or not is printed</p>
 * <p>Date Created: December 2, 2019 </p>
 * @author Isaac Bezzant
 *
 */
	class Exercise_6_3 {
/**
 * This method is used to get the number and print the output by calling on reverse and isPalindrome
 */
		public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      int number;
      System.out.print("Enter a number: ");
      number = input.nextInt();
      System.out.println("The reverse of your number is: " + reverse(number));
      System.out.print("Your number is a palindrome: " + isPalindrome(number));
		}	
/**
 * This method is used to take the number and reverse it
 * <pre>Example:
 * {@code reverse(123) returns: 321
 * </pre>
 * @param number (int; the number from the user to reverse)
 * @return 
 */
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
			int reverseD;
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
	