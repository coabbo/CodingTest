import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static class Node implements Comparable<Node> {
		int r, c, cost;
		
		public Node(int r, int c, int cost) {
			this.r = r;
			this.c = c;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.cost, o.cost);
		}
	}
	
	private static int N;
	private static int M;
	private static Node[][] arr;
	private static int[][] dist;
	private static int INF = Integer.MAX_VALUE;
	
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken()); // 가로의 크기
		N = Integer.parseInt(st.nextToken()); // 세로의 크기
		
		arr = new Node[N][M];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			
			for (int j = 0; j < M; j++) {
				arr[i][j] = new Node(i, j, s.charAt(j) - '0');
			}
		}
		
		dist = new int[N][M];
		for(int[] a : dist) {
			Arrays.fill(a, INF);
		}
		
		int ans = dijkstra(0, 0);
		System.out.println(ans);
	}

	public static int dijkstra(int r, int c) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(r, c, 0));
		
		dist[r][c] = 0;
		
		while(!pq.isEmpty()) {
			Node curr = pq.poll();
			int cr = curr.r;
			int cc = curr.c;
			int cCost = curr.cost;
			
			// 종료 조건
			if(cr == N-1 && cc == M-1) {
				return dist[N-1][M-1];
			}
			
			if(cCost > dist[cr][cc]) continue;
			
			for (int i = 0; i < 4; i++) {
				int nr = cr + dr[i];
				int nc = cc + dc[i];
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
				
				int nCost = arr[nr][nc].cost;
				
				if(dist[nr][nc] > cCost + nCost) {
					pq.offer(new Node(nr, nc, cCost + nCost));
					dist[nr][nc] = cCost + nCost;
				}
			}
		}
		
		return -1;
	}
}