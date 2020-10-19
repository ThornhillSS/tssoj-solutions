/* This program creates an object to deal with the numerous parameters associated with each knob on the soundboard, and stores
 * these parameters in an 2D ArrayList in the same format as the connections of nodes on a graph. It then makes use of the object's
 * private fields to manipulate the values of each knob on the soundboard and output the final result after all operations are complete.
 */
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class Main
{
    static class SoundboardKnob {
        
        private int x, num;
        private String operand;
        
        SoundboardKnob (int a, String b, int c) { // constructor for SoundboardKnob object
            x = a;
            num = c;
            operand = b;
        }
    }
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long soundboardValues[] = new long[N + 1]; // stores the value of each knob
		ArrayList<SoundboardKnob> knobImpact[] = new ArrayList[N + 1]; // stores the values of each soundboard knob and which knob it impacts/how it impacts it
		ArrayList<Integer> queue = new ArrayList<Integer>(); // temporarily stores knob indexes
		for (int i = 1; i <= N; i++)
		{
		    knobImpact[i] = new ArrayList<SoundboardKnob>();
		}
		int numBrokenKnobs = Integer.parseInt(br.readLine());
		for (int i = 0; i < numBrokenKnobs; i++)
		{
		    String knobTurnValues[] = br.readLine().split(" ");
		    knobImpact[Integer.parseInt(knobTurnValues[0])].add(new SoundboardKnob(Integer.parseInt(knobTurnValues[1]), (knobTurnValues[2]), Integer.parseInt(knobTurnValues[3])));
		}
		int numQueries = Integer.parseInt(br.readLine());
		for (int i = 0; i < numQueries; i++)
		{
		    String queryInput[] = br.readLine().split(" ");
		    int knobIndex = Integer.parseInt(queryInput[0]);
		    soundboardValues[knobIndex] += Integer.parseInt(queryInput[1]); // adds amount that knob increases by to correct index
		    queue.add(knobIndex); // adds knob index to queue as initial "node"/starting point for broken knob turns
		    while(queue.size() != 0) // executes until all indexes that are connected have been traversed through, like nodes in a graph
		    {
		        int curKnob = queue.get(0); 
		        queue.remove(0);
		        for (SoundboardKnob j : knobImpact[curKnob]) // traverses through all knobs impacted by knob j
		        {
		            queue.add(j.x); // adds knob index to queue
		            if (j.operand.equals("+")) // checks sign of operation completed
		            {
		                soundboardValues[j.x] += j.num;
		            }
		            else
		            {
		                soundboardValues[j.x] *= j.num;
		            }
		        }
		    }
		}
		for (int i = 1; i <= N; i++)
		{
		    System.out.print(soundboardValues[i] + " ");
		}
	}
}
