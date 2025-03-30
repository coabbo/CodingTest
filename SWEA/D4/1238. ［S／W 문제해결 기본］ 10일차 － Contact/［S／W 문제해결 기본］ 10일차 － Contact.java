import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	private static int[][] graph;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int testCase = 1; testCase <= 10; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 입력받는 숫자 개수 
			int start = Integer.parseInt(st.nextToken());
			
			graph = new int[101][101];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N/2; i++) {
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				
				graph[A][B] = 1;
			}
			
			int ans = bfs(start);
			
			System.out.println("#" + testCase + " " + ans);
		}
		
	} // end of main

	private static int bfs(int start) {
		Queue<Integer> exPlan = new ArrayDeque<>(); //실행계획
		boolean[] visited = new boolean[101]; //정점의 방문여부 확인, 0번은 안 씀
		int[] level = new int[101]; //각 정점까지의 연락 전파 거리를 저장
		
		exPlan.add(start); //최초 실행 계획 넣기. 현재값 start
		visited[start] = true;
		
		while(!exPlan.isEmpty()) {
			int vertex = exPlan.poll(); //현재 값 꺼내기
			
			int[] relation = graph[vertex]; //현재 값의 연결관계 찾기
			
			for(int i = 1; i < relation.length; i++) {
				if(relation[i] == 1 && !visited[i]) {
					visited[i] = true;
					level[i] = level[vertex] + 1;
					exPlan.add(i);
				}
			}
		}
		
		int maxLevel = 0;
		for(int i = 1; i <= 100; i++) {
			if(visited[i]) {
				maxLevel = Math.max(maxLevel, level[i]);
			}
		}
		
		int answer = 0;
		for(int i = 1; i <= 100; i++) {
			if(visited[i] && level[i] == maxLevel) {
				answer = Math.max(answer, i);
			}
		}
		
		return answer;
	}
} // end of class