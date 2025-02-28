import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		String A = st.nextToken();
		String B = st.nextToken();
		
		String reverseA = "";
		String reverseB = "";
		
		for (int i = 2; i >= 0; i--) {
			reverseA += A.charAt(i);
			reverseB += B.charAt(i);
		}
		
		int max = Math.max(Integer.parseInt(reverseA), Integer.parseInt(reverseB));
		
		System.out.println(max);
	}
}