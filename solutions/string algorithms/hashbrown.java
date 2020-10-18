import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static long[]hash, p, hash1, p1;
    public static void main(String[] args) throws IOException{
        int n = readInt(), m = readInt(), seed = 131, arr[] = new int[n+1], arr1[] = new int[m+1];
        for(int i = 0; i<n; i++){
            arr[i] = readInt();
        }
        for(int i = 0; i<m; i++){
            arr1[i] = readInt();
        }
        hash = new long[n+1];
        p = new long[n+1];
        hash1 = new long[m+1];
        p1 = new long[m+1];
        p[0] = 1;
        p1[0] = 1;
        for(int i = 1; i<=n; i++){
            hash[i] = hash[i-1]*seed+arr[i-1];
            p[i] = p[i-1]*seed;
        }
        for(int i = 1; i<=m; i++){
            hash1[i] = hash1[i-1]*seed+arr1[i-1];
            p1[i] = p1[i-1]*seed;
        }
        int ans = 0;
        long val = hash(1, m);
        for(int i = 1; i+m<=n+1; i++){
            if(solve(i, i+m-1)==val)ans++;
        }
        System.out.println(ans);
    }
    static long solve(int l, int r){
        return hash[r]-hash[l-1]*p[r-l+1];
    }
    static long hash(int l, int r){
        return hash1[r]-hash1[l-1]*p1[r-l+1];
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
}
