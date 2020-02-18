//Isaac Bezzant Febuary 12, 2020
import java.util.Scanner;
class Exercise_8_5 {
	public static void main(String[] args) {
		Scanner user = new Scanner(System.in);
		System.out.print("Enter the matrix size by typing the height, and then the length seperated by a space:  ");
		int upSize = user.nextInt();
		int sideSize = user.nextInt();
		double [][] a = new double [upSize][sideSize];
		double [][] b = new double [upSize][sideSize];
		double [][] fin = new double [upSize][sideSize];
		System.out.println("Enter each line of the first matrix with each number seperated by a space, press enter at the end of each line: ");
		for(int i = 0; i < upSize; i++) {
			for(int j = 0; j < sideSize; j++) {
				a[i][j] = user.nextDouble();
			}
		}
		System.out.println("Enter each line of the second matrix with each number seperated by a space, press enter at the end of each line: ");
		for(int i = 0; i < upSize; i++) {
			for(int j = 0; j < sideSize; j++) {
				b[i][j] = user.nextDouble();
			}
		}
		fin = addMatrix(a, b);
		System.out.println("The matrices added together makes the following matrix: ");
		for(int i = 0; i < upSize; i++) {
			for(int j = 0; j < sideSize; j++) {
				System.out.print(fin[i][j] + " ");
			}
    System.out.println();
		}
		
		
	}
	public static double [][] addMatrix(double [][] a, double [][] b) {
		double [][] c = new double [a.length][a[0].length];
		for(int i = 0; i < a.length; i++) {
			for(int j =0 ; j < a[0].length; j++) {
				c[i][j] = a[i][j] + b[i][j];
			}
		}
	return c;	
	}
}