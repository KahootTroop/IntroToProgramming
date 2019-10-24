// Isaac Bezzant October 24, 2019
import java.util.Scanner;
class CramerRule  {
public static void main(String[] args) {
	double a, b, c, d, e, f, n1, n2, denominator, x, y;
	Scanner sc = new Scanner(System.in);
		System.out.print("This program solves the following equation and gives the values of x and y."+"\n3.4x+50.2y=44.5" + "\n2.1x+.55y=5.9" + "\nx=(ed-bf)/(ad-bc) y =(af-ec)/(ad-bc)" + "\na,bc,d,e,f=3.4,50.2,2.1,.55,44.5,5.9");
		System.out.print("\n\nEnter a, b, c, d, e, f:");
			a = sc.nextDouble();
			b = sc.nextDouble();
			c = sc.nextDouble();
			d = sc.nextDouble();
			e = sc.nextDouble();
			f = sc.nextDouble();
			n1 = ((e * d) - (b * f));
			n2 =((a * f) - (e * c));
			denominator = ((a * d) - (b * c));
			x = n1 / denominator;
			y = n2 / denominator;
			if (denominator == 0) {
				System.out.println("/n The equation has no sol");
			}
				else {
					System.out.println("x is " + x +"and y is " +y);
				}
}
}
// Not 100% sure that gathering the user input for the values is needed, but the example in the book did, so I did as well