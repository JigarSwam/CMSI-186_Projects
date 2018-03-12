/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  Clock.java
 *  @author       :  B.J. Johnson
 *  Modified By   :  Jigar Swaminarayan
 *  Date written  :  2017-02-28
 *  Description   :  Class that had methods to be used for ClockSolver.java
 *  Warnings      :  None
 *  Exceptions    :  IllegalArgumentException when the input arguments are "hinky"
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision Histor
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-02-28  B.J. Johnson  Initial writing and release
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

public class Clock {
  /**
   *  Class field definintions go here
   */
   private static final double DEFAULT_TIME_SLICE_IN_SECONDS = 60.0;
   private static final double INVALID_ARGUMENT_VALUE = -1.0;
   private static final double MAXIMUM_DEGREE_VALUE = 360.0;
   private static final double HOUR_HAND_DEGREES_PER_SECOND = 0.00833333333333333;
   private static final double MINUTE_HAND_DEGREES_PER_SECOND = 0.1;
   private static double totalSeconds = 0;
   private static double targetAngle = 0;
   private static double timeSlice = 0;
   private static double hourHand = 0;

  /**
   *  Constructor goes here
   */

   public Clock() {
     System.out.println("Please input a valid angle");
     System.exit(0);
   }

   public Clock(double angle) {
     targetAngle = angle;
     totalSeconds = DEFAULT_TIME_SLICE_IN_SECONDS;
   }

   public Clock(double angle, double timeSliceArg) {
     targetAngle = angle % 360;
     timeSlice = timeSliceArg;
   }

  /**
   *  Methods go here
   *
   *  Method to calculate the next tick from the time increment
   *  @return double-precision value of the current clock tick
   */
   public double tick() {
      totalSeconds += timeSlice;
      return totalSeconds;
   }

  /**
   *  Method to validate the angle argument
   *  @param   argValue String from the main programs args[0] input
   *  @return  double-precision value of the argument
   *  @throws  NumberFormatException
   */
   public double validateAngleArg(String argValue) throws NumberFormatException {
     double newArgValue = Double.parseDouble(argValue);
     if(newArgValue < 360) {
       return newArgValue;
     }
     return -1;
   }

  /**
   *  Method to validate the optional time slice argument
   *  @param  argValue  String from the main programs args[1] input
   *  @return double-precision value of the argument or -1.0 if invalid
   *  note: if the main program determines there IS no optional argument supplied,
   *         I have elected to have it substitute the string "60.0" and call this
   *         method anyhow.  That makes the main program code more uniform, but
   *         this is a DESIGN DECISION, not a requirement!
   *  note: remember that the time slice, if it is small will cause the simulation
   *         to take a VERY LONG TIME to complete!
   */
   public double validateTimeSliceArg(String argValue) {
     double newArgValue = Double.parseDouble(argValue);
     if(newArgValue < 1800) {
       return (newArgValue);
     }
     return -1;
   }

   public int calcHour() {
     int hour = (int)(totalSeconds / 3600);
     return hour;
   }

   public int calcMinute() {
     int minutes = (int)(totalSeconds / 60);
     return minutes;
   }

   public int calcSeconds() {
     int seconds = (int)(totalSeconds - 3600*calcHour() - 60*calcMinute());
     return seconds;
   }

  /**
   *  Method to calculate and return the current position of the hour hand
   *  @return double-precision value of the hour hand location
   */
   public double getHourHandAngle() {
      return totalSeconds * HOUR_HAND_DEGREES_PER_SECOND;
   }

  /**
   *  Method to calculate and return the current position of the minute hand
   *  @return double-precision value of the minute hand location
   */
   public double getMinuteHandAngle() {
      return totalSeconds * MINUTE_HAND_DEGREES_PER_SECOND;
   }

  /**
   *  Method to calculate and return the angle between the hands
   *  @return double-precision value of the angle between the two hands
   */
   public double getHandAngle() {
     double tempAngle = Math.abs(getHourHandAngle()-getMinuteHandAngle());
     if(tempAngle > 180) {
       return 360 - tempAngle;
     }
     return -1;
   }

  /**
   *  Method to fetch the total number of seconds
   *   we can use this to tell when 12 hours have elapsed
   *  @return double-precision value the total seconds private variable
   */
   public double getTotalSeconds() {
      return totalSeconds;
   }

  /**
   *  Method to return a String representation of this clock
   *  @return String value of the current clock
   */
   public String toString() {
     StringBuilder stringify = new StringBuilder();

     stringify.append(calcHour());
     stringify.append(":");
     stringify.append(calcMinute());
     stringify.append(":");
     stringify.append(calcSeconds());

     return stringify.toString();
   }

  /**
   *  The main program starts here
   *  remember the constraints from the project description
   *  @see  http://bjohnson.lmu.build/cmsi186web/homework04.html
   *  be sure to make LOTS of tests!!
   *  remember you are trying to BREAK your code, not just prove it works!
   */
   public static void main(String args[]) {

      System.out.println( "\nCLOCK CLASS TESTER PROGRAM\n" +
                          "--------------------------\n" );
      System.out.println( "  Creating a new clock: " );
      Clock clock = new Clock(Double.parseDouble(args[0]), Double.parseDouble(args[1])); // make this double
      System.out.println( "    New clock created: " + clock.toString() );
      System.out.println( "    Testing validateAngleArg()....");
      System.out.print( "      sending '  0 degrees', expecting double value   0.0" );
      try { System.out.println( (0.0 == clock.validateAngleArg( "0.0" )) ? " - got 0.0" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }
   }
   // Output format - HH:MM:SSSS
}
