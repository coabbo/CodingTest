import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int M;
	private static List<Integer>[] graph;
	private static int[] dist;
	private static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 전체 사람의 수
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int targetX = Integer.parseInt(st.nextToken());
		int targetY = Integer.parseInt(st.nextToken());
		
		M = Integer.parseInt(br.readLine()); // 부모 자식들 간의 관계의 개수
		
		graph = new List[N+1];
		for (int i = 1; i < N+1; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			graph[x].add(y);
			graph[y].add(x);
		}
		
		dist = new int[N+1];
		visited = new boolean[N+1];
		
		int answer = bfs(targetX, targetY);
		
		System.out.println(answer);
	}

	public static int bfs(int targetX, int targetY) {
		Queue<Integer> q = new ArrayDeque<>();
		q.add(targetX);
		dist[targetX] = 0;
		visited[targetX] = true;
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			
			if(curr == targetY) {
				return dist[targetY];
			}
			
			for (int next : graph[curr]) {
				if(visited[next]) continue;
				
				q.add(next);
				dist[next] = dist[curr] + 1;
				visited[next] = true;
			}
		}
		
		return -1;
	}
}