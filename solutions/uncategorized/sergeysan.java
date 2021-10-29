import java.util.*;
import java.io.*;
import java.text.*;
// SIO VERSION 4.0 by ENCODEOUS/ADAM
class SIO {
    public static BufferedReader in;
    public static BufferedWriter out;
    public int bufferSize = -1;
    public SIO(){
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
    }
    public SIO(int buffersize){
        in = new BufferedReader(new InputStreamReader(System.in),buffersize);
        out = new BufferedWriter(new OutputStreamWriter(System.out),buffersize);
        bufferSize = buffersize;
    }
    public String nextLine() throws IOException{
        return in.readLine();
    }
    public int nextInt() throws IOException {
        return nextInt((char)32);
    }
    public int nextInt(char token) throws IOException {
        int number = 0;
        boolean negative = false;
        int a = in.read();
        while (a == token || a< 48 || a > 57) {
            negative = a == 45;
            a = in.read();
        }
        do {
            number = number * 10 + a - 48;
        } while ((a = in.read()) >= 48 && a <= 57 && a != token);
        return negative ? -number : number;
    }
    public long nextLong() throws IOException {
        return nextLong((char)32);
    }
    public long nextLong(char token) throws IOException {
        long number = 0;
        boolean negative = false;
        int a = in.read();
        while (a == token || a< 48 || a > 57) {
            negative = a == 45;
            a = in.read();
        }
        do {
            number = number * 10 + a - 48;
        } while ((a = in.read()) >= 48 && a <= 57 && a != token);
        return negative ? -number : number;
    }
    public double nextDouble(char token) throws IOException {
        double number = 0, div = 1;
        int c = in.read();
        boolean neg = false;
        while (c == token || c< 48 || c > 57) {
            neg = c == 45;
            c = in.read();
        }
        do {
            number = number * 10 + c - 48;
        } while ((c = in.read()) >= 48 && c <= 57);
 
        if (c == 46) {
            while ((c = in.read()) >= 48 && c <= 57 && c != token) {
                number += (c - 48) / (div *= 10);
            }
        }
        if (neg)
            return -number;
        return number;
    }
    public double nextDouble() throws IOException{
        return nextDouble((char)32);
    }
    public String nextToken(char token) throws IOException{
        StringBuilder str = new StringBuilder();
        int a = in.read();
        while (a == 10 || a == token) // skips over the token and newline
            a = in.read();
        while (a != 10 && a != token && a != -1) { // reads until it hits a whitespace, newline or token
            str.append((char) a);
            a = in.read();
        }
        return str.toString();
    }
    public String next() throws IOException{
        return nextToken((char)32);
    }
    public void print(CharSequence cs) throws IOException{
        for (int i = 0; i < cs.length(); i++) {
            out.write(cs.charAt(i));
        }
    }
    public void print(Number number) throws IOException{
        print(number.toString());
    }
    public void println(String str) throws IOException{
        print(str+'\n');
    }
    public void println(Number number) throws IOException{
        print(number.toString()+'\n');
    }
    public void println() throws IOException{
        print(Character.toString('\n'));
    }
    public void close() throws IOException{
        out.flush();
        in.close();
        out.close();
    }
}
public class Main
{
	public static void main(String[] args) throws IOException
	{
		SIO scanner = new SIO ();
		int a = scanner.nextInt();
		double wei[] = new double [a];
		double proj[] = new double [a];
		double test[] = new double [a];
		for (int i = 0; i < a; i++)
		{
		    wei[i] = scanner.nextDouble();
		}
		for (int i = 0; i < a; i++)
		{
		    test[i] = scanner.nextDouble();
		}
		for (int i = 0; i < a; i++)
		{
		    proj[i] = scanner.nextDouble();
		}
		double dp[][] = new double [a+1][3];
		for (int i = 1; i <= a; i++)
		{
		    for (int j = 0; j < 3; j++)
		    {
		        if (j == 0)
		        {
		            dp[i][j] = test[i-1] * wei[i-1] + Math.max(dp[i-1][0], Math.max(dp[i-1][1], dp[i-1][2]));
		            continue;
		        }
		        dp[i][j] = dp[i-1][j-1] + proj[i-1] * wei[i-1];
		    }
		}
		System.out.println((int)Math.max(Math.max(dp[a][1], dp[a][2]), dp[a][0]) / 100);
	}
}
