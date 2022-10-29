import java.util.Scanner;
public class mypow {
    public static void main(String args[]) {
        Scanner myscanner = new Scanner(System.in);
        int x = myscanner.nextInt();
        int y = myscanner.nextInt();
        double LogX = Math.log(x); // calculating the log of x
        double EPower = y*LogX; // the power of e
        double ans = Math.exp(EPower); // the answer using the e constant formula
        System.out.println(ans);
        System.out.println(Math.pow(x,y));
    }
}
