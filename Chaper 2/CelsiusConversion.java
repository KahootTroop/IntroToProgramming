// Isaac Bezzant October 25, 2019 
import java.util.Scanner;
class CelsiusConversion {
	public static void main(String[] args) {
		//Declare scanner
		Scanner input = new Scanner(System.in);
		//Declare Variables
		double fahrenheit;
		double celsius;
		// Get celsius 
		System.out.print("Enter a degree in Celsius: ");
		celsius = input.nextDouble();
		fahrenheit = ((9.0 / 5) * celsius) + 32;
		System.out.print(celsius + " Celsius is " + fahrenheit + " Fahrenheit");
	}
}