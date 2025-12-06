import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int A;
	public static int K;
	private static boolean[] visited;
	private static int[] dist;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		A = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		visited = new boolean[K + 1];
		dist = new int[K + 1];
		bfs(A);
	}

	private static void bfs(int start) {
		Queue<Integer> q = new ArrayDeque<>();
		q.add(start);
		visited[start] = true;
		dist[start] = 0;
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			
			if(curr == K) {
				System.out.println(dist[K]);
				return;
			}
			
			if(curr > K) continue;
			
			int[] num = {curr + 1, curr * 2};
			
			for (int next : num) {
				if(next <= K && !visited[next]) {
					q.add(next);
					visited[next] = true;
					dist[next] = dist[curr] + 1;
				}
			}
		}
	}
}