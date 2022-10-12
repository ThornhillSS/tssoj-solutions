import java.util.*;
import java.io.*;

public class J1WinningScore {
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        int a1 = in.nextInt(), a2 = in.nextInt(), a3 = in.nextInt();
        int b1 = in.nextInt(), b2 = in.nextInt(), b3 = in.nextInt();    
        if (a1*3+a2*2+a3 > b1*3+b2*2+b3) System.out.println("A");
        else if (b1*3+b2*2+b3 > a1*3+a2*2+a3) System.out.println("B");       
        else System.out.println("T");
    }
}