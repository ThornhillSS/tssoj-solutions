import java.util.*;
import java.io.*;
/**
 * CCC '05 S5 - Pinball Ranking
 */
public class ccc05s5 {
	static final int MOD = 1000000007;
	static double S;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		S = 0;
		int t = readInt();
		int[] scores = new int[t];
		for (int i = 0; i < t; i++) {
			scores[i] = readInt();
		}
		mergeSort(scores, 0, t - 1);
		System.out.format("%.2f", (double)((int)((double)(100 * (S + t))/(double)t)) / (double)(100));
	}
	static void mergeSort(int[] array, int x, int z) {
		if (x < z) {
			int y = (x + z) / 2;
			mergeSort(array, x, y);
			mergeSort(array, y + 1, z);
			S += merge(array, x, y, z);
		}
	}
	static double merge(int[] array, int x, int y, int z) {
		int[] array0 = new int[z - x + 1];
		double total = 0;
		int x0 = x;
		int y0 = y + 1;
		int i = 0;
		while (x0 <= y && y0 <= z) {
			if (array[x0] <= array[y0]) {
				array0[i++] = array[x0++];
			}
			else {
				array0[i++] = array[y0++];
				total += (y + 1 - x0);
			}
		}
		while (x0 <= y) {
			array0[i++] = array[x0++];
		}
		while (y0 <= z) {
			array0[i++] = array[y0++];
		}
		for (x0 = x; x0 <= z; x0++) {
			array[x0] = array0[x0 - x];
		}
		return total;
	}
	static String next() throws IOException {
		while (st == null || !st.hasMoreTokens()) {
			st = new StringTokenizer(br.readLine().trim());
		}
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
