import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static List<Integer>[] adj; // 인접 리스트
	static int[] degree; // 각 정점의 진입 차수
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 문제의 수
		M = Integer.parseInt(st.nextToken()); // 먼저 푸는 것이 좋은 문제에 대한 정보의 개수
		
		// 그래프 초기화
		adj = new ArrayList[N+1];
		degree = new int[N+1];
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}
		
		// 간선 정보 읽기
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			adj[A].add(B); // 유향 그래프 (A를 풀어야 B를 풀 수 있음(선행 A → 후행 B))
			degree[B]++; // B로 들어오는 진입차수 +1
		}
		
		// 정점 번호 관리
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		// 위상 정렬
		// 1. 진입 차수가 0인 정점들을 큐에 넣기 (번호 작은 것 우선)
		for (int i = 1; i <= N; i++) {
			if(degree[i] == 0) {
				pq.offer(i);
			}
		}
		
		// 2. 큐가 공백 상태가 될 때까지 반복 -> 하나 꺼내서 간선 제거하고(진입차수 하나 깎기) -> 0되면 새롭게 넣음
		while(!pq.isEmpty()) {
			int curr = pq.poll();
			sb.append(curr).append(" ");
			
			for (int v : adj[curr]) {
				degree[v]--;
				
				if(degree[v] == 0) {
					pq.offer(v);
				}
			}
		}
		
		System.out.println(sb.toString());
	}
}