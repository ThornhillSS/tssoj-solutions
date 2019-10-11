import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); //make scanner
        int numOfStudents = sc.nextInt();    //take input
        sc.nextLine();
        int poop; 
        String[] hereornot = new String [numOfStudents]; //array of student names
        for(int i = 0; i < numOfStudents; i++) {
            hereornot [i] = sc.nextLine(); //fills array with student names
        }
        int numOfQueries = sc.nextInt();
        for(int i = 0; i < numOfQueries; i++) {
            poop = sc.nextInt();
            if (hereornot [poop - 1].equals("yes")) { //compares the the value of the element in hereornot to the string yes and prints an appropriate reponse
                System.out.println("here");
            }
            else {
                System.out.println("not here");
            }
        }
    }
}
