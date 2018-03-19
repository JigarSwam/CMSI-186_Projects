public class Timer {
    private static final double DEFAULT_TIME_SLICE_IN_SECONDS = 1.0;
    private static double totalSeconds = 0;
    private static double timeSlice = 0;

    public double tick() {
      totalSeconds += timeSlice;
      return totalSeconds;
    } 

}

/**
  * Notes:
  * Handles timing part of simulation (tick())

**/
