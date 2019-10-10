import java.util.Scanner;

public class CarRecall {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int model = sc.nextInt();
        // Check whether or not model falls into one of the given defective numbers.
        if (model == 119 || model == 179 || (model >= 189 && model <= 198) || model == 221 || model == 780) {
            System.out.println("NOT Safe.");
        }
        // If it doesn't, it is safe.
        else {
            System.out.println("Safe.");
        }

    }
}
