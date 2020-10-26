import java.util.*;
public class Main //main class
{
	public static void main(String[] args) { //main method that runs when the program starts
	    Scanner sc = new Scanner(System.in); //initializes input scanner
	    int n = sc.nextInt(); //scans for and initializes variable n (number of additions)
	    for(int i = 0; i<n; i++) { //loops n times
    	    int a = sc.nextInt(); //scans for and initializes a
    	    int b = sc.nextInt(); //scans for and initalizes b
    		System.out.println(a+b); //prints the sum of a and b
	    }
	}
}
