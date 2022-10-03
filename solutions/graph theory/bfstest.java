import java.io.*;
import java.util.*;

public class Main {
    /*
        We can do bfs from 0 to n-1, and use a boolean vis array to keep track of which nodes can be visited from 0.
        This would allow us to determine if the n-1 node can be checked or not.
    */
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    public static void main(String[] args) throws IOException {
        int n = readInt(), m = readInt();
        ArrayList<Integer>adj[] = new ArrayList[n+1];
        for(int i = 0; i<=n; i++){
            adj[i] = new ArrayList();
        }
        for(int i = 0; i<m; i++){
            int a = readInt(), b = readInt();
            adj[a].add(b);
            adj[b].add(a);
        }
        Queue<Integer>Q = new LinkedList();
        boolean[]vis = new boolean[n];
        vis[0] = true;
        Q.add(0);
        while(!Q.isEmpty()){
            int cur = Q.poll();
            for(int v:adj[cur]){
                if(!vis[v]){
                    vis[v] = true;
                    Q.add(v);
                }
            }
        }
        println(vis[n-1]?"yes":"no");
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
