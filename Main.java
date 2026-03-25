/********************************************
*	AUTHOR:	Kaan Kocaman
* COLLABORATORS: None
*	LAST MODIFIED:	3/25/2026
********************************************/

import java.util.Scanner;

public class Main
{
  public static final int WIDTH = 30;

  public static void main(String[] args)
  {
    Scanner input = new Scanner(System.in);

    int number = 0;
    char choice = 'y';

    System.out.println("Hello! This program turns any whole number between 0 and 999 into a digital Quipu.");

    while (choice == 'y' || choice == 'Y')
    {
      System.out.print("\nPlease enter a number between 0 and 999: ");
      number = input.nextInt();

      while (number < 0 || number > 999)
      {
        System.out.println("ERROR: please enter value between 0 - 999");
        System.out.print("Please enter a number between 0 and 999: ");
        number = input.nextInt();
      }

      int hundreds = number / 100;
      int tens = (number / 10) % 10;
      int ones = number % 10;

      printQuipu(hundreds, tens, ones);

      System.out.print("\nWould you like to make another quipu? [Y/N]: ");
      choice = input.next().charAt(0);
    }

    System.out.println("\nGoodbye!");
  }

  public static void printKnots(int count)
  {
    for (int i = 0; i < count; i++)
    {
      UtilityBelt.printCentered(WIDTH, "*");
    }
  }

  public static void printQuipu(int hundreds, int tens, int ones)
  {
    System.out.println("\nYour quipu:");

    UtilityBelt.printCentered(WIDTH, "___");

    UtilityBelt.printCentered(WIDTH, "|");
    printKnots(hundreds);

    UtilityBelt.printCentered(WIDTH, "|");
    printKnots(tens);

    UtilityBelt.printCentered(WIDTH, "|");
    printKnots(ones);

    UtilityBelt.printCentered(WIDTH, "|");
    UtilityBelt.printCentered(WIDTH, "\u203E");
  }
}
