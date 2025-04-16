import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N];
		int[] ans = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(num);
		
		int sum = 0;
		for (int i = 0; i < num.length; i++) {
			sum += num[i];
			ans[i] = sum;
		}
		
		int answer = 0;
		for (int i = 0; i < ans.length; i++) {
			answer += ans[i];
		}
		
		System.out.println(answer);
	}
	
}