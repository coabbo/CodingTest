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
		int v;
		long cost;
		
		public Node(int v, long cost) {
			this.v = v;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return Long.compare(this.cost, o.cost);
		}
	}

	private static int N;
	private static List<Node>[] reverseGraph;
	private static List<Integer> interviewCity;
	private static long[] dist;
	private static long INF = Long.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 도시의 수
		int M = Integer.parseInt(st.nextToken()); // 도로의 수
		int K = Integer.parseInt(st.nextToken()); // 면접장의 수
		
		reverseGraph = new ArrayList[N+1]; // 역 그래프
		for (int i = 1; i <= N; i++) {
			reverseGraph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			reverseGraph[end].add(new Node(start, weight)); // 원본 간선을 뒤집어 역그래프에 추가 (end → start)
		}
		
		interviewCity = new ArrayList<>();
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < K; i++) {
			interviewCity.add(Integer.parseInt(st.nextToken()));
		}
		
		dijkstra();
		
		boolean[] isInterview = new boolean[N+1];
		for (int c : interviewCity) {
			isInterview[c] = true;
		}
		
		int mostFarCity = 0;
		long mostFarDist = Long.MIN_VALUE;
		for (int i = 1; i <= N; i++) {
			if(!isInterview[i] && dist[i] > mostFarDist) {
				mostFarCity = i;
				mostFarDist = dist[i];
			}
		}
		
		System.out.println(mostFarCity);
		System.out.println(mostFarDist);
	}

	// 다중 출발점 다익스트라
	public static void dijkstra() {
		
		// 1) dist 배열 초기화
		dist = new long[N+1];
		Arrays.fill(dist, INF);
		
		// 2) 면접장들을 모두 출발점으로 큐에 넣음
		PriorityQueue<Node> pq = new PriorityQueue<>();
		for (int c : interviewCity) {
			dist[c] = 0;
			pq.offer(new Node(c, 0));
		}
		
		// 3) 역 그래프에서 다익스트라 수행
		while(!pq.isEmpty()) {
			Node curr = pq.poll();
			int u = curr.v;
			long costU = curr.cost;
			
			if(costU > dist[u]) continue;
			
			for (Node e : reverseGraph[u]) {
				int v = e.v;
				long w = e.cost;
				
				if(dist[v] > costU + w) {
					dist[v] = costU + w;
					pq.offer(new Node(v, dist[v]));
				}
			}
		}
	}
}