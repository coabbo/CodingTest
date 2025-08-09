import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
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
		N = Integer.parseInt(st.nextToken()); // 가수의 수
		M = Integer.parseInt(st.nextToken()); // 보조 PD의 수
		
		// 그래프 초기화
		adj = new ArrayList[N+1];
		degree = new int[N+1];
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}
		
		// 간선 정보 읽기
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			List<Integer> list = new ArrayList<>();
			int num = Integer.parseInt(st.nextToken()); // 보조 PD가 담당한 가수의 수
			
			int A = Integer.parseInt(st.nextToken());
			for (int j = 0; j < num - 1; j++) {
				int B = Integer.parseInt(st.nextToken());		
				
				adj[A].add(B); // 유향 그래프 (A가 B보다 먼저 출연(선행 A → 후행 B))
				degree[B]++; // B로 들어오는 진입차수 +1
				
				A = B;
			}
		}
		
		// 정점 번호 관리
		Queue<Integer> q = new ArrayDeque<>();
		
		// 위상 정렬
		// 1. 진입 차수가 0인 정점들을 큐에 넣기
		for (int i = 1; i <= N; i++) {
			if(degree[i] == 0) {
				q.offer(i);
			}
		}
		
		// 2. 큐가 공백 상태가 될 때까지 반복 -> 하나 꺼내서 간선 제거하고(진입차수 하나 깎기) -> 0되면 새롭게 넣음
		List<Integer> answer = new ArrayList<>();
		while(!q.isEmpty()) {
			int curr = q.poll();
			answer.add(curr);
			
			for (int v : adj[curr]) {
				degree[v]--;
				
				if(degree[v] == 0) {
					q.offer(v);
				}
			}
		}
		
		if(answer.size() == N) {
			for (int v : answer) {
				System.out.println(v);
			}
		}
		else {
			System.out.println(0);
		}
	}
}