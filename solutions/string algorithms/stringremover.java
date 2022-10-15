import java.util.Scanner;


public class Work1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String[] a = sc.nextLine().split(" ");
		String b = sc.nextLine();
		for(int i = 0; i < a.length; i++) {
		  if(!a[i].equals(b)) {
		    System.out.print(a[i] + (i==a.length-1?"\n":" "));
		  }
		}
	}	
}
