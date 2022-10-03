import java.util.*;
import java.io.*;

public class Main {
  public static class Pair implements Comparable<Pair>{
    public int x;
    public int y;

    public Pair(int x, int y){
      this.x=Math.max(x,y);
      this.y=Math.min(x,y);
    }

    public int compareTo(Pair p){
      if(x == p.x){
        return y - p.y;
      }
      return x - p.x;
    }

    public String toString(){
      return (x + "-" + y);
    }
  }

  public static void main(String[] args) throws IOException{
    BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(java.io.FileDescriptor.out), "ASCII"), 512);
  
    int N = Integer.parseInt(sc.readLine());

    StringTokenizer tk;

    
    for(int asdf = 0; asdf < N; asdf++)
    {
    
      int M = Integer.parseInt(sc.readLine());
      Pair[] arr = new Pair[M];

      for(int i = 0; i < M; i++){
        String s = sc.readLine();
        String[] pair = s.split("-");
        Pair v = new Pair(Integer.parseInt(pair[0]),Integer.parseInt(pair[1]));
        arr[i] = v;
      }

      Arrays.sort(arr);

      ArrayList<ArrayList<Pair>> G = new ArrayList<ArrayList<Pair>>();

      G.add(new ArrayList<Pair>());

      int i = 0;
      int j=0;

      for(Pair p : arr){
        if ((G.get(i)).isEmpty()){
          (G.get(i)).add(p);
          
        }

        
        else{
          boolean check = false;;
          for(int k = 0; k < G.size(); k++){
            if(p.y >= ((G.get(k)).get(G.get(k).size() -1)).y){
              check = true;
              G.get(k).add(p);
              
              break;
            }
          }

          if(!check){
            G.add(new ArrayList<Pair>());
            i++;
            G.get(i).add(p);
          }
        }
      }
      System.out.println(G.size());
    }
  } 
}
