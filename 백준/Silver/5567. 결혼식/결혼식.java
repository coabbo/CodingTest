import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	private static int N;
	private static int M;
	private static boolean[] visited;
	private static List<Integer>[] graph;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 상근이의 동기의 수
		M = Integer.parseInt(br.readLine()); // 리스트의 길이
		visited = new boolean[N+1]; //방문체크
		
		graph = new ArrayList[N+1]; //0번은 안 씀
		for (int i = 1; i < N+1; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			graph[A].add(B);
			graph[B].add(A);
		}
		
		int ans = bfs(1); //상근이의 학번은 1
		
		System.out.println(ans);
	}

	public static int bfs(int start) {
		
		Queue<int[]> exPlan = new ArrayDeque<>(); //실행 계획
		exPlan.add(new int[] {start, 0});
		visited[start] = true;
		int count = 0;
		
		while(!exPlan.isEmpty()) {
			
			int[] curr = exPlan.poll(); //현재값
			int currVertex = curr[0];
			int currLevel = curr[1];
			
			//레벨이 2 이상이면 더이상 깊게 들어가지 않음.
			if(currLevel >= 2) continue;
			
			for (int neighbor : graph[currVertex]) {
				if(!visited[neighbor]) {
					exPlan.add(new int[]{neighbor, currLevel + 1});
					visited[neighbor] = true;
					count++;
				}
			}
		}
		
		return count;
	}
}