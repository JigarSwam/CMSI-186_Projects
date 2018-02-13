/*
Original Author : B.J. Johnson
Modified By     : Jigar Swaminarayan
File Name       : DiceSet.java
Date            : 2018-01-25
Class           : CMSI-186 Programming Lab
Warnings        : None
Description     : Functions that describe a set of dice
*/

public class DiceSet {

   private int count;
   private int sides;
   private Die[] ds = null;

   // public constructor:
  /**
   * constructor
   * @param  count int value containing total dice count
   * @param  sides int value containing the number of pips on each die
   * @throws IllegalArgumentException if one or both arguments don't make sense
   * @note   parameters are checked for validity; invalid values throw "IllegalArgumentException"
   */
   public DiceSet(int count, int sides) {
     this.count = count;
     this.sides = sides;
     ds = new Die[count];
     for(int i = 0; i < count; i++) {
       ds[i] = new Die(sides);
     }
   }

  /**
   * @return the sum of all the dice values in the set
   * roll each die and add values
   */
   public int sum() {
      return 0;
   }

  /**
   * Randomly rolls all of the dice in this set
   *  NOTE: you will need to use one of the "toString()" methods to obtain
   *  the values of the dice in the set
   */
   public void roll() {
     for(int i = 0; i < ds.length - 1; i++) {
       String values = ds[i].roll().toString();
     }
     System.out.println(values);
   }

  /**
   * Randomly rolls a single die of the dice in this set indexed by 'dieIndex'
   * @param  dieIndex int of which die to roll
   * @return the integer value of the newly rolled die
   * @trhows IllegalArgumentException if the index is out of range
   */
   public int rollIndividual(int dieIndex) {
      return 0;
   }

  /**
   * Gets the value of the die in this set indexed by 'dieIndex'
   * @param  dieIndex int of which die to roll
   * @trhows IllegalArgumentException if the index is out of range
   */
   public int getIndividual(int dieIndex) {
      return -999;
   }

  /**
   * @return Public Instance method that returns a String representation of the DiceSet instance
   */
   public String toString() {
      String result = "";
      return result;
   }

  /**
   * @return Class-wide version of the preceding instance method
   */
   public static String toString(DiceSet ds) {
      return "";
   }

  /**
   * @return  tru iff this set is identical to the set passed as an argument
   */
   public boolean isIdentical(DiceSet ds) {
      return true;
   }
  /**
   * A little test main to check things out
   */
   public static void main( String[] args ) {
      // You do this part!
   }

}
