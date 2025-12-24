import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int N, L, R;
	private static int[][] map;
	private static boolean[][] visited;
	private static int peopleMove = 0;
	private static List<int[]> movePosition;
	
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while(true) {
			boolean moved = false;
			visited = new boolean[N][N];
	
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {	
					if(!visited[i][j]) {
						if(bfs(i, j)) moved = true;
					}
				}
			}
			
			if(!moved) break;
			else peopleMove++;
		}
		
		System.out.println(peopleMove);
	}

	public static boolean bfs(int r, int c) {
		Queue<int[]> q = new ArrayDeque<>();
		movePosition = new ArrayList<>();
		int sum = map[r][c];
		
		q.add(new int[] {r, c});
		visited[r][c] = true;
		movePosition.add(new int[] {r, c});
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int cr = curr[0];
			int cc = curr[1];
			
			for (int d = 0; d < 4; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
				if(visited[nr][nc]) continue;
				if(Math.abs(map[cr][cc] - map[nr][nc]) < L || Math.abs(map[cr][cc] - map[nr][nc]) > R) continue;
				
				q.add(new int[] {nr, nc});
				visited[nr][nc] = true;
				movePosition.add(new int[] {nr, nc});
				sum += map[nr][nc];
			}
		}
		
		if(movePosition.size() > 1) {
			int avg = sum / movePosition.size();
			
			for (int[] position : movePosition) {
				int pr = position[0];
				int pc = position[1];
				
				map[pr][pc] = avg;
			}	
			return true;
		}
		else return false;
	}
}