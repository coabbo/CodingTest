import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int N, M, K, X;
	private static List<Integer>[] graph;
	private static int[] dist;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 도시의 개수
		M = Integer.parseInt(st.nextToken()); // 도로의 개수
		K = Integer.parseInt(st.nextToken()); // 거리 정보
		X = Integer.parseInt(st.nextToken()); // 출발 도시의 번호
		
		graph = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			graph[A].add(B);
		}
		
		dist = new int[N+1];
		bfs();
		
		int count = 0;
		for (int i = 1; i < dist.length; i++) {
			if (dist[i] == K) {
				sb.append(i).append("\n");
				count++;
			}
		}
		
		if (count == 0) System.out.println(-1);
		else System.out.println(sb.toString());
	}

	private static void bfs() {
		Queue<Integer> q = new ArrayDeque<>();
		Arrays.fill(dist, -1);
		
		q.add(X);
		dist[X] = 0;
		
		while (!q.isEmpty()) {
			int curr = q.poll();
			
			for (int next : graph[curr]) {
				if (dist[next] != -1) continue;
				
				q.add(next);
				dist[next] = dist[curr] + 1;
			}
		}
	}
}