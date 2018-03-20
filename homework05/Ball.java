/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  SoccerSim.java
 *  @author       :  Jigar Swaminarayan
 *  Date written  :  2017-03-13
 *  Description   :  Helper class for a Ball object for SoccerSim.java.
 *  Warnings      :  None
 *  Exceptions    :  None
**/
public class Ball {
  private final double RADIUS_IN_INCHES = 4.45;
  private final double WEIGHT_IN_POUNDS = 1;
  private final double FRICTION_PERCENT_PER_SECOND = .01;
  private final double DEFAULT_X_LOCATION = 0;
  private final double DEFAULT_Y_LOCATION = 0;
  private final double DEFAULT_X_VELOCITY_FEET = 2;
  private final double DEFAULT_Y_VELOCITY_FEET = 2;
  private static final double DEFAULT_TIME_SLICE_IN_SECONDS = 1.0;
  private static final double EPSILON_VALUE = 0.01;

  private double ballX = 0;
  private double ballY = 0;
  private double ballXVelocity = 0;
  private double ballYVelocity = 0;

  private static double timeSlice = 0;

  public Ball() {
    ballX = DEFAULT_X_LOCATION;
    ballY = DEFAULT_Y_LOCATION;
    ballXVelocity = DEFAULT_X_VELOCITY_FEET;
    ballYVelocity = DEFAULT_Y_VELOCITY_FEET;

    timeSlice = DEFAULT_TIME_SLICE_IN_SECONDS;
  }

  public Ball(double xLoc, double yLoc, double xVel, double yVel) {
    ballX = xLoc;
    ballY = yLoc;
    ballXVelocity = xVel;
    ballYVelocity = yVel;

    timeSlice = DEFAULT_TIME_SLICE_IN_SECONDS;
  }
  public Ball(double xLoc, double yLoc, double xVel, double yVel, double timeSliceArg) {
    ballX = xLoc;
    ballY = yLoc;
    ballXVelocity = xVel;
    ballYVelocity = yVel;

    timeSlice = timeSliceArg;
  }

  public void move() {
    ballX += ballXVelocity;
    ballY += ballYVelocity;
    ballXVelocity = ballXVelocity - ((ballXVelocity * FRICTION_PERCENT_PER_SECOND) * timeSlice);
    ballYVelocity = ballYVelocity - ((ballYVelocity * FRICTION_PERCENT_PER_SECOND) * timeSlice);
  }

  public String toString() {
    return "";
  }

  public static void main(String args[]) {
    //tests:
    /**
    *move()
    **/
  }

}


/**
  * Notes:

  * Speed dec @1% / seconds
  * 2ft/seconds
  * c = sqrt(a^2 + b^2)
  * ball needs to update itself
  * validate arguments
  * epsilon value
  * V(f) = V(0) - ((V(0) * 0.01) * timeSlice);
**/
