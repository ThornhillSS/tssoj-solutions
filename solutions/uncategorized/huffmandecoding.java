import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class HuffmanDecoding {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // fancy input
		int codes = Integer.parseInt(br.readLine()); // get the amount of future letters and numbers
		HashMap<String, String> thing = new HashMap<String, String>(); // this hashmap will store the values of both the letter and its corrosponding number
		String ans = ""; // this will be the final answer
		
		for(int i = 0; i < codes; i++) { // looping to get my input
			String[] a = br.readLine().split(" "); // splitting the first line
			String b = a[0]; // temproary element 1
			String c = a[1]; // emproary element 2
			thing.put(c, b); // add these values to the hasmap
		}
		
		String[] code = br.readLine().split(""); // this is the encoded message
		String x = ""; // this will be used to store the numbers of the ecoded message
		
		for(int i = 0; i < code.length; i++) { // loop though the entire length of the encoded message
			x = x + code[i]; // make a string of the numbers (ne by one)
			if(thing.containsKey(x)) { // if there is a match between the string i have accumulated and a key
				ans = ans + thing.get(x); // my answer will now include the letter corosponding with the numbers
				x = ""; // reset the string for future checks
			}
		}
		System.out.println(ans); // print out the decoded message
	}
}
