/********************************************
*	AUTHOR:	Kaan Kocaman
* COLLABORATORS: None
*	LAST MODIFIED:	3/25/2026
********************************************/

/********************************************
*	Quipu
*********************************************
*	PROGRAM DESCRIPTION:
*	A user will enter a number between 0 and 999 and this program will display the number as a quipu.
*********************************************
*	ALGORITHM:
*	1. Display intro message
*	2. Ask user for a number (0–999)
*	3. Validate input using a loop
*	4. Break number into hundreds, tens, ones
*	5. Print values
*	6. Call method to display quipu
*	7. Ask user if they want to repeat
*	8. Loop until user quits
*********************************************/

import java.util.Scanner;

public class Main
{

  /***** CONSTANT SECTION *****/
  public static final int WIDTH = 30;

  public static void main(String[] args)
  {
    /***** DECLARATION SECTION *****/
    Scanner input = new Scanner(System.in);
    int number;
    char choice = 'y';

    /***** INTRO SECTION *****/
    System.out.println("Hello! This program turns any whole number between 0 and 999 into a digital Quipu.\n");

    /***** PROCESS LOOP *****/
    while (choice == 'y' || choice == 'Y')
    {
      /***** INPUT SECTION *****/
      System.out.print("Please enter a number between 0 and 999: ");
      number = input.nextInt();

      // validation loop
      while (number < 0 || number > 999)
      {
        System.out.println("ERROR: please enter value between 0 - 999\n");
        System.out.print("Please enter a number between 0 and 999: ");
        number = input.nextInt();
      }

      /***** PROCESSING SECTION *****/
      int hundreds = number / 100;
      int tens = (number / 10) % 10;
      int ones = number % 10;

      /***** OUTPUT SECTION *****/
      System.out.println("\nHundreds   = " + hundreds);
      System.out.println("Tens       = " + tens);
      System.out.println("Ones       = " + ones);

      printQuipu(hundreds, tens, ones);

      System.out.print("\nWould you like to make another quipu? [Y/N]: ");
      choice = input.next().charAt(0);
      System.out.println();
    }

    System.out.println("Goodbye!");
  }

  /***** STATIC METHODS *****/

  // prints vertical knots
  public static void printKnots(int count)
  {
    for (int i = 0; i < count; i++)
    {
      UtilityBelt.printCentered(WIDTH, "*");
    }
  }

  // prints full quipu
  public static void printQuipu(int hundreds, int tens, int ones)
  {
    System.out.println("\nYour quipu:");

    UtilityBelt.printCentered(WIDTH, "___");

    // hundreds
    UtilityBelt.printCentered(WIDTH, "|");
    printKnots(hundreds);

    // tens
    UtilityBelt.printCentered(WIDTH, "|");
    printKnots(tens);

    // ones
    UtilityBelt.printCentered(WIDTH, "|");
    printKnots(ones);

    // bottom
    UtilityBelt.printCentered(WIDTH, "|");
    UtilityBelt.printCentered(WIDTH, "\u203E");
  }
}
