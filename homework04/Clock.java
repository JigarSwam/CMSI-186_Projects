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
   private static final double HOUR_HAND_DEGREES_PER_SECOND = 0.00834;
   private static final double MINUTE_HAND_DEGREES_PER_SECOND = 0.1;
   private static double totalSeconds = 0;
   private static double targetAngle = 0;
   private static double timeSlice = 0;
   private static double hourHand = 0;

  /**
   *  Constructor goes here
   */

   public Clock() {
     targetAngle = 180;
     timeSlice = DEFAULT_TIME_SLICE_IN_SECONDS;
   }

   public Clock(double angle) {
     targetAngle = angle;
     timeSlice = DEFAULT_TIME_SLICE_IN_SECONDS;
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
     if(newArgValue < 360 && newArgValue > 0) {
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
     if(newArgValue < 1800 && newArgValue > 0) {
       return (newArgValue);
     }
     return -1;
   }

   public int calcHour() {
     int hour = (int)(totalSeconds / 3600);
     return hour;
   }

   public int calcMinute() {
     int minutes = (int)(totalSeconds / 60 % 60);
     return minutes;
   }

   public double calcSeconds() {
     double seconds = totalSeconds % 60;
     return seconds;
   }

  /**
   *  Method to calculate and return the current position of the hour hand
   *  @return double-precision value of the hour hand location
   */
   public static double getHourHandAngle() {
      return HOUR_HAND_DEGREES_PER_SECOND * totalSeconds % 360;
   }

  /**
   *  Method to calculate and return the current position of the minute hand
   *  @return double-precision value of the minute hand location
   */
   public static double getMinuteHandAngle() {
      return totalSeconds * MINUTE_HAND_DEGREES_PER_SECOND % 360;
   }

  /**
   *  Method to calculate and return the angle between the hands
   *  @return double-precision value of the angle between the two hands
   */
   public static double getHandAngle() {
      double angle = Math.abs(getHourHandAngle()-getMinuteHandAngle());
      if(angle > 180){
        return 360 - angle;
      }
      return angle;
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
      Clock clock = new Clock(90, 60);
      System.out.println( "    New clock created: " + clock.toString() );
      System.out.println( "    Testing validateAngleArg()....");
      System.out.print( "      sending '  0 degrees', expecting double value   0.0" );
      try { System.out.println( (0.0 == clock.validateAngleArg( "0.0" )) ? " - got 0.0" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }
      double numSecs = 0;
      for(int i = 0; i < 10; i++) {
        numSecs += 60;
        System.out.println(clock);
        clock.tick();
        try { System.out.println( (numSecs == clock.getTotalSeconds()) ? " - got correct seconds" : " - no joy" ); }
        catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }

      }
      System.out.println(clock.getTotalSeconds());
      try { System.out.println( (60 == clock.validateAngleArg("60") ) ? " 60 is valid angle arg" : " 60 is invalid angle arg" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }
      try { System.out.println( (90 == clock.validateAngleArg( "90" )) ? " 90 is valid angle arg" : " 90 is invalid angle arg" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }
      try { System.out.println( (15 == clock.validateAngleArg( "15" )) ? " 15 is valid angle arg" : " 15 is invali angle argd" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }
      try { System.out.println( (2005 == clock.validateAngleArg( "2005" )) ? " 2005 is valid angle arg" : " 2005 is invalid angle arg" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }
      try { System.out.println( (-5 == clock.validateAngleArg( "-5" )) ? " -5 is valid angle arg" : " -5 is invalid angle arg" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }
      try { System.out.println( (-10000 == clock.validateAngleArg( "-10000" )) ? " -10000 is valid angle arg" : " -10000 is invalid angle arg" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }
      try { System.out.println( (-1 == clock.validateAngleArg( "xyz" )) ? " xyz is valid angle arg" : " xyz is invalid angle arg" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }
      try { System.out.println( (-16 == clock.validateAngleArg( "-16" )) ? " -16 is valid" : " -16 is invalid" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }

      try { System.out.println( (60 == clock.validateTimeSliceArg("60") ) ? " 60 is valid time slice" : " 60 is invalid time slice" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }
      try { System.out.println( (-60 == clock.validateTimeSliceArg("-60") ) ? " -60 is valid time slice" : " -60 is invalid time slice" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }
      try { System.out.println( (22.5 == clock.validateTimeSliceArg("22.5") ) ? " 22.5 is valid time slice" : " 22.5 is invalid time slice" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }
      try { System.out.println( (-1 == clock.validateTimeSliceArg("xyz") ) ? " xyz is valid time slice" : " xyz is invalid time slice" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }

      System.out.println(getHourHandAngle());
      System.out.println(getMinuteHandAngle());
      System.out.println(getHandAngle());

      //getHourHandAngle tests
      //getMinuteHandAngle tests
      //getHandAngle tests
   }
   // Output format - HH:MM:SSSS
}
