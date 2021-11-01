import java.util.*;
public class Main
{
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int x1 = scanner.nextInt();
		int y1 = scanner.nextInt();
		int x2 = scanner.nextInt();
		int y2 = scanner.nextInt();
		int cost = 0;
		if(a*2>b) //diagonal
		{
		    if(Math.abs(x1-x2)>Math.abs(y1-y2))
	        {
		        cost+= Math.abs(y1-y2)*b;
		        cost+= (Math.abs(x1-x2) - Math.abs(y1-y2))*a;
	        }
	        else
	        {
		        cost+= Math.abs(x1-x2)*b;
		        cost+= (Math.abs(y1-y2) - Math.abs(x1-x2))*a;
	        }
		}
        else
        {
            cost+= a*(Math.abs(x1-x2)+Math.abs(y1-y2));
        }
		
		System.out.println(cost);
	
	}
}
