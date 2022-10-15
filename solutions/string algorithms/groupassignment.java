import java.util.Scanner;


public class Work1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char c = sc.nextLine().charAt(0);
        System.out.println(c <= 'I' ? "Group 1." : (c <= 'S' ? "Group 2." : "Group 3."));
    }    
}
