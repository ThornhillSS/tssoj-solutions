import java.util.Scanner;
public class isprime {
   public static void main(String args[])
   {		
	int temp;
	boolean isPrime=true;
	Scanner scan= new Scanner(System.in);
	int num=scan.nextInt();
        scan.close();
	for(int i=2;i<=num/2;i++) // we are looping from 2 to num/2 because a number is not divisible by more than its half.
	{
           temp=num%i;
	   if(temp==0) // check to see if the number is divisible by i
	   {
	      isPrime=false;
	      break;
	   }
	}
	if(isPrime)
	   System.out.println("YES");
	else
	   System.out.println("NO");
   }
}