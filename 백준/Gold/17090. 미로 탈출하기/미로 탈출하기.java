import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static int N, M;
	public static char[][] map;
	public static int[][] dp;
	public static boolean[][] visited;
	
	public static int[] dr = {-1, 1, 0, 0};
	public static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j);
			}
		}

		dp = new int[N][M];
		for (int i = 0; i < N; i++) {
			Arrays.fill(dp[i], -1); // 아직 계산 안 된 경우 -1
		}
		
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(dp[i][j] == -1) {
					dfs(i, j);
				}
			}
		}
		
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(dp[i][j] == 1) count++;
			}
		}
		
		System.out.println(count);
	}

	private static int dfs(int r, int c) {
		if(r < 0 || c < 0 || r >= N || c >= M) { // 미로에서 탈출하면 1을 반환
			return 1;
		}
		
		if(dp[r][c] != -1) { // 이미 계산되어 있는 경우 메모이제이션
			return dp[r][c];
		}
		
		dp[r][c] = 0;
		visited[r][c] = true;
		
		int nr = r;
		int nc = c;
		if(map[r][c] == 'U') nr--;
		else if(map[r][c] == 'D') nr++;
		else if(map[r][c] == 'L') nc--;
		else if(map[r][c] == 'R') nc++;
		
		if(nr < 0 || nc < 0 || nr >= N || nc >= M) { // 범위 밖인 경우
			dp[r][c] = dfs(nr, nc);
		}
		else if(visited[nr][nc]) { // 탈출 불가능(사이클)
			dp[r][c] = -2;
			visited[r][c] = false; // 백트래킹
			return -2;
		}
		else {
			dp[r][c] = dfs(nr, nc);
		}
		
		visited[r][c] = false;
		
		return dp[r][c];
	}
}