import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int[] map;
	private static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int testCase = 0; testCase < T; testCase++) {
			int N = Integer.parseInt(br.readLine());
			map = new int[N+1];
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 1; i <= N; i++) {
				map[i] = Integer.parseInt(st.nextToken());
			}
			
			visited = new boolean[N+1];
			
			int count = 0;
			for (int i = 1; i < map.length; i++) {
				if (!visited[i]) {
					dfs(i);
					count++;
				}
			}
			
			sb.append(count).append("\n");
		}
		
		System.out.println(sb.toString());
	}

	public static void dfs(int node) {
		visited[node] = true;
		
		int nextNode = map[node];
		
		if (!visited[nextNode]) {
			dfs(nextNode);
		}
	}
}