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
    try {Die d = new Die(6)};

  }


}
