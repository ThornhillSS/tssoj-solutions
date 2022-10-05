
import java.util.*;
import java.io.*;

public class J1SpecialDay {
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt(), d = in.nextInt();
        if (m>2) System.out.println("After");
        else if (m<2) System.out.println("Before");
        else {
            if (d>18) System.out.println("After");
            else if (d<18) System.out.println("Before");
            else System.out.println("Special");
        }
    }
}