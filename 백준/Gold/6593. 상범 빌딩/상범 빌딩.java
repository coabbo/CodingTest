import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int L, R, C;
	private static int endL, endR, endC;
	
	private static char[][][] map;
	private static int[][][] dist;
	
	private static int[] dl = {0, 0, 0, 0, -1, 1}; // 상하 이동
	private static int[] dr = {-1, 1, 0, 0, 0, 0}; // 동서남북 이동
	private static int[] dc = {0, 0, -1, 1, 0, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			if(L == 0 && R == 0 && C == 0) break;
			
			map = new char[L][R][C];
			
			int startL = 0, startR = 0, startC = 0;
			endL = 0;
			endR = 0;
			endC = 0;
			
			for (int i = 0; i < L; i++) {
				for (int j = 0; j < R; j++) {
					String s = br.readLine();
					
					for (int k = 0; k < C; k++) {
						char c = s.charAt(k);
						
						map[i][j][k] = c;
						
						if(c == 'S') {
							startL = i;
							startR = j;
							startC = k;
						}
						
						if(c == 'E') {
							endL = i;
							endR = j;
							endC = k;
						}
					}
				}
				
				br.readLine();
			}
			
			dist = new int[L][R][C];
			for (int l = 0; l < L; l++) {
				for (int r = 0; r < R; r++) {
					Arrays.fill(dist[l][r], -1);
				}
			}
			
			bfs(startL, startR, startC);
		}
	}

	public static void bfs(int startL, int startR, int startC) {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {startL, startR, startC});
		dist[startL][startR][startC] = 0;
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int cl = curr[0];
			int cr = curr[1];
			int cc = curr[2];
			
			if(cl == endL && cr == endR && cc == endC) {
				System.out.println("Escaped in " + dist[endL][endR][endC] + " minute(s).");
				return;
			}
			
			for (int d = 0; d < 6; d++) {
				int nl = cl + dl[d];
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				
				if(nl < 0 || nr < 0 || nc < 0 || nl >= L || nr >= R || nc >= C) continue;
				if(dist[nl][nr][nc] != -1) continue;
				if(map[nl][nr][nc] == '#') continue;
				
				q.add(new int[] {nl, nr, nc});
				dist[nl][nr][nc] = dist[cl][cr][cc] + 1;
			}
		}
		
		System.out.println("Trapped!");
	}
}