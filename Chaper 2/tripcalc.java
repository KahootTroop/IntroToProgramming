import java.util.Scanner;
class tripcalc {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    //Aquire driving distance
    System.out.println("Enter the driving distance: ");
    double drivingDistance = input.nextDouble();
    //Aquire miles per gallon
    System.out.println("Enter miles per gallon: ");
    double milesPerGallon = input.nextDouble();
    //Aquire price per gallon 
    System.out.println("Enter price per gallon:");
    double pricePerGallon = input.nextDouble(); 
    //Calculate trip cost
    double tripCost = ((drivingDistance / milesPerGallon) * pricePerGallon);
    //Print trip cost
    System.out.println("The total cost of your trip is: $" + tripCost); 
  }
}