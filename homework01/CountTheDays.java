
/*
Author      : Jigar Swaminarayan
Date        : 2018-01-18
Class       : CMSI-186 Programming Lab
Warnings    : None
Description : Program which counts number of days between two dates.
*/

public class CountTheDays {

  public static void main (String [] args) {
    long[] makeLong = new long[6];
    for(int i = 0; i < 6; i++) {
      makeLong[i] = Long.parseLong(args[i]);
    }
    System.out.println(CalendarStuff.daysBetween(makeLong[0], makeLong[1], makeLong[2], makeLong[3], makeLong[4], makeLong[5]));
  }
}
