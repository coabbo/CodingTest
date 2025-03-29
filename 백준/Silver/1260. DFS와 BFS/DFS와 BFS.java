import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	private static int[][] graph;
	private static int N;
	private static int M;
	private static int V;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); //1. 정점의 개수
		M = Integer.parseInt(st.nextToken()); //1. 간선의 개수
		V = Integer.parseInt(st.nextToken()); //1. 탐색을 시작할 정점의 번호
		
		graph = new int[N+1][N+1]; //2. graph 2차원 배열 만들기, 0번은 안 씀
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			graph[A][B] = 1;
			graph[B][A] = 1;
		} //3. 입력값 처리
		
		String dfs = dfs(V); //4. dfs선언
		String bfs = bfs(V); //4. bfs선언
		
		System.out.println(dfs + "\n" + bfs);
	}

	private static String dfs(int v) {
		Queue<Integer> route = new ArrayDeque<>();  // 경로 
		Stack<Integer> exPlan = new Stack<>(); //실행 계획
		boolean[] visited = new boolean[N+1]; //정점의 방문여부 확인, 0번은 안 씀
		
		exPlan.push(v); //4-0. 최초 실행 계획 넣기, 최초 현재값 v
		
		while(!exPlan.isEmpty()) {
			
			int vertex = exPlan.pop(); //현재 값 꺼내기	
			if(visited[vertex]) {
				continue;
			}

			//실제 방문했을 때 방문 찍어야 함!!!!!
			visited[vertex] = true; //방문완료
			route.add(vertex); //경로에 넣음
			
			int[] relation = graph[vertex]; //현재 값의 연결관계 찾기
			
			for (int i = relation.length - 1; i > 0; i--) { //작은거부터 하라고 함
				if(relation[i] == 1 && !visited[i]) { //연결관계가 있으면서 방문을 아직 하지 않았다면
					exPlan.push(i); //실행계획에 넣음
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		int routeSize = route.size();
		for (int i = 0; i < routeSize; i++) {
			sb.append(route.poll()).append(" ");
		}
		
		String ans = sb.toString();
		
		return ans;
	}
	
	private static String bfs(int v) {
		Queue<Integer> route = new ArrayDeque<>();  // 경로 
		Queue<Integer> exPlan = new ArrayDeque<>(); //실행 계획
		boolean[] visited = new boolean[N+1]; //정점의 방문여부 확인, 0번은 안 씀
		
		exPlan.add(v); //4-0. 최초 실행 계획 넣기, 최초 현재값 v
		
		while(!exPlan.isEmpty()) {
			
			int vertex = exPlan.poll(); //현재 값 꺼내기		
			if(visited[vertex]) {
				continue;
			}
			
			//실제 방문했을 때 방문 찍어야 함!!!!!
			visited[vertex] = true; //방문완료
			route.add(vertex); //경로에 넣음
			
			
			int[] relation = graph[vertex]; //현재 값의 연결관계 찾기
			
			for (int i = 1; i < relation.length; i++) { //작은거 부터 넣어야 해서..
				if(relation[i] == 1 && !visited[i]) { //연결관계가 있으면서 방문을 아직 하지 않았다면
					exPlan.add(i); //실행계획에 넣음
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		int routeSize = route.size();
		for (int i = 0; i < routeSize; i++) {
			sb.append(route.poll()).append(" ");
		}
		
		String ans = sb.toString();
		
		return ans;
	}

}