import java.util.Scanner; 
  class Exercise_3_19 {
    public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      //define variables
      double a;
      double b;
      double c;
      double ab;
      double ac;
      double bc;
      double perimeter;
      //get three side lengths of triangle
      System.out.println("Enter length of first side: ");
      a = s.nextDouble();
      System.out.println("Enter length of second side: ");
      b = s.nextDouble();
      System.out.println("Enter length of third side: ");
      c = s.nextDouble();
      ab = a + b;
      ac = a + c;
      bc = b + c;
      perimeter = a + b + c;
      //if statement to determine if input is valid
      if (ab <= c || ac <= b || bc <= a) {
        System.out.println("The input is invalid");
      } // if
        else {
          System.out.println("The perimeter is: " + perimeter);
        } // else
  } //main
} //class