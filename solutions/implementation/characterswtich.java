import java.util.Scanner;
public class Main {  
  public static void main(String args[]) { 
    Scanner sc = new Scanner(System.in);
    String[] txt = sc.nextLine().split(""); // splits the inputed word into letters

    System.out.print(txt[txt.length - 1]); // prints out the last letter of the word
      
      // This loop will print out the middle portion of the word (no first and last letter)
      for(int i = 1; i < txt.length - 1; i++) {
        System.out.print(txt[i]);
      }
    System.out.print(txt[0]); // prints out the first letter of the word
  } 
}
