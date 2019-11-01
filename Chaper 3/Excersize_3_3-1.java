import java.util.Scanner;
class Excersize_3_3 {
	public static void main(String[] args) {
		Scanner g = new Scanner(System.in);
		double a, b, c, d, e, f;
		double adbc;
		double x, y;
		System.out.println("Enter a, b, c, d, e, f: ");
		a = g.nextDouble();
		b = g.nextDouble();
		c = g.nextDouble();
		d = g.nextDouble();
		e = g.nextDouble();
		f = g.nextDouble();
		adbc = (a * d) - (b * c);
		if (adbc == 0) {
			System.out.println("There is no solution");
		}
		else {
			x = (e * d - b * f) / adbc;
			y = (a * f - e * c) / adbc;
			System.out.println("X is " + x + " Y is " + y);
		}
	}
}