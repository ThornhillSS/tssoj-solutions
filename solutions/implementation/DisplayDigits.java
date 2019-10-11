import java.util.Scanner;
// Solution by Adam Chen / Encodeous
public class DisplayDigits {
    public static void main(String[] args) {
        // Problem: http://tssoj.me/problem/digitdisplay
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine(); // Reading the next line
        for(int i = 0; i< s.length(); i++){
            System.out.println(s.charAt(i)); // Print the character on seperate lines
        }
    }
}
