import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	private static int R;
	private static int C;
	private static int maxCount = 0;
	private static char[][] map;
	private static Set<Character> visited;
	
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
		
		visited = new HashSet<>();
		dfs(0, 0);
		
		System.out.println(maxCount);
	}

	private static void dfs(int r, int c) {
		visited.add(map[r][c]);
		maxCount = Math.max(maxCount, visited.size());
		
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
			if(visited.contains(map[nr][nc])) continue;
			
			dfs(nr, nc);
			
			visited.remove(map[nr][nc]);
		}
	}
}