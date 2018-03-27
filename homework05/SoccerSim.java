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
  public boolean collision = false;

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

  public void validateVelocity() {
  /**  if((newVel > 0) && ((newVel < QUAD_1_WIDTH) && (newVel < QUAD_1_HEIGHT)) && ((newVel > QUAD_2_WIDTH) && (newVel < QUAD_2_HEIGHT)) &&
      ((newVel > QUAD_3_WIDTH) && (newVel > QUAD_3_HEIGHT)) && ((newVel < QUAD_4_WIDTH) && (newVel > QUAD_4_HEIGHT))) {
      return (newVel);
    }
    throw new IllegalArgumentException();
**/}

  public boolean atRest() {
    for (Ball ball : ballArr){
      if (!ball.stationary()) {
        return false;
      }
    }
    return true;
  }

 // public void validateLocation() {
 //   double newLoc = Double.parseDouble(location);
 //   if(((newLoc < QUAD_1_WIDTH) && (newLoc < QUAD_1_HEIGHT)) && ((newLoc > QUAD_2_WIDTH) && (newLoc < QUAD_2_HEIGHT)) &&
 //     ((newLoc > QUAD_3_WIDTH) && (newLoc > QUAD_3_HEIGHT)) && ((newLoc < QUAD_4_WIDTH) && (newLoc > QUAD_4_HEIGHT))) {
 //     return (newLoc);
 //   }
 //   throw new IllegalArgumentException("Invalid Coordinates");
 // }

 public boolean collisionOccured() {
   int count = 1;
   for(Ball ball : ballArr) {
     if(Math.sqrt(Math.pow(POLE_X - ball.getXLoc(),2) + (Math.pow(POLE_Y - ball.getYLoc(), 2))) < ball.RADIUS_IN_INCHES) {
       System.out.println("Ball" + count + " has collided with pole at <" + ball.getXLoc() + "," + ball.getYLoc() + ">");
       collision = true;
       return true;
     }
     for(Ball ball_2 : ballArr) {
       if(Math.sqrt(Math.pow(ball_2.getXLoc() - ball.getXLoc(),2) + (Math.pow(ball_2.getYLoc() - ball.getYLoc(), 2)))
       < Ball.RADIUS_IN_INCHES && ball != ball_2) {
         System.out.println(ball_2 + " has collided with " + ball + " at <" + ball.getXLoc() + "," + ball.getYLoc() + ">");
         collision = true;
         return true;
       }
     }
     count++;
   }
   return false;
 }

   public String toString() {
     String result = "";
     for(Ball ball : ballArr) {
       result += ball.toString();
     }
     return result;
   }


  public static void main(String[] args) {
    SoccerSim ss = new SoccerSim(args);
    Timer timer = new Timer(ss.timeSlice);

    try {
      System.out.println("Initial Report at " + timer.toString());
      System.out.println(ss);
      while(!ss.atRest()) {
        System.out.println(timer.toString());
        for(Ball ball : ss.ballArr) {
          ball.move();
          System.out.println(ss.toString());
        }
        timer.tick();
      }
      // collision test
    }
    catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }
  }
}


// try has everything: (3) validation methods, Initial report, while loop that runs everything
