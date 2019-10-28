// Isaac Bezzant October 28, 2019 
import java.util.Scanner;
class Excersize_2_13 {
	public static void main(String[] args) {
    // Set scanner
    Scanner input = new Scanner(System.in);
    //Aquire monthy savings and save as double
    System.out.print("Enter monthly savings: ");
    double MonthSaving = input.nextDouble();
    //calculate account value after first month
    double FirstMonth = MonthSaving * (1 + 0.00417);
    //calculate account value after second month
    double SecondMonth = (MonthSaving + FirstMonth) * (1 + 0.00417);
    //calculate account value after third month
    double ThirdMonth = (MonthSaving + SecondMonth) * (1 + 0.00417);
    //calculate account value after fourth month
    double FourthMonth = (MonthSaving + ThirdMonth) * (1 + 0.00417);
    //calculate account value after fifth month
    double FifthMonth = (MonthSaving + FourthMonth) * (1 + 0.00417);
    //calculate account value after sixth month
    double SixthMonth = (MonthSaving + FifthMonth) * (1 + 0.00417);
    //Print total account value after six months
    System.out.print("After the Sixth month your account value will be " + SixthMonth);
  }
}
