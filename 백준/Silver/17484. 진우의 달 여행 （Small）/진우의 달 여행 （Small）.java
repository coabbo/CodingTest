import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static int N;
	private static int M;
	private static int[][] map;
	private static int result;
	
	static int[] dr = {1, 1, 1};
	static int[] dc = {-1, 0, 1};

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken()); // 행의 수
		M = Integer.parseInt(st.nextToken()); // 열의 수
		
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		result = Integer.MAX_VALUE;
		for (int c = 0; c < M; c++) { // 맨 처음 시작할 때 갈 수 있는 방향
			dfs(0, c, -1, map[0][c]);
		}
		
		System.out.println(result);
	}

	
	private static void dfs(int r, int c, int lastDir, int sum) {
		
		if(r == N-1) { // 도착
			result = Math.min(result, sum);
			return;
		}
		
		for (int d = 0; d < 3; d++) {
			
			if(d == lastDir) continue; // 같은 방향 연속 금지
			
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue; // 범위 벗어나면 패스
			
			dfs(nr, nc, d, sum + map[nr][nc]); // 누적 연료 더해서 재귀
		}
	}
}