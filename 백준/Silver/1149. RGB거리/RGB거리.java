import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		int[][] cost = new int[N+1][3];
		for (int i = 1; i < cost.length; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			for (int j = 0; j < 3; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 2; i <= N; i++) { // 비용 계산
			cost[i][0] += Math.min(cost[i-1][1], cost[i-1][2]); // 빨강
			cost[i][1] += Math.min(cost[i-1][0], cost[i-1][2]); // 초록
			cost[i][2] += Math.min(cost[i-1][0], cost[i-1][1]); // 파랑
		}
		
		System.out.println(Math.min(cost[N][0], Math.min(cost[N][1], cost[N][2])));
	}
}