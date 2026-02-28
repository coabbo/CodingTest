import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main {
	private static int N;
	private static List<Integer>[] graph;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		graph = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			
			for (int j = 0; j < N; j++) {
				if (s.charAt(j) == 'Y') {
					graph[i].add(j); // i번 사람의 친구 목록에 j 추가
				}
			}
		}
		
		int max = 0;
		for (int i = 0; i < N; i++) {
			max = Math.max(bfs(i), max);
		}
		
		System.out.println(max);
	}

	private static int bfs(int start) {
		Queue<int[]> q = new ArrayDeque<>();
		boolean[] visited = new boolean[N];
		int count = 0;
		
		q.add(new int[] {start, 0});
		visited[start] = true;
		
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int now = curr[0];
			int dist = curr[1];
			
			// 거리가 2 미만인 경우에만 다음 친구를 탐색 
			if (dist < 2) {
				for (int neighbor : graph[now]) {
					if (!visited[neighbor]) {
						q.add(new int[] {neighbor, dist + 1});
						visited[neighbor] = true;
						count++;
					}
				}
			}
		}
		
		return count;
	}
}