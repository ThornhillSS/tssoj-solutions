import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Making scanner
        String unit1 = sc.nextLine(); // Get the first number as a string
        String unit2 = sc.nextLine(); // Get the second number as a string
        int length1 = unit1.length(); // Get the length of the first number
        int length2 = unit2.length(); // Get the length of the second number
        int length = length2; // This will be the longer one
        int carryOver = 0; // This will be used to calculate the remainder
        if(length1 >= length2) {
          length = length1;
        }
        int [] array1 = new int [length]; // make an array for both the numbers
        int [] array2 = new int [length];
        String ans = ""; // this will store the final answer
        for(int i = 0; i < length1; i++) { // split the numbers into seperate digits into 2 arrays
          array1 [length - i - 1] = Character.getNumericValue(unit1.charAt(length1 - i - 1));
        }
        for(int j = 0; j < length2; j++) {
          array2 [length - j - 1] = Character.getNumericValue(unit2.charAt(length2 - j - 1));
        }
        for(int a = 0; a < length; a++) { 
         ans += (array1 [length - a - 1] + array2 [length - a - 1] + carryOver) % 10; // add the first digit of the sum to the final answer
          carryOver = (int) ((array1 [length - a - 1] + array2 [length - a - 1] + carryOver) / 10); // this will store the carried over value
        }
        if(carryOver == 1) {
        	ans += carryOver; // add the additional carried over number if necessary
        }
        String[] thing = ans.split(""); // this will set the final answer to a string array
        for(int b = 0; b < ans.length(); b++){
          System.out.print(thing[ans.length() - b - 1]); // print out all elements in the string array
        }
    }
}
