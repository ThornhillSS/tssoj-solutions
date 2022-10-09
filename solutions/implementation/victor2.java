import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @author Encodeous
 * Solution to https://tssoj.ca/problem/victor2
 */
public class Victor2 {
    private static int numberOfArrangements = 0;
    private static int totalSlots;
     private static int repeatCondition;
    /**
     * Recursively solve the problem
     * @param slot The current slot
     * @param count The number of marbles that are currently the same, and are in a row
     * @param isWhite The color of the marbles that are currently in a row
     */
    public static void solve(int slot, int count, boolean isWhite) {
        if (count > repeatCondition)
            return;
        if (slot == totalSlots) {
            numberOfArrangements++;
            return;
        }
        // white marble
        solve(slot + 1, isWhite ? count + 1 : 1, true);
        // black marble
        solve(slot + 1, isWhite ? 1 : count + 1, false);
    }
    public static void main(String[] args) {
        // Read Input
        Scanner sc = new Scanner(System.in);
        // Read M and R
        totalSlots = sc.nextInt();
        repeatCondition = sc.nextInt();
        // call the recursive function
        // first marble is white
        solve(1, 1, true);
        // first marble is black
        solve(1, 1, false);
        System.out.println(numberOfArrangements);
    }
}
