import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			
			System.out.print(s.charAt(0));
			System.out.print(s.charAt(s.length()-1));
			System.out.println("");
		}
	}
}