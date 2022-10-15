import java.util.Scanner;


public class Work1 {
	
	public static void main(String args[]) { 
	      Scanner input = new Scanner(System.in);
	      int cents = getCents(input.nextInt(), input.nextInt(), input.nextInt(), input.nextInt());
	      System.out.println(cents);
	  } 

	  public static int getCents(int quarters, int dimes, int nickels, int pennies) {
	      return quarters * 25 + dimes * 10 + nickels * 5 + pennies;
	  }
}
