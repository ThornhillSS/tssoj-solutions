
import java.util.*;
import java.io.*;

public class J2HappyOrSad {
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        int hap = 0, sad = 0;
        for (int i=0;i<line.length()-2;i++) {
            if (line.charAt(i)==':'&&line.charAt(i+1)=='-') {
                if (line.charAt(i+2)==')') hap++;
                else if (line.charAt(i+2)=='(') sad++;
            }
        }
        if (hap==sad && hap!=0) System.out.println("unsure");
        else if (hap>sad) System.out.println("happy");
        else if (sad>hap) System.out.println("sad");
        else if (hap==0&&sad==0) System.out.println("none");
        
    }
}
