import java.util.Scanner;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
	    Scanner input = new Scanner(System.in);
	    
	    int n = input.nextInt();
	    
	    System.out.print(n/1000 + (n%1000)/100 + (n%100)/10 + n%10);
	}
}
