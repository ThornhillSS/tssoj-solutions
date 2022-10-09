import java.util.Scanner;
import java.util.Arrays;
public class Main
{
	public static void main(String[] args) 
	{
	    Scanner input = new Scanner(System.in);
	    int[] bowl = new int[3];
	    
	    //take input
	    for(int i = 0; i<3; i++)
	    {
	        bowl[i] = input.nextInt();
	    }
	    Arrays.sort(bowl); //now the middle bowl should be in index 1
		System.out.println(bowl[1]);
	}
}
