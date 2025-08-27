import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int K, W, H;
    private static int[][] map;
    private static int[][][] dist;

    private static int[] dr = { -1, 1, 0, 0 };
    private static int[] dc = { 0, 0, -1, 1 };

    private static int[] hr = { -1, -2, -2, -1, 1, 2, 2, 1 };
    private static int[] hc = { -2, -1, 1, 2, -2, -1, 1, 2 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][W];
        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dist = new int[H][W][K+1]; // dist[r][c][k] = (r,c)에 도착했을 때, 말의 움직임을 k번 한 상태의 최단 거리

        bfs();
    }

    public static void bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] { 0, 0, 0 });
        dist[0][0][0] = 0;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int cr = curr[0];
            int cc = curr[1];
            int ck = curr[2];

            if (cr == H - 1 && cc == W - 1) {
                System.out.println(dist[cr][cc][ck]);
                return;
            }

            if (ck < K) {
                for (int d = 0; d < 8; d++) {
                    int nr = cr + hr[d];
                    int nc = cc + hc[d];
                    int nk = ck + 1;

                    if (nr < 0 || nr >= H || nc < 0 || nc >= W) continue;
                    if (map[nr][nc] == 1) continue;

                    if (dist[nr][nc][nk] == 0) {
                        q.add(new int[] { nr, nc, nk });
                        dist[nr][nc][nk] = dist[cr][cc][ck] + 1;
                    }
                }
            }

            for (int d = 0; d < 4; d++) {
                int nr = cr + dr[d];
                int nc = cc + dc[d];
                int nk = ck;

                if (nr < 0 || nr >= H || nc < 0 || nc >= W) continue;
                if (map[nr][nc] == 1) continue;

                if (dist[nr][nc][nk] == 0) {
                    q.add(new int[] { nr, nc, nk });
                    dist[nr][nc][nk] = dist[cr][cc][ck] + 1;
                }
            }
        }

        System.out.println(-1);
    }
}