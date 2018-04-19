/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * File name   :  BrobInt.java
 * Purpose     :  Learning exercise to implement arbitrarily large numbers and their operations
 * @author     :  B.J. Johnson
 * Modified By :  Jigar Swaminarayan
 * Date        :  2017-03-27
 * Description :  @see <a href='http://bjohnson.lmu.build/cmsi186web/homework06.html'>Assignment Page</a>
 * Notes       :  None
 * Warnings    :  None
 *
 */
import java.util.Arrays;

public class BrobInt {

   public static BrobInt ZERO     = new BrobInt(  "0" );      // Constant for "zero"
   public static BrobInt ONE      = new BrobInt(  "1" );      // Constant for "one"
   public static BrobInt TWO      = new BrobInt(  "2" );      // Constant for "two"
   public static BrobInt THREE    = new BrobInt(  "3" );      // Constant for "three"
   public static BrobInt FOUR     = new BrobInt(  "4" );      // Constant for "four"
   public static BrobInt FIVE     = new BrobInt(  "5" );      // Constant for "five"
   public static BrobInt SIX      = new BrobInt(  "6" );      // Constant for "six"
   public static BrobInt SEVEN    = new BrobInt(  "7" );      // Constant for "seven"
   public static BrobInt EIGHT    = new BrobInt(  "8" );      // Constant for "eight"
   public static BrobInt NINE     = new BrobInt(  "9" );      // Constant for "nine"
   public static BrobInt TEN      = new BrobInt( "10" );      // Constant for "ten"

  /// Some constants for other intrinsic data types
  ///  these can help speed up the math if they fit into the proper memory space
  //  public static BrobInt MAX_INT  = new BrobInt( new Integer( Integer.MAX_VALUE ).toString() );
  //  public static BrobInt MIN_INT  = new BrobInt( new Integer( Integer.MIN_VALUE ).toString() );
  //  public static BrobInt MAX_LONG = new BrobInt( new Long( Long.MAX_VALUE ).toString() );
  //  public static BrobInt MIN_LONG = new BrobInt( new Long( Long.MIN_VALUE ).toString() );

  /// These are the internal fields
   public String internalValue = "";        // internal String representation of this BrobInt
   public byte   sign          = 0;         // "0" is positive, "1" is negative
   public String reversed      = "";        // the backwards version of the internal String representation
   public byte[] byteVersion   = null;      // byte array for storing the string values; uses the reversed string

   public boolean isNeg;

