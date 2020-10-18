import java.io.*;
import java.util.*;
/*
        We can use a BIT (Binary Indexed Tree) to count inversions.
        By looping from N to 1 we can count the number of inversions for each index in the array, and 
        the BIT makes it very efficient to do so.
*/
public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static int n, arr[], bit[];
    public static void main(String[] args) throws IOException {
        n = readInt();
        arr = new int[n+1];
        bit = new int[100001];
        for(int i = 0; i<n; i++){
            arr[i] = readInt();
        }
        long ans = 0;
        for(int i = n-1; i>=0; i--){
            ans+=query(arr[i]-1);
            update(arr[i], 1);
        }
        println(ans);
    }
    static void update(int a, int val){
        for(int i = a; i<bit.length; i+=i&-i){
            bit[i]+=val;
        }
    }
    static long query(int a){ //long is probably not needed here
        long ans = 0;
        for(int i = a; i>0; i-=(i&-i)){
            ans+=bit[i];
        }
        return ans;
    }
    static String next () throws IOException {
        while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(input.readLine().trim());
        return st.nextToken();
    }
    static long readLong () throws IOException {
        return Long.parseLong(next());
    }
    static int readInt () throws IOException {
        return Integer.parseInt(next());
    }
    static double readDouble () throws IOException {
        return Double.parseDouble(next());
    }
    static char readChar () throws IOException {
        return next().charAt(0);
    }
    static String readLine () throws IOException {
        return input.readLine().trim();
    }
    static void print(Object b) {
        System.out.print(b);
    }
    static void println(Object b) {
        System.out.println(b);
    }
    static void println() {
        System.out.println();
    }
}
