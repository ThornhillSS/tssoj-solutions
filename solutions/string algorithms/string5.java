import java.util.Scanner;
public class HTMLStrings {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		
		String input = sc.nextLine();
		System.out.println(removeTag(input));

	}
	
	private static String removeTag(String html) { 
		// check minimum length for proper tag.
		if(html.length() < 7) { 
			return html;
		}
		
		if(html.charAt(0) != '<' ) {
			return html;
		}
		int i = 1;
		String tag = "</";
		//Get the prefix of the tag.
		while(i < html.length() && html.charAt(i) != '>') {
		  tag += html.charAt(i);
		  i++;
		}
		tag += ">";
		if(i >= html.length() || html.charAt(i) != '>' || !html.endsWith(tag)) return html;
		//return the tag's content.
		return html.substring(i+1, html.length()-tag.length());

	}

}
