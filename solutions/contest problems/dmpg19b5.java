//The idea of this solution is to sort all pairs by their x-value and pick a group of 3 adjacent pair, so there can't be other points inside the triangle they create 
import java.util.*;
import java.io.*;
public class Main
{
    //Pair class to sort points by their x-value while retaining the corresponding y-value, index and colour
    static class Pair implements Comparable<Pair>
    {
        int x;
        int y;
        int colour;
        int order;
        Pair (int order, int x, int y, int colour)
        {
            this.order = order;
            this.x = x;
            this.y = y;
            this.colour = colour;
        }
        public int compareTo(Pair other)
        {
            return this.x - other.x;
        }
    }
    public static void main(String[] args) throws IOException
    {
        Scanner scanner = new Scanner (System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        Pair arr[] = new Pair[a];
        //reading input and creating a pair object that contains its index, x, y, and colour
        for (int i = 0; i < a; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = new Pair(i+1, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        //sorting all pairs by x-value
        Arrays.sort(arr);
        for (int i = 0; i < a-2; i++)
        {
            //if three adjacent pairs in the sorted array don't all share colours, output it and exit
            if (!(arr[i].colour == arr[i+1].colour && arr[i+2].colour == arr[i+1].colour))
            {
                System.out.println(arr[i].order + " " + arr[i+1].order + " " + arr[i+2].order);
                System.exit(0);
            }
        }
        //if program hasn't exited, there are no valid pairs
        System.out.println(-1);
    }
}
