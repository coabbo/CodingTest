import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int R, C;
	private static char[][] map;
	private static boolean[][] visited;
	private static int sheepCount = 0;
	private static int wolfCount = 0;
	
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
					bfs(i, j);
				}
			}
		}
		
		System.out.println(sheepCount + " " + wolfCount);
	}

	private static void bfs(int r, int c) {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {r, c});
		visited[r][c] = true;
		
		int tempSheepCount = 0;
		int tempWolfCount = 0;
		
		if(map[r][c] == 'o') tempSheepCount++;
		if(map[r][c] == 'v') tempWolfCount++;
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int cr = curr[0];
			int cc = curr[1];
			
			for (int d = 0; d < 4; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				
				if(nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
				if(map[nr][nc] == '#') continue;
				if(visited[nr][nc]) continue;
				
				if(map[nr][nc] == 'o') tempSheepCount++;
				if(map[nr][nc] == 'v') tempWolfCount++;
				q.add(new int[] {nr, nc});
				visited[nr][nc] = true;
			}
		}
		
		if(tempSheepCount > tempWolfCount) {
			wolfCount -= tempWolfCount;
		}
		else {
			sheepCount -= tempSheepCount;
		}
	}
}