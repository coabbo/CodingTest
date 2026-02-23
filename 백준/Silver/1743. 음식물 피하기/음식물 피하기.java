import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static int N, M, K;
	private static char[][] map;
	private static boolean[][] visited;
	
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		for (char[] c : map) {
			Arrays.fill(c, '.');
		}
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			map[r-1][c-1] = '#';
		}
		
		visited = new boolean[N][M];
		
		int maxSize = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == '#' && !visited[i][j]) {
					int size = dfs(i, j);
					maxSize = Math.max(maxSize, size);
				}
			}
		}
		
		System.out.println(maxSize);
	}

	private static int dfs(int r, int c) {
		visited[r][c] = true;
		int count = 1;
		
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
			if(visited[nr][nc]) continue;
			if(map[nr][nc] == '.') continue;
			
			count += dfs(nr, nc);
		}
		
		return count;
	}
}