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
		
		if(N == K) {
			System.out.println(0);
			System.out.println(1);
		}
		else {
			bfs(N, K);
		}
	}

	public static void bfs(int start, int target) {
		Queue<Integer> q = new ArrayDeque<>();
		q.add(start);
		
		int[] dist = new int[100000 + 1]; // 방문 여부 판단
		Arrays.fill(dist, -1);
		dist[start] = 0;
		
		int[] ways = new int[100000 + 1]; // 최단 경로 개수 누적
		ways[start] = 1;
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			
			// 이동할 수 있는 세 가지 경우
			int[] nexts = {curr - 1, curr + 1, curr * 2};
			
			for (int v : nexts) {
				if(v < 0 || v > 100000) continue;
				
				// 아직 한 번도 안 가본 곳이면
				if(dist[v] == -1) {
					q.add(v);
					dist[v] = dist[curr] + 1;
					ways[v] = ways[curr];
				}
				// 방문한 적이 있고, 최단 거리라면
				else if(dist[v] == dist[curr] + 1) {
					ways[v] += ways[curr]; // curr을 거쳐 오는 최단 경로 추가
				}
			}
		}
		
		System.out.println(dist[target]);
		System.out.println(ways[target]);
	}
}