import java.util.*;
import java.io.*;

public class Solution {
	
	static int N;
	static int[][] num;
	static int[] dr = {-1, 1, 0, 0}; //상하좌우
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for (int testCase = 1; testCase <= T; testCase++) {
			
			N = Integer.parseInt(br.readLine());
			num = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					num[i][j] = Integer.parseInt(st.nextToken());
				}	
			} // 방 번호 입력
			
						
			int maxCount = 0;
			int startRoom = Integer.MAX_VALUE;
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					boolean[][] visited = new boolean[N][N]; //방문체크
					int count = bfs(i, j, visited); //방문할 수 있는 방 길이 계산
						
					if(count > maxCount){
						maxCount = count;
						startRoom = num[i][j];
					}
					//길이가 같으면 번호가 더 작은 방 선택
					else if(count == maxCount && num[i][j] < startRoom) {
						startRoom = num[i][j];
					}
				}
			}
			
			System.out.println("#" + testCase + " " + startRoom + " " + maxCount);
		}
    } // end of main

	//bfs로 특정 방에서 갈 수 있는 최대 방 번호까지 이동
	static int bfs(int r, int c, boolean[][] visited) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {r, c});
		visited[r][c] = true;
		
		int count = 1; //현재 방 자체를 포함한 경로 길이
		int startRoom = num[r][c]; //시작 방 번호
		
		while(!queue.isEmpty()) {
			int[] curr = queue.poll();
			int cr = curr[0];
			int cc = curr[1];
			
			for(int d = 0; d < 4; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				
				//범위 체크
				if(nr < 0 || nc < 0 || nr >= N || nc >= N || visited[nr][nc]) continue;
				
				//이동할 수 있는 방이면 큐에 추가
				if(num[nr][nc] == num[cr][cc] + 1) {
					queue.add(new int[] {nr, nc});
					visited[nr][nc] = true;
					count++;
				}
			}
		}
		return count;
	}
} // end of class