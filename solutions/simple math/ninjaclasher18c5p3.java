import java.util.Scanner;
public class Main
{
	public static void main(String[] args) 
	{
	    Scanner input = new Scanner(System.in);
	    int base = input.nextInt();
	    int x = input.nextInt(), y = input.nextInt();
	    int x1 = toBase10(base, x), y1 = toBase10(base, y); //converts input into base 10
	    long sum = x1+y1;
	    long product = (long)x1*y1;
	    
	    String answer = toBase(base, sum); //converts answer back into base b
	    
	    for(int i = answer.length()-1; i >= 0; i--) //output it backwards bc that's the way I calculated it
	    {
	        System.out.print(answer.charAt(i));
	    }

	    answer = toBase(base, product); //repeat with product

	    System.out.println();
	    for(int i = answer.length()-1; i >= 0; i--)
	    {
	        System.out.print(answer.charAt(i));
	    }

	}
	
	/**
	 * This method converts a number into the number in base b but backwards
	 * Used for sum
	 * Pre: num > 0 
	 * Post: the equivalent in base b is returned but backwards
	 */
	public static String toBase(int base, long num)
	{
	    String remainder = "";
	    while(num > 0)
	    {
	        remainder += num % base;
	        num /= base;
	    }
	    return remainder;
	}
	/**
	 * This method converts a number into base 10
	 * Pre: num > 0 
	 * Post: the number in base 10 is returned
	 */
	public static int toBase10(int base, int bin)
	{
	    String length = bin + ""; //flag for loop
	    int dec = 0;
        int power = 1;
        int curr = bin%10;
        bin /= 10;
        
        dec = curr;
        for(int i = 1; i<length.length(); i++)
        {
            curr = bin%10; //increases/decreases stuff correspondingly 
            bin /= 10;
            power *= base;
            
            dec += power*curr; //find how much the decimal at that place is worth and add it
            
        }
        return dec;
    }
}
