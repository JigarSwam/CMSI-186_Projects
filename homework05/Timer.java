/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  Timer.java
 *  @author       :  Jigar Swaminarayan
 *  Date written  :  2017-03-13
 *  Description   :  Helper class for a Timer object for SoccerSim.java.
 *  Warnings      :  None
 *  Exceptions    :  None
**/
public class Timer {

    private static final double DEFAULT_TIME_SLICE_IN_SECONDS = 1.0;
    private static double totalSeconds = 0;
    private static double timeSlice = 0;
    private static double inchesInFeet = 12;

    public Timer() {
      super();
    }

    public double tick() {
      totalSeconds += timeSlice;
      return totalSeconds;
    }

    public double getTotalSeconds() {
       return totalSeconds;
    }

    public double validateTimeSliceArg(String argValue) throws NumberFormatException {
      double newArgValue = Double.parseDouble(argValue);
      if(newArgValue < 1800 && newArgValue > 0) {
        return (newArgValue);
      }
      throw new IllegalArgumentException();
    }

    public static int calcHour() {
      int hour = (int)(totalSeconds / 3600);
      return hour;
    }

    public static int calcMinute() {
      int minutes = (int)(totalSeconds / 60 % 60);
      return minutes;
    }

    public static double calcSeconds() {
      double seconds = totalSeconds % 60;
      return seconds;
    }

    public static String toTimeString() {
      String hour = Integer.toString(calcHour());
      String min = Integer.toString(calcMinute());
      String sec = Double.toString(calcSeconds());
      return hour + ":" + min + ":" + sec;
    }

    public static void main(String[] args) {

      Timer timer = new Timer();
      System.out.println(timer.getTotalSeconds());

      double numSecs = 0;
      for(int i = 0; i < 10; i++) {
        numSecs += 60;
        System.out.println(timer);
        timer.tick();
        try { System.out.println( (numSecs == timer.getTotalSeconds()) ? " - got correct seconds" : " - no joy" ); }
        catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }
      }


      /** TESTS
      * tick()
      * toString()
      **/
      // create new Timer timer
      //System.out.println(timer.getTotalSeconds());
    }

}
