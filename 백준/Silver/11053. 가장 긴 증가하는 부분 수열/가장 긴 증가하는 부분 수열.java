import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[N];
		dp[0] = 1;
		
		int answer = 0;
		for (int i = 0; i < N; i++) {
			int max = 0;
			for (int j = i-1; j >= 0; j--) {
				if(arr[i] > arr[j] && dp[j] > max) {
					max = dp[j];
				}
			}
			dp[i] = max + 1;
			answer = Math.max(answer, dp[i]);
		}
		
		System.out.println(answer);
	}
}