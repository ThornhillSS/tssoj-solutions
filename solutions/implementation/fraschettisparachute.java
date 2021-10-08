import java.util.Scanner;
import java.text.DecimalFormat;
public class Parachute
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.0");
        double a = -4.9;
        double b = 5.0;
        double c = 360.0 - scanner.nextInt();
        System.out.println(df.format((-b-Math.sqrt(Math.pow(b,2)-4*a*c))/(2*a)));
    }
}
