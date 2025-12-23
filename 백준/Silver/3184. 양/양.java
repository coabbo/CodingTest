import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int R, C;
	private static char[][] map;
	private static boolean[][] visited;
	
	private static int sheepCount = 0;
	private static int wolfCount = 0;
	
	private static int tempSheepCount;
	private static int tempWolfCount;
	
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j);
				
				if(map[i][j] == 'o') sheepCount++;
				if(map[i][j] == 'v') wolfCount++;
			}
		}
		
		visited = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] != '#' && !visited[i][j]) {
					tempSheepCount = 0;
					tempWolfCount = 0;
					
					dfs(i, j);
					
					if(tempSheepCount > tempWolfCount) {
						wolfCount -= tempWolfCount;
					}
					else {
						sheepCount -= tempSheepCount;
					}
				}
			}
		}
		
		System.out.println(sheepCount + " " + wolfCount);
	}

	private static void dfs(int r, int c) {
		visited[r][c] = true;
		
		if(map[r][c] == 'o') tempSheepCount++;
		if(map[r][c] == 'v') tempWolfCount++;
		
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
				
			if(nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
			if(map[nr][nc] == '#') continue;
			if(visited[nr][nc]) continue;
			
			dfs(nr, nc);
		}
	}
}