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
			return Integer.compare(this.cost, o.cost);
		}
	}

	private static int N;
	private static List<Node>[] graph;
	private static int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 학생의 수
		int M = Integer.parseInt(st.nextToken()); // 단방향 도로의 개수
		int X = Integer.parseInt(st.nextToken()); // 파티를 하는 마을
		
		graph = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			
			graph[start].add(new Node(end, time));
		}
		
		int max = Integer.MIN_VALUE;
		for (int i = 1; i <= N; i++) {
			int go = dijkstra(i, X);
			int back = dijkstra(X, i);
			
			max = Math.max(go + back, max);
		}
		
		System.out.println(max);
	}

	public static int dijkstra(int start, int end) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		
		int[] dist = new int[N+1];
		Arrays.fill(dist, INF);
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
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