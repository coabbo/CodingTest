import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] stair = new int[N+1];
		for (int i = 1; i < stair.length; i++) {
			stair[i] = Integer.parseInt(br.readLine());
		}
		
		int[] dp = new int[N+1];
		if(N >= 1) dp[1] = stair[1];
		if(N >= 2) dp[2] = Math.max(stair[1], stair[1] + stair[2]);
		if(N >= 3) dp[3] = Math.max(stair[1] + stair[3], stair[2] + stair[3]);
		
		for (int i = 4; i < dp.length; i++) {
			dp[i] = Math.max(dp[i-3] + stair[i-1] + stair[i], dp[i-2] + stair[i]);
		}
		
		System.out.println(dp[N]);
	}
}