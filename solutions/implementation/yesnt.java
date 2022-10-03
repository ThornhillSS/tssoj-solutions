import java.util.*;
public class Main
{
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		String a = scanner.nextLine();
		int yes = 0;
		int no = 0;
		for(int i = 1; i > 0; i++) {
		    no++;
		    i = a.indexOf("nt", i);
		    //System.out.println(i);
		}
		no--;
		if(!a.substring(0,2).equals("no"))
		    no++;
	    System.out.println(no % 2 == 1? "yes" : "no");
	}
}
