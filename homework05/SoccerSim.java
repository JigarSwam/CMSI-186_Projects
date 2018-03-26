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

  public final double POLE_X = 200;
  public final double POLE_Y = -50;

  public int numBalls = 0;

  public SoccerSim(String args[]) {

  }

  public double validateVelocity(String velocity) {
    double newVel = Double.parseDouble(velocity);
    if((newVel > 0) && ((newVel < QUAD_1_WIDTH) && (newVel < QUAD_1_HEIGHT)) && ((newVel > QUAD_2_WIDTH) && (newVel < QUAD_2_HEIGHT)) &&
      ((newVel > QUAD_3_WIDTH) && (newVel > QUAD_3_HEIGHT)) && ((newVel < QUAD_4_WIDTH) && (newVel > QUAD_4_HEIGHT))) {
      return (newVel);
    }
    throw new IllegalArgumentException();
  }

  //ballStatus

  //Ball[] balls = null;
 // validateLocation() - vel > 0, location is initially on field, doesn't matter for later

 public static void collisionOccured() {

 }

  public static void main(String[] args) {
    Timer timer = new Timer();
    System.out.println("Initial Report at : " + timer.toTimeString());

  }
}


/**
  * whileCollisionOcurred
  * collisionNotPossible
  * hasCollided()
  * instantiates field, timer, ball

**/
