import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static int[][] city;
	public static boolean[][] visited;
	public static int N;
	public static int M;
	
	static int[] dr = {1, 0}; //남동쪽
	static int[] dc = {0, 1};
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		city = new int[M][N];
		visited = new boolean[M][N];
		
		for (int i = 0; i < city.length; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < city[0].length; j++) {
				city[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		String answer = bfs(0, 0);
		System.out.println(answer);
	}

	public static String bfs(int r, int c) {
		Queue<int[]> q = new ArrayDeque<>();
		
		q.add(new int[] {r, c});
		visited[r][c] = true;
		
		String answer = "No";
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			
			if(curr[0] == M-1 && curr[1] == N-1) {
				answer = "Yes";
				break;
			}
			
			for (int d = 0; d < 2; d++) {
				int nr = curr[0] + dr[d];
				int nc = curr[1] + dc[d];
				
				if(nr < 0 || nc < 0 || nr >= M || nc >= N) continue;
				if(city[nr][nc] == 0 || visited[nr][nc]) continue;
				
				visited[nr][nc] = true;
				q.add(new int[] {nr, nc});
			}
		}
		
		return answer;
	}
}