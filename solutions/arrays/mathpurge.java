import java.util.Scanner;
public class Main
{
	public static void main(String[] args) 
	{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(); //number of names
    String names[] = new String[n];
    int a, k;

    input.nextLine();
    for(int i = 0; i<n; i++) //input names
    {
        names[i] = input.nextLine();
    }

    a = input.nextInt(); //number of people purged
    for(int i = 0; i<a; i++)
    {
        k = input.nextInt(); //index of purged
        names[k] = "1"; //replace all purged people's names with "1"
    }
    for(int i = 0; i<n; i++)
    {
      if(!names[i].equals("1")) //if the name isn't "1" means they are not purged
        System.out.println(names[i]);
    }
	}
}
