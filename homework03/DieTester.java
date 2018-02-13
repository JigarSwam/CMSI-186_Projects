public class DieTester {


  public static void main ( String [] args ) {
    Die d = null;

    try{d = new Die(1);}
    catch (IllegalArgumentException iae) {System.out.println ("Too few sides requested to constructor...");}

    try{d = new Die(2);}
    catch (IllegalArgumentException iae) {System.out.println ("Too few sides requested to constructor...");}

    try{d = new Die(3);}
    catch (IllegalArgumentException iae) {System.out.println ("Too few sides requested to constructor...");}

    try{d = new Die(4);}
    catch (IllegalArgumentException iae) {System.out.println ("Too few sides requested to constructor...");}
    System.out.println("roll() test for a 4 sided die");
    System.out.println("You rolled a " + d.roll());
    System.out.println("Your value is " + d.getValue());
    System.out.println(d.toString());
    System.out.println("You rerolled a " + d.roll());
    System.out.println("You rerolled a " + d.roll());

    try{d = new Die(5);}
    catch (IllegalArgumentException iae) {System.out.println ("Too few sides requested to constructor...");}
    System.out.println("roll() test for a 5 sided die");
    System.out.println("You rolled a " + d.roll());
    System.out.println("Your value is " + d.getValue());
    System.out.println(d.toString());
    System.out.println("You rerolled a " + d.roll());
    System.out.println("You rerolled a " + d.roll());

    try{d = new Die(6);}
    catch (IllegalArgumentException iae) {System.out.println ("Too few sides requested to constructor...");}
    System.out.println("roll() test for a 6 sided die");
    System.out.println("You rolled a " + d.roll());
    System.out.println("Your value is " + d.getValue());
    System.out.println(d.toString());
    System.out.println("You rerolled a " + d.roll());
    System.out.println("You rerolled a " + d.roll());

    try{d = new Die(7);}
    catch (IllegalArgumentException iae) {System.out.println ("Too few sides requested to constructor...");}
    System.out.println("roll() test for a 7 sided die");
    System.out.println("You rolled a " + d.roll());
    System.out.println("Your value is " + d.getValue());
    System.out.println(d.toString());
    System.out.println("You rerolled a " + d.roll());
    System.out.println("You rerolled a " + d.roll());

    try{d = new Die(8);}
    catch (IllegalArgumentException iae) {System.out.println ("Too few sides requested to constructor...");}
    System.out.println("roll() test for a 8 sided die");
    System.out.println("You rolled a " + d.roll());
    System.out.println("Your value is " + d.getValue());
    System.out.println(d.toString());
    System.out.println("You rerolled a " + d.roll());
    System.out.println("You rerolled a " + d.roll());

    try{d = new Die(9);}
    catch (IllegalArgumentException iae) {System.out.println ("Too few sides requested to constructor...");}
    System.out.println("roll() test for a 9 sided die");
    System.out.println("You rolled a " + d.roll());
    System.out.println("Your value is " + d.getValue());
    System.out.println(d.toString());
    System.out.println("You rerolled a " + d.roll());
    System.out.println("You rerolled a " + d.roll());

    try{d = new Die(10);}
    catch (IllegalArgumentException iae) {System.out.println ("Too few sides requested to constructor...");}
    System.out.println("roll() test for a 10 sided die");
    System.out.println("You rolled a " + d.roll());
    System.out.println("Your value is " + d.getValue());
    System.out.println(d.toString());
    System.out.println("You rerolled a " + d.roll());
    System.out.println("You rerolled a " + d.roll());

    try{d = new Die(11);}
    catch (IllegalArgumentException iae) {System.out.println ("Too few sides requested to constructor...");}
    System.out.println("roll() test for a 11 sided die");
    System.out.println("You rolled a " + d.roll());
    System.out.println("Your value is " + d.getValue());
    System.out.println(d.toString());
    System.out.println("You rerolled a " + d.roll());
    System.out.println("You rerolled a " + d.roll());
    System.out.println("Restting current die side count to " + d.setSides(12));
    System.out.println("roll() test for a 11 sided die");
    System.out.println("You rolled a " + d.roll());
    System.out.println("Your value is " + d.getValue());
    System.out.println(d.toString());
    System.out.println("You rerolled a " + d.roll());
    System.out.println("You rerolled a " + d.roll());

  }
}
