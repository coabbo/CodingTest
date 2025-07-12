import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static List<Integer>[] graph;
	private static List<Integer>[] cost;
	private static boolean[] visited;
	private static int maxDist; // 지금까지 찾은 최대 거리
	private static int farthestNode; // 최대 거리를 만든 노드

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); // 노드의 개수
		graph = new ArrayList[N+1];
		cost = new ArrayList[N+1];
		
		for (int i = 0; i <= N; i++) {
			graph[i] = new ArrayList<>();
			cost[i] = new ArrayList<>();
		}
		
		for (int i = 1; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			
			graph[A].add(B);
			cost[A].add(W);
			
			graph[B].add(A);
			cost[B].add(W);
		}
		
		// 1) 첫 번째 DFS: 1번에서 가장 먼 노드 찾기
		visited = new boolean[N+1];
		maxDist = 0;
		dfs(1, 0);
		
		// 2) 두 번째 DFS: farthestNode에서 최대 거리 찾기
		visited = new boolean[N+1];
		maxDist = 0;
		dfs(farthestNode, 0);
		
		System.out.println(maxDist);
	}

	// curr: 현재 노드, dist: 시작점부터 curr까지 누적 거리 
	public static void dfs(int curr, int dist) {
		visited[curr] = true;
		
		if(dist > maxDist) {
			maxDist = dist;
			farthestNode = curr;
		}
		
		for (int i = 0; i < graph[curr].size(); i++) {
			int next = graph[curr].get(i);
			int w = cost[curr].get(i);
			
			if(!visited[next]) {
				dfs(next, dist + w);
			}
		}
	}
}