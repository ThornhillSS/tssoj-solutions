import java.util.*;
public class Main
{
	public static void main(String[] args) 
	{
	    Scanner input = new Scanner(System.in);
	    int start = input.nextInt();
	    int end = input.nextInt();
	    String num = "";
	    int count = 0;
	    
	    //loop from starting number to ending number
	    for(int i = start; i<=end; i++)
	    {
	        //passes every number into the method to check if same
	        if(isSame(Integer.toString(i)))
	            count++;
	    }
		System.out.println(count);
	}
	/**
	 * This method checks if the first and last digit of the number is the same
	 * Pre: The parameter is a number 
	 * Post: If the first and last digit is the same true is returned.
	 */
	public static boolean isSame(String num)
	{
	    int n = num.length();
	    for(int i = 0; i<(n/2); i++)
	    {
	        if(num.charAt(i) != num.charAt(n-i-1))
	            return false;
	    }
	    return true;
	}
}
