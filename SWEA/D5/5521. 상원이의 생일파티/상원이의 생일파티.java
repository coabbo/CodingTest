import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= TC; testCase++) { // 10개 테스트케이스
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken()); // 1~N 학생 번호, N, 2 ≤ N ≤ 500
            int M = Integer.parseInt(st.nextToken()); // 친한 친구 관계의 수 M, 1 ≤ M ≤ 10^4
 
            int[][] map = new int[N+1][N+1]; // 0번 정점은 없음 안씀
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken()); // a, b (1 ≤ a ＜ b ≤ N)
                int b = Integer.parseInt(st.nextToken());
                map[a][b] = map[b][a] = 1; // 무향그래프
            }
            // 1번 학생이 상원
            // BFS로 탐색을 해보자 반복문, Queue FIFO
            Queue<Integer> q = new LinkedList<Integer>();
            boolean[] visited = new boolean[N+1]; // 0번 정점은 없음 안씀, 1~N, 여러번 방문하는 것을 막기위해서
            visited[1] = true;
            q.offer(1); // 시작정점을 큐에 넣고 시작
            int level = 0;
            int result = 0; // 초대장 받은 친구들
            while (q.size() > 0) { // 큐가 빌때까지
            	level++;
            	int size = q.size(); // 현재 큐에 들어있는 정점은 같은 레벨
            	for (int j = 0; j < size; j++) {
            		int num = q.poll();
            		// 꺼낸 정점과 인접한 정점을 큐에 넣고 다시 탐색 반복
            		for (int i = 1; i <= N; i++) {
            			if (!visited[i] && map[num][i] == 1) { // 미방문, 인접
            				visited[i] = true;
            				q.offer(i); // 큐에 추가
            				result++; // 초대장 받은 친구들
            			}
            		}
				}
            	if (level == 2) break;
            }
            
            sb.append("#").append(testCase).append(" ").append(result).append("\n");
        } // end of for testCase
        System.out.print(sb.toString());
    } // end of main
} // end of class