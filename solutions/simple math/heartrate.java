import java.util.Scanner;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
	    Scanner input = new Scanner(System.in);
	    
	    int age = input.nextInt();
	    int restingHeart = input.nextInt();
	    double intensity = input.nextDouble();
	    
	    int maxHeart = 220 - age;
	    int heartReserve = maxHeart - restingHeart;
	    
	    System.out.print((double)restingHeart + (double)(intensity*heartReserve));
	}
}
