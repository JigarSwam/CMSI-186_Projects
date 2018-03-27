/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  Ball.java
 *  @author       :  Jigar Swaminarayan
 *  Date written  :  2017-03-13
 *  Description   :  Helper class for a Ball object for SoccerSim.java.
 *  Warnings      :  None
 *  Exceptions    :  None
**/

import java.text.DecimalFormat;

public class Ball {
  public static final double RADIUS_IN_INCHES = 4.45;
  private static final double WEIGHT_IN_POUNDS = 1;
  private static final double FRICTION_PERCENT_PER_SECOND = .01;
  private static final double DEFAULT_X_LOCATION = 0;
  private static final double DEFAULT_Y_LOCATION = 0;
  private static final double DEFAULT_X_VELOCITY_FEET = 2;
  private static final double DEFAULT_Y_VELOCITY_FEET = 2;
  public static final double DEFAULT_TIME_SLICE_IN_SECONDS = 1.0;
  public static final double EPSILON_VALUE = 0.01;
  public static final double STOP_XVEL = 1/12;
  public static final double STOP_YVEL = 1/12;

  public double ballX = 0;
  public double ballY = 0;
  public double ballXVelocity = 0;
  public double ballYVelocity = 0;

  private double timeSlice = 0;

  public Ball() {
    ballX = DEFAULT_X_LOCATION;
    ballY = DEFAULT_Y_LOCATION;
    ballXVelocity = DEFAULT_X_VELOCITY_FEET;
    ballYVelocity = DEFAULT_Y_VELOCITY_FEET;

    timeSlice = DEFAULT_TIME_SLICE_IN_SECONDS;
  }

  public double getXLoc() {
    return ballX;
  }

  public double getYLoc() {
    return ballY;
  }

  public double getXVel() {
    return ballXVelocity;
  }

  public double getYVel() {
    return ballYVelocity;
  }

  public boolean stationary() {
    return Math.abs(ballXVelocity) <= .083 && Math.abs(ballYVelocity) <= .083;
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
      if ((Math.abs(ballXVelocity) * 12) <= 1.0) {
        ballXVelocity = 0;
      }
      if ((Math.abs(ballYVelocity) * 12) <= 1.0) {
        ballYVelocity = 0;
      }
  }

  public String toString() {
    DecimalFormat df = new DecimalFormat("#.##");
    return "Position: " + "<" + df.format(ballX) + ", " + df.format(ballY) + ">" + " Velocity: " + "<" + df.format(ballXVelocity) + ", " + df.format(ballYVelocity) +">";
  }

  public static void main(String args[]) {
    System.out.println( "\nBall CLASS TESTER PROGRAM\n" +
                        "--------------------------\n" );
    System.out.println( "  Creating a new ball... " );
    Ball ball = new Ball();
    System.out.println( "  New ball created: " + ball.toString());

    ball.move();
    System.out.println("Update: " + ball.toString());
    try { System.out.println( (2.0 == ball.ballX) ? " move() for X-val working as intended" : " move() not working" ); }
    catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }
    try { System.out.println( (2.0 == ball.ballY) ? " move() for Y-val working as intended" : " move() not working" ); }
    catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }
    try { System.out.println( (1.98 == ball.ballXVelocity) ? " move() for X-Velocity working as intended" : " move() not working" ); }
    catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }
    try { System.out.println( (1.98 == ball.ballYVelocity) ? " move() for Y-Velocity working as intended" : " move() not working" ); }
    catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }

    ball.move();
    System.out.println("Update: " + ball.toString());
    try { System.out.println( (3.98 == ball.ballX) ? " move() for X-val working as intended" : " move() not working" ); }
    catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }
    try { System.out.println( (3.98 == ball.ballY) ? " move() for Y-val working as intended" : " move() not working" ); }
    catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }
    try { System.out.println( (1.9602 == ball.ballXVelocity) ? " move() for X-Velocity working as intended" : " move() not working" ); }
    catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }
    try { System.out.println( (1.9602 == ball.ballYVelocity) ? " move() for Y-Velocity working as intended" : " move() not working" ); }
    catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }

    // test twice again with ball with different timeSlice value
  }
}
