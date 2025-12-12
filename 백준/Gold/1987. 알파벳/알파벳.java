import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int R;
	private static int C;
	private static int maxCount = 0;
	private static char[][] map;
	private static boolean[] visited;
	
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		for (int i = 0; i < map.length; i++) {
			String s = br.readLine();
			
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		
		visited = new boolean[26];
		dfs(0, 0, 1);
		
		System.out.println(maxCount);
	}

	private static void dfs(int r, int c, int count) {
		visited[map[r][c] - 'A'] = true;
		maxCount = Math.max(maxCount, count);
		
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
			if(visited[map[nr][nc] - 'A']) continue;
			
			dfs(nr, nc, count + 1);
			
			visited[map[nr][nc] - 'A'] = false;
		}
	}
}