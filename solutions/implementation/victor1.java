import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @author Encodeous
 * Solution to https://tssoj.ca/problem/victor1
 */
public class Victor1 {
    public static void main(String[] args) {
        // Read Input
        Scanner sc = new Scanner(System.in);
        // Read the initial value
        double initialValue = sc.nextDouble();
        // Apply operators until the '=' sign
        while (true) {
            String operator = sc.next();
            // check if it is the '=' sign
            if (operator.equals("="))
                break;
            // read and parse the number
            String value = sc.next();
            double doubleValue = Double.parseDouble(value);
            // apply the operation
            if (operator.equals("+")) {
                initialValue += doubleValue;
            } else {
                initialValue -= doubleValue;
            }
        }
        // format the output
        DecimalFormat df = new DecimalFormat("0.0");
        System.out.println(df.format(initialValue));
    }
}
