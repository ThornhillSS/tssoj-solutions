import java.util.*;
import java.io.*;
/**
 * DMOPC '14 Contest 2 P4 - Deforestation
 */
public class triway19w1p4 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int[] massOfTrees = new int[n];
		for (int i = 0; i < n; i++) {
			massOfTrees[i] = readInt();
		}
		int[] prefixSumMassOfTrees = new int[n];
		prefixSumMassOfTrees[0] = massOfTrees[0];
		for (int i = 1; i < n; i++) {
			prefixSumMassOfTrees[i] = prefixSumMassOfTrees[i - 1] + massOfTrees[i];
		}
		int q = readInt();
		for (int i = 0; i < q; i++) {
			int a = readInt();
			int b = readInt();
			System.out.println((prefixSumMassOfTrees[b] - prefixSumMassOfTrees[a] + massOfTrees[a]));
		}
	}
	static String next() throws IOException {
		while (st == null || !st.hasMoreTokens()) 
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}
	static long readLong() throws IOException {
		return Long.parseLong(next());
	}
	static int readInt() throws IOException {
		return Integer.parseInt(next());
	}
	static double readDouble() throws IOException {
		return Double.parseDouble(next());
	}
	static char readCharacter() throws IOException {
		return next().charAt(0);
	}
	static String readLine() throws IOException {
		return br.readLine().trim();
	}
}
