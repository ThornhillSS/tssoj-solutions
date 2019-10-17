import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt(); // how many numbers will there be
		
		int ans = 0; // the sum of those numbers
		
		for(int i = 0; i < num; i++) { // loop for each number
			ans += sc.nextInt(); // add the new number to the pre-existing total value
			System.out.print(ans + " "); // print out the answer in proper format
		}
	}
}
