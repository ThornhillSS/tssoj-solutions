import java.util.Scanner;
public class Main
{
	public static void main(String[] args) 
	{
	    Scanner input = new Scanner(System.in);
	    int regular = input.nextInt();
	    int small = input.nextInt();
	    
	    int leftover = regular*8 + small*3 - 28; //total - 28 students
		System.out.println(leftover);
	}
}
