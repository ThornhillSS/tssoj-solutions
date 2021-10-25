import java.util.*;
import java.io.*;
public class Main 
{
    int n;
    int parent[];
    int rank[];
    public Main(int n)
    {
        this.n = n;
        parent = new int[n];
        rank = new int [n];
        for (int i = 0; i < n; i++)
        {
            parent[i] = i;
        }
    }
    int find(int x)
    {
        if (parent[x] != x)
        {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    void union(int x, int y)
    {
        int xRoot = find(x);
        int yRoot = find(y);
        if (xRoot == yRoot)
        {
            return;
        }
        if (rank[xRoot] < rank[yRoot])
        {
            parent[xRoot] = yRoot;
        }
        else if (rank[xRoot] > rank[yRoot])
        {
            parent[yRoot] = xRoot;
        }
        else 
        {
            parent[yRoot] = xRoot;
            rank[xRoot] += 1;
        }
    }
    public static void main (String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int c = a;
        Main dsu = new Main(a);
        int b = Integer.parseInt(br.readLine());
        for (int i = 0; i < b; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken())-1;
            int e = Integer.parseInt(st.nextToken())-1;
            if (dsu.find(d) != dsu.find(e))
            {
                c --;
            }
            dsu.union(d, e);
        }
        System.out.println(c);
    }
}
