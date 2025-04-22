import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static String[][] campus;
	public static boolean[][] visited;
	public static int N;
	public static int M;
	public static int count = 0;
	
	static int[] dr = {-1, 1, 0, 0}; //상하좌우
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
	
		campus = new String[N][M];
		visited = new boolean[N][M];
		
		for (int i = 0; i < campus.length; i++) {
			String s = br.readLine();
			for (int j = 0; j < campus[i].length; j++) {
				campus[i][j] = "" + s.charAt(j);
			}
		}
		
		for (int i = 0; i < campus.length; i++) {
			for (int j = 0; j < campus[0].length; j++) {
				if(campus[i][j].equals("I")) {
					bfs(i, j);
				}
			}
		}
		
		if(count == 0) {
			System.out.println("TT");
		} else {
			System.out.println(count);
		}
	}

	private static void bfs(int r, int c) {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {r, c});
		visited[r][c] = true;
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = curr[0] + dr[d];
				int nc = curr[1] + dc[d];
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
				
				if(campus[nr][nc].equals("X") || visited[nr][nc]) continue;
				
				visited[nr][nc] = true;
				q.add(new int[] {nr, nc});
				
				if(campus[nr][nc].equals("P"))
					count++;
			}
		}
	}
}