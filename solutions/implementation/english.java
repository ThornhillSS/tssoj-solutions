import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int numOfVowels = 0; //counters
	    int numOfWords = 0;
	    int consonants = 0;
	    int n = sc.nextInt(); //takes input for # of words, n
	    String word;
	    for(int i = 0; i<n; i++) {
	        word = sc.next(); //takes input for the current word
	        for(int j = 0; j<word.length(); j++) {
	            if(word.charAt(j) == 'a' || word.charAt(j) == 'e' || word.charAt(j) == 'i' || word.charAt(j) == 'o' || word.charAt(j) == 'u') { //checks if the current letter in the word is a vowel
	                numOfVowels++;
	                if(numOfVowels > 2) { //checks if there were more than 2 vowels together, if so - not an english word
	                    numOfVowels = 0; //returns numOfVowels to 0 since we are only checking for more than 2 consecutive vowels in the word
	                    numOfWords++;
	                    break; //continues onto next word
	                }
	            }
	            else {
	                consonants++;
	                if(numOfVowels>0) //if current letter is not a vowel, but the previous one was, return numOfVowels to 0 again since we are only checking for more than 2 consecutive vowels in the word
	                    numOfVowels = 0;
	                if(consonants == word.length()) { //checks if the word had no vowels, therefore not an english word
	                    consonants = 0;
	                    numOfWords++;
	                }
	                
	            }
	        }
	        consonants = 0; //resets counters for the next word
	        numOfVowels = 0;
	    }
	    System.out.println(numOfWords); //prints out the # of non-english words
	}
}
