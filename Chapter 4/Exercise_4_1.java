//Isaac Bezzant November 1, 2019
import java.util.Scanner;
  class Exercise_4_1 {
    public static void main(String[] args) {
      Scanner y = new Scanner(System.in);
      double r;
      double s;
      double area;
      System.out.println("Enter the length from the center of the pentagon to the vertex: ");
      r = y.nextDouble();
      s = (2 * r) * (Math.sin(Math.PI / 5));
      area = (5 * Math.pow(s, 2)) / (4 * Math.tan(Math.PI / 5));
      area = Math.round(area * 100) / 100d;
      System.out.println("The Area is: " + area);
    }
  }