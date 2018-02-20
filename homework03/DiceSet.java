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
     if(count < 1 || sides < 4) {throw new IllegalArgumentException();}
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
     int sum = 0;
     for(int i = 0; i < ds.length; i++) {
       sum += ds[i].roll();
     }
      return sum;
   }

  /**
   * Randomly rolls all of the dice in this set
   *  NOTE: you will need to use one of the "toString()" methods to obtain
   *  the values of the dice in the set
   */
   public void roll() {
    String result = "";
    for (int i=0; i < ds.length; i++){
      result += new Integer(ds[i].roll()).toString() + " ";
   }
   System.out.println(result);
  }

  /**
   * Randomly rolls a single die of the dice in this set indexed by 'dieIndex'
   * @param  dieIndex int of which die to roll
   * @return the integer value of the newly rolled die
   * @throws IllegalArgumentException if the index is out of range
   */
   public int rollIndividual(int dieIndex) {
     if(dieIndex > ds.length) {throw new IllegalArgumentException();}
      return ds[dieIndex].roll();
   }

  /**
   * Gets the value of the die in this set indexed by 'dieIndex'
   * @param  dieIndex int of which die to roll
   * @throws IllegalArgumentException if the index is out of range
   */
   public int getIndividual(int dieIndex) {
     if(dieIndex > ds.length) {throw new IllegalArgumentException();}
      return ds[dieIndex].getValue();
   }

  /**
   * @return Public Instance method that returns a String representation of the DiceSet instance
   */
   public String toString() {
      String result = "";
      for(int i = 0; i < ds.length - 1; i++) {
         result += new Integer(ds[i].roll()).toString() + " ";
      }
      return result;
   }

  /**
   * @return Class-wide version of the preceding instance method
   */
   public static String toString(DiceSet ds) {
      return ds.toString();
   }

  /**
   * @return  true iff this set is identical to the set passed as an argument
   */
   public boolean isIdentical(DiceSet ds) {
     return (ds.count == this.count) && (ds.sum() == this.sum()) && (ds.sides == this.sides);
   }

}
