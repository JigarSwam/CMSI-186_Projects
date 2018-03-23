public class Timer {
    private static final double DEFAULT_TIME_SLICE_IN_SECONDS = 1.0;
    private static double totalSeconds = 0;
    private static double timeSlice = 0;
    private static double inchesInFeet = 12;

    public double tick() {
      totalSeconds += timeSlice;
      return totalSeconds;
    }

    public double validateTimeSliceArg(String argValue) throws NumberFormatException {
      double newArgValue = Double.parseDouble(argValue);
      if(newArgValue < 1800 && newArgValue > 0) {
        return (newArgValue);
      }
      throw new IllegalArgumentException();
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

    public String toString() {
      StringBuilder stringify = new StringBuilder();
      stringify.append(calcHour());
      stringify.append(":");
      stringify.append(calcMinute());
      stringify.append(":");
      stringify.append(calcSeconds());

      return stringify.toString();
    }

    public static void main(String[] args) {


      /** TESTS
      * tick()
      * toString()
      **/
      // create new Timer timer
      //System.out.println(timer.getTotalSeconds());
    }

}
