/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * File name  :  DynamicChangeMaker.java
 * Purpose    :  Find the best
 * @author    :  Jigar Swaminarayan
 * Date       :  2017-24-17
 * Description:  Program to determine the most efficient amount of coins needed to
 *               add to a target value.
 * Notes      :  None
 * Warnings   :  None
 */

public class DynamicChangeMaker {
  public static int rowCount = 0;
  public static int columnCount = 0;
  public static Tuple result;

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method that takes an integer array of denominations and a integer that is the target value.
   *  @param denominations  Integer Array of the values used to add up to target value.
   *  @param target  Integer value of the intended total from the denominations
   * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  public static Tuple makeChangeWithDynamicProgramming(int[] denominations, int target) {
    rowCount = denominations.length;
    columnCount = target + 1;
    Tuple[][] t = new Tuple[rowCount][columnCount];
    Tuple denoms = new Tuple(denominations);

    for(int i = 0; i < rowCount; i++) {
      for(int j = 0; j < columnCount; j++) {
        if(j == 0) {
          t[i][j] = new Tuple(denoms.length());
        } else {
          if(denoms.getElement(i) > j) {
            t[i][j] = Tuple.IMPOSSIBLE;
            if(j >= denoms.getElement(i)) {
              if(t[i][j-denoms.getElement(i)].isImpossible()) {
                t[i][j] = Tuple.IMPOSSIBLE;
              } else {
                t[i][j].setElement(i, 1);
            }
          }
            if(i != 0) {
              if(t[i-1][j].isImpossible()) {
                t[i][j] = Tuple.IMPOSSIBLE;
              } else if(t[i-1][j].total() < t[i][j].total()) {
                t[i][j] = t[i-1][j];
              }
            }
          } else {
            t[i][j] = new Tuple(denoms.length());
            t[i][j].setElement(i, 1);
            if((j - denominations[i]) >= 0) {
              if(t[i][j-denoms.getElement(i)].isImpossible()) {
                t[i][j] = Tuple.IMPOSSIBLE;
              } else {
                t[i][j] = t[i][j-1];
              }
            }
            if(i != 0) {
              if(t[i-1][j].isImpossible()) {
                t[i][j] = t[i][j];
              } else if(t[i-1][j].total() < t[i][j].total()) {
                t[i][j] = t[i-1][j];
              }
            }
          }
        }
        result = t[i][j];
      }
    }
    return result;
  }
  // public String validate() {
  //   if(denominations)
  // }
}
