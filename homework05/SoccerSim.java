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

  private final double FIELD_X = 500;
  private final double FIELD_Y = 500;

  private final double QUAD_1_WIDTH = 250;
  private final double QUAD_2_WIDTH = 250;

  public double validateVelocity(String velocity) { //check not bigger than size of field, doesn't jump off field right away
    double newVel = Double.parseDouble(velocity);
    if(newVel > 0) {
      return (newVel);
    }
    return -1.0; //throw error
  }
 // validateLocation() - vel > 0, location is initially on field, doesn't matter for later

  public static void main(String[] args) {

  }
}


/**
  * whileCollisionOcurred
  * collisionNotPossible
  * hasCollided()
  * instantiates field, timer, ball

**/
