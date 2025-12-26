import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static int M, N;
	private static int[][] map;
	private static int[][] dp;
	
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[M][N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp = new int[M][N];
		for (int i = 0; i < M; i++) {
			Arrays.fill(dp[i], -1); // 아직 계산 안 된 경우 -1
		}
		
		int answer = dfs(0, 0);
		System.out.println(answer);
	}
	
	// (r, c)에서 도착점까지 갈 수 있는 경로 수 반환
	public static int dfs(int r, int c) {
		if(r == M-1 && c == N-1) { // 도착점, 경로 하나 완성
			return 1;
		}
		
		if(dp[r][c] != -1) { // 이미 계산되어 있는 경우 메모이제이션
			return dp[r][c];
		}
		
		dp[r][c] = 0;
		
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr < 0 || nc < 0 || nr >= M || nc >= N) continue;
			if(map[r][c] <= map[nr][nc]) continue;
			
			dp[r][c] += dfs(nr, nc);
		}
		
		return dp[r][c];
	}
}