import java.util.Random;
import java.util.Scanner;
import java. lang. Math. *;


public class Work1 {

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        String num = "" + input.nextInt();
        
        int total = 0;
        
        for(int i = 0; i < num.length(); i++) {
              total += Integer.parseInt("" + num.charAt(i));
        }
        System.out.println(total);
    }
}
