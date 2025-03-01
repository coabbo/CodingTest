import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		StringBuilder sb = new StringBuilder(input);
		String reverseInput = sb.reverse().toString();
		
		if(input.equals(reverseInput)) {
			System.out.println("1");
		} else {
			System.out.println("0");
		}
	}
}