import java.util.Scanner;
import java.text.DecimalFormat;

/**
 * @author Encodeous
 * Solution to https://tssoj.ca/problem/victor4
 */
public class Victor4 {
    private static final Scanner READER = new Scanner(System.in);

    /**
     * Evaluates the input of the program
     *
     * @return Returns the evaluated result
     */
    private static double parseValue() {
        // Ensure the test data is correct & that we have made no errors
        if (!READER.next().equals("(")) {
            System.out.println("Invalid Data");
            return Double.NaN;
        }
        // Check if the next token is a value, or an expression
        if (READER.hasNextDouble()) {
            // The next token is a double, so we can just return it
            double value = READER.nextDouble();
            // "Consume" the closing bracket
            READER.next();
            return value;
        }
        // The next token will contain an expression
        double leftVal = parseValue();

        String operator = READER.next();

        double rightVal = parseValue();

        // "Consume" the closing bracket
        READER.next();

        // Apply operation
        if (operator.equals("!")) {
            if (leftVal > rightVal) {
                return leftVal + rightVal;
            } else {
                return leftVal - rightVal;
            }
        } else if (operator.equals("@")) {
            if (leftVal > rightVal) {
                return leftVal - rightVal;
            } else {
                return leftVal + rightVal;
            }
        } else {
            return Math.sqrt(leftVal * leftVal + rightVal * rightVal);
        }
    }

    public static void main(String[] args) {
        DecimalFormat formatter = new DecimalFormat("0.0");
        // Recursively parse, then format the expression
        System.out.println(formatter.format(parseValue()));
    }
}