  /**
   *  Constructor takes a string and assigns it to the internal storage, checks for a sign character
   *   and handles that accordingly;  it then checks to see if it's all valid digits, and reverses it
   *   for later use
   *  @param  value  String value to make into a BrobInt
   */
   public BrobInt(String value) {
     internalValue = value;
     if(value.charAt(0) == '-') {
       value = value.replace("-", "");
       sign = 1;
     }
     else {
       sign = 0;
       value = value.replace("+", "");
     }
       byteVersion = new byte[value.length()];
       int index = 0;
       for(int i = value.length()-1; i >= 0; i--) {
         byteVersion[index] = (byte)(value.charAt(i) - 48);
         reversed += value.charAt(i);
         index++;
       }
       validateDigits();
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to validate that all the characters in the value are valid decimal digits
   *  @return  boolean  true if all digits are good
   *  @throws  IllegalArgumentException if something is hinky
   *  note that there is no return false, because of throwing the exception
   *  note also that this must check for the '+' and '-' sign digits
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public boolean validateDigits() throws IllegalArgumentException {
     for(byte b : byteVersion) {
       if(b > 9 || b < 0) {
         throw new IllegalArgumentException("Invalid Digit(s)");
       }
     }
     return true;
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to reverse the value of this BrobInt
   *  @return BrobInt that is the reverse of the value of this BrobInt
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public void reverser() {
     reversed = new StringBuffer(internalValue).reverse().toString();
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to reverse the value of a BrobIntk passed as argument
   *  Note: static method
   *  @param  gint         BrobInt to reverse its value
   *  @return BrobInt that is the reverse of the value of the BrobInt passed as argument
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public static BrobInt reverser(BrobInt gint) {
     String strgint = gint.toString();
     char letter[] = strgint.toCharArray();
     String reverseString = "";
     for(int i = letter.length-1; i >= 0; i--) {
       reverseString += letter[i];
     }
     return new BrobInt(reverseString);
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to add the value of a BrobIntk passed as argument to this BrobInt using byte array
   *  @param  gint         BrobInt to add to this
   *  @return BrobInt that is the sum of the value of this BrobInt and the one passed in
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public BrobInt addByte(BrobInt gint) {
     String result = "";
     BrobInt isBigger;
     BrobInt isSmaller;
     byte carry = 0;

     isBigger = (Math.max(this.byteVersion.length, gint.byteVersion.length) == this.byteVersion.length) ? this : gint;
     isSmaller = (Math.max(this.byteVersion.length, gint.byteVersion.length) == this.byteVersion.length) ? gint : this;

     byte[] total = new byte[isBigger.byteVersion.length + 1];

     if(gint.sign == this.sign) {
       for(int i = 0; i < isBigger.byteVersion.length; i++) {
         if(i < isSmaller.byteVersion.length) {
           total[i] = (byte)((isBigger.byteVersion[i] + isSmaller.byteVersion[i] + carry) % 10);
           carry = isBigger.byteVersion[i] + isSmaller.byteVersion[i] + carry > 9 ? (byte)1 : (byte)0;
         }
         else {
           total[i] = (byte)((isBigger.byteVersion[i] + carry) % 10);
           carry = isBigger.byteVersion[i] + carry > 9 ? (byte)1 : (byte)0;
         }
        }
        if(carry > 0) {
          total[total.length - 1] = carry;
        }
        for(int i = total.length-1; i >= 0; i--) {
          result += total[i];
        }
        result = result.replaceAll("^0+(?!$)", "");
        if(gint.sign == 1) {
          result = "-" + result;
       }
     }
     return new BrobInt(result);
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to subtract the value of a BrobIntk passed as argument to this BrobInt using bytes
   *  @param  gint         BrobInt to subtract from this
   *  @return BrobInt that is the difference of the value of this BrobInt and the one passed in
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public BrobInt subtractByte(BrobInt gint) {
     String result = "";

     byte big = (byte)(this.bigger(gint));
     byte borrowChecker = 0;
     BrobInt bigger;
     BrobInt smaller;

     BrobInt copy1 = new BrobInt(this.toString());
     BrobInt copy2 = new BrobInt(gint.toString());

     if(big >= 0) {
       bigger = new BrobInt(this.toString());
       smaller = new BrobInt(gint.toString());
     } else {
       bigger = new BrobInt(gint.toString());
       smaller = new BrobInt(this.toString());

       if (bigger.sign == 0) {
               bigger.sign = 1;
           } else {
               bigger.sign = 0;
           }
     }

     byte[] difference = new byte[bigger.byteVersion.length + 1];

     if(copy2.sign == 1 && copy1.sign == 0) {
       copy2.sign = 0;
       return copy1.addByte(copy2);
     }

     if(copy1.sign == 1 && copy2.sign == 0) {
       copy2.sign = 1;
       return copy1.addByte(copy2);
     }

       for(int i = 0; i < bigger.byteVersion.length; i++) {
         if(i < smaller.byteVersion.length) {
           borrowChecker = (byte)(bigger.byteVersion[i] - smaller.byteVersion[i]);
           if(borrowChecker < 0) {
             bigger.byteVersion[i+1] = (byte)(bigger.byteVersion[i+1] - 1);
             bigger.byteVersion[i] = (byte)(bigger.byteVersion[i] + 10);
             difference[i] = (byte)(bigger.byteVersion[i] - smaller.byteVersion[i]);
           } else {
             difference[i] = borrowChecker;
           }
         } else {
           difference[i] = bigger.byteVersion[i];
         }
       }
       for(int i = difference.length-1; i >= 0; i--) {
         result += difference[i];
       }
        result = result.replaceAll("^0+(?!$)", "");
        if (bigger.sign == 1) {
          result = '-' + result;
        }
        return new BrobInt(result);
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to multiply the value of a BrobIntk passed as argument to this BrobInt
   *  @param  gint         BrobInt to multiply by this
   *  @return BrobInt that is the product of the value of this BrobInt and the one passed in
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public BrobInt multiply(BrobInt gint) {
     String result = "";
     byte carry = 0;

     if(this.sign != gint.sign) {
       result += '-';
     }
     byte[] a;
     byte[] b;

     if(this.byteVersion.length > gint.byteVersion.length) {
       a = new byte[this.byteVersion.length];
       b = new byte[gint.byteVersion.length];

       for(int i = 0; i < this.byteVersion.length; i++) {
         a[i] = this.byteVersion[i];
       }
       for(int i = 0; i < gint.byteVersion.length; i++) {
         b[i] = gint.byteVersion[i];
       }
     } else {
       a = new byte[gint.byteVersion.length];
       b = new byte[this.byteVersion.length];

       for(int i = 0; i < gint.byteVersion.length; i++) {
         a[i] = gint.byteVersion[i];
       }
       for(int i = 0; i < this.byteVersion.length; i++) {
         b[i] = this.byteVersion[i];
       }
     }

  byte[] product = new byte[a.length + b.length + 1];
  for(int i = 0; i < product.length; i++) {
    product[i] = 0;
  }

  for(int i = 0; i < b.length; i++) {
    int k = i;
    for(int j = 0; j < a.length; j++) {
      product[k] = (byte)((a[j] * b[i]) + product[k]);
      if(product[k] > 9) {
        carry = (byte)(product[k] / 10);
        product[k] = (byte)(product[k] % 10);
      } else {
        carry = 0;
      }
      product[k+1] += carry;
      k++;
    }
  }

  for(int i = product.length-1; i >= 0; i--) {
    result += product[i];
  }
  result = result.replaceAll("^0+(?!$)", "");
  return new BrobInt(result);
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to divide the value of this BrobIntk by the BrobInt passed as argument
   *  @param  gint         BrobInt to divide this by
   *  @return BrobInt that is the dividend of this BrobInt divided by the one passed in
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public BrobInt divide(BrobInt gint) {
      throw new UnsupportedOperationException( "\n         Sorry, that operation is not yet implemented." );
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to get the remainder of division of this BrobInt by the one passed as argument
   *  @param  gint         BrobInt to divide this one by
   *  @return BrobInt that is the remainder of division of this BrobInt by the one passed in
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public BrobInt remainder(BrobInt gint) {
      throw new UnsupportedOperationException( "\n         Sorry, that operation is not yet implemented." );
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to compare a BrobInt passed as argument to this BrobInt
   *  @param  gint  BrobInt to add to this
   *  @return int   that is one of neg/0/pos if this BrobInt precedes/equals/follows the argument
   *  NOTE: this method performs a lexicographical comparison using the java String "compareTo()" method
   *        THAT was easy.....
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public int compareTo(BrobInt gint) {
      return (internalValue.compareTo(gint.toString()));
   }

/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Helper method to compare BrobInt passed as argument to this BrobInt
 * @param gint BrobInt to compare to this
 * @return int that is either -1/0/1 depending on which value is bigger
 * NOTE: -1 if gint is bigger, 0 if equal, 1 if this is bigger
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public int bigger(BrobInt gint) {
     if(this.byteVersion.length > gint.byteVersion.length) {
       return 1;
     }
     if(this.byteVersion.length < gint.byteVersion.length) {
       return -1;
     }
     if(this.byteVersion.length == gint.byteVersion.length) {
       for(int i = 0; i < this.byteVersion.length; i++) {
         if(this.byteVersion[i] > gint.byteVersion[i]) {
           return 1;
         }
         if(this.byteVersion[i] < gint.byteVersion[i]) {
           return -1;
         }
       }
     }
     return 0;
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to check if a BrobInt passed as argument is equal to this BrobInt
   *  @param  gint     BrobInt to compare to this
   *  @return boolean  that is true if they are equal and false otherwise
   *  NOTE: this method performs a similar lexicographical comparison as the "compareTo()" method above
   *        also using the java String "equals()" method -- THAT was easy, too..........
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public boolean equals( BrobInt gint ) {
      return (internalValue.equals(gint.toString()));
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to return a BrobInt given a long value passed as argument
   *  @param  value         long type number to make into a BrobInt
   *  @return BrobInt  which is the BrobInt representation of the long
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public static BrobInt valueOf(long value) throws NumberFormatException {
      BrobInt gi = null;
      try {
         gi = new BrobInt(new Long(value).toString());
      }
      catch(NumberFormatException nfe) {
         System.out.println( "\n  Sorry, the value must be numeric of type long." );
      }
      return gi;
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to return a String representation of this BrobInt
   *  @return String  which is the String representation of this BrobInt
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public String toString() {
      String byteVersionOutput = "";
      for( int i = 0; i < byteVersion.length; i++ ) {
         byteVersionOutput = byteVersionOutput.concat( Byte.toString( byteVersion[i] ) );
      }
      byteVersionOutput = new String( new StringBuffer( byteVersionOutput ).reverse() );
      return internalValue;
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to display an Array representation of this BrobInt as its bytes
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public void toArray(byte[] d) {
      System.out.println( Arrays.toString( d ) );
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  the main method redirects the user to the test class
   *  @param  args  String array which contains command line arguments
   *  note:  we don't really care about these
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public static void main(String[] args) {

     System.out.println( "\n  Hello, world, from the BrobInt program!!\n" );
     System.out.println( "\n   You should run your tests from the BrobIntTester...\n" );

      System.exit( 0 );
   }
}
