package battleship;
import java.util.Scanner;
/** <h1> Battleship </h1>
 * <p> A text based battleship game designed for two players to compete on the same system </p>
 * @author Isaac Bezzant
 * <p> Completed on May 15, 2020 </p>
 */
public class Battleship {
	/** This is the main method, used to call on the other methods, and determine when the game ends. 
	 * 
	 */
	public static void main(String[] args) {
		String battleship = "B";
	    Scanner user = new Scanner(System.in);
		String userOneBoard[][] = new String[9][25];
		String userTwoBoard[][] = new String[9][25];
		String oneHitBoard [][] = new String[9][25];
        String twoHitBoard [][] = new String[9][25];
		char[] columnLetters = "ABCDEFGH".toCharArray();
		int counter1 = 0;
        boolean oneWin = false;
        boolean twoWin = false;
		buildBoard(userOneBoard, userTwoBoard, oneHitBoard, twoHitBoard, columnLetters, counter1);
		generateBattleShipOne(userOneBoard, user, columnLetters, battleship);
		generateBattleShipTwo(userTwoBoard, user, columnLetters, battleship);
		do {
            playerOneTurn(userOneBoard, userTwoBoard, oneHitBoard, columnLetters, user, oneWin);
            if(oneWin != true || twoWin != true) {
                playerTwoTurn(userOneBoard, userTwoBoard, twoHitBoard, columnLetters, user, twoWin);
            }
        } while(oneWin != true || twoWin != true);
		if(oneWin = true) {
            int tempCheck2 = 0;
		    clearScreen();
            System.out.println("Congratulations! User One wins the game! ");
            do {
                System.out.println("Press 1 to play again, or 2 to view the boards from this round");
                if (user.nextInt() == 1) {
                    tempCheck2 = 1;
                    main(args);
                } else if (user.nextInt() == 2) {
                    tempCheck2 = 1;
                    System.out.println("User One's Board: ");
                    printOne(userOneBoard);
                    System.out.println("User Two's Board: ");
                    printTwo(userTwoBoard);
                    System.out.println("User One's Attacks: ");
                    oneHit(oneHitBoard);
                    System.out.println("User Two's Attacks: ");
                    twoHit(twoHitBoard);
                } else {
                    System.out.println("Incorrect Selection, please try again...");
                }
            } while(tempCheck2 == 1);
        }
		else if(twoWin == true) {
		    int tempCheck2 = 0;
		    clearScreen();
		    System.out.println("Congratulations! User Two wins the game! ");
		    do {
                System.out.println("Press 1 to play again, or 2 to view the boards from this round");
                if (user.nextInt() == 1) {
                tempCheck2 = 1;
                main(args);
                } else if (user.nextInt() == 2) {
                tempCheck2 = 1;
                System.out.println("User One's Board: ");
                printOne(userOneBoard);
                System.out.println("User Two's Board: ");
                printTwo(userTwoBoard);
                System.out.println("User One's Attacks: ");
                oneHit(oneHitBoard);
                System.out.println("User Two's Attacks: ");
                twoHit(twoHitBoard);
                } else {
                    System.out.println("Incorrect Selection, please try again...");
                }
            } while(tempCheck2 == 1);
        }
	}
	/** This method is called every time it is user one's turn to attack the enemy. It prompts the user to give a tile to attack, and then tells the user if the attack was a hit or miss. 
	 * 
	 * @param userOneBoard(String[][]; Used to show user one their board, and its the enemy's attacks on it)
	 * @param userTwoBoard(String[][]; Changed to indicated hits and misses to user two on their turn)
	 * @param oneHitBoard(String[][]; Used to show user one where they have attacked and whether the attack was successful or not)
	 * @param columnLetters(char[]; An array of letters that the user may call upon to indicate a row to attack)
	 * @param user(Scanner; Used to get user input on what tile to attack)
	 * @param oneWin(boolean; If user one hits enough tiles to destroy all of the enemy's battleships, it becomes true and indicates that user one wins)
	 */
	public static void playerOneTurn(String[][] userOneBoard, String[][] userTwoBoard, String[][] oneHitBoard, char[] columnLetters, Scanner user, boolean oneWin) {
        clearScreen();
	    System.out.println("It is now user one's turn to attack the enemy, press enter to continue: ");
        String temp = user.nextLine();
	    printOne(userOneBoard);
	    int tempCheck1 = 0;
	    String hit = "X";
	    String miss = "O";
	    int hitCount = 0;
	    int doTry = 0;
	    int rowTile = 0;
	    char userColTile = 'a';
		do {
            oneHit(oneHitBoard);
            do {
                System.out.print("Enter the number of the row you would like to attack: ");
                try {
                    rowTile = Integer.parseInt(user.next());
                }
                catch(Exception e) {
                    System.out.println("Please enter a correct number...");
                    doTry = 1;
                }
            } while(doTry == 1);
            doTry = 0;
            do {
                System.out.print("Enter the letter of the column you would like to attack: ");
                String letterCheck = user.next();
               if(Character.isLetter(letterCheck.charAt(0))) {
                   userColTile = letterCheck.charAt(0);
                   doTry = 0;
               }
               else {
                    System.out.println("Please enter a correct letter...");
                    doTry = 1;
               }
            }while(doTry == 1);
            doTry = 0;
            int colTile = getColTile(userColTile, columnLetters);
            if(oneHitBoard[rowTile][colTile] == "-") {
                tempCheck1 = 1;
                if(userTwoBoard[rowTile][colTile] == "B") {
                    hitCount++;
                    oneHitBoard[rowTile][colTile] = hit;
                    userTwoBoard[rowTile][colTile] = hit;
                    oneHit(oneHitBoard);
                    System.out.println("Hit! You hit an enemy battleship! Press enter to continue: ");
                    temp = user.nextLine();
                    temp = user.nextLine();
                }
                else if(userTwoBoard[rowTile][colTile] == "-") {
                    oneHitBoard[rowTile][colTile] = miss;
                    oneHit(oneHitBoard);
                    userTwoBoard[rowTile][colTile] = miss;
                    System.out.println("Miss! Your shot missed the enemy battleships! Press enter to continue: ");
                    temp = user.nextLine();
                    temp = user.nextLine();
                }
            }
            else {
                System.out.println("Please choose a tile that you have not already attacked...");
            }
        } while(tempCheck1 != 1);
		if(hitCount > 16) {
		    oneWin = true;
        }
	}
	/** This method is called every time it is user two's turn to attack the enemy. It prompts the user to give a tile to attack, and then tells the user if the attack was a hit or miss. 
	 * 
	 * @param userOneBoard(String[][]; Changed to indicated hits and misses to user one on their turn)
	 * @param userTwoBoard(String[][]; Used to show user two their board, and its the enemy's attacks on it)
	 * @param twoHitBoard(String[][]; Used to show user two their attacks on the enemy and whether they were successful or not)
	 * @param columnLetters(char[]; An array of letters that the user may call upon to indicate a row to attack)
	 * @param user(Scanner; Used to get user input on what tile to attack)
	 * @param twoWin(boolean; If user two hits enough tiles to destroy all of the enemy's battleships, it becomes true and indicates that user two wins)
	 */
	public static void playerTwoTurn(String[][] userOneBoard, String[][] userTwoBoard, String[][] twoHitBoard, char[] columnLetters, Scanner user, boolean twoWin) {
        clearScreen();
	    System.out.println("It is now user two's turn to attack the enemy, press enter to continue: ");
        String temp = user.nextLine();
	    printTwo(userTwoBoard);
        int tempCheck1 = 0;
        String hit = "X";
        String miss = "O";
        int hitCount = 0;
        int rowTile = 0;
        int doTry = 0;
        char userColTile = 'a';
        do {
            twoHit(twoHitBoard);
            do {
                System.out.print("Enter the number of the row you would like to attack: ");
                try {
                    rowTile = Integer.parseInt(user.next());
                }
                catch(Exception e) {
                    System.out.println("Please enter a correct number...");
                    doTry = 1;
                }
            } while(doTry == 1);
            doTry = 0;
            do {
                System.out.print("Enter the letter of the column you would like to attack: ");
                String letterCheck = user.next();
               if(Character.isLetter(letterCheck.charAt(0))) {
                   userColTile = letterCheck.charAt(0);
                   doTry = 0;
               }
               else {
                    System.out.println("Please enter a correct letter...");
                    doTry = 1;
               }
            }while(doTry == 1);
            doTry = 0;
            int colTile = getColTile(userColTile, columnLetters);
            if(twoHitBoard[rowTile][colTile] == "-") {
                tempCheck1 = 1;
                if(userOneBoard[rowTile][colTile] == "B") {
                    hitCount++;
                    twoHitBoard[rowTile][colTile] = hit;
                    userOneBoard[rowTile][colTile] = hit;
                    twoHit(twoHitBoard);
                    System.out.println("Hit! You hit an enemy battleship! Press enter to continue: ");
                    temp = user.nextLine();
                    temp = user.nextLine();
                }
                else if(userOneBoard[rowTile][colTile] == "-") {
                    twoHitBoard[rowTile][colTile] = miss;
                    userOneBoard[rowTile][colTile] = miss;
                    twoHit(twoHitBoard);
                    System.out.println("Miss! Your shot missed the enemy battleships! Press enter to continue: ");
                    temp = user.nextLine();
                    temp = user.nextLine();
                }
            }
            else {
                System.out.println("Please choose a tile that you have not already attacked...");
            }
        } while(tempCheck1 != 1);
        if(hitCount > 16) {
            twoWin = true;
        }
	}
	/** This method is used to let user one decide where to place their battleships for the game
	 *
	 * @param userOneBoard(String][]; Shows user one their board, so they can see what spaces are open to place battleships on)
	 * @param user(Scanner; Used to get user input on where to put their battleships)
	 * @param columnLetters(char[]; An array of letters the user can call upon to indicate the column place their battleship)
	 * @param battleship(String; the letter used to represent the users battleships on userOneBoard)
	 */
	public static void generateBattleShipOne(String[][] userOneBoard, Scanner user, char[] columnLetters, String battleship) {
	    String temp;
	    char userColTile = 'a';
	    int userRowTile = 0;
	    int colTile = 0;
	    int doTry = 0;
	    System.out.println("User One will now place their battleships, press enter when ready: ");
	    temp = user.nextLine();
	    clearScreen();
        for(int i = 0; i < 5; i++) {
            switch(i) {
                case 0:
                	int direction = 0;
                    System.out.println("User One will now place the battleship 'Carrier'(Length of 5), press enter to continue: ");
                    temp = user.nextLine();
                    int tempCheck = 0;
                    int tempCheck1 = 0;
                    do {
                        printOne(userOneBoard);
                        do {
	                        System.out.println("Would you like to place the battleship going up/down or right/left? Type 1 for up/down or 2 for right/left: ");
	                        try {
	                        	direction = Integer.parseInt(user.next());
	                        	doTry = 0;
	                        }
	                        catch(Exception e) {
	                        	System.out.println("Please enter a correct number...");
	                        	doTry = 1;
	                        }
                        }while(doTry == 1);
                        doTry = 0;
                        if (direction == 1) {
                            tempCheck = 1;
                            do {
                                printOne(userOneBoard);
                                do {
	                                System.out.print("Enter the number of the row you would like your battleship to be placed on: ");
	                                try {
	                                	userRowTile = Integer.parseInt(user.next());
	                                }
	                                catch(Exception e) {
	                                	System.out.println("Please enter a correct number...");
	                                	doTry = 1;
	                                }
                                } while(doTry == 1);
                                doTry = 0;
                                do {
	                                System.out.print("Enter the letter of the column you would like your battleship to be placed on: ");
	                                String letterCheck = user.next();
	                               if(Character.isLetter(letterCheck.charAt(0))) {
	                            	   userColTile = letterCheck.charAt(0);
	                            	   doTry = 0;
	                               }
	                               else {
	                                	System.out.println("Please enter a correct letter...");
	                                	doTry = 1;
	                               }
                                }while(doTry == 1);
                                doTry = 0;
                                colTile = getColTile(userColTile, columnLetters);
                                int check1 = 0;
                                int tempStack1 = 0;
                                    if(userRowTile + 4 < 9) {
                                        for (int j = 0; j < 5; j++) {
                                            if (userOneBoard[userRowTile + j][colTile] == "-") {
                                                tempCheck1 = 1;
                                                check1 = 1;
                                                tempStack1++;
                                            }
                                        }
                                    }
                                    else if(userRowTile - 4 > 0) {
                                        if (tempStack1 != 5) {
                                            for (int j = 0; j < 5; j++) {
                                                if (userOneBoard[userRowTile - j][colTile] == "-") {
                                                    tempCheck1 = 1;
                                                    check1 = 2;
                                                }
                                            }
                                        }
                                    }
                                if(check1 == 1) {
                                    for (int l = 0; l < 5; l++) {
                                        userOneBoard[userRowTile + l][colTile] = battleship;
                                    }
                                    printOne(userOneBoard);
                                    System.out.println("Battleship placement complete, press enter to continue: ");
                                    temp = user.nextLine();
                                }
                                else if(check1 == 2) {
                                    for (int l = 0; l < 5; l++) {
                                        userOneBoard[userRowTile - l][colTile] = battleship;
                                    }
                                    printOne(userOneBoard);
                                    System.out.println("Battleship placement complete, press enter to continue: ");
                                    temp = user.nextLine();
                                }
                                else {
                                    System.out.println("Incorrect placement, please choose a location with a clear path for the battleship... ");
                                }
                            } while(tempCheck1 != 1);
                        }
                        else if (direction == 2) {
                            tempCheck = 1;
                            do {
                            	do {
                                    System.out.print("Enter the number of the row you would like your battleship to be placed on: ");
                                    try {
                                        userRowTile = Integer.parseInt(user.next());
                                    }
                                    catch(Exception e) {
                                        System.out.println("Please enter a correct number...");
                                        doTry = 1;
                                    }
                                } while(doTry == 1);
                                doTry = 0;
                                do {
                                    System.out.print("Enter the letter of the column you would like your battleship to be placed on: ");
                                    String letterCheck = user.next();
                                   if(Character.isLetter(letterCheck.charAt(0))) {
                                       userColTile = letterCheck.charAt(0);
                                       doTry = 0;
                                   }
                                   else {
                                        System.out.println("Please enter a correct letter...");
                                        doTry = 1;
                                   }
                                }while(doTry == 1);
                                doTry = 0;
                                colTile = getColTile(userColTile, columnLetters);
                                int check1 = 0;
                                int tempCheck2 = 0;
                                int tempStack1 = 0;
                                int tempStack2 = 0;
                                do {
                                    if(colTile + 12 < 25) {
                                        for (int j = 0; j < 15; j += 3) {
                                            if (userOneBoard[userRowTile][colTile + j] == "-") {
                                                tempCheck1 = 1;
                                                check1 = 1;
                                                tempCheck2 = 1;
                                                tempStack1++;
                                            }
                                        }
                                    }
                                    else if(colTile - 12 > 0) {
                                        if (tempStack1 != 5) {
                                            for (int j = 0; j < 15; j += 3) {
                                                if (userOneBoard[userRowTile][colTile - j] == "-") {
                                                    tempCheck1 = 1;
                                                    check1 = 2;
                                                    tempCheck2 = 1;
                                                    tempStack2++;
                                                }
                                            }
                                        }
                                    }
                                    else {
                                        if (tempStack1 != 5) {
                                            if (tempStack2 != 5) {
                                                for (int j = 0; j < 5; j++) {
                                                    if (userOneBoard[userRowTile - j][colTile] != "-" || userOneBoard[userRowTile + j][colTile] != "-") {
                                                        System.out.println("Incorrect selection, please choose a location with a clear path for the battleship...");
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } while(tempCheck2 != 1);
                                if(check1 == 1) {
                                    for (int l = 0; l < 15; l += 3) {
                                        userOneBoard[userRowTile][colTile + l] = battleship;
                                    }
                                    printOne(userOneBoard);
                                    System.out.println("Battleship placement complete, press enter to continue: ");
                                    temp = user.nextLine();
                                }
                                else if(check1 == 2) {
                                    for (int l = 0; l < 15; l += 3) {
                                        userOneBoard[userRowTile][colTile - l] = battleship;
                                    }
                                    printOne(userOneBoard);
                                    System.out.println("Battleship placement complete, press enter to continue: ");
                                    temp = user.nextLine();
                                }
                            } while(tempCheck1 != 1);
                        } else {
                            System.out.println("Incorrect Selection please choose from one of the given options...");
                        }
                    } while(tempCheck != 1);
                    break;
                case 1:
                    System.out.println("User One will now place the battleship 'battleship'(Length of 4), press enter to continue: ");
                    temp = user.nextLine();
                    tempCheck = 0;
                    tempCheck1 = 0;
                    direction = 0;
                    int check1;
                    do {
                        printOne(userOneBoard);
                        do {
                            System.out.println("Would you like to place the battleship going up/down or right/left? Type 1 for up/down or 2 for right/left: ");
                            try {
                                direction = Integer.parseInt(user.next());
                                doTry = 0;
                            }
                            catch(Exception e) {
                                System.out.println("Please enter a correct number...");
                                doTry = 1;
                            }
                        }while(doTry == 1);
                        doTry = 0;
                        if (direction == 1) {
                            tempCheck = 1;
                            do {
                                printOne(userOneBoard);
                                do {
                                    System.out.print("Enter the number of the row you would like your battleship to be placed on: ");
                                    try {
                                        userRowTile = Integer.parseInt(user.next());
                                    }
                                    catch(Exception e) {
                                        System.out.println("Please enter a correct number...");
                                        doTry = 1;
                                    }
                                } while(doTry == 1);
                                doTry = 0;
                                do {
                                    System.out.print("Enter the letter of the column you would like your battleship to be placed on: ");
                                    String letterCheck = user.next();
                                   if(Character.isLetter(letterCheck.charAt(0))) {
                                       userColTile = letterCheck.charAt(0);
                                       doTry = 0;
                                   }
                                   else {
                                        System.out.println("Please enter a correct letter...");
                                        doTry = 1;
                                   }
                                }while(doTry == 1);
                                doTry = 0;
                                colTile = getColTile(userColTile, columnLetters);
                                check1 = 0;
                                int tempStack1 = 0;
                                int tempStack2 = 0;
                                if ((userRowTile + 3) < 9) {
                                    for (int j = 0; j < 4; j++) {
                                        if (userOneBoard[userRowTile + j][colTile] == "-") {
                                            tempStack1++;
                                        }
                                    }
                                    if(tempStack1 == 4) {
                                        check1 = 1;
                                    }
                                }
                                else if (userRowTile - 3 > 0) {
                                    if (tempStack1 != 4) {
                                        for (int j = 0; j < 4; j++) {
                                            if (userOneBoard[userRowTile - j][colTile] == "-") {
                                                tempStack2++;
                                            }
                                        }
                                        if(tempStack2 == 4) {
                                            check1 = 2;
                                        }
                                    }
                                }
                                if(check1 == 1) {
                                    for (int l = 0; l < 4; l++) {
                                        userOneBoard[userRowTile + l][colTile] = battleship;
                                    }
                                    tempCheck1 = 1;
                                    printOne(userOneBoard);
                                    System.out.println("Battleship placement complete, press enter to continue: ");
                                    temp = user.nextLine();
                                }
                                else if(check1 == 2) {
                                    for (int l = 0; l < 4; l++) {
                                        userOneBoard[userRowTile - l][colTile] = battleship;
                                    }
                                    tempCheck1 = 1;
                                    printOne(userOneBoard);
                                    System.out.println("Battleship placement complete, press enter to continue: ");
                                    temp = user.nextLine();
                                }
                                else {
                                    System.out.println("Incorrect placement, please choose a location with a clear path for the battleship... ");
                                }
                            } while(tempCheck1 != 1);
                        }
                        else if (direction == 2) {
                            tempCheck = 1;
                            do {
                            	do {
                                    System.out.print("Enter the number of the row you would like your battleship to be placed on: ");
                                    try {
                                        userRowTile = Integer.parseInt(user.next());
                                    }
                                    catch(Exception e) {
                                        System.out.println("Please enter a correct number...");
                                        doTry = 1;
                                    }
                                } while(doTry == 1);
                                doTry = 0;
                                do {
                                    System.out.print("Enter the letter of the column you would like your battleship to be placed on: ");
                                    String letterCheck = user.next();
                                   if(Character.isLetter(letterCheck.charAt(0))) {
                                       userColTile = letterCheck.charAt(0);
                                       doTry = 0;
                                   }
                                   else {
                                        System.out.println("Please enter a correct letter...");
                                        doTry = 1;
                                   }
                                }while(doTry == 1);
                                doTry = 0;
                                colTile = getColTile(userColTile, columnLetters);
                                check1 = 0;
                                int tempCheck2 = 0;
                                int tempStack1 = 0;
                                do {
                                    if(colTile + 12 < 25) {
                                        for (int j = 0; j < 12; j += 3) {
                                            if (userOneBoard[userRowTile][colTile + j] == "-") {
                                                tempCheck1 = 1;
                                                check1 = 1;
                                                tempCheck2 = 1;
                                                tempStack1++;
                                            }
                                        }
                                    }
                                    else if(colTile - 12 > 0) {
                                        if (tempStack1 != 4) {
                                            for (int j = 0; j < 12; j += 3) {
                                                if (userOneBoard[userRowTile][colTile - j] == "-") {
                                                    tempCheck1 = 1;
                                                    check1 = 2;
                                                    tempCheck2 = 1;
                                                }
                                            }
                                        }
                                    }
                                    else {
                                        System.out.println("Incorrect selection, please choose a location with a clear path for the battleship...");
                                    }
                                } while(tempCheck2 != 1);
                                if(check1 == 1) {
                                    for (int l = 0; l < 12; l += 3) {
                                        userOneBoard[userRowTile][colTile + l] = battleship;
                                    }
                                    printOne(userOneBoard);
                                    System.out.println("Battleship placement complete, press enter to continue: ");
                                    temp = user.nextLine();
                                }
                                else if(check1 == 2) {
                                    for (int l = 0; l < 12; l += 3) {
                                        userOneBoard[userRowTile][colTile - l] = battleship;
                                    }
                                    printOne(userOneBoard);
                                    System.out.println("Battleship placement complete, press enter to continue: ");
                                    temp = user.nextLine();
                                }
                            } while(tempCheck1 != 1);
                        } else {
                            System.out.println("Incorrect Selection please choose from one of the given options...");
                        }
                    } while(tempCheck != 1);
                    break;
                case 2:
                    System.out.println("User One will now place the battleship 'destroyer'(Length of 3), press enter to continue: ");
                    temp = user.nextLine();
                    tempCheck = 0;
                    tempCheck1 = 0;
                    direction = 0;
                    do {
                        printOne(userOneBoard);
                        do {
                            System.out.println("Would you like to place the battleship going up/down or right/left? Type 1 for up/down or 2 for right/left: ");
                            try {
                                direction = Integer.parseInt(user.next());
                                doTry = 0;
                            }
                            catch(Exception e) {
                                System.out.println("Please enter a correct number...");
                                doTry = 1;
                            }
                        }while(doTry == 1);
                        doTry = 0;
                        if (direction == 1) {
                            tempCheck = 1;
                            do {
                                printOne(userOneBoard);
                                do {
                                    System.out.print("Enter the number of the row you would like your battleship to be placed on: ");
                                    try {
                                        userRowTile = Integer.parseInt(user.next());
                                    }
                                    catch(Exception e) {
                                        System.out.println("Please enter a correct number...");
                                        doTry = 1;
                                    }
                                } while(doTry == 1);
                                doTry = 0;
                                do {
                                    System.out.print("Enter the letter of the column you would like your battleship to be placed on: ");
                                    String letterCheck = user.next();
                                   if(Character.isLetter(letterCheck.charAt(0))) {
                                       userColTile = letterCheck.charAt(0);
                                       doTry = 0;
                                   }
                                   else {
                                        System.out.println("Please enter a correct letter...");
                                        doTry = 1;
                                   }
                                }while(doTry == 1);
                                doTry = 0;
                                colTile = getColTile(userColTile, columnLetters);
                                check1 = 0;
                                int tempStack1 = 0;
                                int tempStack2 = 0;
                                if ((userRowTile + 2) < 9) {
                                    for (int j = 0; j < 3; j++) {
                                        if (userOneBoard[userRowTile + j][colTile] == "-") {
                                            tempStack1++;
                                        }
                                    }
                                    if(tempStack1 == 3) {
                                        check1 = 1;
                                    }
                                }
                                else if (userRowTile - 2 > 0) {
                                    if (tempStack1 != 3) {
                                        for (int j = 0; j < 3; j++) {
                                            if (userOneBoard[userRowTile - j][colTile] == "-") {
                                                tempStack2++;
                                            }
                                        }
                                        if(tempStack2 == 3) {
                                            check1 = 2;
                                        }
                                    }
                                }
                                if(check1 == 1) {
                                    for (int l = 0; l < 3; l++) {
                                        userOneBoard[userRowTile + l][colTile] = battleship;
                                    }
                                    tempCheck1 = 1;
                                    printOne(userOneBoard);
                                    System.out.println("Battleship placement complete, press enter to continue: ");
                                    temp = user.nextLine();
                                }
                                else if(check1 == 2) {
                                    for (int l = 0; l < 3; l++) {
                                        userOneBoard[userRowTile - l][colTile] = battleship;
                                    }
                                    tempCheck1 = 1;
                                    printOne(userOneBoard);
                                    System.out.println("Battleship placement complete, press enter to continue: ");
                                    temp = user.nextLine();
                                }
                                else {
                                    System.out.println("Incorrect placement, please choose a location with a clear path for the battleship... ");
                                }
                            } while(tempCheck1 != 1);
                        }
                        else if (direction == 2) {
                            tempCheck = 1;
                            do {
                            	do {
                                    System.out.print("Enter the number of the row you would like your battleship to be placed on: ");
                                    try {
                                        userRowTile = Integer.parseInt(user.next());
                                    }
                                    catch(Exception e) {
                                        System.out.println("Please enter a correct number...");
                                        doTry = 1;
                                    }
                                } while(doTry == 1);
                                doTry = 0;
                                do {
                                    System.out.print("Enter the letter of the column you would like your battleship to be placed on: ");
                                    String letterCheck = user.next();
                                   if(Character.isLetter(letterCheck.charAt(0))) {
                                       userColTile = letterCheck.charAt(0);
                                       doTry = 0;
                                   }
                                   else {
                                        System.out.println("Please enter a correct letter...");
                                        doTry = 1;
                                   }
                                }while(doTry == 1);
                                doTry = 0;
                                colTile = getColTile(userColTile, columnLetters);
                                check1 = 0;
                                int tempCheck2 = 0;
                                int tempStack1 = 0;
                                do {
                                    if(colTile + 9 < 25) {
                                        for (int j = 0; j < 9; j += 3) {
                                            if (userOneBoard[userRowTile][colTile + j] == "-") {
                                                tempCheck1 = 1;
                                                check1 = 1;
                                                tempCheck2 = 1;
                                                tempStack1++;
                                            }
                                        }
                                    }
                                    else if(colTile - 9 > 0) {
                                        if (tempStack1 != 3) {
                                            for (int j = 0; j < 9; j += 3) {
                                                if (userOneBoard[userRowTile][colTile - j] == "-") {
                                                    tempCheck1 = 1;
                                                    check1 = 2;
                                                    tempCheck2 = 1;
                                                }
                                            }
                                        }
                                    }
                                    else {
                                        System.out.println("Incorrect selection, please choose a location with a clear path for the battleship...");
                                    }
                                } while(tempCheck2 != 1);
                                if(check1 == 1) {
                                    for (int l = 0; l < 9; l += 3) {
                                        userOneBoard[userRowTile][colTile + l] = battleship;
                                    }
                                    printOne(userOneBoard);
                                    System.out.println("Battleship placement complete, press enter to continue: ");
                                    temp = user.nextLine();
                                }
                                else if(check1 == 2) {
                                    for (int l = 0; l < 9; l += 3) {
                                        userOneBoard[userRowTile][colTile - l] = battleship;
                                    }
                                    printOne(userOneBoard);
                                    System.out.println("Battleship placement complete, press enter to continue: ");
                                    temp = user.nextLine();
                                }
                            } while(tempCheck1 != 1);
                        } else {
                            System.out.println("Incorrect Selection please choose from one of the given options...");
                        }
                    } while(tempCheck != 1);
                    break;
                case 3:
                    System.out.println("User One will now place the battleship 'submarine'(Length of 3), press enter to continue: ");
                    temp = user.nextLine();
                    tempCheck = 0;
                    tempCheck1 = 0;
                    direction = 0;
                    do {
                        printOne(userOneBoard);
                        do {
                            System.out.println("Would you like to place the battleship going up/down or right/left? Type 1 for up/down or 2 for right/left: ");
                            try {
                                direction = Integer.parseInt(user.next());
                                doTry = 0;
                            }
                            catch(Exception e) {
                                System.out.println("Please enter a correct number...");
                                doTry = 1;
                            }
                        }while(doTry == 1);
                        doTry = 0;
                        if (direction == 1) {
                            tempCheck = 1;
                            do {
                                printOne(userOneBoard);
                                do {
                                    System.out.print("Enter the number of the row you would like your battleship to be placed on: ");
                                    try {
                                        userRowTile = Integer.parseInt(user.next());
                                    }
                                    catch(Exception e) {
                                        System.out.println("Please enter a correct number...");
                                        doTry = 1;
                                    }
                                } while(doTry == 1);
                                doTry = 0;
                                do {
                                    System.out.print("Enter the letter of the column you would like your battleship to be placed on: ");
                                    String letterCheck = user.next();
                                   if(Character.isLetter(letterCheck.charAt(0))) {
                                       userColTile = letterCheck.charAt(0);
                                       doTry = 0;
                                   }
                                   else {
                                        System.out.println("Please enter a correct letter...");
                                        doTry = 1;
                                   }
                                }while(doTry == 1);
                                doTry = 0;
                                colTile = getColTile(userColTile, columnLetters);
                                check1 = 0;
                                int tempStack1 = 0;
                                int tempStack2 = 0;
                                if ((userRowTile + 2) < 9) {
                                    for (int j = 0; j < 3; j++) {
                                        if (userOneBoard[userRowTile + j][colTile] == "-") {
                                            tempStack1++;
                                        }
                                    }
                                    if(tempStack1 == 3) {
                                        check1 = 1;
                                    }
                                }
                                else if (userRowTile - 2 > 0) {
                                    if (tempStack1 != 3) {
                                        for (int j = 0; j < 3; j++) {
                                            if (userOneBoard[userRowTile - j][colTile] == "-") {
                                                tempStack2++;
                                            }
                                        }
                                        if(tempStack2 == 3) {
                                            check1 = 2;
                                        }
                                    }
                                }
                                if(check1 == 1) {
                                    for (int l = 0; l < 3; l++) {
                                        userOneBoard[userRowTile + l][colTile] = battleship;
                                    }
                                    tempCheck1 = 1;
                                    printOne(userOneBoard);
                                    System.out.println("Battleship placement complete, press enter to continue: ");
                                    temp = user.nextLine();
                                }
                                else if(check1 == 2) {
                                    for (int l = 0; l < 3; l++) {
                                        userOneBoard[userRowTile - l][colTile] = battleship;
                                    }
                                    tempCheck1 = 1;
                                    printOne(userOneBoard);
                                    System.out.println("Battleship placement complete, press enter to continue: ");
                                    temp = user.nextLine();
                                }
                                else {
                                    System.out.println("Incorrect placement, please choose a location with a clear path for the battleship... ");
                                }
                            } while(tempCheck1 != 1);
                        }
                        else if (direction == 2) {
                            tempCheck = 1;
                            do {
                            	do {
                                    System.out.print("Enter the number of the row you would like your battleship to be placed on: ");
                                    try {
                                        userRowTile = Integer.parseInt(user.next());
                                    }
                                    catch(Exception e) {
                                        System.out.println("Please enter a correct number...");
                                        doTry = 1;
                                    }
                                } while(doTry == 1);
                                doTry = 0;
                                do {
                                    System.out.print("Enter the letter of the column you would like your battleship to be placed on: ");
                                    String letterCheck = user.next();
                                   if(Character.isLetter(letterCheck.charAt(0))) {
                                       userColTile = letterCheck.charAt(0);
                                       doTry = 0;
                                   }
                                   else {
                                        System.out.println("Please enter a correct letter...");
                                        doTry = 1;
                                   }
                                }while(doTry == 1);
                                doTry = 0;
                                colTile = getColTile(userColTile, columnLetters);
                                check1 = 0;
                                int tempCheck2 = 0;
                                int tempStack1 = 0;
                                do {
                                    if(colTile + 9 < 25) {
                                        for (int j = 0; j < 9; j += 3) {
                                            if (userOneBoard[userRowTile][colTile + j] == "-") {
                                                tempCheck1 = 1;
                                                check1 = 1;
                                                tempCheck2 = 1;
                                                tempStack1++;
                                            }
                                        }
                                    }
                                    else if(colTile - 9 > 0) {
                                        if (tempStack1 != 3) {
                                            for (int j = 0; j < 9; j += 3) {
                                                if (userOneBoard[userRowTile][colTile - j] == "-") {
                                                    tempCheck1 = 1;
                                                    check1 = 2;
                                                    tempCheck2 = 1;
                                                }
                                            }
                                        }
                                    }
                                    else {
                                        System.out.println("Incorrect selection, please choose a location with a clear path for the battleship...");
                                    }
                                } while(tempCheck2 != 1);
                                if(check1 == 1) {
                                    for (int l = 0; l < 9; l += 3) {
                                        userOneBoard[userRowTile][colTile + l] = battleship;
                                    }
                                    printOne(userOneBoard);
                                    System.out.println("Battleship placement complete, press enter to continue: ");
                                    temp = user.nextLine();
                                }
                                else if(check1 == 2) {
                                    for (int l = 0; l < 9; l += 3) {
                                        userOneBoard[userRowTile][colTile - l] = battleship;
                                    }
                                    printOne(userOneBoard);
                                    System.out.println("Battleship placement complete, press enter to continue: ");
                                    temp = user.nextLine();
                                }
                            } while(tempCheck1 != 1);
                        } else {
                            System.out.println("Incorrect Selection please choose from one of the given options...");
                        }
                    } while(tempCheck != 1);
                    break;
                case 4:
                    System.out.println("User One will now place the battleship 'patrol boat'(Length of 2), press enter to continue: ");
                    temp = user.nextLine();
                    tempCheck = 0;
                    tempCheck1 = 0;
                    direction = 0;
                    do {
                        printOne(userOneBoard);
                        do {
                            System.out.println("Would you like to place the battleship going up/down or right/left? Type 1 for up/down or 2 for right/left: ");
                            try {
                                direction = Integer.parseInt(user.next());
                                doTry = 0;
                            }
                            catch(Exception e) {
                                System.out.println("Please enter a correct number...");
                                doTry = 1;
                            }
                        }while(doTry == 1);
                        doTry = 0;
                        if (direction == 1) {
                            tempCheck = 1;
                            do {
                                printOne(userOneBoard);
                                do {
                                    System.out.print("Enter the number of the row you would like your battleship to be placed on: ");
                                    try {
                                        userRowTile = Integer.parseInt(user.next());
                                    }
                                    catch(Exception e) {
                                        System.out.println("Please enter a correct number...");
                                        doTry = 1;
                                    }
                                } while(doTry == 1);
                                doTry = 0;
                                do {
                                    System.out.print("Enter the letter of the column you would like your battleship to be placed on: ");
                                    String letterCheck = user.next();
                                   if(Character.isLetter(letterCheck.charAt(0))) {
                                       userColTile = letterCheck.charAt(0);
                                       doTry = 0;
                                   }
                                   else {
                                        System.out.println("Please enter a correct letter...");
                                        doTry = 1;
                                   }
                                }while(doTry == 1);
                                doTry = 0;
                                colTile = getColTile(userColTile, columnLetters);
                                check1 = 0;
                                int tempStack1 = 0;
                                int tempStack2 = 0;
                                if ((userRowTile + 1) < 9) {
                                    for (int j = 0; j < 2; j++) {
                                        if (userOneBoard[userRowTile + j][colTile] == "-") {
                                            tempStack1++;
                                        }
                                    }
                                    if(tempStack1 == 2) {
                                        check1 = 1;
                                    }
                                }
                                else if (userRowTile - 1 > 0) {
                                    if (tempStack1 != 2) {
                                        for (int j = 0; j < 2; j++) {
                                            if (userOneBoard[userRowTile - j][colTile] == "-") {
                                                tempStack2++;
                                            }
                                        }
                                        if(tempStack2 == 2) {
                                            check1 = 2;
                                        }
                                    }
                                }
                                if(check1 == 1) {
                                    for (int l = 0; l < 2; l++) {
                                        userOneBoard[userRowTile + l][colTile] = battleship;
                                    }
                                    tempCheck1 = 1;
                                    printOne(userOneBoard);
                                    System.out.println("Battleship placement complete, press enter to continue: ");
                                    temp = user.nextLine();
                                }
                                else if(check1 == 2) {
                                    for (int l = 0; l < 2; l++) {
                                        userOneBoard[userRowTile - l][colTile] = battleship;
                                    }
                                    tempCheck1 = 1;
                                    printOne(userOneBoard);
                                    System.out.println("Battleship placement complete, press enter to continue: ");
                                    temp = user.nextLine();
                                }
                                else {
                                    System.out.println("Incorrect placement, please choose a location with a clear path for the battleship... ");
                                }
                            } while(tempCheck1 != 1);
                        }
                        else if (direction == 2) {
                            tempCheck = 1;
                            do {
                            	do {
                                    System.out.print("Enter the number of the row you would like your battleship to be placed on: ");
                                    try {
                                        userRowTile = Integer.parseInt(user.next());
                                    }
                                    catch(Exception e) {
                                        System.out.println("Please enter a correct number...");
                                        doTry = 1;
                                    }
                                } while(doTry == 1);
                                doTry = 0;
                                do {
                                    System.out.print("Enter the letter of the column you would like your battleship to be placed on: ");
                                    String letterCheck = user.next();
                                   if(Character.isLetter(letterCheck.charAt(0))) {
                                       userColTile = letterCheck.charAt(0);
                                       doTry = 0;
                                   }
                                   else {
                                        System.out.println("Please enter a correct letter...");
                                        doTry = 1;
                                   }
                                }while(doTry == 1);
                                doTry = 0;
                                colTile = getColTile(userColTile, columnLetters);
                                check1 = 0;
                                int tempCheck2 = 0;
                                int tempStack1 = 0;
                                do {
                                    if(colTile + 6 < 25) {
                                        for (int j = 0; j < 6; j += 3) {
                                            if (userOneBoard[userRowTile][colTile + j] == "-") {
                                                tempCheck1 = 1;
                                                check1 = 1;
                                                tempCheck2 = 1;
                                                tempStack1++;
                                            }
                                        }
                                    }
                                    else if(colTile - 6 > 0) {
                                        if (tempStack1 != 2) {
                                            for (int j = 0; j < 6; j += 3) {
                                                if (userOneBoard[userRowTile][colTile - j] == "-") {
                                                    tempCheck1 = 1;
                                                    check1 = 2;
                                                    tempCheck2 = 1;
                                                }
                                            }
                                        }
                                    }
                                    else {
                                        System.out.println("Incorrect selection, please choose a location with a clear path for the battleship...");
                                    }
                                } while(tempCheck2 != 1);
                                if(check1 == 1) {
                                    for (int l = 0; l < 6; l += 3) {
                                        userOneBoard[userRowTile][colTile + l] = battleship;
                                    }
                                    printOne(userOneBoard);
                                    System.out.println("Battleship placement complete, press enter to continue: ");
                                    temp = user.nextLine();
                                }
                                else if(check1 == 2) {
                                    for (int l = 0; l < 6; l += 3) {
                                        userOneBoard[userRowTile][colTile - l] = battleship;
                                    }
                                    printOne(userOneBoard);
                                    System.out.println("Battleship placement complete, press enter to continue: ");
                                    temp = user.nextLine();
                                }
                            } while(tempCheck1 != 1);
                        } else {
                            System.out.println("Incorrect Selection please choose from one of the given options...");
                        }
                    } while(tempCheck != 1);
                    break;
            }
        }
        clearScreen();
	}
	/** This method is used to let user two decide where to place their battleships for the game
	 * 
	 * @param userTwoBoard(String[][]; Displays user twos board, so they can see open spaces to place their battleships)
	 * @param user(Scanner; used to get user input to know where to place the user's battleships)
	 * @param columnLetters(char[]; An array of letters for the user to call upon to indicated their column choice when placing battleships)
	 * @param battleship(String; The letter used to indicated battleships on userTwoBoard)
	 */
    public static void generateBattleShipTwo(String[][] userTwoBoard, Scanner user, char[] columnLetters, String battleship) {
        String temp;
        char userColTile = 0;
        int userRowTile = 0;
        int colTile = 0;
        int doTry = 0;
        int direction = 0;
        System.out.println("User Two will now place their battleships, press enter when ready: ");
        temp = user.nextLine();
        clearScreen();
        for(int i = 0; i < 5; i++) {
            switch(i) {
                case 0:
                    System.out.println("User Two will now place the battleship 'Carrier'(Length of 5), press enter to continue: ");
                    temp = user.nextLine();
                    int tempCheck = 0;
                    int tempCheck1 = 0;
                    do {
                        printTwo(userTwoBoard);
                        do {
                            System.out.println("Would you like to place the battleship going up/down or right/left? Type 1 for up/down or 2 for right/left: ");
                            try {
                                direction = Integer.parseInt(user.next());
                                doTry = 0;
                            }
                            catch(Exception e) {
                                System.out.println("Please enter a correct number...");
                                doTry = 1;
                            }
                        }while(doTry == 1);
                        doTry = 0;
                        if (direction == 1) {
                            tempCheck = 1;
                            do {
                                printTwo(userTwoBoard);
                                do {
                                    System.out.print("Enter the number of the row you would like your battleship to be placed on: ");
                                    try {
                                        userRowTile = Integer.parseInt(user.next());
                                    }
                                    catch(Exception e) {
                                        System.out.println("Please enter a correct number...");
                                        doTry = 1;
                                    }
                                } while(doTry == 1);
                                doTry = 0;
                                do {
                                    System.out.print("Enter the letter of the column you would like your battleship to be placed on: ");
                                    String letterCheck = user.next();
                                   if(Character.isLetter(letterCheck.charAt(0))) {
                                       userColTile = letterCheck.charAt(0);
                                       doTry = 0;
                                   }
                                   else {
                                        System.out.println("Please enter a correct letter...");
                                        doTry = 1;
                                   }
                                }while(doTry == 1);
                                doTry = 0;
                                do {
                                	System.out.print("Enter the letter of the column you would like your battleship to be placed on: ");
                                	try {
                                		userColTile = user.next().charAt(0);
                                		doTry = 0;
                                	}
                                	catch(Exception e) {
                                		System.out.println("Please enter a correct letter...");
                                		doTry = 1;
                                	}
                                }while(doTry == 1);
                                doTry = 0;
                                colTile = getColTile(userColTile, columnLetters);
                                int check1 = 0;
                                int tempStack1 = 0;
                                if(userRowTile + 4 < 9) {
                                    for (int j = 0; j < 5; j++) {
                                        if (userTwoBoard[userRowTile + j][colTile] == "-") {
                                            tempCheck1 = 1;
                                            check1 = 1;
                                            tempStack1++;
                                        }
                                    }
                                }
                                else if(userRowTile - 4 > 0) {
                                    if (tempStack1 != 5) {
                                        for (int j = 0; j < 5; j++) {
                                            if (userTwoBoard[userRowTile - j][colTile] == "-") {
                                                tempCheck1 = 1;
                                                check1 = 2;
                                            }
                                        }
                                    }
                                }
                                if(check1 == 1) {
                                    for (int l = 0; l < 5; l++) {
                                        userTwoBoard[userRowTile + l][colTile] = battleship;
                                    }
                                    printTwo(userTwoBoard);
                                    System.out.println("Battleship placement complete, press enter to continue: ");
                                    temp = user.nextLine();
                                }
                                else if(check1 == 2) {
                                    for (int l = 0; l < 5; l++) {
                                        userTwoBoard[userRowTile - l][colTile] = battleship;
                                    }
                                    printTwo(userTwoBoard);
                                    System.out.println("Battleship placement complete, press enter to continue: ");
                                    temp = user.nextLine();
                                }
                                else {
                                    System.out.println("Incorrect placement, please choose a location with a clear path for the battleship... ");
                                }
                            } while(tempCheck1 != 1);
                        }
                        else if (direction == 2) {
                            tempCheck = 1;
                            do {
                            	do {
                                    System.out.print("Enter the number of the row you would like your battleship to be placed on: ");
                                    try {
                                        userRowTile = Integer.parseInt(user.next());
                                    }
                                    catch(Exception e) {
                                        System.out.println("Please enter a correct number...");
                                        doTry = 1;
                                    }
                                } while(doTry == 1);
                                doTry = 0;
                                do {
                                    System.out.print("Enter the letter of the column you would like your battleship to be placed on: ");
                                    String letterCheck = user.next();
                                   if(Character.isLetter(letterCheck.charAt(0))) {
                                       userColTile = letterCheck.charAt(0);
                                       doTry = 0;
                                   }
                                   else {
                                        System.out.println("Please enter a correct letter...");
                                        doTry = 1;
                                   }
                                }while(doTry == 1);
                                doTry = 0;
                                colTile = getColTile(userColTile, columnLetters);
                                int check1 = 0;
                                int tempCheck2 = 0;
                                int tempStack1 = 0;
                                int tempStack2 = 0;
                                do {
                                    if(colTile + 12 < 25) {
                                        for (int j = 0; j < 15; j += 3) {
                                            if (userTwoBoard[userRowTile][colTile + j] == "-") {
                                                tempCheck1 = 1;
                                                check1 = 1;
                                                tempCheck2 = 1;
                                                tempStack1++;
                                            }
                                        }
                                    }
                                    else if(colTile - 12 > 0) {
                                        if (tempStack1 != 5) {
                                            for (int j = 0; j < 15; j += 3) {
                                                if (userTwoBoard[userRowTile][colTile - j] == "-") {
                                                    tempCheck1 = 1;
                                                    check1 = 2;
                                                    tempCheck2 = 1;
                                                    tempStack2++;
                                                }
                                            }
                                        }
                                    }
                                    else {
                                        if (tempStack1 != 5) {
                                            if (tempStack2 != 5) {
                                                for (int j = 0; j < 5; j++) {
                                                    if (userTwoBoard[userRowTile - j][colTile] != "-" || userTwoBoard[userRowTile + j][colTile] != "-") {
                                                        System.out.println("Incorrect selection, please choose a location with a clear path for the battleship...");
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } while(tempCheck2 != 1);
                                if(check1 == 1) {
                                    for (int l = 0; l < 15; l += 3) {
                                        userTwoBoard[userRowTile][colTile + l] = battleship;
                                    }
                                    printTwo(userTwoBoard);
                                    System.out.println("Battleship placement complete, press enter to continue: ");
                                    temp = user.nextLine();
                                }
                                else if(check1 == 2) {
                                    for (int l = 0; l < 15; l += 3) {
                                        userTwoBoard[userRowTile][colTile - l] = battleship;
                                    }
                                    printTwo(userTwoBoard);
                                    System.out.println("Battleship placement complete, press enter to continue: ");
                                    temp = user.nextLine();
                                }
                            } while(tempCheck1 != 1);
                        } else {
                            System.out.println("Incorrect Selection please choose from one of the given options...");
                        }
                    } while(tempCheck != 1);
                    break;
                case 1:
                    System.out.println("User Two will now place the battleship 'battleship'(Length of 4), press enter to continue: ");
                    temp = user.nextLine();
                    tempCheck = 0;
                    tempCheck1 = 0;
                    int check1;
                    do {
                        printTwo(userTwoBoard);
                        do {
                            System.out.println("Would you like to place the battleship going up/down or right/left? Type 1 for up/down or 2 for right/left: ");
                            try {
                                direction = Integer.parseInt(user.next());
                                doTry = 0;
                            }
                            catch(Exception e) {
                                System.out.println("Please enter a correct number...");
                                doTry = 1;
                            }
                        }while(doTry == 1);
                        doTry = 0;
                        if (direction == 1) {
                            tempCheck = 1;
                            do {
                                printTwo(userTwoBoard);
                                do {
                                    System.out.print("Enter the number of the row you would like your battleship to be placed on: ");
                                    try {
                                        userRowTile = Integer.parseInt(user.next());
                                    }
                                    catch(Exception e) {
                                        System.out.println("Please enter a correct number...");
                                        doTry = 1;
                                    }
                                } while(doTry == 1);
                                doTry = 0;
                                do {
                                    System.out.print("Enter the letter of the column you would like your battleship to be placed on: ");
                                    String letterCheck = user.next();
                                   if(Character.isLetter(letterCheck.charAt(0))) {
                                       userColTile = letterCheck.charAt(0);
                                       doTry = 0;
                                   }
                                   else {
                                        System.out.println("Please enter a correct letter...");
                                        doTry = 1;
                                   }
                                }while(doTry == 1);
                                doTry = 0;
                                colTile = getColTile(userColTile, columnLetters);
                                check1 = 0;
                                int tempStack1 = 0;
                                int tempStack2 = 0;
                                if ((userRowTile + 3) < 9) {
                                    for (int j = 0; j < 4; j++) {
                                        if (userTwoBoard[userRowTile + j][colTile] == "-") {
                                            tempStack1++;
                                        }
                                    }
                                    if(tempStack1 == 4) {
                                        check1 = 1;
                                    }
                                }
                                else if (userRowTile - 3 > 0) {
                                    if (tempStack1 != 4) {
                                        for (int j = 0; j < 4; j++) {
                                            if (userTwoBoard[userRowTile - j][colTile] == "-") {
                                                tempStack2++;
                                            }
                                        }
                                        if(tempStack2 == 4) {
                                            check1 = 2;
                                        }
                                    }
                                }
                                if(check1 == 1) {
                                    for (int l = 0; l < 4; l++) {
                                        userTwoBoard[userRowTile + l][colTile] = battleship;
                                    }
                                    tempCheck1 = 1;
                                    printTwo(userTwoBoard);
                                    System.out.println("Battleship placement complete, press enter to continue: ");
                                    temp = user.nextLine();
                                }
                                else if(check1 == 2) {
                                    for (int l = 0; l < 4; l++) {
                                        userTwoBoard[userRowTile - l][colTile] = battleship;
                                    }
                                    tempCheck1 = 1;
                                    printTwo(userTwoBoard);
                                    System.out.println("Battleship placement complete, press enter to continue: ");
                                    temp = user.nextLine();
                                }
                                else {
                                    System.out.println("Incorrect placement, please choose a location with a clear path for the battleship... ");
                                }
                            } while(tempCheck1 != 1);
                        }
                        else if (direction == 2) {
                            tempCheck = 1;
                            do {
                            	do {
                                    System.out.print("Enter the number of the row you would like your battleship to be placed on: ");
                                    try {
                                        userRowTile = Integer.parseInt(user.next());
                                    }
                                    catch(Exception e) {
                                        System.out.println("Please enter a correct number...");
                                        doTry = 1;
                                    }
                                } while(doTry == 1);
                                doTry = 0;
                                do {
                                    System.out.print("Enter the letter of the column you would like your battleship to be placed on: ");
                                    String letterCheck = user.next();
                                   if(Character.isLetter(letterCheck.charAt(0))) {
                                       userColTile = letterCheck.charAt(0);
                                       doTry = 0;
                                   }
                                   else {
                                        System.out.println("Please enter a correct letter...");
                                        doTry = 1;
                                   }
                                }while(doTry == 1);
                                doTry = 0;
                                colTile = getColTile(userColTile, columnLetters);
                                check1 = 0;
                                int tempCheck2 = 0;
                                int tempStack1 = 0;
                                do {
                                    if(colTile + 12 < 25) {
                                        for (int j = 0; j < 12; j += 3) {
                                            if (userTwoBoard[userRowTile][colTile + j] == "-") {
                                                tempCheck1 = 1;
                                                check1 = 1;
                                                tempCheck2 = 1;
                                                tempStack1++;
                                            }
                                        }
                                    }
                                    else if(colTile - 12 > 0) {
                                        if (tempStack1 != 4) {
                                            for (int j = 0; j < 12; j += 3) {
                                                if (userTwoBoard[userRowTile][colTile - j] == "-") {
                                                    tempCheck1 = 1;
                                                    check1 = 2;
                                                    tempCheck2 = 1;
                                                }
                                            }
                                        }
                                    }
                                    else {
                                        System.out.println("Incorrect selection, please choose a location with a clear path for the battleship...");
                                    }
                                } while(tempCheck2 != 1);
                                if(check1 == 1) {
                                    for (int l = 0; l < 12; l += 3) {
                                        userTwoBoard[userRowTile][colTile + l] = battleship;
                                    }
                                    printTwo(userTwoBoard);
                                    System.out.println("Battleship placement complete, press enter to continue: ");
                                    temp = user.nextLine();
                                }
                                else if(check1 == 2) {
                                    for (int l = 0; l < 12; l += 3) {
                                        userTwoBoard[userRowTile][colTile - l] = battleship;
                                    }
                                    printTwo(userTwoBoard);
                                    System.out.println("Battleship placement complete, press enter to continue: ");
                                    temp = user.nextLine();
                                }
                            } while(tempCheck1 != 1);
                        } else {
                            System.out.println("Incorrect Selection please choose from one of the given options...");
                        }
                    } while(tempCheck != 1);
                    break;
                case 2:
                    System.out.println("User Two will now place the battleship 'destroyer'(Length of 3), press enter to continue: ");
                    temp = user.nextLine();
                    tempCheck = 0;
                    tempCheck1 = 0;
                    do {
                        printTwo(userTwoBoard);
                        do {
                            System.out.println("Would you like to place the battleship going up/down or right/left? Type 1 for up/down or 2 for right/left: ");
                            try {
                                direction = Integer.parseInt(user.next());
                                doTry = 0;
                            }
                            catch(Exception e) {
                                System.out.println("Please enter a correct number...");
                                doTry = 1;
                            }
                        }while(doTry == 1);
                        doTry = 0;
                        if (direction == 1) {
                            tempCheck = 1;
                            do {
                                printTwo(userTwoBoard);
                                do {
                                    System.out.print("Enter the number of the row you would like your battleship to be placed on: ");
                                    try {
                                        userRowTile = Integer.parseInt(user.next());
                                    }
                                    catch(Exception e) {
                                        System.out.println("Please enter a correct number...");
                                        doTry = 1;
                                    }
                                } while(doTry == 1);
                                doTry = 0;
                                do {
                                    System.out.print("Enter the letter of the column you would like your battleship to be placed on: ");
                                    String letterCheck = user.next();
                                   if(Character.isLetter(letterCheck.charAt(0))) {
                                       userColTile = letterCheck.charAt(0);
                                       doTry = 0;
                                   }
                                   else {
                                        System.out.println("Please enter a correct letter...");
                                        doTry = 1;
                                   }
                                }while(doTry == 1);
                                doTry = 0;
                                colTile = getColTile(userColTile, columnLetters);
                                check1 = 0;
                                int tempStack1 = 0;
                                int tempStack2 = 0;
                                if ((userRowTile + 2) < 9) {
                                    for (int j = 0; j < 3; j++) {
                                        if (userTwoBoard[userRowTile + j][colTile] == "-") {
                                            tempStack1++;
                                        }
                                    }
                                    if(tempStack1 == 3) {
                                        check1 = 1;
                                    }
                                }
                                else if (userRowTile - 2 > 0) {
                                    if (tempStack1 != 3) {
                                        for (int j = 0; j < 3; j++) {
                                            if (userTwoBoard[userRowTile - j][colTile] == "-") {
                                                tempStack2++;
                                            }
                                        }
                                        if(tempStack2 == 3) {
                                            check1 = 2;
                                        }
                                    }
                                }
                                if(check1 == 1) {
                                    for (int l = 0; l < 3; l++) {
                                        userTwoBoard[userRowTile + l][colTile] = battleship;
                                    }
                                    tempCheck1 = 1;
                                    printTwo(userTwoBoard);
                                    System.out.println("Battleship placement complete, press enter to continue: ");
                                    temp = user.nextLine();
                                }
                                else if(check1 == 2) {
                                    for (int l = 0; l < 3; l++) {
                                        userTwoBoard[userRowTile - l][colTile] = battleship;
                                    }
                                    tempCheck1 = 1;
                                    printTwo(userTwoBoard);
                                    System.out.println("Battleship placement complete, press enter to continue: ");
                                    temp = user.nextLine();
                                }
                                else {
                                    System.out.println("Incorrect placement, please choose a location with a clear path for the battleship... ");
                                }
                            } while(tempCheck1 != 1);
                        }
                        else if (direction == 2) {
                            tempCheck = 1;
                            do {
                            	do {
                                    System.out.print("Enter the number of the row you would like your battleship to be placed on: ");
                                    try {
                                        userRowTile = Integer.parseInt(user.next());
                                    }
                                    catch(Exception e) {
                                        System.out.println("Please enter a correct number...");
                                        doTry = 1;
                                    }
                                } while(doTry == 1);
                                doTry = 0;
                                do {
                                    System.out.print("Enter the letter of the column you would like your battleship to be placed on: ");
                                    String letterCheck = user.next();
                                   if(Character.isLetter(letterCheck.charAt(0))) {
                                       userColTile = letterCheck.charAt(0);
                                       doTry = 0;
                                   }
                                   else {
                                        System.out.println("Please enter a correct letter...");
                                        doTry = 1;
                                   }
                                }while(doTry == 1);
                                doTry = 0;
                                colTile = getColTile(userColTile, columnLetters);
                                check1 = 0;
                                int tempCheck2 = 0;
                                int tempStack1 = 0;
                                do {
                                    if(colTile + 9 < 25) {
                                        for (int j = 0; j < 9; j += 3) {
                                            if (userTwoBoard[userRowTile][colTile + j] == "-") {
                                                tempCheck1 = 1;
                                                check1 = 1;
                                                tempCheck2 = 1;
                                                tempStack1++;
                                            }
                                        }
                                    }
                                    else if(colTile - 9 > 0) {
                                        if (tempStack1 != 3) {
                                            for (int j = 0; j < 9; j += 3) {
                                                if (userTwoBoard[userRowTile][colTile - j] == "-") {
                                                    tempCheck1 = 1;
                                                    check1 = 2;
                                                    tempCheck2 = 1;
                                                }
                                            }
                                        }
                                    }
                                    else {
                                        System.out.println("Incorrect selection, please choose a location with a clear path for the battleship...");
                                    }
                                } while(tempCheck2 != 1);
                                if(check1 == 1) {
                                    for (int l = 0; l < 9; l += 3) {
                                        userTwoBoard[userRowTile][colTile + l] = battleship;
                                    }
                                    printTwo(userTwoBoard);
                                    System.out.println("Battleship placement complete, press enter to continue: ");
                                    temp = user.nextLine();
                                }
                                else if(check1 == 2) {
                                    for (int l = 0; l < 9; l += 3) {
                                        userTwoBoard[userRowTile][colTile - l] = battleship;
                                    }
                                    printTwo(userTwoBoard);
                                    System.out.println("Battleship placement complete, press enter to continue: ");
                                    temp = user.nextLine();
                                }
                            } while(tempCheck1 != 1);
                        } else {
                            System.out.println("Incorrect Selection please choose from one of the given options...");
                        }
                    } while(tempCheck != 1);
                    break;
                case 3:
                    System.out.println("User Two will now place the battleship 'submarine'(Length of 3), press enter to continue: ");
                    temp = user.nextLine();
                    tempCheck = 0;
                    tempCheck1 = 0;
                    do {
                        printTwo(userTwoBoard);
                        do {
                            System.out.println("Would you like to place the battleship going up/down or right/left? Type 1 for up/down or 2 for right/left: ");
                            try {
                                direction = Integer.parseInt(user.next());
                                doTry = 0;
                            }
                            catch(Exception e) {
                                System.out.println("Please enter a correct number...");
                                doTry = 1;
                            }
                        }while(doTry == 1);
                        doTry = 0;
                        if (direction == 1) {
                            tempCheck = 1;
                            do {
                                printTwo(userTwoBoard);
                                do {
                                    System.out.print("Enter the number of the row you would like your battleship to be placed on: ");
                                    try {
                                        userRowTile = Integer.parseInt(user.next());
                                    }
                                    catch(Exception e) {
                                        System.out.println("Please enter a correct number...");
                                        doTry = 1;
                                    }
                                } while(doTry == 1);
                                doTry = 0;
                                do {
                                    System.out.print("Enter the letter of the column you would like your battleship to be placed on: ");
                                    String letterCheck = user.next();
                                   if(Character.isLetter(letterCheck.charAt(0))) {
                                       userColTile = letterCheck.charAt(0);
                                       doTry = 0;
                                   }
                                   else {
                                        System.out.println("Please enter a correct letter...");
                                        doTry = 1;
                                   }
                                }while(doTry == 1);
                                doTry = 0;

                                colTile = getColTile(userColTile, columnLetters);
                                check1 = 0;
                                int tempStack1 = 0;
                                int tempStack2 = 0;
                                if ((userRowTile + 2) < 9) {
                                    for (int j = 0; j < 3; j++) {
                                        if (userTwoBoard[userRowTile + j][colTile] == "-") {
                                            tempStack1++;
                                        }
                                    }
                                    if(tempStack1 == 3) {
                                        check1 = 1;
                                    }
                                }
                                else if (userRowTile - 2 > 0) {
                                    if (tempStack1 != 3) {
                                        for (int j = 0; j < 3; j++) {
                                            if (userTwoBoard[userRowTile - j][colTile] == "-") {
                                                tempStack2++;
                                            }
                                        }
                                        if(tempStack2 == 3) {
                                            check1 = 2;
                                        }
                                    }
                                }
                                if(check1 == 1) {
                                    for (int l = 0; l < 3; l++) {
                                        userTwoBoard[userRowTile + l][colTile] = battleship;
                                    }
                                    tempCheck1 = 1;
                                    printTwo(userTwoBoard);
                                    System.out.println("Battleship placement complete, press enter to continue: ");
                                    temp = user.nextLine();
                                }
                                else if(check1 == 2) {
                                    for (int l = 0; l < 3; l++) {
                                        userTwoBoard[userRowTile - l][colTile] = battleship;
                                    }
                                    tempCheck1 = 1;
                                    printTwo(userTwoBoard);
                                    System.out.println("Battleship placement complete, press enter to continue: ");
                                    temp = user.nextLine();
                                }
                                else {
                                    System.out.println("Incorrect placement, please choose a location with a clear path for the battleship... ");
                                }
                            } while(tempCheck1 != 1);
                        }
                        else if (direction == 2) {
                            tempCheck = 1;
                            do {
                            	do {
                                    System.out.print("Enter the number of the row you would like your battleship to be placed on: ");
                                    try {
                                        userRowTile = Integer.parseInt(user.next());
                                    }
                                    catch(Exception e) {
                                        System.out.println("Please enter a correct number...");
                                        doTry = 1;
                                    }
                                } while(doTry == 1);
                                doTry = 0;
                                do {
                                    System.out.print("Enter the letter of the column you would like your battleship to be placed on: ");
                                    String letterCheck = user.next();
                                   if(Character.isLetter(letterCheck.charAt(0))) {
                                       userColTile = letterCheck.charAt(0);
                                       doTry = 0;
                                   }
                                   else {
                                        System.out.println("Please enter a correct letter...");
                                        doTry = 1;
                                   }
                                }while(doTry == 1);
                                doTry = 0;

                                colTile = getColTile(userColTile, columnLetters);
                                check1 = 0;
                                int tempCheck2 = 0;
                                int tempStack1 = 0;
                                do {
                                    if(colTile + 9 < 25) {
                                        for (int j = 0; j < 9; j += 3) {
                                            if (userTwoBoard[userRowTile][colTile + j] == "-") {
                                                tempCheck1 = 1;
                                                check1 = 1;
                                                tempCheck2 = 1;
                                                tempStack1++;
                                            }
                                        }
                                    }
                                    else if(colTile - 9 > 0) {
                                        if (tempStack1 != 3) {
                                            for (int j = 0; j < 9; j += 3) {
                                                if (userTwoBoard[userRowTile][colTile - j] == "-") {
                                                    tempCheck1 = 1;
                                                    check1 = 2;
                                                    tempCheck2 = 1;
                                                }
                                            }
                                        }
                                    }
                                    else {
                                        System.out.println("Incorrect selection, please choose a location with a clear path for the battleship...");
                                    }
                                } while(tempCheck2 != 1);
                                if(check1 == 1) {
                                    for (int l = 0; l < 9; l += 3) {
                                        userTwoBoard[userRowTile][colTile + l] = battleship;
                                    }
                                    printTwo(userTwoBoard);
                                    System.out.println("Battleship placement complete, press enter to continue: ");
                                    temp = user.nextLine();
                                }
                                else if(check1 == 2) {
                                    for (int l = 0; l < 9; l += 3) {
                                        userTwoBoard[userRowTile][colTile - l] = battleship;
                                    }
                                    printTwo(userTwoBoard);
                                    System.out.println("Battleship placement complete, press enter to continue: ");
                                    temp = user.nextLine();
                                }
                            } while(tempCheck1 != 1);
                        } else {
                            System.out.println("Incorrect Selection please choose from one of the given options...");
                        }
                    } while(tempCheck != 1);
                    break;
                case 4:
                    System.out.println("User One will now place the battleship 'patrol boat'(Length of 2), press enter to continue: ");
                    temp = user.nextLine();
                    tempCheck = 0;
                    tempCheck1 = 0;
                    do {
                        printTwo(userTwoBoard);
                        do {
                            System.out.println("Would you like to place the battleship going up/down or right/left? Type 1 for up/down or 2 for right/left: ");
                            try {
                                direction = Integer.parseInt(user.next());
                                doTry = 0;
                            }
                            catch(Exception e) {
                                System.out.println("Please enter a correct number...");
                                doTry = 1;
                            }
                        }while(doTry == 1);
                        doTry = 0;
                        if (direction == 1) {
                            tempCheck = 1;
                            do {
                                printTwo(userTwoBoard);
                                do {
                                    System.out.print("Enter the number of the row you would like your battleship to be placed on: ");
                                    try {
                                        userRowTile = Integer.parseInt(user.next());
                                    }
                                    catch(Exception e) {
                                        System.out.println("Please enter a correct number...");
                                        doTry = 1;
                                    }
                                } while(doTry == 1);
                                doTry = 0;
                                do {
                                    System.out.print("Enter the letter of the column you would like your battleship to be placed on: ");
                                    String letterCheck = user.next();
                                   if(Character.isLetter(letterCheck.charAt(0))) {
                                       userColTile = letterCheck.charAt(0);
                                       doTry = 0;
                                   }
                                   else {
                                        System.out.println("Please enter a correct letter...");
                                        doTry = 1;
                                   }
                                }while(doTry == 1);
                                doTry = 0;
                                colTile = getColTile(userColTile, columnLetters);
                                check1 = 0;
                                int tempStack1 = 0;
                                int tempStack2 = 0;
                                if ((userRowTile + 1) < 9) {
                                    for (int j = 0; j < 2; j++) {
                                        if (userTwoBoard[userRowTile + j][colTile] == "-") {
                                            tempStack1++;
                                        }
                                    }
                                    if(tempStack1 == 2) {
                                        check1 = 1;
                                    }
                                }
                                else if (userRowTile - 1 > 0) {
                                    if (tempStack1 != 2) {
                                        for (int j = 0; j < 2; j++) {
                                            if (userTwoBoard[userRowTile - j][colTile] == "-") {
                                                tempStack2++;
                                            }
                                        }
                                        if(tempStack2 == 2) {
                                            check1 = 2;
                                        }
                                    }
                                }
                                if(check1 == 1) {
                                    for (int l = 0; l < 2; l++) {
                                        userTwoBoard[userRowTile + l][colTile] = battleship;
                                    }
                                    tempCheck1 = 1;
                                    printTwo(userTwoBoard);
                                    System.out.println("Battleship placement complete, press enter to continue: ");
                                    temp = user.nextLine();
                                }
                                else if(check1 == 2) {
                                    for (int l = 0; l < 2; l++) {
                                        userTwoBoard[userRowTile - l][colTile] = battleship;
                                    }
                                    tempCheck1 = 1;
                                    printOne(userTwoBoard);
                                    System.out.println("Battleship placement complete, press enter to continue: ");
                                    temp = user.nextLine();
                                }
                                else {
                                    System.out.println("Incorrect placement, please choose a location with a clear path for the battleship... ");
                                }
                            } while(tempCheck1 != 1);
                        }
                        else if (direction == 2) {
                            tempCheck = 1;
                            do {
                            	do {
                                    System.out.print("Enter the number of the row you would like your battleship to be placed on: ");
                                    try {
                                        userRowTile = Integer.parseInt(user.next());
                                    }
                                    catch(Exception e) {
                                        System.out.println("Please enter a correct number...");
                                        doTry = 1;
                                    }
                                } while(doTry == 1);
                                doTry = 0;
                                do {
                                    System.out.print("Enter the letter of the column you would like your battleship to be placed on: ");
                                    String letterCheck = user.next();
                                   if(Character.isLetter(letterCheck.charAt(0))) {
                                       userColTile = letterCheck.charAt(0);
                                       doTry = 0;
                                   }
                                   else {
                                        System.out.println("Please enter a correct letter...");
                                        doTry = 1;
                                   }
                                }while(doTry == 1);
                                doTry = 0;
                                colTile = getColTile(userColTile, columnLetters);
                                check1 = 0;
                                int tempCheck2 = 0;
                                int tempStack1 = 0;
                                do {
                                    if(colTile + 6 < 25) {
                                        for (int j = 0; j < 6; j += 3) {
                                            if (userTwoBoard[userRowTile][colTile + j] == "-") {
                                                tempCheck1 = 1;
                                                check1 = 1;
                                                tempCheck2 = 1;
                                                tempStack1++;
                                            }
                                        }
                                    }
                                    else if(colTile - 6 > 0) {
                                        if (tempStack1 != 2) {
                                            for (int j = 0; j < 6; j += 3) {
                                                if (userTwoBoard[userRowTile][colTile - j] == "-") {
                                                    tempCheck1 = 1;
                                                    check1 = 2;
                                                    tempCheck2 = 1;
                                                }
                                            }
                                        }
                                    }
                                    else {
                                        System.out.println("Incorrect selection, please choose a location with a clear path for the battleship...");
                                    }
                                } while(tempCheck2 != 1);
                                if(check1 == 1) {
                                    for (int l = 0; l < 6; l += 3) {
                                        userTwoBoard[userRowTile][colTile + l] = battleship;
                                    }
                                    printTwo(userTwoBoard);
                                    System.out.println("Battleship placement complete, press enter to continue: ");
                                    temp = user.nextLine();
                                }
                                else if(check1 == 2) {
                                    for (int l = 0; l < 6; l += 3) {
                                        userTwoBoard[userRowTile][colTile - l] = battleship;
                                    }
                                    printTwo(userTwoBoard);
                                    System.out.println("Battleship placement complete, press enter to continue: ");
                                    temp = user.nextLine();
                                }
                            } while(tempCheck1 != 1);
                        } else {
                            System.out.println("Incorrect Selection please choose from one of the given options...");
                        }
                    } while(tempCheck != 1);
                    break;
            }
        }
        clearScreen();
    }
    /** This method is used to take the char given by the user to indicate the column, and return the number to be used for placement in the users board array
     * <pre> Examples: {@code getColTile(a, columnLetters) returns: 2 getColTile(D, columnLetters) returns: 11 }</pre>
     * @param userColTile(char; The letter given by the user to indicated what column they want their battleship or attack placed on)
     * @param columnLetters(char[]; The array of letters that the user could have chosen from, used to match the user input with its corresponding number)
     * @return colTile(int; the number to be placed in the array for the column of the battleship or attack, corresponds with the letter given by the user)
     */
    public static int getColTile(char userColTile, char[] columnLetters) {
	    int colTile = 0;
	    switch(userColTile) {
            case 'A':
            case 'a':
                colTile = 2;
                break;
            case 'B':
            case 'b':
                colTile = 5;
                break;
            case 'C':
            case 'c':
                colTile = 8;
                break;
            case 'D':
            case 'd':
                colTile = 11;
                break;
            case 'E':
            case 'e':
                colTile = 14;
                break;
            case 'F':
            case 'f':
                colTile = 17;
                break;
            case 'G':
            case 'g':
                colTile = 20;
                break;
            case 'H':
            case 'h':
                colTile = 23;
                break;
        }
        return colTile;
    }
    /** This method is used to print out userOneBoard without having to write it out manually every time
     * <pre> Example of what userOneBoard could look like when printed: {@code 
     *          A  B  C  D  E  F  G  H 
     *	1{B}{-}{-}{-}{B}{B}{B}{B}
     *	2{B}{-}{-}{-}{-}{-}{-}{-}
     *	3{B}{-}{B}{-}{-}{B}{-}{-}
     *	4{B}{-}{B}{-}{-}{B}{-}{-}
     *	5{B}{-}{-}{-}{-}{B}{-}{-}
     *	6{-}{-}{-}{-}{-}{-}{-}{-}
     *	7{-}{-}{B}{B}{B}{-}{-}{-}
     *	8{-}{-}{-}{-}{-}{-}{-}{-}
     * }</pre>
     * @param userOneBoard(String[][]; The array being printed out in the method)
     */
	public static void printOne(String[][] userOneBoard) {
	    for(int i = 0; i < userOneBoard.length; i++) {
	        for(int j = 0; j < userOneBoard[0].length; j++) {
	            System.out.print(userOneBoard[i][j]);
            }
	        System.out.println();
        }
    }
	/** This method is used to print out userTwoBoard without having to write it out manually every time
	 * <pre> Example of what userTwoBoard could look like when printed: {@code 
     *          A  B  C  D  E  F  G  H 
     *	1{B}{-}{-}{-}{B}{B}{B}{B}
     *	2{B}{-}{-}{-}{-}{-}{-}{-}
     *	3{B}{-}{B}{-}{-}{B}{-}{-}
     *	4{B}{-}{B}{-}{-}{B}{-}{-}
     *	5{B}{-}{-}{-}{-}{B}{-}{-}
     *	6{-}{-}{-}{-}{-}{-}{-}{-}
     *	7{-}{-}{B}{B}{B}{-}{-}{-}
     *	8{-}{-}{-}{-}{-}{-}{-}{-}
     * }</pre>
	 * @param userTwoBoard(String[][]; The array being printed out in the method)
	 */
    public static void printTwo(String[][] userTwoBoard) {
        for(int i = 0; i < userTwoBoard.length; i++) {
            for(int j = 0; j < userTwoBoard[0].length; j++) {
                System.out.print(userTwoBoard[i][j]);
            }
            System.out.println();
        }
    }
    /** This method is used to print out oneHit without having to write it out manually every time
     * <pre> Example of what oneHit could look like when printed: {@code 
     *          A  B  C  D  E  F  G  H 
     *	1{-}{-}{-}{-}{-}{-}{-}{-}
     *	2{-}{-}{X}{-}{-}{-}{-}{-}
     *	3{-}{-}{X}{-}{-}{-}{-}{-}
     *	4{-}{-}{X}{-}{-}{O}{-}{-}
     *	5{-}{-}{-}{-}{O}{-}{-}{-}
     *	6{-}{X}{-}{-}{O}{-}{-}{-}
     *	7{-}{-}{-}{-}{-}{-}{-}{-}
     *	8{-}{-}{-}{-}{-}{-}{-}{-}
     * }</pre>
     * @param oneHitBoard(String[][]; The array being printed out in the method)
     */
    public static void oneHit(String[][] oneHitBoard) {
        for(int i = 0; i < oneHitBoard.length; i++) {
            for(int j = 0; j < oneHitBoard[0].length; j++) {
                System.out.print(oneHitBoard[i][j]);
            }
            System.out.println();
        }
    }
    /** This method is used to print out twoHit without having to write it out manually every time
     * <pre> Example of what twoHit could look like when printed: {@code 
     *          A  B  C  D  E  F  G  H 
     *	1{-}{-}{-}{-}{-}{-}{-}{-}
     *	2{-}{-}{X}{-}{-}{-}{-}{-}
     *	3{-}{-}{X}{-}{-}{-}{-}{-}
     *	4{-}{-}{X}{-}{-}{O}{-}{-}
     *	5{-}{-}{-}{-}{O}{-}{-}{-}
     *	6{-}{X}{-}{-}{O}{-}{-}{-}
     *	7{-}{-}{-}{-}{-}{-}{-}{-}
     *	8{-}{-}{-}{-}{-}{-}{-}{-}
     * }</pre>
     * @param twoHitBoard(String[][]; the array being printed out in the method)
     */
    public static void twoHit(String[][] twoHitBoard) {
        for(int i = 0; i < twoHitBoard.length; i++) {
            for(int j = 0; j < twoHitBoard[0].length; j++) {
                System.out.print(twoHitBoard[i][j]);
            }
            System.out.println();
        }
    }
    /** This method is used to create the game board for all of the arrays
     * <pre> Example of what the arrays will all be formated to look like: {@code 
     *          A  B  C  D  E  F  G  H 
     *	1{-}{-}{-}{-}{-}{-}{-}{-}
     *	2{-}{-}{-}{-}{-}{-}{-}{-}
     *	3{-}{-}{-}{-}{-}{-}{-}{-}
     *	4{-}{-}{-}{-}{-}{-}{-}{-}
     *	5{-}{-}{-}{-}{-}{-}{-}{-}
     *	6{-}{-}{-}{-}{-}{-}{-}{-}
     *	7{-}{-}{-}{-}{-}{-}{-}{-}
     *	8{-}{-}{-}{-}{-}{-}{-}{-}
     * }</pre>
     * @param userOneBoard(String[][]; The array being made into the game board for user one)
     * @param userTwoBoard(String[][]; The array being made into the game board for user two)
     * @param oneHitBoard(String[][]; The array being made into the game board for user one to show hits on the enemy)
     * @param twoHitBoard(String[][]; The array being made into the game board for user two to show hits on the enemy)
     * @param columnLetters(char[]; An array of letters to be placed in the game board to be referenced to for column placement)
     * @param counter1(int; Used to be increased in a loop to test each index of an array)
     */
	public static void buildBoard(String[][] userOneBoard, String[][] userTwoBoard, String[][] oneHitBoard, String[][] twoHitBoard, char[] columnLetters, int counter1) {
		for(int j = 0; j < userOneBoard.length; j++) {
			userOneBoard[j][0] = Integer.toString(j);
		}

		for(int j = 0; j < userOneBoard[0].length; j += 3) {
			userOneBoard[0][j] = " ";
		}

		for(int j = 1; j < userOneBoard[0].length; j+= 3) {
			userOneBoard[0][j] = " ";
		}

		for(int j = 2; j < userOneBoard[0].length; j += 3) {
			userOneBoard[0][j] = Character.toString(columnLetters[counter1]);
			counter1++;
		}

		for(int i  = 1; i < userOneBoard.length; i++) {
			for(int j = 1; j < userOneBoard[0].length; j += 3) {
				userOneBoard[i][j] = "{";
			}
		}
		for(int i  = 1; i < userOneBoard.length; i++) {
			for(int j = 3; j < userOneBoard[0].length; j += 3) {
				userOneBoard[i][j] = "}";
			}
		}
		for(int i  = 1; i < userOneBoard.length; i++) {
			for(int j = 2; j < userOneBoard[0].length; j += 3) {
				userOneBoard[i][j] = "-";
			}
		}
        counter1 = 0;
		for(int j = 0; j < userTwoBoard.length; j++) {
			userTwoBoard[j][0] = Integer.toString(j);
		}

		for(int j = 0; j < userTwoBoard[0].length; j += 3) {
			userTwoBoard[0][j] = " ";
		}

		for(int j = 1; j < userTwoBoard[0].length; j+= 3) {
			userTwoBoard[0][j] = " ";
		}
		counter1 = 0;
		for(int j = 2; j < userTwoBoard[0].length; j += 3) {
			userTwoBoard[0][j] = Character.toString(columnLetters[counter1]);
			counter1++;
		}

		for(int i  = 1; i < userTwoBoard.length; i++) {
			for(int j = 1; j < userTwoBoard[0].length; j += 3) {
				userTwoBoard[i][j] = "{";
			}
		}
		for(int i  = 1; i < userTwoBoard.length; i++) {
			for(int j = 3; j < userTwoBoard[0].length; j += 3) {
				userTwoBoard[i][j] = "}";
			}
		}
		for(int i  = 1; i < userTwoBoard.length; i++) {
			for(int j = 2; j < userTwoBoard[0].length; j += 3) {
				userTwoBoard[i][j] = "-";
			}
		}
        counter1 = 0;
        for(int j = 0; j < oneHitBoard.length; j++) {
            oneHitBoard[j][0] = Integer.toString(j);
        }

        for(int j = 0; j < oneHitBoard[0].length; j += 3) {
            oneHitBoard[0][j] = " ";
        }

        for(int j = 1; j < oneHitBoard[0].length; j+= 3) {
            oneHitBoard[0][j] = " ";
        }

        for(int j = 2; j < oneHitBoard[0].length; j += 3) {
            oneHitBoard[0][j] = Character.toString(columnLetters[counter1]);
            counter1++;
        }

        for(int i  = 1; i < oneHitBoard.length; i++) {
            for(int j = 1; j < oneHitBoard[0].length; j += 3) {
                oneHitBoard[i][j] = "{";
            }
        }
        for(int i  = 1; i < oneHitBoard.length; i++) {
            for(int j = 3; j < oneHitBoard[0].length; j += 3) {
                oneHitBoard[i][j] = "}";
            }
        }
        for(int i  = 1; i < oneHitBoard.length; i++) {
            for(int j = 2; j < oneHitBoard[0].length; j += 3) {
                oneHitBoard[i][j] = "-";
            }
        }
        counter1 = 0;
        for(int j = 0; j < twoHitBoard.length; j++) {
            twoHitBoard[j][0] = Integer.toString(j);
        }

        for(int j = 0; j < twoHitBoard[0].length; j += 3) {
            twoHitBoard[0][j] = " ";
        }

        for(int j = 1; j < twoHitBoard[0].length; j+= 3) {
            twoHitBoard[0][j] = " ";
        }

        for(int j = 2; j < twoHitBoard[0].length; j += 3) {
            twoHitBoard[0][j] = Character.toString(columnLetters[counter1]);
            counter1++;
        }

        for(int i  = 1; i < twoHitBoard.length; i++) {
            for(int j = 1; j < twoHitBoard[0].length; j += 3) {
                twoHitBoard[i][j] = "{";
            }
        }
        for(int i  = 1; i < twoHitBoard.length; i++) {
            for(int j = 3; j < twoHitBoard[0].length; j += 3) {
                twoHitBoard[i][j] = "}";
            }
        }
        for(int i  = 1; i < twoHitBoard.length; i++) {
            for(int j = 2; j < twoHitBoard[0].length; j += 3) {
                twoHitBoard[i][j] = "-";
            }
        }
	}
	/** This method is used to clear the screen by printing out 20 blank lines
	 * <pre>Example: {@code clearScreen(); does: 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * Example End (20 blank lines above)} </pre>
	 */
	public static void clearScreen() {
		for(int i = 0; i < 20; i++) {
			System.out.println();
		}
	}
}
