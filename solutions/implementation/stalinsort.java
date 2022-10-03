import java.util.Scanner;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
	    Scanner input = new Scanner(System.in);
	    
	    int amount = input.nextInt();
	    int previousInt = 0;
	    for(int i=0; i<amount; i++) {
	        int num = input.nextInt();
	        
	        if(num > previousInt) {
	            System.out.println(num);
	            previousInt = num;
	        }
	    }
	}
}
