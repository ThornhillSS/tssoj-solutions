import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException{
    BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(sc.readLine());

    boolean arr[] = new boolean[N+1];

    for(int i = 0; i < N; i++){
      StringTokenizer tk = new StringTokenizer(sc.readLine());
      arr[Integer.parseInt(tk.nextToken())] = true;
    }

    int count = 0;

    for(int i = 0; i <= N; i++){
      if (!arr[i]){
        count += i;
      }
    }
    System.out.print(count);
  }
}
