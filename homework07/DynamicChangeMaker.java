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


  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method that takes an integer array of denominations and a integer that is the target value.
   *  @param denominations  Integer Array of the values used to add up to target value.
   *  @param target  Integer value of the intended total from the denominations
   * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  public static String makeChangeWithDynamicProgramming(int[] denominations, int target) {
    rowCount = denominations.length;
    columnCount = target + 1;
    Tuple[][] t = new Tuple[rowCount][columnCount];
    Tuple denoms = new Tuple(denominations);

    for(int i = 0; i < rowCount; i++) {
      for(int j = 0; j < columnCount; j++) {
        if(j == 0) {
          // the result thingy is <0,0>
        } else {
          if(denoms.getElement(i) > j) {
            t[i][j] = Tuple.IMPOSSIBLE;
            if(some_check_to_see_if_we_are_ABLE_to_look_backwards) {
              // if the cell looking backward is NOT an "IMPOSSIBLE", add it
            }
            if(i != 0) {
              // if the cell above is impossible, basically do nothing since
                    //  this the current cell is already IMPOSSIBLE

                    // else if the cell above has a total that is less than the current
                    //  cell, copy it down
            }
          }
        } else {
          // make a new tuple with a one in the current demonimation index
           if((j - denominations[i]) >= 0) {
             // if it's IMPOSSIBLE, mark the current cell IMPOSSIBLE, too
             // else, add the previous cell to the current cell
           }
           if( i != 0 ) {
             // if the cell above is impossible, basically do nothing since
             //  this the current cell is already IMPOSSIBLE
             // else if the cell above has a total that is less than the current
             //  cell, copy it down
           }
         }
       }
     }
   }
    return "";
  }
  // validating arguments methods
  // helper methods
}
