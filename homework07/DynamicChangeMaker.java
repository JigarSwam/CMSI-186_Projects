/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * File name  :  DynamicChangeMaker.java
 * Purpose    :  Find the best
 * @author    :  Jigar Swaminarayan
 * Date       :  2017-24-17
 * Description:  Program to determine the most efficient amount of coins needed to
 *               add to a target value.
 * Notes      :  None
 * Warnings   :  None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

public class DynamicChangeMaker {
  public static int rowCount = 0;
  public static int columnCount = 0;
  public static Tuple result;

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method that takes an integer array of denominations and a integer that is the target value.
   *  @param denominations  Integer Array of the values used to add up to target value.
   *  @param target  Integer value of the intended total from the denominations
   * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
   public static void main(String[] args) {
     int[] denoms = new int[3];
     denoms[0] = 1;
     denoms[1] = 3;
     denoms[2] = 4;
     int tar = 9;
     System.out.println(makeChangeWithDynamicProgramming(denoms, tar));
   }

  public static Tuple makeChangeWithDynamicProgramming(int[] denominations, int target) {
    if ((denominations.length < 1) || (target < 0)) {
     throw new IllegalArgumentException();
   }
   for (int i = 0; i < denominations.length; i++) {
     if (denominations[i] < 1) {
       throw new IllegalArgumentException();
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
      return t[target][denominations.length - 1];
    }
  }
