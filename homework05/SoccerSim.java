/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  SoccerSim.java
 *  @author       :  B.J. Johnson
 *  Modified By   :  Jigar Swaminarayan
 *  Date written  :  2017-03-13
 *  Description   :  Simulation with soccer balls to determine, after they are kicked, if there is a collision.
 *  Warnings      :  None
 *  Exceptions    :  None
**/
public class SoccerSim {

  private final double FIELD_X_WIDTH = 500;
  private final double FIELD_Y_HEIGHT = 500;

  private final double QUAD_1_WIDTH = 250;
  private final double QUAD_1_HEIGHT = 250;

  private final double QUAD_2_WIDTH = -250;
  private final double QUAD_2_HEIGHT = 250;

  private final double QUAD_3_WIDTH = -250;
  private final double QUAD_3_HEIGHT = -250;

  private final double QUAD_4_WIDTH = 250;
  private final double QUAD_4_HEIGHT = -250;

  public final static double POLE_X = 200;
  public final static double POLE_Y = -50;

  public int numBalls;
  private Ball[] ballArr;
  public double DEFAULT_TIME_SLICE_IN_SECONDS = 1.0;
  public double timeSlice;

  public SoccerSim(String args[]) {
    numBalls = (int)(args.length / 4);
    if(args.length % 4 == 1) {
      timeSlice = Double.parseDouble(args[args.length-1]);
    }
    else if(args.length % 4 == 0) {
      timeSlice = DEFAULT_TIME_SLICE_IN_SECONDS;
    }
    else {
      throw new IllegalArgumentException("Invalid Number of Arguments");
    }
    ballArr = new Ball[numBalls];
    int j = 0;
    for(int i=0; i < ballArr.length; i++) {
      double xPos = Double.parseDouble(args[i+0]);
      double yPos = Double.parseDouble(args[i+1]);
      double xVel = Double.parseDouble(args[i+2]);
      double yVel = Double.parseDouble(args[i+3]);
      ballArr[j] = new Ball(xPos, yPos, xVel, yVel, timeSlice);
      j++;
    }
  }

  public double validateVelocity(String velocity) {
    double newVel = Double.parseDouble(velocity);
    if((newVel > 0) && ((newVel < QUAD_1_WIDTH) && (newVel < QUAD_1_HEIGHT)) && ((newVel > QUAD_2_WIDTH) && (newVel < QUAD_2_HEIGHT)) &&
      ((newVel > QUAD_3_WIDTH) && (newVel > QUAD_3_HEIGHT)) && ((newVel < QUAD_4_WIDTH) && (newVel > QUAD_4_HEIGHT))) {
      return (newVel);
    }
    throw new IllegalArgumentException();
  }

  public static String atRest() {
    if(Ball.ballXVelocity == Ball.STOP_XVEL && Ball.ballYVelocity == Ball.STOP_YVEL) {
      return "at rest";
    }
    return "";
  }

  //ballStatus
 // validateLocation() - vel > 0, location is initially on field, doesn't matter for later
 public double validateLocation(String location) {
   double newLoc = Double.parseDouble(location);
   if(((newLoc < QUAD_1_WIDTH) && (newLoc < QUAD_1_HEIGHT)) && ((newLoc > QUAD_2_WIDTH) && (newLoc < QUAD_2_HEIGHT)) &&
     ((newLoc > QUAD_3_WIDTH) && (newLoc > QUAD_3_HEIGHT)) && ((newLoc < QUAD_4_WIDTH) && (newLoc > QUAD_4_HEIGHT))) {
     return (newLoc);
   }
   throw new IllegalArgumentException("Invalid Coordinates");
 }

 public static String collisionOccured() {
   if((Ball.ballX <= POLE_X - (Ball.RADIUS_IN_INCHES / 12) || (Ball.ballX >= POLE_X - (Ball.RADIUS_IN_INCHES / 12))) &&
      (Ball.ballY <= POLE_Y - (Ball.RADIUS_IN_INCHES / 12) || (Ball.ballY >= POLE_Y - (Ball.RADIUS_IN_INCHES / 12)))) {
     return "Collision Occurred";
   }
   return "";
 }

  public static void main(String[] args) {
    Timer timer = new Timer();
    System.out.println("Initial Report at " + timer.toTimeString());
  }
}


/**
  * whileCollisionOcurred
  * collisionNotPossible
  * hasCollided()
  * instantiates field, timer, ball

**/
