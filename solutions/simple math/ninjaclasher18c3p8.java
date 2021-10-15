import java.util.Scanner;
public class Main
{
	public static void main(String[] args) 
	{
	    Scanner input = new Scanner(System.in);
	    long n = input.nextLong();
	    long a, b, c;
	    
	    //to maximize, get a, b, and c as close to a third as n as possible
	    if(n%3 == 0) //a, b, c all the same number in this case
	    {
	        a = n/3;
	        b = n/3;
	        c = n/3;
	    }
	    else 
	    {
	        a = n/3;
	        b = a+1; //b is one more than a
	        c = n-a-b; //c is one less than a (the remaining value left)
	    }
		System.out.println(a*b*c + b*c + a*b + a*c);
	}
}
