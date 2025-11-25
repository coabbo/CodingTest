import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static List<Integer>[] graph;
	public static boolean[] visited;
	public static int[] order;
	public static int[] result;
	public static int idx = 1;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 정점의 수
		int M = N - 1; // 간선의 수
		
		graph = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			graph[A].add(B);
			graph[B].add(A);
		}
		
		order = new int[N+1];
		int[] input = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1; i <= N; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			order[num] = i;
			input[i] = num;
		}
		
		for(int i = 1; i <= N; i++) {
			Collections.sort(graph[i], (o1, o2) -> order[o1] - order[o2]);
		}
		
		visited = new boolean[N+1];
		result = new int[N+1];
		dfs(1);
		
		for (int i = 1; i <= N; i++) {
			if (result[i] != input[i]) {
				System.out.println(0);
				return;
			}
		}
		
		System.out.println(1);
	}

	private static void dfs(int start) {
		visited[start] = true;
		result[idx++] = start;
		
		for(int next : graph[start]) {
			if(!visited[next]) {
				dfs(next);
			}
		}
	}
}