//The idea behind this dp solution is to use an array that will hold the maximum value that can be obtained using the first i numbers, and build up to the final answer.
import java.util.*;
import java.io.*;
public class Main 
{
    public static void main(String[] args) throws IOException 
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long arr[] = new long[a+1];
        //checking the first index seperately as subtracting 2 from the index would throw an outofbounds error
        arr[1] = Math.max(arr[0], arr[0] + Integer.parseInt(st.nextToken()));
        //looping through the input 
        for (int i = 2; i <= a; i++)
        {
            long c = Integer.parseInt(st.nextToken());
            //adding the current value to the max 2 indexes before (since they can't be consecutive), and setting it the current index's max if it's bigger than the previous index's max
            arr[i] = Math.max(arr[i-1], arr[i-2] + c);
        }
        //the max of the last index is the answer
        System.out.println(arr[a]);
    }
}
