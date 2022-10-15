import java.util.Scanner;
public class dateStr {
	
	public static void dateStr(String date) {
		char dash = '-';
		char zero = '0';
		if (date.length() == 10) {
			date = date.substring(3, 5) + dash + date.substring(0, 2) + dash + date.substring(6);
			System.out.print(date);
		}
		else if (date.length() == 8) {
			date = zero + date.substring(2, 3) + dash + zero + date.substring(0, 1) + dash + date.substring(4);
			System.out.print(date);
		}
		else if (date.length() == 9 && date.charAt(1) == '/') {
			date = date.substring(2, 4) + dash + zero + date.substring(0, 1) + dash + date.substring(5);
			System.out.print(date);
		}
		else {
			date = zero + date.substring(3, 4) + dash + date.substring(0, 2) + dash + date.substring(5);
			System.out.print(date);

		}
		}
	
	public static void main(String args[]) {
		
		Scanner input = new Scanner(System.in);
		dateStr(input.next());
		
	}
		

}
