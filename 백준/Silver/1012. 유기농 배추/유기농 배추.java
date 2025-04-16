import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	private static int N;
	private static int M;
	private static int K;
	private static int[][] map;
	private static boolean[][] visited;
	
	static int[] dr = {-1, 1, 0, 0}; //상하좌우
	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); //배추밭의 세로길이
			M = Integer.parseInt(st.nextToken()); //배추밭의 가로길이
			K = Integer.parseInt(st.nextToken()); //배추가 심어져 있는 위치의 개수
			
			map = new int[N][M]; //배추밭
			visited = new boolean[N][M]; //방문 체크
			
			int ans = 0; //배추흰지렁이 마리의 수
			
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int num1 = Integer.parseInt(st.nextToken());
				int num2 = Integer.parseInt(st.nextToken());
				
				map[num1][num2] = 1;
			}
			
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[0].length; j++) {
					if(map[i][j] == 1 && !visited[i][j]) {
						bfs(i, j);
						ans++;
					}
				}
			}
			
			System.out.println(ans);
		}
	}

	public static void bfs(int r, int c) {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {r, c}); //처음 좌표 넣음
		visited[r][c] = true;
		
		while(!q.isEmpty()) {
			int[] curr = q.poll(); //현재 위치
			
			for (int d = 0; d < 4; d++) {
				int nr = curr[0] + dr[d];
				int nc = curr[1] + dc[d];
				
				//1. 범위를 벗어나면 패스
				if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
				
				//2. 모두 땅이거나 / 이미 방문한 곳이면 패스
				if(map[nr][nc] == 0 || visited[nr][nc]) continue;
				
				visited[nr][nc] = true;
				q.add(new int[] {nr, nc});
			}
		}
	}
}