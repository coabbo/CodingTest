import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static List<Integer>[] adj; // 인접 리스트
	static int[] degree; // 각 정점의 진입 차수
	static int[] time; // 각 건물의 건설 시간
	static int[] result; // 각 건물의 완성 시간
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 건물의 종류 수
		
		// 그래프 초기화
		adj = new ArrayList[N+1];
		degree = new int[N+1];
		time = new int[N+1];
		result = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}
		
		// 간선 정보 읽기
		for (int A = 1; A <= N; A++) {
			st = new StringTokenizer(br.readLine(), " ");
			int W = Integer.parseInt(st.nextToken());
			time[A] = W;
			result[A] = W;
			
			while(true) {
				int B = Integer.parseInt(st.nextToken());
				
				if(B == -1) break;
				
				adj[B].add(A); // 유향 그래프 (B번 건물이 A번 건물보다 먼저 지어져야 함(선행 B → 후행 A))
				degree[A]++;
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
		while(!q.isEmpty()) {
			int curr = q.poll();
			
			for (int v : adj[curr]) {
				degree[v]--;
				result[v] = Math.max(result[v], result[curr] + time[v]);
				
				if(degree[v] == 0) {
					q.offer(v);
				}
			}
		}
		
		for (int i = 1; i <= N; i++) {
			sb.append(result[i]).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}