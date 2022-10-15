import java.util.Scanner;
import java.math.*;

public class ExponentCalculation {

	public static void main(String[] args) {
			
		Scanner sc = new Scanner(System.in);
		
		//Enter X Value
		int x = sc.nextInt();
		//Enter Y Value
		int y = sc.nextInt();
		

		System.out.println(Math.exp(y * Math.log(x)));
		System.out.println(Math.pow(x,y));
	}

}
