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
			this.v = v; // 정점 번호
			this.cost = cost; // 출발점부터 이 정점까지 누적된 비용
		}
		
		@Override
		public int compareTo(Node o) {
			// 비용이 작은 순서대로 우선순위큐에서 꺼내기 위해 비교
			return Integer.compare(this.cost, o.cost);
		}
	}
	
	private static int N;
	private static final int INF = Integer.MAX_VALUE; // 아직 경로가 없음을 나타내는 무한대
	private static List<Node>[] graph;
	private static int[] dist; // dist[v] = 시작점에서 v까지의 최단 거리
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine()); // 도시의 개수
		int M = Integer.parseInt(br.readLine()); // 버스의 개수
		
		graph = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		// 간선 입력 (유향 그래프)
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken()); // 버스 출발지의 도시 번호
			int end = Integer.parseInt(st.nextToken()); // 버스 도착지의 도시 번호
			int weight = Integer.parseInt(st.nextToken()); // 버스 비용
			
			graph[start].add(new Node(end, weight));
		}
		
		// 최단 거리 배열 초기화
		dist = new int[N+1];
		Arrays.fill(dist, INF);
		
		st = new StringTokenizer(br.readLine(), " ");
		int departurePoint = Integer.parseInt(st.nextToken()); // 구해야 하는 출발점의 도시번호
		int arrivalPoint = Integer.parseInt(st.nextToken()); // 구해야 하는 도착점의 도시번호

		int ans = dijkstra(departurePoint, arrivalPoint);
		System.out.println(ans);
	}

	public static int dijkstra(int start, int end) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		
		dist[start] = 0;
		
		while (!pq.isEmpty()) {
			Node curr = pq.poll();
			int u = curr.v; // 현재 탐색 중인 혹은 출발점 정점
			int costU = curr.cost;
			
			// 이미 더 짧은 경로가 기록되어 있으면 넘어감
			if(costU > dist[u]) continue;
			
			// u에서 출발하는 모든 간선을 검사
			for (Node e : graph[u]) {
				int v = e.v; // u에 인접한 도착점(이웃) 정점
				int w = e.cost;
				
				// u -> v 경로를 거쳐가는게 더 작으면 갱신
				if(dist[v] > costU + w) {
					dist[v] = costU + w;
					pq.offer(new Node(v, dist[v]));
				}
			}
		}
		
		return dist[end];
	}
}