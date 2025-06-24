import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수
		
		long[] dp = new long[100 + 1];
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 1;
		
		for (int i = 4; i < dp.length; i++) {
			dp[i] = dp[i-3] + dp[i-2];
		}
		
		for (int testCase = 1; testCase <= T; testCase++) {
			int N = Integer.parseInt(br.readLine());
			
			sb.append(dp[N]).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}