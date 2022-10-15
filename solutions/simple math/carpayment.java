import java.util.Scanner;
import java.math.*;

public class CarPayment {

	public static void main(String[] args) {
			
		Scanner sc = new Scanner(System.in);
		
		//Enter principal amount
		int p = sc.nextInt();
		
		//Enter interest rate
		double r = sc.nextDouble();
		
		//Enter amount of months
		int m = sc.nextInt();
		
		double total = (p*(r/12))/(1-(Math.pow(1+r/12,-m)));
		
		System.out.printf("%.2f", total);
	}

}
