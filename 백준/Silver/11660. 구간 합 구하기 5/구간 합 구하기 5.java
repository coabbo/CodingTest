import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 표의 크기
		int M = Integer.parseInt(st.nextToken()); // 합을 구해야 하는 횟수
		
		int[][] dp = new int[N+1][N+1];
		
		for (int i = 1; i < dp.length; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			for (int j = 1; j < dp.length; j++) {
				dp[i][j] = dp[i][j-1] + Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < M; i++) {
			int sum = 0;
			
			st = new StringTokenizer(br.readLine(), " ");
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			for (int j = x1; j <= x2; j++) {
				sum += dp[j][y2] - dp[j][y1-1];
			}
			
			System.out.println(sum);
		}
	}
}