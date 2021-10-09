import java.util.*;
public class Main
{
	public static void main(String[] args) 
	{
	    Scanner input = new Scanner(System.in);
	    int b = 5, c;
	    double a = -4.9, t;
	    c = 360-input.nextInt();
	    t = (-b-Math.sqrt(b*b-4.0*a*c))/(2.0*a); //calculate time using quadratic formula
		System.out.format("%.1f", t); //use format to format to one decimal place
	}
} 
