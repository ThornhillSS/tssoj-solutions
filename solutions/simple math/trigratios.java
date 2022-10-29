import java.util.Scanner;
import java.text.DecimalFormat;
import java.lang.Math;
public class trigratios {
    public static void main(String[] args) {
        DecimalFormat formatCommas = new DecimalFormat("#.##");
        Scanner myscanner = new Scanner(System.in);
        int angle = myscanner.nextInt();
        double angler = Math.toRadians(angle); // converts the angle in degree to radians
        System.out.println(formatCommas.format(Math.sin(angler)));
        System.out.println(formatCommas.format(Math.cos(angler)));
        System.out.println(formatCommas.format(Math.tan(angler)));

    }
}
