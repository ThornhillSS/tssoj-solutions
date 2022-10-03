import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException{
    BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(sc.readLine());
    N -= 1;
    int val = Integer.parseInt(sc.readLine());

    int iter = -1;
    int out = 1;

    while (N!=0){
      N = N >> 1;
      iter++;
      int max = 0;
      for(int i = 0; i < Math.pow(2,iter); i++){
        int a = Integer.parseInt(sc.readLine());
        if (a>max){
          max = a;
        }
      }
      if (max > val){
        break;
      }
      else{
        out++;
      }

    }

    
    System.out.print(out);
  }
}
