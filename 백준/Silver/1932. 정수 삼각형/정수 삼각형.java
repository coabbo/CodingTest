import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 삼각형의 크기
		
		int[][] arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			for (int j = 0; j < N; j++) {
				if(!st.hasMoreTokens()) continue;
				
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] dp = new int[N][N];
		dp[0][0] = arr[0][0];
		
		for (int i = 1; i < N; i++) {
			for (int j = 0; j <= i; j++) {
				if(j == 0) dp[i][j] = dp[i-1][j] + arr[i][j];
				else if(j == i) dp[i][j] = dp[i-1][j-1] + arr[i][j];
				else dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + arr[i][j];
			}
		}
		
		int ans = 0;
		for (int j = 0; j < N; j++) {
			ans = Math.max(ans, dp[N-1][j]);
		}
		System.out.println(ans);
	}
}