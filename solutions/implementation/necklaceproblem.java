import java.util.Scanner;

public class Main {

    private static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        for(int i = 0; i < n; i++) {
          int a = sc.nextInt();
          int b = sc.nextInt();
          int previous = a; // keep track of previous bead
          int current = b; // keep track of current bead

          System.out.print(a + " " + b);
          while(true) {
            int temp = current;
            current = (current + previous) % 10; // set current bead to unit's digit of the sum
            System.out.print(" " + current);
            previous = temp;
            if(current == b && previous == a) break;
          }
          System.out.println();
        }
    }
}
