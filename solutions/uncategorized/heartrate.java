import java.util.Scanner;

public class HeartRate {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double age = input.nextDouble();
        double resting = input.nextDouble();
        double target = input.nextDouble();
        System.out.println(resting + target * (220 - age - resting));
    }
}
