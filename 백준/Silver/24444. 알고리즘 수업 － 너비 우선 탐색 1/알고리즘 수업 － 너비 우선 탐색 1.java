import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int M;
	private static int R;
	private static ArrayList<Integer>[] graph;
	private static boolean[] visited;
	private static StringBuilder sb;
	private static int[] order;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken()); //정점의 수
		M = Integer.parseInt(st.nextToken()); //간선의 수
		R = Integer.parseInt(st.nextToken()); //시작 정점
		
		graph = new ArrayList[N+1]; //정점은 1번부터 시작
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			graph[A].add(B);
			graph[B].add(A); //무방향 그래프
		}
		
		//인접 정점은 오름차순으로 방문하기 위해 정렬
		for(int i = 1; i <= N; i++) {
			Collections.sort(graph[i]);
		}
		
		order = new int[N+1];
		visited = new boolean[N+1];
		
		bfs(R);
		
		for (int i = 1; i <= N; i++) {
			sb.append(order[i]).append("\n");
		}
		
		System.out.println(sb.toString());
	}

	public static void bfs(int start) {
		Queue<Integer> exPlan = new ArrayDeque<>(); //실행 계획
		int cnt = 1;
		exPlan.add(start); //첫 값을 넣음
		visited[start] = true; //첫 방문처리
		order[start] = cnt;
		
		while(!exPlan.isEmpty()) {
			int vertex = exPlan.poll(); //현재 값
			
			for (int next : graph[vertex]) {
				if(!visited[next]) {
					exPlan.add(next);
					visited[next] = true;
					order[next] = ++cnt;
				}
			}
		}
	}
}