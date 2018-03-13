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
  private final double FRICTION_PERCENT_PER_SECOND = .99;
  private final double DEFAULT_X_LOCATION = 0;
  private final double DEFAULT_Y_LOCATION = 0;
  private final double DEFAULT_X_VELOCITY = 1;
  private final double DEFAULT_Y_VELOCITY = 1;
  private final double DEFAULT_X2_LOCATION = 50;
  private final double DEFAULT_Y2_LOCATION = 50;
  private static final double DEFAULT_TIME_SLICE_IN_SECONDS = 60.0;

  private double ballOneX = 0;
  private double ballOneY = 0;
  private double ballOneXVelocity = 0;
  private double ballOneYVelocity = 0;

  private double ballTwoX = 0;
  private double ballTwoY = 0;
  private double ballTwoXVelocity = 0;
  private double ballTwoYVelocity = 0;

  public Ball() {
    ballOneX = DEFAULT_X_LOCATION;
    ballOneY = DEFAULT_Y_LOCATION;
    ballOneXVelocity = DEFAULT_X_VELOCITY;
    ballOneYVelocity = DEFAULT_Y_VELOCITY;

    ballTwoX = DEFAULT_X2_LOCATION;
    ballTw0Y = DEFAULT_Y2_LOCATION;
    ballTwoXVelocity = DEFAULT_X_VELOCITY;
    ballTwoYVelocity = DEFAULT_Y_VELOCITY;
  }

  public Ball(double xOneLoc, double yOneLoc, double xOneVel, double yOneVel,
              double xTwoLoc, double yTwoLoc, double xTwoVel, double yTwoVel) {
    ballOneX = xOneLoc;
    ballOneY = yOneloc;
    ballOneXVelocity = xOneVel;
    ballOneYVelocity = yOneVel;

    ballTwoX = xTwoLoc;
    ballTwoY = yTwoloc;
    ballTwoXVelocity = xTwoVel;
    ballOneYVelocity = yTwoVel;
  }

  // calcLocation()
  // calcVelocity()
  // validateVelocity()
  // validateLocation()
  // hasCollided()

}


/**
  * Notes:
  ----------------------- Ball 1
  * args[0] - x location
  * args[1] - y location
  * args[2] - x move
  * args[3] - y move
  ----------------------- Ball 2
  * args[4] - x location
  * args[5] - y location
  * args[6] - x move
  * args[7] - y move

  * Speed dec @1% / seconds
  * 2ft/seconds
  * c = sqrt(a^2 + b^2)
  * ball needs to update itself
  * validate arguments
  * epsilon value
**/
