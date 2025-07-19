import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 물품의 수
		int K = Integer.parseInt(st.nextToken()); // 버틸 수 있는 무게
		
		int[] weights = new int[N+1];
		int[] values = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			weights[i] = Integer.parseInt(st.nextToken());
			values[i] = Integer.parseInt(st.nextToken());
		}
		
		int[][] dp = new int[N+1][K+1];
		
		for (int i = 1; i <= N; i++) {
			for (int k = 0; k <= K; k++) {
				if(weights[i] <= k) { // 고려할 물품의 무게가 임시무게(k)보다 작은 경우
					dp[i][k] = Math.max(dp[i-1][k], dp[i-1][k-weights[i]] + values[i]);
				}
				else {
					dp[i][k] = dp[i-1][k];
				}
			}
		}
		
		System.out.println(dp[N][K]);
	}
}