//The idea behind this dp solution is to create an array that will hold the minimum cost to jump to each rock, starting from the first. We can then build up to the final answer by comparing the cost of rock i with the cost of the 2 rocks before it.
import java.util.*;
public class Main
{
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner (System.in);
		int a = scanner.nextInt();
		int rocks[] = new int [a];
    //store all rock heights in an array
		for (int i = 0; i < a; i++)
		{
		    rocks[i] = scanner.nextInt();
		}
		int min[] = new int [a];
    //the minimum cost to get to the second rock is just the difference from the first to the second
		min[1] = Math.abs(rocks[1] - rocks[0]);
		for (int i = 2; i < a; i++)
		{
        //to get the minimum cost to get to rock i, we take the minimum of the cost it takes to get to rock i-1 + the cost of getting from rock i-1 to rock i and the same for rock i-2 
		    min[i] = Math.min(min[i-1] + Math.abs(rocks[i] - rocks[i-1]), min[i-2] + Math.abs(rocks[i] - rocks[i-2]));
		}
    //the minimum cost to get the final rock is the answer
		System.out.println(min[a - 1]);
	}
}
