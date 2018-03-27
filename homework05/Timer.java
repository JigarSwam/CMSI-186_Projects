/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  Timer.java
 *  @author       :  Jigar Swaminarayan
 *  Date written  :  2017-03-13
 *  Description   :  Helper class for a Timer object for SoccerSim.java.
 *  Warnings      :  None
 *  Exceptions    :  None
**/
public class Timer {

    public static final double DEFAULT_TIME_SLICE_IN_SECONDS = 1.0;
    private static double totalSeconds = 0;
    public static double timeSlice = 0;
    private static double inchesInFeet = 12;

    public Timer() {
      timeSlice = DEFAULT_TIME_SLICE_IN_SECONDS;
    }

    public Timer(double timeSliceArg) {
      timeSlice = timeSliceArg;
    }

    public double tick() {
      totalSeconds += timeSlice;
      return totalSeconds;
    }

    public static double getTotalSeconds() {
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

    public String toString() {
      String hour = Integer.toString(calcHour());
      String min = Integer.toString(calcMinute());
      String sec = Double.toString(calcSeconds());
      return hour + ":" + min + ":" + sec;
    }

    public static void main(String[] args) {

      Timer timer = new Timer();

      System.out.println("Testing with a timeSlice of 20 with 10 ticks.");
      timeSlice = 20;
      double numSecs = 0;
      for(int i = 0; i < 10; i++) {
        System.out.println(timer.toString());
        timer.tick();
      }
      System.out.println(timer.getTotalSeconds());
    }
}
