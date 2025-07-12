import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static List<Integer>[] graph;
	private static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine()); // 노드의 개수
		graph = new ArrayList[N+1];
		
		for (int i = 0; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		// 간선 입력
		for (int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			graph[A].add(B);
			graph[B].add(A);
		}
		
		bfs(1);
	}

	public static void bfs(int start) {
		Queue<Integer> q = new ArrayDeque<>();
		q.add(start);
		
		boolean[] visited = new boolean[N+1]; // 방문 체크
		visited[start] = true;
		
		int[] parent = new int[N+1]; // 부모를 기록
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			
			for (int v : graph[curr]) {
				if(visited[v]) continue;
					
				q.add(v);
				visited[v] = true;
				parent[v] = curr;
			}
		}
		
		for (int i = 2; i < parent.length; i++) {
			sb.append(parent[i]).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}