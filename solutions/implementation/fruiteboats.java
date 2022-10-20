import java.util.*;
import java.text.*;
import static java.util.stream.Collectors.*;
import static java.util.Map.Entry.*;
import java.io.*;
import java.util.stream.*;
public class Main
{
  static BufferedReader in;
  static StringTokenizer as;
  public static void main (String[]args) throws IOException
  {
    in = new BufferedReader (new InputStreamReader (System.in));
//
    int n = readInt();
    int a = 0;
    int b = 0;
    int c = 0;
    //readLine();
    for(int i = 0; i<n; i++)
    {
        String temp = readLine();
        char lol = temp.charAt(i*2);
        char lul = temp.charAt(((n-1)*2)-(i*2));
        if(lol=='A')
            a++;
        else if(lol=='B')
            b++;
        else
            c++;
        if(((n-1)*2)-(i*2)!=(i*2))
        {
            if(lul=='A')
                a++;
            else if(lul=='B')
                b++;
            else
                c++;
        }
    }
    System.out.println(a+ "\n" + b + "\n" + c);
//
  }
  static String read () throws IOException
  {
    while (as == null || !as.hasMoreTokens ())
      {
	as = new StringTokenizer (in.readLine ().trim ());
      }
    return as.nextToken ();
  }
  static long readLong () throws IOException
  {
    return Long.parseLong (read ());
  }
  static int readInt () throws IOException
  {
    return Integer.parseInt (read ());
  }
  static double readDouble () throws IOException
  {
    return Double.parseDouble (read ());
  }
  static String readLine () throws IOException
  {
    return in.readLine ().trim ();
  }
}
