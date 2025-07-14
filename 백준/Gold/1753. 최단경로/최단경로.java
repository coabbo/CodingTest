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
	
	private static final int INF = Integer.MAX_VALUE;
	private static List<Node>[] graph;
	private static int[] dist;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int V = Integer.parseInt(st.nextToken()); // 정점의 개수
		int E = Integer.parseInt(st.nextToken()); // 간선의 개수
		int K = Integer.parseInt(br.readLine()); // 시작 정점의 번호
		
		graph = new ArrayList[V+1];
		for (int i = 1; i <= V; i++) {
			graph[i] = new ArrayList<>();
		}
		
		// 간선 입력 (유향 그래프)
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			graph[u].add(new Node(v, w));
		}
		
		// 최단 거리 배열 초기화
		dist = new int[V+1];
		Arrays.fill(dist, INF);
		
		dijkstra(K);
		
		for (int i = 1; i <= V; i++) {
			if(dist[i] == INF) {
				sb.append("INF").append("\n");
			}
			else {
				sb.append(dist[i]).append("\n");
			}
		}
		
		System.out.println(sb.toString());
	}

	public static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		
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
	}
}