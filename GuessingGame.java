package Chapter5;
import java.util.Random;
import java.util.Scanner;
public class GuessingGame {
    public static void main(String[] args){
        final int MAX = 20; //maximum random number
        Scanner myscanner = new Scanner(System.in);
        int NumSeed = myscanner.nextInt(); //gets the seed
        int jsumabatNumber = myscanner.nextInt(); // gets the number
        Random rand = new Random(NumSeed);
        rand.setSeed(NumSeed);
        int answer = rand.nextInt(MAX) + 1; //correct answer
        if (jsumabatNumber == answer){
            System.out.println("WINNER");
        }
        else {
                   System.out.println("LOSER");
        }
    }
}
