//The idea behind this dp solution is to hold an array that holds the maximum possible pieces at any given index. To do this, we simply loop through the array and increment the next possible piece's index's max value by 1.
import java.util.*;
import java.text.*;
public class Main
{
	public static void main(String[] args) 
	{
	    Scanner scanner = new Scanner (System.in);
	    int a = scanner.nextInt();
      //array that holds the max value at each index, the size of the bar
	    int arr [] = new int [a+1];
	    int b = scanner.nextInt();
	    int c = scanner.nextInt();
	    int d = scanner.nextInt();
      //1 piece can be made at the initial positions of x, y, and z
	    arr[b] = 1;
	    arr[c] = 1;
	    arr[d] = 1;
	    for (int i = 0; i < a; i++)
	    {
	        if (arr[i] != 0)
	        {
              //if there's enough space to make another piece of length x, y, or z, add 1 to the max value of the current index + x, y, or z
	            if (i + b <= a)
	            {
	                arr[i + b] = arr[i] + 1;
	            }
	            if (i + c <= a)
	            {
	                arr[i + c] = arr[i] + 1;
	            }
	            if (i + d <= a)
	            {
	                arr[i + d] = arr[i] + 1;
	            }
	        }
	    }
      //the max amount of pieces at the last index is the answer
	    System.out.println(arr[a]);
	}
}
