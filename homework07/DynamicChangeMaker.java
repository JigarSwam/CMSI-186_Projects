/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * File name  :  DynamicChangeMaker.java
 * Purpose    :  Find the best
 * @author    :  Jigar Swaminarayan
 * Date       :  2017-24-17
 * Description:
 * Notes      :  None
 * Warnings   :  None
 */

public class DynamicChangeMaker {
  public static int rowCount = 0;
  public static int columnCount = 0;

  public static String makeChangeWithDynamicProgramming(int[] denominations, int target) {
    rowCount = denominations.length;
    columnCount = target + 1;
    Tuple[][] theTable = new Tuple[rowCount][columnCount];

    return "";
  }
  // validating arguments methods
  // helper methods
}
