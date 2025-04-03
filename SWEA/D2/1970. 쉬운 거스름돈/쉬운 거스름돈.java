import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int[] coins = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
		int[] answer = new int[8];
		
		int T = Integer.parseInt(br.readLine()); //테스트케이스 개수
		
		for (int testCase = 1; testCase <= T; testCase++) {
			sb.append("#").append(testCase).append(" ").append("\n");
			
			int money = Integer.parseInt(br.readLine());
			
			for (int i = 0; i < answer.length; i++) {
				answer[i] = money / coins[i];
				sb.append(answer[i]).append(" ");
				money = money % coins[i];
			}
			
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
