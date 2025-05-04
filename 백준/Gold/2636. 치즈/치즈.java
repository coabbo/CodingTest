import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int M;
	private static int[][] pan;
	private static boolean[][] visited; // 방문 체크
	
	private static int cheeseNum;
	private static int meltCheeseTime;
	private static int lastMeltCheeseNum;
	
	private static final int AIR = 0;
	private static final int CHEESE = 1;
	
	private static int[] dr = {-1, 1, 0, 0}; // 상하좌우
	private static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 행의 크기
		M = Integer.parseInt(st.nextToken()); // 열의 크기
		
		pan = new int[N][M];
		cheeseNum = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				pan[i][j] = Integer.parseInt(st.nextToken());
				if(pan[i][j] == CHEESE) cheeseNum++; // 치즈의 총 개수
			}
		}
		
		meltCheeseTime = 0; // 치즈가 모두 녹아서 없어지는 데 걸리는 시간
		lastMeltCheeseNum = 0; // 모두 녹기 한 시간 전에 남아있던 치즈 개수

		while(cheeseNum != 0) {
			meltCheeseTime++;
			lastMeltCheeseNum = cheeseNum;
			
			visited = new boolean[N][M];
			bfs(0, 0);
		}
		
		System.out.println(meltCheeseTime);
		System.out.println(lastMeltCheeseNum);
	}

	// 외부 공기 확장 및 치즈 녹이기
	public static void bfs(int r, int c) {
		Queue<int[]> q = new ArrayDeque<>();
		visited[r][c] = true; // 방문 처리
		q.add(new int[] {r, c}); // 큐 확장
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = curr[0] + dr[d];
				int nc = curr[1] + dc[d];
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
				if(visited[nr][nc]) continue;
				
				visited[nr][nc] = true;
				if(pan[nr][nc] == AIR) {
					q.add(new int[] {nr, nc});
				}
				else {
					cheeseNum--;
					pan[nr][nc] = AIR;
				}
			}
		}
	}
}