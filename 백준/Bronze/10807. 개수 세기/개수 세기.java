import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] numArr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			numArr[i] = Integer.parseInt(st.nextToken());
		}
				
		int v = Integer.parseInt(br.readLine());
		int answer = 0;
		
		for (int i = 0; i < numArr.length; i++) {
			if(numArr[i] == v) {
				answer += 1;
			}
		}
		
		System.out.println(answer);
	}
}