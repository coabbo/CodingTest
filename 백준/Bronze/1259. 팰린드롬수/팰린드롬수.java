import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String origin = "";
		while(true) {
			origin = br.readLine();
			
			if(origin.equals("0")) {
				break;
			}
			
			sb.append(origin);
			String reverseOrigin = sb.reverse().toString();
			
			String answer = "";
			
			if(origin.equals(reverseOrigin)) {
				answer = "yes";
			}
			else {
				answer = "no";
			}
			
			sb.delete(0, sb.length());
			
			System.out.println(answer);
		}
	}	
}