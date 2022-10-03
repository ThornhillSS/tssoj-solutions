import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    static String next () throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
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
    static char readCharacter () throws IOException {
        return next().charAt(0);
    }
    static String readLine () throws IOException {
        return br.readLine().trim();
    }
    public static void main(String[] args) throws IOException {
            int n = readInt();
        int pp = 0;
            if (n != 1) { ArrayList<Integer> postive = new ArrayList<>(); ArrayList<Integer> negative = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    int xy = readInt();
                    if (xy != 0) {
                        if (xy > 0) postive.add (xy);
                        else negative.add (xy);
                    } }
                for (Integer i : postive) {
                    pp = pp == 0 ? i : pp * i;
                }
                Collections.sort(negative, Collections.reverseOrder ());
                if (negative.size () % 2 == 1) {
                    negative.remove (0);
                }
                for (Integer i : negative) {
                    pp = pp == 0 ? i : pp * i;
                } }
            else {
                pp = readInt();
            }
            System.out.println (pp);
    }}
