import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 수빈이가 있는 위치
		int K = Integer.parseInt(st.nextToken()); // 동생이 있는 위치
		
		int ans = bfs(N, K);
		System.out.println(ans);
	}

	public static int bfs(int start, int target) {
		Queue<Integer> q = new ArrayDeque<>();
		q.add(start);
		
		boolean[] visited = new boolean[100000 + 1];
		visited[start] = true;
		
		int[] dist = new int[100000 + 1];
		dist[start] = 0;
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			
			if(curr == target) {
				return dist[curr];
			}
			
			// 이동할 수 있는 세 가지 경우
			int[] nexts = {curr - 1, curr + 1, curr * 2};
			
			for (int v : nexts) {
				if(v >= 0 && v <= 100000 && !visited[v]) {
					q.add(v);
					visited[v] = true;
					dist[v] = dist[curr] + 1;
				}
			}
		}
		
		return -1;
	}
}