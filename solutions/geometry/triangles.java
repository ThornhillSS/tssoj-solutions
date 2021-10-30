import java.util.*;
import java.io.*;
public class Main
{
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
        for (int i = 0; i < a; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = new Pair(i+1, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(arr);
        for (int i = 0; i < a-2; i++)
        {
            if (!(arr[i].colour == arr[i+1].colour && arr[i+2].colour == arr[i+1].colour))
            {
                System.out.println(arr[i].order + " " + arr[i+1].order + " " + arr[i+2].order);
                System.exit(0);
            }
        }
        System.out.println(-1);
    }
}
