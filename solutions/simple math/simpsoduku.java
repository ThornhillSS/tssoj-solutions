import java.util.Scanner;

public class Main
{
	public static void main(String[] args) 
	{
	    Scanner input = new Scanner(System.in);
	    int a = 0;
	    for(int i = 0; i<8; i++)
	        a += input.nextInt(); //takes input for the 8 known sudoku values
	    System.out.println(45-a); //a full 3x3 sudoku board will always be a sum of 45, therefore to find the missing number we do 45 - sum of the other 8 values
	}
}
