import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	private static int N;
	private static int K;
	private static List<Integer>[] graph;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 수빈이가 있는 위치
		K = Integer.parseInt(st.nextToken()); // 동생이 있는 위치
		
		graph = new ArrayList[100000 + 1];
		for (int i = 0; i <= 100000; i++) {
			graph[i] = new ArrayList<>();
		}
		
		// 간선 입력
		for (int i = 0; i <= 100000; i++) {
			if(i == 0) {
				graph[i].add(i+1);
				graph[i].add(i*2);
			}
			else {
				graph[i].add(i-1);
				graph[i].add(i+1);
				graph[i].add(i*2);
			}
		}
		
		int ans = bfs(N);
		System.out.println(ans);
	}

	public static int bfs(int start) {
		Queue<Integer> q = new ArrayDeque<>();
		q.add(start);
		
		int[] second = new int[100000 + 1];
		Arrays.fill(second, -1);
		second[start] = 0;
		
		int minSecond = Integer.MAX_VALUE;
		while(!q.isEmpty()) {
			int curr = q.poll();
			
			if(curr == K) {
				minSecond = second[K];
				break;
			}
			
			for (int v : graph[curr]) {
				if(v < 0 || v > 100000) continue;
				
				if(second[v] == -1 && (v >= 0 && v <= 100000)) {
					q.add(v);
					second[v] = second[curr] + 1;
				}
			}
		}
		
		return minSecond;
	}
}