import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int N, M;
	private static char[][] map;
	private static boolean[][] visited;
	
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
		
		visited = new boolean[N][M];
		int count = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(!visited[i][j]) {
					dfs(i, j);
					count++;
				}
			}
		}
		
		System.out.println(count);
	}

	private static void dfs(int r, int c) {
		visited[r][c] = true;
		
		if(map[r][c] == '-') {
			int nr = r + 0;
			int nc = c + 1;
			
			if(nr < 0 || nc < 0 || nr >= N || nc >= M) return;
			if(map[nr][nc] == '|') return;
			
			dfs(nr, nc);
		}
		else {
			int nr = r + 1;
			int nc = c + 0;
			
			if(nr < 0 || nc < 0 || nr >= N || nc >= M) return;
			if(map[nr][nc] == '-') return;
			
			dfs(nr, nc);
		}
	}
}