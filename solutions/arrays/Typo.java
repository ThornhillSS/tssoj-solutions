import java.util.Scanner;

public class Typo {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    // Get text as character array.
    char[] text = sc.nextLine().toCharArray();
    int typos = sc.nextInt();
    // For each typo, modify the array element to the corrected character.
    for (int i = 0; i < typos; i++) {
      int index = sc.nextInt();
      String replacement = sc.next();
      text[index] = replacement.charAt(0);
    }
    System.out.println(new String(text));
  }
}
