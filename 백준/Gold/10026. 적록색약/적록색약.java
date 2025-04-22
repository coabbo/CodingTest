import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Queue;

public class Main {

	private static String[][] RGBmap; //일반적인 그림
	private static String[][] RBmap; //적록색약 그림
	private static int N;

	static int[] dr = {-1, 1, 0, 0}; //상하좌우
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		RGBmap = new String[N][N];
		RBmap = new String[N][N];
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				
				if(s.charAt(j) == 'G') {
					RBmap[i][j] = "R";
					RGBmap[i][j] = "" + s.charAt(j);
				}
				else {
					RBmap[i][j] = "" + s.charAt(j);
					RGBmap[i][j] = "" + s.charAt(j);
				}
			}
		}
		
		int answer = 0;
		
		boolean[][] visitedRGB = new boolean[N][N];
		for (int i = 0; i < RGBmap.length; i++) {
			for (int j = 0; j < RGBmap[0].length; j++) {
				if(!visitedRGB[i][j]) {
					bfs(RGBmap, visitedRGB, i, j);
					answer += 1;
				}
			}
		}
		System.out.print(answer + " ");
		
		answer = 0;
		boolean[][] visitedRB = new boolean[N][N];
		for (int i = 0; i < RBmap.length; i++) {
			for (int j = 0; j < RBmap[0].length; j++) {
				if(!visitedRB[i][j]) {
					bfs(RBmap, visitedRB, i, j);
					answer += 1;
				}
			}
		}
		System.out.print(answer + " ");
	}

	public static void bfs(String[][] map, boolean[][] visited, int r, int c) {
		Queue<int[]> q = new ArrayDeque<>();
		
		q.add(new int[] {r, c});
		visited[r][c] = true;
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			String color = map[curr[0]][curr[1]];
			
			for (int d = 0; d < 4; d++) {
				int nr = curr[0] + dr[d];
				int nc = curr[1] + dc[d];
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
				
				if(!color.equals(map[nr][nc]) || visited[nr][nc]) continue;
				
				visited[nr][nc] = true;
				q.add(new int[] {nr, nc});
			}
		}
	}
}