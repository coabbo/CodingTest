import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
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
		
		int[] parent = new int[100000 + 1]; // 이동 경로 추적
		Arrays.fill(parent, -1);
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			
			if(curr == target) break;
			
			// 이동할 수 있는 세 가지 경우
			int[] nexts = {curr - 1, curr + 1, curr * 2};
			
			for (int v : nexts) {
				if(v < 0 || v > 100000) continue;
				
				// 아직 한 번도 안 가본 곳이면
				if(dist[v] == -1) {
					q.add(v);
					dist[v] = dist[curr] + 1;
					parent[v] = curr;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(dist[target]).append("\n");
		
		// 경로 복원
		List<Integer> route = new ArrayList<>();
		for (int v = target; v != -1; ) {			
			route.add(v);
			v = parent[v];
		}
		Collections.reverse(route);
		
		for (Integer v : route) {
			if(target == v) {
				sb.append(v);
			}
			else{
				sb.append(v).append(" ");
			}
		}
		
		System.out.println(sb.toString());
	}
}