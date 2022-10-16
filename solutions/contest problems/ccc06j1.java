/*
 *Write a program that will compute the total Calories of a meal.
 *The user will enter the number of calories for each of the four
 *food items eaten. The program will then display the total number
 *of calories consumed.
 *Created by Amirhosein Soleimanian
 *LINK: https://tssoj.ca/problem/ccc06j1
 */

import java.io.*;

public class ccc_2006_J1{
    public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    int cal = 0;
    int choice = 0;
    choice = Integer.parseInt(in.readLine());
    if(choice == 1) cal += 461;
    else if(choice == 2) cal += 431;
    else if(choice == 3) cal += 420;

    choice = Integer.parseInt(in.readLine());
    if(choice == 1) cal += 100;
    else if(choice == 2) cal += 57;
    else if(choice == 3) cal += 70;

    choice = Integer.parseInt(in.readLine());
    if(choice == 1) cal += 130;
    else if(choice == 2) cal += 160;
    else if(choice == 3) cal += 118;

    choice = Integer.parseInt(in.readLine());
    if(choice == 1) cal += 167;
    else if(choice == 2) cal += 266;
    else if(choice == 3) cal += 75;

    System.out.println("Your total Calorie count is " + cal + ".");
    }
}