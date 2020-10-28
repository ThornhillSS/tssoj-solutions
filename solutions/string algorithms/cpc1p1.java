import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int n = sc.nextInt(); //takes input for # of handwriting samples
	    sc.nextLine(); //necessary since we are taking input of strings after the previous input of an int
	    String str;
	    for(int i = 0; i<n; i++) {
	        str = sc.next(); //takes input for the current writing sample
	        if(str.contains("chika")) //if the string contains chika, output YES, otherwise NO
	            System.out.println("YES");
	        else
	            System.out.println("NO");
	    }
	}
}
