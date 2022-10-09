import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Pair class :)
 */
class Pair{

    public Pair(int left, int right, int count) {
        this.left = left;
        this.right = right;
        this.count = count;
    }

    public int left;
    public int right;
    public int count;

}
public class Victor3 {
    /**
     * Recursively loop through all 2^n cases
     * @param n Current index
     * @param state Current State
     * @param req Requirements
     * @return returns true if the state is valid
     */
    public static boolean solve(int n, boolean[] state, ArrayList<Pair> req){
        // base case
        if(n == 0){
            // check requirements
            for(Pair x : req){
                int count = 0;
                for(int i = x.left; i <= x.right; i++){
                    if(state[i]) count++;
                }
                if(count != x.count){
                    return false;
                }
            }
            // output the array
            for(int i = 1; i < state.length; i++){
                System.out.print(state[i] ? "1 ": "0 ");
            }
            System.out.println();
            return true;
        }
        // Case 1: set current to white
        state[n] = true;
        if(solve(n-1, state, req)) return true; // if we found a valid case, then just return
        // case 2: set current to black
        state[n] = false;
        if(solve(n-1, state, req)) return true; // if we found a valid case, then just return
        // No valid case
        return false;
    }

    /**
     * This solution will brute force all 2^n possible cases.
     * Time Complexity: O(T*M*2^N)
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for(int cs = 0; cs < t; cs++){
            int n = scan.nextInt(), m = scan.nextInt();
            ArrayList<Pair> arr = new ArrayList<>();
            // read in the requirements
            for(int i = 0; i < m; i++){
                int l = scan.nextInt(), r = scan.nextInt(), c = scan.nextInt();
                arr.add(new Pair(l,r,c));
            }
            // brute force the solution
            solve(n, new boolean[n+1], arr);
        }
        scan.close();
    }
}
