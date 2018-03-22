/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  SoccerSim.java
 *  @author       :  Jigar Swaminarayan
 *  Date written  :  2017-03-13
 *  Description   :  Helper class for a Ball object for SoccerSim.java.
 *  Warnings      :  None
 *  Exceptions    :  None
**/
public class Ball {
  private static final double RADIUS_IN_INCHES = 4.45;
  private static final double WEIGHT_IN_POUNDS = 1;
  private static final double FRICTION_PERCENT_PER_SECOND = .01;
  private static final double DEFAULT_X_LOCATION = 0;
  private static final double DEFAULT_Y_LOCATION = 0;
  private static final double DEFAULT_X_VELOCITY_FEET = 2;
  private static final double DEFAULT_Y_VELOCITY_FEET = 2;
  private static final double DEFAULT_TIME_SLICE_IN_SECONDS = 1.0;
  private static final double EPSILON_VALUE = 0.01;

  public static double ballX = 0;
  public static double ballY = 0;
  public static double ballXVelocity = 0;
  public static double ballYVelocity = 0;

  private static double timeSlice = 0;

  // args length % 4 and not 0 or 1 error

  public Ball() {
    ballX = DEFAULT_X_LOCATION;
    ballY = DEFAULT_Y_LOCATION;
    ballXVelocity = DEFAULT_X_VELOCITY_FEET;
    ballYVelocity = DEFAULT_Y_VELOCITY_FEET;

    timeSlice = DEFAULT_TIME_SLICE_IN_SECONDS;
  }

  public Ball(double xLoc, double yLoc, double xVel, double yVel, double timeSliceArg) {
    ballX = xLoc;
    ballY = yLoc;
    ballXVelocity = xVel;
    ballYVelocity = yVel;

    timeSlice = timeSliceArg;
  }

  public static void move() {
    ballX += ballXVelocity;
    ballY += ballYVelocity;
    ballXVelocity = ballXVelocity - ((ballXVelocity * FRICTION_PERCENT_PER_SECOND) * timeSlice);
    ballYVelocity = ballYVelocity - ((ballYVelocity * FRICTION_PERCENT_PER_SECOND) * timeSlice);
  }

  public static void atRest() {
     boolean ballStopped = false;
    if(Ball.ballXVelocity < .083333 && Ball.ballYVelocity < 0.83333) {
      ballStopped = true;
      System.out.println("at rest");
    }
  }

  public String toString() {
    return "Position: " + "<" + ballX + ">" + "<" + ballY + ">" + "Velocity: " + "<" + ballXVelocity + ">" + "<" + ballYVelocity +">";
  }

  public static void main(String args[]) {
    //tests:
    /**
    *move()
    **/
    // create new Ball object and move it, do multiple times
    //try { System.out.println( (60 == clock.validateAngleArg("60") ) ? " 60 is valid angle arg" : " 60 is invalid angle arg" ); }
    //catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }
  }
}
