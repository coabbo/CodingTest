import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 수빈이가 있는 위치
		int K = Integer.parseInt(st.nextToken()); // 동생이 있는 위치
		
		bfs(N, K);
	}

	public static void bfs(int start, int target) {
		Queue<Integer> q = new ArrayDeque<>();
		q.add(start);
		
		int[] dist = new int[100000 + 1]; // 최단 시간 구하기 및 방문 체크
		Arrays.fill(dist, -1);
		dist[start] = 0;
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			
			if(curr == target) break;
			
			// 이동할 수 있는 세 가지 경우
			int[] nexts = {curr * 2, curr - 1, curr + 1};
			
			for (int i = 0; i < 3; i++) {
				int v = nexts[i];
				
				if(v < 0 || v > 100000) continue;
				
				// 아직 한 번도 안 가본 곳이면
				if(dist[v] == -1) {
					q.add(v);
					
					if(i == 0) {
						dist[v] = dist[curr];
					}
					else {
						dist[v] = dist[curr] + 1;
					}
				}
			}
		}

		System.out.println(dist[target]);
	}
}