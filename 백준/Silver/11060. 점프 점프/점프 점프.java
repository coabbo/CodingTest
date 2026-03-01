import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int[] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(bfs(0));
	}

	private static int bfs(int start) {
		Queue<Integer> q = new ArrayDeque<>();
		int[] dist = new int[N];
		Arrays.fill(dist, -1);
		
		q.add(start);
		dist[start] = 0;
		
		while (!q.isEmpty()) {
			int curr = q.poll();
			
			if (curr == N-1) {
				return dist[curr];
			}
			
			for (int jump = 1; jump <= map[curr]; jump++) {
				int next = curr + jump;
				
				// 범위 내에 있고 아직 방문하지 않았다면
				if (next < N && dist[next] == -1) {
					q.add(next);
					dist[next] = dist[curr] + 1;
				}
			}
		}
		
		return -1;
	}
}