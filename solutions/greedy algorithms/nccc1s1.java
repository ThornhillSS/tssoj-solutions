import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // gloves[i] represents the number of collected left gloves for size i
        // gloves[i + 3] represents the number of collected right gloves for size i
        int[] gloves = new int[7];
        int pairs = 0;
        for (int i = 0; i < n; i++) {
            int sz = sc.nextInt();
            char side = sc.next().charAt(0);
            if (side == 'L') gloves[sz]++;
            else gloves[sz + 3]++;
            // If a glove from both hands is collected for a given size, match the pair
            if (gloves[sz] > 0 && gloves[sz + 3] > 0) {
              gloves[sz]--;
              gloves[sz + 3]--;
              pairs++;
            }
        }
        System.out.println(pairs);
    }
}
