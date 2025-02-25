
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int total = Integer.parseInt(br.readLine());
		int sum = 0;
		
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine() + " ");
			
			int price = Integer.parseInt(st.nextToken());
			int count = Integer.parseInt(st.nextToken());
			
			sum += price * count;
		}
		
		if(total == sum) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}
}