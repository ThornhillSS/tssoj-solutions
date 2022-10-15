import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char f = sc.nextLine().charAt(0);
        char m = sc.nextLine().charAt(0);
        char l = sc.nextLine().charAt(0);
        f = Character.isUpperCase(f) ? Character.toLowerCase(f) : Character.toUpperCase(f);
        m = Character.isUpperCase(m) ? Character.toLowerCase(m) : Character.toUpperCase(m);
        l = Character.isUpperCase(l) ? Character.toLowerCase(l) : Character.toUpperCase(l);
        System.out.println(""+f+m+l);
    }
}
