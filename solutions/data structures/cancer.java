import java.util.*;
public class Main
{
    static long[] bit;
    public static long find (int n)
    {
        long sum = 0;
        while (n > 0)
        {
            sum += bit[n];
            n -= (n & -n);
        }
        return sum;
    }
    public static void update(int n, int v)
    {
        while (n < bit.length)
        {
            bit[n] += v;
            n += (n & -n);
        }
    }
    public static void print()
    {
        for (int i = 1; i < bit.length; i++)
        {
            System.out.print(bit[i] + " ");
        }
        System.out.println();
    }
    public static boolean[] sieve (int n)
    {
        boolean[] composites = new boolean [n+1];
        composites[1] = true;
        for (int i = 2; i*i <= n; i++)
        {
            if (!composites[i])
            {
                for (int j = i*i; j <= n; j += i)
                {
                    composites[j] = true;
                }
            }
        }
        return composites;
    }
	public static void main(String[] args) 
	{
	    Scanner scanner = new Scanner (System.in);
		int n = scanner.nextInt();
		int q = scanner.nextInt();
		boolean[] composites = sieve((int)Math.sqrt(1000000000));
		HashSet<Long> cancer = new HashSet<Long>();
		for (int i = 1; i < composites.length; i++)
		{
		    if (!composites[i])
		    { 
		        cancer.add((long)i * i);
		    }
		}
		int[] arr = new int [n+1];
		bit = new long [n+1];
        for (int i = 1; i <= n; i++)
        {
            arr[i] = scanner.nextInt();
            if (cancer.contains((long)arr[i]))
            {
                update(i, 1);
            }
        }
        for (int i = 0; i < q; i++)
        {
            if (scanner.nextInt() == 1)
            {
                int l = scanner.nextInt();
                int r = scanner.nextInt();
                System.out.println(find(r) - find(l-1));
            }
            else
            {
                int a = 0;
                int b = scanner.nextInt();
                int d = scanner.nextInt();
                if (cancer.contains((long)d))
                {
                    a = 1;
                }
                int c = 0;
                if (cancer.contains((long)arr[b]))
                {
                    c = 1;
                }
                update(b, a - c);
                arr[b] = d;
            }
        }
	}
}
