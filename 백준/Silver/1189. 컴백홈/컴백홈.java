import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int R, C, K;
	private static char[][] map;
	private static boolean[][] visited;
	private static int answer = 0;
	
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		visited = new boolean[R][C];
		
		visited[R-1][0] = true;
		dfs(R-1, 0, 1);
		
		System.out.println(answer);
	}


	private static void dfs(int r, int c, int depth) {
		
		// 거리가 이미 K보다 큰 경우 가지치기
		if (depth > K) return;
		
		// 목적지에 도착했을 때 
		if (r == 0 && c == C - 1) {
			if (depth == K) answer++;
			return;
		}
		
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if (nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
			if (map[nr][nc] == 'T') continue;
			if (visited[nr][nc]) continue;

			visited[nr][nc] = true; // 방문 처리
			dfs(nr, nc, depth + 1);
			visited[nr][nc] = false; // 백트래킹
		}
	}
}