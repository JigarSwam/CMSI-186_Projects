/*
Author      : Jigar Swaminarayan
Date        : 2018-01-25
Class       : CMSI-186 Programming Lab
Warnings    : None
Description : Program with multiple Java String methods in order to get familar with Java Strings.
*/

import java.util.Set;
import java.util.LinkedHashSet;

public class StringStuff {

  static String evenAlphabet = "BDFHJLNPRTVXZbdfhjlnprtvxz";
  static String oddAlphabet = "ACEGIKMOQSUWYacegikmoqsuwy";

  public static boolean containsVowel(String s) {
   if(s.contains("A") || s.contains("E") || s.contains("I") || s.contains("O") || s.contains("U") || s.contains("Y")) {
     return true;
   }
   else if(s.contains("a") || s.contains("e") || s.contains("i") || s.contains("o") || s.contains("u") || s.contains("y")) {
     return true;
   }
    return false;
 }

 public static boolean isPalindrome(String s) {
   boolean result = (s.equals(reverse(s))) ? true : false;
   return result;
 }

 public static String evensOnly(String s) {
   char[] newEvenAlpha = evenAlphabet.toCharArray();
   char[] originalString = s.toCharArray();
   String evenString = "";
   for(int i = 0; i < originalString.length; i++) {
     for(int j = 0; j < newEvenAlpha.length; j++) {
       if(originalString[i] == newEvenAlpha[j]) {
         evenString += originalString[i];
       }
     }
   }
   //System.out.println(evenString);
   return evenString;
 }

 public static String oddsOnly(String s) {
   char[] newOddAlpha = oddAlphabet.toCharArray();
   char[] originalString = s.toCharArray();
   String oddString = "";
   for(int i = 0; i < originalString.length; i++) {
     for(int j = 0; j < newOddAlpha.length; j++) {
       if(originalString[i] == newOddAlpha[j]) {
         oddString += originalString[i];
       }
     }
   }
   //System.out.println(oddString);
   return oddString;
 }

 public static String evensOnlyNoDupes(String s) {
   String even = evensOnly(s);
   String evensNoDupes = "";
   for(int i = 0; i < even.length(); i++) {
     if(evensNoDupes.indexOf(even.charAt(i)) == -1) {
       evensNoDupes += even.charAt(i);
     }
   }
   //System.out.println(evensNoDupes);
   return evensNoDupes;
 }

 public static String oddsOnlyNoDupes(String s) {
   String odd = oddsOnly(s);
   String oddsNoDupes = "";
   for(int i = 0; i < odd.length(); i++) {
     if(oddsNoDupes.indexOf(odd.charAt(i)) == -1) {
       oddsNoDupes += odd.charAt(i);
     }
   }
    System.out.println(oddsNoDupes);
    return oddsNoDupes;
 }

/**
 * Method to return the reverse of a string passed as an argument
 *
 * @param s String containing the data to be reversed
 * @return  String containing the reverse of the input string
 */
 public static String reverse(String s) {
   char letter[] = s.toCharArray();
   String reverseString = "";
   for(int i = letter.length-1; i >= 0; i--) {
     reverseString += letter[i];
   }

   return reverseString;
 }

/**
 * Main method to test the methods in this class
 *
 * @param args String array containing command line parameters
 */
 public static void main( String args[] ) {
    String blah = new String( "Blah blah blah" );
    String woof = new String( "BCDBCDBCDBCDBCD" );
    String pal1 = new String( "a" );
    String pal2 = new String( "ab" );
    String pal3 = new String( "aba" );
    String pal4 = new String( "amanaplanacanalpanama" );
    String pal5 = new String( "abba" );
    System.out.println( containsVowel( blah ) );
    System.out.println( containsVowel( woof ) );
    System.out.println( isPalindrome( pal1 ) );
    System.out.println( isPalindrome( pal2 ) );
    System.out.println( isPalindrome( pal3 ) );
    System.out.println( isPalindrome( pal4 ) );
    System.out.println( isPalindrome( pal5 ) );
    System.out.println( "evensOnly()        returns: " + evensOnly( "REHEARSALSZ" ) );
    System.out.println( "evensOnly()        returns: " + evensOnly( "REhearSALsz" ) );
    System.out.println( "evensOnlyNoDupes() returns: " + evensOnlyNoDupes( "REhearSALsz" ) );
    System.out.println( "oddsOnly()         returns: " + oddsOnly( "xylophones" ) );
    System.out.println( "oddsOnly()         returns: " + oddsOnly( "XYloPHonES" ) );
    System.out.println( "oddsOnlyNoDupes()  returns: " + oddsOnlyNoDupes( "XYloPHonES" ) );
    System.out.println( "reverse()          returns: " + reverse( "REHEARSALSZ" ) );
 }
}
