import java.util.*;
public class Exercise6 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String input = sc.nextLine();
        
        for(int i = 0; i < input.length(); i++) {
            boolean isDigit = Character.isDigit(input.charAt(i));
            
            if(!isDigit) {
                System.out.println("no");
                return;
            }
            
        }
        System.out.println("yes");
    }

}
