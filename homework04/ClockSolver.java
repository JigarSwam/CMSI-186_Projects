/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  ClockSolver.java
 *  @author       :  B.J. Johnson
 *  Modified By   :  Jigar Swaminarayan
 *  Date written  :  2017-02-28
 *  Description   :  Main class to solve clock degrees.
 *  Warnings      :  None
 *  Exceptions    :  IllegalArgumentException when the input arguments are "hinky"
**/
public class ClockSolver {
  /**
   *  Class field definintions go here
   */
   private final double MAX_TIME_SLICE_IN_SECONDS  = 1800.00;
   private final double DEFAULT_TIME_SLICE_SECONDS = 60.0;
   private static final double EPSILON_VALUE = 5;      // small value for double-precision comparisons
   private static double angle = 0;
   private static double timeSlice = 0;
   private static double targetAngle = 0;

  /**
   *  Constructor
   *  This just calls the superclass constructor, which is "Object"
   */
   public ClockSolver() {
      super();
   }

  /**
   *  Method to handle all the input arguments from the command line
   *   this sets up the variables for the simulation
   */
   public void handleInitialArguments(String args[]) {
     // args[0] specifies the angle for which you are looking
     //  your simulation will find all the angles in the 12-hour day at which those angles occur
     // args[1] if present will specify a time slice value; if not present, defaults to 60 seconds
     // you may want to consider using args[2] for an "angle window"

      System.out.println( "\n   Hello world, from the ClockSolver program!!\n\n" ) ;
      if( 0 == args.length ) {
         System.out.println( "   Sorry you must enter at least one argument\n" +
                             "   Usage: java ClockSolver <angle> [timeSlice]\n" +
                             "   Please try again..........." );
         System.exit(1);
      }
      if(1 == args.length) {
        targetAngle = Double.parseDouble(args[0]);
        timeSlice = DEFAULT_TIME_SLICE_SECONDS;
      }
      if(2 == args.length) {
        targetAngle = Double.parseDouble(args[0]);
        timeSlice = Double.parseDouble(args[1]);
      }
      Clock clock = new Clock(angle, timeSlice);
   }

  /**
   *  The main program starts here
   *  remember the constraints from the project description
   *  @see  http://bjohnson.lmu.build/cmsi186web/homework04.html
   *  @param  args  String array of the arguments from the command line
   *                args[0] is the angle for which we are looking
   *                args[1] is the time slice; this is optional and defaults to 60 seconds
   */
   public static void main(String args[]) {
      ClockSolver cse = new ClockSolver();
      Clock clock = new Clock();
      if(args.length == 1) {
         clock = new Clock(Double.parseDouble(args[0]));
      }
      if(args.length == 2) {
         clock = new Clock(Double.parseDouble(args[0]), Double.parseDouble(args[1]));
      }
      double[] timeValues = new double[3];
      cse.handleInitialArguments( args );
      int totalTime = 43200;
      System.out.println(clock);
      while(clock.getTotalSeconds() < totalTime) {
         if(EPSILON_VALUE >= targetAngle - clock.getHandAngle() && targetAngle - clock.getHandAngle() >= 0 ||
          clock.getHandAngle() - targetAngle <= EPSILON_VALUE && clock.getHandAngle() - targetAngle >= 0) {
           System.out.println(clock.getHourHandAngle());
           System.out.println(clock);
         }
         clock.tick();
      }
      System.exit(0);
   }
}
