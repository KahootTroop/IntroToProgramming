//Isaac Bezzant December 3, 2019
import java.util.Scanner;
	class Exercise_6_37 {
		public static void main(String[] args) {
			Scanner input = new Scanner(System.in);
			int number, width;
			System.out.print("Enter a number: ");
			number = input.nextInt();
			System.out.print("Enter the desired width of your number: ");
			width = input.nextInt();
			System.out.print("Your number with the desired width is: " + format(number, width));
		}
		public static String format(int number, int width) {
			String format = number + "";
			while(format.length() < width) {
				format = "0" + format;
			}
			return format;
		}
	}