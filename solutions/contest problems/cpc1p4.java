import java.util.*;
import java.io.*;

public class Main {
    //checks if prime
    static boolean prime(int n) 
{ 
    if (n == 1) 
        return false; 
    //checks for factors all the way to root(n)
    for (int i = 2; i * i <= n; i++) { 
        if (n % i == 0) 
            return false; 
    } 
  
    return true; 
} 

    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in); 
    //input
    int N = sc.nextInt();
    //loop for all queries
    for (int i  = 0; i < N; i++){
      int s = sc.nextInt();  
      //hardcode for smaller values
      if (s==1||s==2||s==3){
        System.out.println("NO");
      }
      //goldbach conjecture
      else if(s%2 == 0){
        System.out.println("YES");
      }
      //odd must be odd prime + 2
      else if(prime(s-2)){
        System.out.println("YES");
      }
      //else statement
      else{
        System.out.println("NO");
      }
    }
    
    }
}
