import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N;
    private static int[][] map;
    private static int targetA;
    private static int targetB;

    private static int[][] dist;
    private static boolean[][] visited;

    private static int[] dr = {-1, -2, -2, -1, 1, 2, 2, 1};
    private static int[] dc = {-2, -1, 1, 2, -2, -1, 1, 2};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수

        for (int testCase = 0; testCase < T; testCase++) {
            N = Integer.parseInt(br.readLine()); // 체스판의 한 변의 길이
            map = new int[N][N];
            
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine(), " ");
            targetA = Integer.parseInt(st.nextToken());
            targetB = Integer.parseInt(st.nextToken());

            dist = new int[N][N];
            visited = new boolean[N][N];
            bfs(A, B);
        }
    }

    public static void bfs(int r, int c) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {r, c});
        dist[r][c] = 0;
        visited[r][c] = true;

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int cr = curr[0];
            int cc = curr[1];

            if(cr == targetA && cc == targetB) {
                System.out.println(dist[targetA][targetB]);
                break;
            }

            for (int d = 0; d < 8; d++) {
                int nr = cr + dr[d];
                int nc = cc + dc[d];

                if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
                if(visited[nr][nc]) continue;

                q.add(new int[] {nr, nc});
                dist[nr][nc] = dist[cr][cc] + 1;
                visited[nr][nc] = true;
            }
        }
    }
}