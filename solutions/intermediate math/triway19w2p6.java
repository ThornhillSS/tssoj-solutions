import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    static BigInteger[] dp = new BigInteger[201];
    static BigInteger solveFast(int n){
        if(dp[n] != null) return dp[n];
        if(n == 1 || n == 2) return BigInteger.ONE;
        else return dp[n] = solveFast(n - 1).add(solveFast(n - 2));
    }
    public static void main(String[] args) {
        // recursive dp with BigInteger
        Scanner s = new Scanner(System.in);
        while(true){
            int n = s.nextInt();
            if(n == 0) break;
            System.out.println(solveFast(n).toString());
        }
    }
}