public class DieTester {


  public static void main ( String [] args ) {
    //- test_roll();
    test_getValue();

  }

  public static void test_roll() {
    Die d = new Die(6);
    System.out.println("Current state is " + d.roll());
    System.out.println("Current state is " + d.roll());
    System.out.println("Current state is " + d.roll());
    System.out.println("Current state is " + d.roll());
    System.out.println("Current state is " + d.roll());
  }

  public static void test_getValue() {
    Die d = new Die(6);
  }

  public static void test_setSides() {
    Die d = new Die(6);
  }

  public static void test_toString() {
    Die d = new Die(6);
  }


}
