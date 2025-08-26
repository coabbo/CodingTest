import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int N, M, K;
    private static int[][] map;
    private static int[][][] dist;

    private static int[] dr = { -1, 1, 0, 0 };
    private static int[] dc = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();

            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        dist = new int[N][M][K+1]; // dist[r][c][k] = (r,c)에 도착했을 때, 벽을 k개 부순 상태의 최단 거리

        bfs();
    }

    public static void bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] { 0, 0, 0 });
        dist[0][0][0] = 1;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int cr = curr[0];
            int cc = curr[1];
            int breakWall = curr[2];

            if (cr == N - 1 && cc == M - 1) {
                System.out.println(dist[cr][cc][breakWall]);
                return;
            }

            for (int d = 0; d < 4; d++) {
                int nr = cr + dr[d];
                int nc = cc + dc[d];

                if (nr < 0 || nr >= N || nc < 0 || nc >= M)
                    continue;

                if (map[nr][nc] == 0) { // 이동할 수 있는 길이면
                    if (dist[nr][nc][breakWall] == 0) { // 아직 방문하지 않았으면
                        q.add(new int[] { nr, nc, breakWall });
                        dist[nr][nc][breakWall] = dist[cr][cc][breakWall] + 1;
                    }
                }
                else { // 이동할 수 없는 벽이면
                    if (breakWall < K && dist[nr][nc][breakWall + 1] == 0) { // 벽을 부술 수 있고, 아직 방문하지 않았으면
                        q.add(new int[] { nr, nc, breakWall + 1 });
                        dist[nr][nc][breakWall + 1] = dist[cr][cc][breakWall] + 1;
                    }
                }
            }
        }

        System.out.println(-1);
    }
}