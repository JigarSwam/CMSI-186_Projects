/*
Original Author : Jigar Swaminarayan
File Name       : DieSetTester.java
Date            : 2018-02-15
Class           : CMSI-186 Programming Lab
Warnings        : None
Description     : Tests for DieSet.java methods
*/
public class DiceSetTester {

  public static void main ( String [] args ) {
    DiceSet ds = null;

    try{ds = new DiceSet(1, 1);}
    catch (IllegalArgumentException iae) {System.out.println ("Too few sides requested to constructor...");}

    try{ds = new DiceSet(2, 2);}
    catch (IllegalArgumentException iae) {System.out.println ("Too few sides requested to constructor...");}

    try{ds = new DiceSet(3, 3);}
    catch (IllegalArgumentException iae) {System.out.println ("Too few sides requested to constructor...");}


    try{ds = new DiceSet(4, 4);}
    catch (IllegalArgumentException iae) {System.out.println ("Too few sides or too few die requested to constructor...");}
    System.out.println("roll() test for 4 die with 4 sides");
    System.out.println("You rolled " + ds.toString());
    System.out.println("Your value is " + ds.sum());
    System.out.println("An individual role of the first die " + ds.rollIndividual(0));
    System.out.println("An individual value of that role is " + ds.getIndividual(0));
    System.out.println("An individual role of the sixth die, should be error " + ds.rollIndividual(5));

  }

}
