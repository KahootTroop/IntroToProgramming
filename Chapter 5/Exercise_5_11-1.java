// Isaac Bezzant 11/11/19
class Exercise_5_11 {
  public static void main(String[] args) {
    System.out.println("Printing all numbers from 100-200 that are divisible by 5 or 6 but not both:");
    int count = 0; //set count to zero
    for (int i = 100; i <= 200; i++ ) {
      if ((i % 5 == 0 && i % 6 != 0) || (i % 5 != 0 && i % 6 == 0)) {
        System.out.print(i + " "); // put exactly one space
        count ++; //increase count by 1 
      }
      if (count == 10) {
        System.out.println(); //if count is 10 start new line 
        count = 0; //reset count
      }
    }
  }
}
//not part of the assignment but, the example output on the assignement is for numbers 0-100 not 100-200