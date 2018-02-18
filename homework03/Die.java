/*
Original Author : B.J. Johnson
Modified By     : Jigar Swaminarayan
File Name       : Die.java
Date            : 2018-01-25
Class           : CMSI-186 Programming Lab
Warnings        : None
Description     : Data fields and methods to describe a single game die
*/

public class Die {

  /**
   * private instance data
   */
   private int sides;
   private int pips;
   private final int MINIMUM_SIDES = 4;

  /**
   * constructor
   * @param nSides int value containing the number of sides to build on THIS Die
   * @throws       IllegalArgumentException
   * Note: parameter must be checked for validity; invalid value must throw "IllegalArgumentException"
   */
   public Die(int nSides) throws IllegalArgumentException {
     if(nSides < 4) {throw new IllegalArgumentException();}
     sides = nSides;
   }

  /**
   * Roll THIS die and return the result
   * @return  integer value of the result of the roll, randomly selected
   */
   public int roll() {
     pips = (int) (Math.random() * this.sides) + 1;
     return pips;
   }

  /**
   * Get the value of THIS die to return to the caller; note that the way
   *  the count is determined is left as a design decision to the programmer
   *  For example, what about a four-sided die - which face is considered its
   *  "value"?
   * @return the pip count of THIS die instance
   */
   public int getValue() {
     return this.pips;
   }

  /**
   * @param  int  the number of sides to set/reset for this Die instance
   * @return      The new number of sides, in case anyone is looking
   * @throws      IllegalArgumentException
   */
   public int setSides(int sides) throws IllegalArgumentException {
     if(sides < 4) {throw new IllegalArgumentException();}
      this.sides = sides;
      return sides;
   }

  /**
   * Public Instance method that returns a String representation of THIS die instance
   * @return String representation of this Die
   */
   public String toString() {
     String stringify = "[" + pips + "]";
      return stringify;
   }

  /**
   * Class-wide method that returns a String representation of THIS die instance
   * @return String representation of this Die
   */
   public static String toString(Die d) {
      return d.toString();
   }

}
