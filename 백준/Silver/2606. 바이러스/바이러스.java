import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	private static int V;
	private static int E;
	private static List<Integer>[] graph; //인접 리스트
	private static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		V = Integer.parseInt(br.readLine()); //정점의 개수
		E = Integer.parseInt(br.readLine()); //간선의 개수
		
		graph = new ArrayList[V+1]; //정점은 1번부터 시작
		for (int i = 1; i <= V; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < E; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			graph[A].add(B);
			graph[B].add(A);
		}
		
		int ans = bfs(1);
		
		System.out.println(ans);
	}

	public static int bfs(int i) {
		
		Queue<Integer> exPlan = new ArrayDeque<>(); //실행 계획
		visited = new boolean[V+1];
		
		exPlan.add(i); //첫 값을 넣음
		visited[i] = true; //첫 값 방문처리
		
		int virus = 0;
		
		while(!exPlan.isEmpty()) {
			int vertex = exPlan.poll(); //현재 값

			for (int j : graph[vertex]) {
				if(!visited[j]) {
					exPlan.add(j);
					visited[j] = true;
					virus++;
				}
			}
		}
		
		return virus;
	}
}