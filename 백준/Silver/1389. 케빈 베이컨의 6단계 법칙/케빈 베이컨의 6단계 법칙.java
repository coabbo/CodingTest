import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static List<Integer>[] adj;
	private static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 유저의 수(정점)
		int M = Integer.parseInt(st.nextToken()); // 친구 관계의 수(간선)
		int answer = 0;
		
		adj = new ArrayList[N+1]; // 인접 리스트, 정점은 1번부터 시작
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}
		
		// 간선 입력(양방향)
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			adj[A].add(B);
			adj[B].add(A);
		}
		
		int minNum = Integer.MAX_VALUE;
		for(int i = 1; i <= N; i++) {
			visited = new boolean[N+1]; // 방문 체크
			int num = bfs(i);
			
			if(num < minNum) {
				minNum = num;
				answer = i;
			}
		}
		
		System.out.println(answer);
	}

	public static int bfs(int start) {
		Queue<int[]> q = new ArrayDeque<>(); 
		q.add(new int[] {start, 0});
		visited[start] = true;
		int count = 0;
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int currVertex = curr[0];
			int currLevel = curr[1];
			
			for (int v : adj[currVertex]) {
				if(!visited[v]) {
					q.add(new int[] {v, currLevel + 1});
					visited[v] = true;
				}
			}
			
			count += currLevel;
		}
		
		return count;
	}
}