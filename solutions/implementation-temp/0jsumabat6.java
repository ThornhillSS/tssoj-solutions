import java.util.*;
import java.io.*;

public class Main {

  // create a function that increments the characters of the string using ascii values
  public static String incr(String str){
    String str1 = "";
    for (int i = 0; i < str.length(); i++){
    char c = str.charAt(i);
    int ascii = (int) c;
    ascii++;
    if (ascii == 123) ascii = 97;
    str1 += Character.toString((char)ascii);
    }
    return str1;    
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String key = sc.nextLine();
    String s = sc.nextLine();
    // check keeps track of whether the incantation contains the key
    boolean check = false;
    // loop through 26 times to get every variation of the key
    for(int i = 0; i < 26; i++){
    // if the ritual contains a variation of the key, make check true and break out
      if(s.contains(key)){
        check=true;
        break;
      }
     // if it doesn't contain this variation, move onto the next
      key = incr(key);
    }

    // prints the statements accordingly
    
    if(check){
      System.out.print("YOUR SOUL IS MINE");
    }
    else{
      System.out.print("PRANKED");
    }
  }
}
