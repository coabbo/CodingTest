import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
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
		N = Integer.parseInt(st.nextToken()); // 과목의 수
		M = Integer.parseInt(st.nextToken()); // 선수 조건의 수
		
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
			adj[A].add(B); // 유향 그래프 (A번 과목이 B번 과목의 선수과목(선행 A → 후행 B))
			degree[B]++; // B로 들어오는 진입차수 +1
		}
		
		// 정점 번호 관리
		Queue<Integer> q = new ArrayDeque<>();
		
		// 위상 정렬
		// 1. 진입 차수가 0인 정점들을 큐에 넣기
		int[] answer = new int[N+1];
		for (int i = 1; i <= N; i++) {
			if(degree[i] == 0) {
				q.offer(i);
				answer[i] = 1;
			}
		}
		
		// 2. 큐가 공백 상태가 될 때까지 반복 -> 하나 꺼내서 간선 제거하고(진입차수 하나 깎기) -> 0되면 새롭게 넣음
		while(!q.isEmpty()) {
			int curr = q.poll();
			
			for (int v : adj[curr]) {
				degree[v]--;
				
				if(degree[v] == 0) {
					q.offer(v);
					answer[v] = answer[curr] + 1;
				}
			}
		}
		
		for (int i = 1; i <= N; i++) {
			sb.append(answer[i]).append(" ");
		}
		
		System.out.println(sb.toString());
	}
}