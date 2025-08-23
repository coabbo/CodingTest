import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int[][] map;
	private static int[] area;
	private static boolean[][] visited;
	
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		int minHeight = Integer.MAX_VALUE;
		int maxHeight = Integer.MIN_VALUE;
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");	
			
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				minHeight = Math.min(minHeight, map[i][j]);
				maxHeight = Math.max(maxHeight, map[i][j]);
			}
		}
		
		area = new int[maxHeight + 1];
		
		for (int height = 0; height <= maxHeight; height++) {
			visited = new boolean[N][N];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(!visited[i][j] && height < map[i][j]) {
						bfs(i, j, height);
					}
				}
			}
		}
		
		int maxArea = 0;
		for (int height = 0; height <= maxHeight; height++) {
			maxArea = Math.max(area[height], maxArea);
		}
		System.out.println(maxArea);
	}

	public static void bfs(int r, int c, int height) {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {r, c});
		visited[r][c] = true;
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int cr = curr[0];
			int cc = curr[1];
			
			for (int d = 0; d < 4; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
				if(visited[nr][nc]) continue;
				if(height >= map[nr][nc]) continue;
				
				q.add(new int[] {nr, nc});
				visited[nr][nc] = true;
			}
		}
		
		area[height] = area[height] + 1;
	}
}