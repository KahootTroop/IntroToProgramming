// Isaac Bezzant November 30, 2019
package jd_17;
import java.util.Scanner;
/** 
 * <h1> Exercise 6-17 was designed to display a matrix to length and width of the users choice </h1>
 * <p> The purpose of this program is to display a matrix to length and width of the users choice after prompting the user to choose the value for n </p>
 * 
 * <p> Date Created: November 30, 2019 </p>
 * 
 * @author Isaac Bezzant
 *
 */
	public class Exercise_6_17 {
/** 
 * This method is used to get the user input for value n and call printMatrix(n)		
 */
		public static void main(String[] args) {
			Scanner input = new Scanner(System.in);
			int n;
			System.out.println("Print Matrix");
			System.out.print("Enter value for n: ");
			n = input.nextInt();
			printMatrix(n);
		}
/**
 * this method is used to print out ones and zeros with the length of each row and column being equal to n
 * <pre>Example: 
 * printMatrix(3) returns: 
 * 001
 * 101
 * 100
 * </pre>		
 * @param n (int; the value the user wants for the length and width of the matrix)
 */
		public static void printMatrix(int n) {
			for (int row = 0; row < n; row++) {
				System.out.println();
				for(int col = 0; col < n; col++) {
					System.out.print((int)(Math.random() * 2) + " ");
				}
			}
		}
	}