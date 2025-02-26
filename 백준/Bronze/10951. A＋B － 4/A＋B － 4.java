import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int A, B;
		String input = "";
		
		while((input = br.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(input, " ");

			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			
			System.out.println(A+B);
		}
	}
}