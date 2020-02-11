// Isaac Bezzant January 28, 2020
import java.util.Scanner;
class Untitled {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double[] userList = new double[10];
		System.out.print("Enter " + userList.length + " numbers, each seperated by a space: ");
		for(int i = 0; i < userList.length; i++) {
			userList[i] = input.nextDouble();
		}
		System.out.println("The minimum number is: " + min(userList));
		
	}
	public static double min(double[] userList) {
	double minimum = userList[0];
		for(int i = 1; i < userList.length; i++) {
			if(userList[i] < minimum) {
			minimum = userList[i];
			}
		}	
	return minimum;
	}
}
