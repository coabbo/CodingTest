import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int N, M;
	private static List<int[]>[][] graph;
	private static boolean[][] visited;
	private static boolean[][] light;
	private static int count;
	
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new List[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				graph[i][j] = new ArrayList<>();
			}
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph[x][y].add(new int[] {a, b});
		}
		
		visited = new boolean[N+1][N+1];
		light = new boolean[N+1][N+1];
		count = 1;
		bfs(1, 1);
		System.out.println(count);
	}

	public static void bfs(int r, int c) {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {r, c});
		visited[r][c] = true;
		light[r][c] = true;
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int cr = curr[0];
			int cc = curr[1];
			
			for (int[] pos : graph[cr][cc]) {
				int nr = pos[0];
				int nc = pos[1];
				
				if(!light[nr][nc]) {
					light[nr][nc] = true;
					count++;
				}
				
				// 불이 켜져있는 방에서 인접한 방문 가능한 방이 있으면 추가
				for (int d = 0; d < 4; d++) {
					int checkR = nr + dr[d];
					int checkC = nc + dc[d];
								
					if(checkR < 1 || checkC < 1 || checkR > N || checkC > N) continue;
					
					if(visited[checkR][checkC] && !visited[nr][nc]) {
						q.add(new int[] {nr, nc});
						visited[nr][nc] = true;
						break;
					}
				}
			}
			
			// 상하좌우로 이동
			for (int d = 0; d < 4; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				
				if(nr < 1 || nc < 1 || nr > N || nc > N) continue;
				if(!light[nr][nc]) continue;
				if(visited[nr][nc]) continue;
				
				q.add(new int[] {nr, nc});
				visited[nr][nc] = true;
			}
		}
	}
}