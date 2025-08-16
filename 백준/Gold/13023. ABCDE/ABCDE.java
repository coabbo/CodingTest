import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int M;
	private static List<Integer>[] graph;
	private static boolean[] visited;
	private static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 사람의 수
		M = Integer.parseInt(st.nextToken()); // 친구 관계의 수
		
		graph = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph[a].add(b);
			graph[b].add(a);
		}
		
		visited = new boolean[N];
		answer = 0;
		
		for (int i = 0; i < N; i++) {
			if(answer == 1) break; // 이미 조건 만족했으면 탐색 중단
			
			visited[i] = true; // 시작 노드 방문 표시
			dfs(i, 0); // i번 노드에서 깊이 0부터 탐색 시작
			visited[i] = false; // 다음 시작 노드를 위해 초기화
		}
		
		System.out.println(answer);
	}

	public static void dfs(int node, int depth) {
		if (answer == 1) return; // 이미 답 찾았으면 더 안 내려감
		
		// 1. 종료 조건
		if(depth == 4) {
			answer = 1;
			return;
		}

		// 2. 재귀 탐색
		for (int next : graph[node]) {
			if(!visited[next]) { // 아직 방문하지 않았다면
				visited[next] = true; // 방문 처리
				dfs(next, depth + 1); // 깊이 증가시키면서 탐색
				visited[next] = false; // 백트래킹 (다른 경로 탐색을 위해 되돌리기)
				
				if (answer == 1) return; // 찾았으면 더 안 탐색
			}
		}
	}
}