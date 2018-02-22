/*
Author      : Jigar Swaminarayan
File Name   : HighRoll.java
Date        : 2018-01-25
Class       : CMSI-186 Programming Lab
Warnings    : None
Description : Die rolling game
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class HighRoll{
  private static int sum = 0;
  private static int highScore = 0;

   public static void main( String args[] ) {
      System.out.println( "\n   Welcome to High Roll!\n" );
      DiceSet dSet = new DiceSet(Integer.parseInt(args[0]), Integer.parseInt(args[1]));

     // This line uses the two classes to assemble an "input stream" for the user to type
     // text into the program
      BufferedReader input = new BufferedReader( new InputStreamReader( System.in ) );
      while( true ) {
        System.out.println( "Press the 'q' key to quit the program." );
        System.out.println("Press '1' to roll all the die! ");
        System.out.println("Press '2' to role one die. ");
        System.out.println("Press '3' to calculate the score of all the die. ");
        System.out.println("Press '4' to save the score as a high score. ");
        System.out.println("Press '5' to display the high score. ");

         System.out.print( ">> " );
         String inputLine = null;
         try {
            inputLine = input.readLine();
            if( 0 == inputLine.length() ) {
               System.out.println("enter some text!:");
            }
            System.out.println( "   You typed: " + inputLine );
            if( 'q' == inputLine.charAt(0) ) {
               break;
            }
            else if ('1' == inputLine.charAt(0)) {
              dSet.roll();
            }
            else if('2' == inputLine.charAt(0)) {
              try{
                System.out.println("Which die do you want to roll? ");
                System.out.println(dSet.rollIndividual(Integer.parseInt(input.readLine())));
              }
              catch( IOException ioe ) {
                 System.out.println( "Caught IOException" );
               }
            }
            else if('3' == inputLine.charAt(0)) {
              sum = dSet.sum();
              System.out.println(sum);
            }
            else if('4' == inputLine.charAt(0)) {
              highScore = sum;
            }
            else if('5' == inputLine.charAt(0)) {
              System.out.println(sum);
            }
         }
         catch( IOException ioe ) {
            System.out.println( "Caught IOException" );
         }
      }
   }
}
