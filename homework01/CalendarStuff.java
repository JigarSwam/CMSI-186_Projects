
/*
Author      : Jigar Swaminarayan
Date        : 2018-01-18
Class       : CMSI-186 Programming Lab
Warnings    : None
Description : Program which determines leap year, valid dates, days in a month
              and number of days between two dates.
*/

public class CalendarStuff {

 private static final int SUNDAY = 1;
 private static final int MONDAY = SUNDAY + 1;
 private static final int TUESDAY = MONDAY + 1;
 private static final int WEDNESDAY = TUESDAY + 1;
 private static final int THURSDAY = WEDNESDAY + 1;
 private static final int FRIDAY = THURSDAY + 1;
 private static final int SATURDAY = FRIDAY + 1;

 private static final int JANUARY = 1;
 private static final int FEBRUARY = JANUARY + 1;
 private static final int MARCH = FEBRUARY + 1;
 private static final int APRIL = MARCH + 1;
 private static final int MAY = APRIL + 1;
 private static final int JUNE = MAY + 1;
 private static final int JULY = JUNE + 1;
 private static final int AUGUST = JULY + 1;
 private static final int SEPTEMBER = AUGUST + 1;
 private static final int OCTOBER = SEPTEMBER + 1;
 private static final int NOVEMBER = OCTOBER + 1;
 private static final int DECEMBER = NOVEMBER + 1;

 private static int[] days = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

 public CalendarStuff(long day, long month, long year) {
    System.out.println( "Constructor called..." );  // replace this with the actual code
 }

  public static boolean isLeapYear(long year) {
      return ((year % 4 == 0) && (((year % 100 != 0) || (year % 400 == 0))));
  }

  public static long daysInMonth(long month, long year) {
      if(month == FEBRUARY && isLeapYear(year)) {
        return days[(int)month] + 1;
      }
      return days[(int)month];
   }

  public static boolean dateEquals(long month1, long day1, long year1, long month2, long day2, long year2) {
     if(year2 != year1) {
       return false;
     }
     if(month2 != month1) {
       return false;
     }
     if(day2 != day1) {
       return false;
     }
     return true;
  }

// returns -1 when date1 < date2, 0 when equal, 1 when date1 > date2
  public static int compareDate(long month1, long day1, long year1, long month2, long day2, long year2) {
      int result = (int)(year1 - year2);
      if(result == 0) {
        result = (int)(month1 - month2);
        if(result == 0) {
          result = (int)(day1 - day2);
        }
      }
      if(result < 0) {
        return -1;
      }
      else if(result > 0) {
        return 1;
      }
      else {
        return 0;
      }
   }

  public static boolean isValidDate(long month, long day, long year) {
    int isLeap = 0;
    if(month < 1 || month > 12) {
      return false;
    }
    if(year <= 0) {
      return false;
    }
    if(month == FEBRUARY && isLeapYear(year)) {
      isLeap = 1;
      }
    if(day <= 0 || day > days[(int)month] + isLeap) {
      return false;
    }
    return true;
  }

  public static String toMonthString(int month) {
      String monthString = "";
      switch(month) {
        case 1: monthString = "January"; break;
        case 2: monthString = "February"; break;
        case 3: monthString = "March"; break;
        case 4: monthString = "April"; break;
        case 5: monthString = "May"; break;
        case 6: monthString = "June"; break;
        case 7: monthString = "July"; break;
        case 8: monthString = "August"; break;
        case 9: monthString = "September"; break;
        case 10: monthString = "October"; break;
        case 11: monthString = "November"; break;
        case 12: monthString = "December"; break;
        default: throw new IllegalArgumentException("Illegal month value given to 'toMonthString()'.");
      }
      return monthString;
   }

   public static String toDayOfWeekString(int day) {
     String dayString = "";
     switch(day) {
       case 1: dayString = "Sunday"; break;
       case 2: dayString = "Monday"; break;
       case 3: dayString = "Tuesday"; break;
       case 4: dayString = "Wednesday"; break;
       case 5: dayString = "Thursday"; break;
       case 6: dayString = "Friday"; break;
       case 7: dayString = "Saturday"; break;
       default: throw new IllegalArgumentException("Illegal month value given to 'toMonthString()'.");
     }
     return dayString;
  }

  public static long daysBetween(long month0, long day0, long year0, long month1, long day1, long year1) {
      int daysInBetween = 0;
      int amountLeapYear = 0;
      int result = compareDate(month0, day0, year0, month1, day1, year1);
      // -1 when date0 < date1 0 when equal, 1 when date0 > date1
      if(result == 0) {
        return daysInBetween;
      }
      else if(result == -1) {
        daysInBetween += 365*((int)(year1 - year0));
        for(long i = year0; i <= year1; i++) {
          if(isLeapYear(i)) {
            amountLeapYear++;
          }
        }
        if(isLeapYear(year0) && month0 > FEBRUARY) { // If first date occurs after Feb. 29 on Leap year
            amountLeapYear--;
        }
        if(isLeapYear(year1) && month1 == FEBRUARY && day1 <= 28){ // If have not passed Feb 29 in second year, subract a day
              amountLeapYear--;
          }
        if(isLeapYear(year1) && month1 == JANUARY){ // If have not passed Feb. 29 in second year, subract a day
              amountLeapYear--;
          }
      }
      else if(result == 1) {
        daysInBetween += 365*((int)(year0 - year1));
        for(long i = year1; i < year0; i++) {
          if(isLeapYear(i)) {
            amountLeapYear++;
          }
        }
        if(isLeapYear(year1) && month1 > FEBRUARY) { // If first date occurs after Feb. 29 on Leap Year
            amountLeapYear--;
        }
        if(isLeapYear(year0) && month0 == FEBRUARY && day0 <= 28){ // If have not passed Feb. 29 in second year, subract a day
              amountLeapYear--;
          }
        if(isLeapYear(year0) && year0 == JANUARY){ // If have not passed Feb. 29 in second year, subract a day
              amountLeapYear--;
          }
      }
      daysInBetween += amountLeapYear;
      if(month1 == month0) {
        daysInBetween += 0;
      }
      else if(month1 > month0) {
        for(long i = month0; i < month1; i++) {
          daysInBetween += days[(int)i];
        }
      }
      else if(month1 < month0) {
        for(long i = month1; i < month0; i++) {
          daysInBetween -= days[(int)i];
        }
      }
      daysInBetween = (int)Math.abs((daysInBetween - day0 + day1));
      return daysInBetween;
  }
}
