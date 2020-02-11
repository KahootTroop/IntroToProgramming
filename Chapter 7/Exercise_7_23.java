//Isaac Bezzant Febuary 10, 2020
class Exercise_7_23 {
  public static void main(String[] args) {
    boolean[] doors = new boolean[101];
    // all doors start closed
    for(int i = 0; i < doors.length; i++) { 
      doors[i] = false;
    }
    //S1 opens every locker
    for(int i = 0; i < 100; i++) { 
      doors[i] = true;
    }
    for(int i = 1; i < 100; i++) {
      for(int j = i; j < doors.length; j += i + 1) {
        if(doors[j] == true) {
          doors[j] = false;
        }
        else if(doors[j] == false) {
          doors[j] = true;
        }
      }
    }
    System.out.print("The lockers still opened are: ");
    for(int i = 0; i < 101; i++) {
      if(doors[i] == true) {
        System.out.print("L" + (i + 1) + " ");
      }
    }
  }
}