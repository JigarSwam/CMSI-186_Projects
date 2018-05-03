/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * File name  :  DynamicChangeMaker.java
 * Purpose    :  Find the most efficient assortment of coins in order to get the target amount.
 * @author    :  Jigar Swaminarayan
 * Date       :  2017-24-17
 * Description:  Program to determine the most efficient amount of coins needed to
 *               add to a target value.
 * Notes      :  None
 * Warnings   :  None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

public class DynamicChangeMaker {

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method that takes an integer array of denominations and a integer that is the target value.
   *  @param denominations  Integer Array of the values used to add up to target value.
   *  @param target  Integer value of the intended total from the denominations
   * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

  public static Tuple makeChangeWithDynamicProgramming(int[] denominations, int target) {
    if ((denominations.length < 1) || (target < 0)) {
     System.out.println("BAD DATA: No Coins Found OR Target is negative");
     return Tuple.IMPOSSIBLE;
   }
   for (int i = 0; i < denominations.length; i++) {
     if (denominations[i] < 1) {
       System.out.println("BAD DATA: Invalid denominations");
       return Tuple.IMPOSSIBLE;
     }
   }
   for (int i = 0; i < denominations.length; i++) {
     for (int j = i + 1; j < denominations.length; j++) {
       if(denominations[i] == denominations[j]) {
         System.out.println("BAD DATA: Repeat Denominations");
         return Tuple.IMPOSSIBLE;
       }
     }
   }


   Tuple[][] t = new Tuple[target + 1][denominations.length];

   for (int row = 0; row < t[0].length; row ++) {
        for (int col = 0; col < t.length; col++) {
          t[col][row] = new Tuple(0);
          if (col == 0) {
            t[col][row] = new Tuple(denominations.length);
          }
          else if (col >= denominations[row]) {
            t[col][row] = new Tuple(denominations.length);
            t[col][row].setElement(row, 1);
            if (t[col - denominations[row]][row].length() != 0) {
              t[col][row] = t[col][row].add(t[col - denominations[row]][row]);
            } else {
              t[col][row] = new Tuple(0);
            }
          }
          if (row > 0) {
            if ( (col < denominations[row]) ||
                 (t[col][row].length() == 0) ||
                 ( (t[col][row - 1].total() < t[col][row].total()) &&
                   (t[col][row - 1].length() != 0) ) ) {
              t[col][row] = t[col][row - 1];
            }
          }
        }
      }
      if(t[target][denominations.length -1].length() == 0) {
        return Tuple.IMPOSSIBLE;
      } else {
        return t[target][denominations.length - 1];
      }
    }
  }
