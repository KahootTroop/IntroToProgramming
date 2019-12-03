// Isaac Bezzant November 30, 2019
import java.util.Scanner;
	class Exercise_6_17 {
		public static void main(String[] args) {
			Scanner input = new Scanner(System.in);
			int n;
			System.out.println("Print Matrix");
			System.out.print("Enter value for n: ");
			n = input.nextInt();
			printMatrix(n);
		}
		public static void printMatrix(int n) {
			for (int row = 0; row < n; row++) {
				System.out.println();
				for(int col = 0; col < n; col++) {
					System.out.print((int)(Math.random() * 2) + " ");
				}
			}
		}
	}