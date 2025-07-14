import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	public static class Node implements Comparable<Node> {
		int v, cost;
		
		Node(int v, int cost) {
			this.v = v;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node o) {
			// 비용이 작은 순서대로 우선순위큐에서 꺼내기 위해 비교
			return Integer.compare(this.cost, o.cost);
		}
	}
	
	private static int N;
	private static final int INF = Integer.MAX_VALUE;
	private static List<Node>[] graph;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 정점의 개수
		int E = Integer.parseInt(st.nextToken()); // 간선의 개수
		
		graph = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		// 간선 입력 (무향 그래프)
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			graph[a].add(new Node(b, c));
			graph[b].add(new Node(a, c));
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		
		// 1 -> v1 -> v2 -> N으로 가는 경우
		int dist1 = dijkstra(1, v1);
		int dist2 = dijkstra(v1, v2);
		int dist3 = dijkstra(v2, N);
		int result1 = (dist1 == INF || dist2 == INF || dist3 == INF) ? INF : dist1 + dist2 + dist3;
		
		// 1 -> v2 -> v1 -> N으로 가는 경우
		int dist4 = dijkstra(1, v2);
		int dist5 = dijkstra(v2, v1);
		int dist6 = dijkstra(v1, N);
		int result2 = (dist4 == INF || dist5 == INF || dist6 == INF) ? INF : dist4 + dist5 + dist6;
		
		int ans = Math.min(result1, result2);
		if(ans == INF) {
			System.out.println(-1);
		}
		else {
			System.out.println(ans);
		}
	}

	public static int dijkstra(int start, int end) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		
		// 최단 거리 배열 초기화
		int[] dist = new int[N+1];
		Arrays.fill(dist, INF);
		dist[start] = 0;
		
		while (!pq.isEmpty()) {
			Node curr = pq.poll();
			int u = curr.v;
			int costU = curr.cost;
			
			if(costU > dist[u]) continue;
			
			for (Node e : graph[u]) {
				int v = e.v;
				int w = e.cost;
				
				if(dist[v] > costU + w) {
					dist[v] = costU + w;
					pq.offer(new Node(v, dist[v]));
				}
			}
		}
		
		return dist[end];
	}
}