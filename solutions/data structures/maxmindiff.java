import java.util.*;
import java.io.*;
 
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
// your main class goes here
public class Main
{
    static int inputarr[];
    static int segtreemin[];
    static int segtreemax[];
    
    static public void constructMinTree(int low, int high, int pos)
    {
        if (low == high)
        {
            segtreemin[pos] = inputarr[low];
            return;
        }
        int mid = (low + high) / 2;
        constructMinTree(low, mid, 2 * pos + 1);
        constructMinTree(mid + 1, high, 2 * pos + 2);
        segtreemin[pos] = Math.min(segtreemin[2 * pos + 1], segtreemin[2 * pos + 2]);
        return;
    }
    
    static public void constructMaxTree(int low, int high, int pos)
    {
        if (low == high)
        {
            segtreemax[pos] = inputarr[low];
            return;
        }
        int mid = (low + high) / 2;
        constructMaxTree(low, mid, 2 * pos + 1);
        constructMaxTree(mid + 1, high, 2 * pos + 2);
        segtreemax[pos] = Math.max(segtreemax[2 * pos + 1], segtreemax[2 * pos + 2]);
        return;
    }
    
    static public int rangeQueryMin(int qlo, int qhi, int low, int high, int pos)
    {
        if (qlo <= low && qhi >= high)
        {
            return segtreemin[pos];
        }
        else if (qlo > high || qhi < low)
        {
            return Integer.MAX_VALUE;
        }
        int mid = (low + high) / 2;
        return (Math.min(rangeQueryMin(qlo, qhi, low, mid, 2 * pos + 1), rangeQueryMin(qlo, qhi, mid + 1, high, 2 * pos + 2)));
    }
    
    static public int rangeQueryMax(int qlo, int qhi, int low, int high, int pos)
    {
        if (qlo <= low && qhi >= high)
        {
            return segtreemax[pos];
        }
        else if (qlo > high || qhi < low)
        {
            return -1;
        }
        int mid = (low + high) / 2;
        return (Math.max(rangeQueryMax(qlo, qhi, low, mid, 2 * pos + 1), rangeQueryMax(qlo, qhi, mid + 1, high, 2 * pos + 2)));
    }
    
	public static void main(String[] args) throws IOException
	{
	    SIO scanner = new SIO ();
		int size = scanner.nextInt();
		int queries = scanner.nextInt();
		inputarr = new int [size];
		for (int i = 0; i < size; i++)
		{
		    inputarr[i] = scanner.nextInt();
		}
		segtreemin = new int [2 * (1 << (int)Math.ceil(Math.log(size)/Math.log(2))) - 1];
		constructMinTree(0, size-1, 0);
		segtreemax = new int [2 * (1 << (int)Math.ceil(Math.log(size)/Math.log(2))) - 1];
		constructMaxTree(0, size-1, 0);
		for (int i = 0; i < queries; i++)
		{
		    int a = scanner.nextInt()-1;
		    int b = scanner.nextInt()-1;
		    System.out.println(rangeQueryMax(a, b, 0, size - 1, 0) - rangeQueryMin(a, b, 0, size - 1, 0));
		}
	}
}
