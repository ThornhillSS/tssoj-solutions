import java.lang.*;
import java.util.Scanner;

public class main {
    static String ptime_checker(int n)
    {
        if (n <= 1)
            return "YES";
        for (int i = 2; i < n; i++)
            if (n % i == 0)
                return "NO";

        return "YES";
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        System.out.println(ptime_checker(n));
    }
}
