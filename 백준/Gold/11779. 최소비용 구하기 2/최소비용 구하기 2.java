import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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

	private static StringBuilder sb;
	private static int N;
	private static List<Node>[] graph;
	private static int INF = Integer.MAX_VALUE;
	private static int[] dist;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine()); // 도시의 개수
		int M = Integer.parseInt(br.readLine()); // 버스의 개수
		
		graph = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			graph[start].add(new Node(end, weight));
		}
		
		dist = new int[N+1];
		Arrays.fill(dist, INF);
		
		st = new StringTokenizer(br.readLine(), " ");
		int departurePoint = Integer.parseInt(st.nextToken());
		int arrivalPoint = Integer.parseInt(st.nextToken());
		
		dijkstra(departurePoint, arrivalPoint);
		
		System.out.println(sb.toString());
	}

	public static void dijkstra(int start, int end) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		
		dist[start] = 0;
		
		int[] parent = new int[N+1]; // 이동 경로 추적
		Arrays.fill(parent, -1);
		
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
					parent[v] = u;
					pq.offer(new Node(v, dist[v]));
				}
			}
		}
		
		// 경로 복원
		List<Integer> route = new ArrayList<>();
		for (int v = end; v != -1;) {
			route.add(v);
			v = parent[v];
		}
		Collections.reverse(route);
		
		sb.append(dist[end]).append("\n");
		sb.append(route.size()).append("\n");
		for (Integer v : route) {
			sb.append(v + " ");
		}
	}
}