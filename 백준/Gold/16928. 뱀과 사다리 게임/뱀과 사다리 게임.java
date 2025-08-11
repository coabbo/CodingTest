import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int[] board;
	private static int[] dist;
	private static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 사다리의 수
		int M = Integer.parseInt(st.nextToken()); // 뱀의 수
		
		board = new int[101];
		for (int i = 1; i < board.length; i++) {
			board[i] = i;
		}
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			board[x] = y;
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			board[u] = v;
		}

		dist = new int[101];
		visited = new boolean[101];
		
		bfs(1);
	}

	public static void bfs(int start) {
		Queue<Integer> q = new ArrayDeque<>();
		q.add(start);
		
		visited[start] = true;
		dist[start] = 0;
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			
			if(curr == 100) {
				System.out.println(dist[100]);
				break;
			}
			
			for (int i = 1; i <= 6; i++) {
				int next = curr + i;
				
				if(next > 100) continue;
				if(visited[board[next]]) continue;
				
				q.add(board[next]);
				visited[board[next]] = true;
				dist[board[next]] = dist[curr] + 1;
			}
		}
	}
}