
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int A = -3;
		int B = 13;
		
		while(A != 0 && B != 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			if(A == 0 && B == 0) {
				break;
			}
			System.out.println(A+B);
		}
	}
}