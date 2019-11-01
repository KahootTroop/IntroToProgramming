//Isaac Bezzant November 1, 2019
import java.util.Scanner;
  class Exercise_4_23 {
    public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      String name;
      double hours, payRate, fedRate, stateRate, gross, net, totalD, fedD, stateD;
      System.out.println("Enter employee name: ");
      name = input.next();
      System.out.println("Enter hours worked: ");
      hours = input.nextDouble();
      System.out.println("Enter hourly pay rate: ");
      payRate = input.nextDouble();
      System.out.println("Enter federal tax withholding rate: ");
      fedRate = input.nextDouble();
      System.out.println("Enter state tax withholding rate: ");
      stateRate = input.nextDouble();
      gross = hours * payRate;
      fedD = gross * fedRate;
      fedD = Math.round(fedD * 100) / 100d;
      stateD = gross * stateRate;
      stateD = Math.round(stateD * 100) / 100d;
      totalD = fedD + stateD;
      totalD = Math.round(totalD * 100) / 100d;
      net = gross - totalD;
      net = Math.round(net * 100) / 100d;
      System.out.println("Employee Name: " + name);
      System.out.println("Hours worked: " + hours);
      System.out.println("Pay rate: $" + payRate);
      System.out.println("Gross pay: $" + gross);
      System.out.println("Deductions: ");
      System.out.println("Federal Withholding (" + fedRate * 100 + "%): " + fedD);
      System.out.println("State Withholding (" + stateRate * 100 + "%): " + stateD);
      System.out.println("Total Deductions: " + totalD);
      System.out.println("Net pay: $" + net);
    }
  }