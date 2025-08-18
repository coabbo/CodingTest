import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int w;
    private static int h;
    private static int[][] map;
    private static boolean[][] visited;
    private static int count;

    private static int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1}; // 상하좌우, 대각선
    private static int[] dc = {0, 0, -1, 1, -1, 1, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if(w == 0 && h == 0) break;

            map = new int[h][w];
            visited = new boolean[h][w];
            count = 0;

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if(map[i][j] == 1 && !visited[i][j]){
                        bfs(i, j);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }

    public static void bfs(int r, int c) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {r, c});
        visited[r][c] = true;

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int cr = curr[0];
            int cc = curr[1];

            for (int d = 0; d < 8; d++) {
                int nr = cr + dr[d];
                int nc = cc + dc[d];

                if(nr < 0 || nc < 0 || nr >= h || nc >= w) continue;
                if(map[nr][nc] == 0 || visited[nr][nc]) continue;

                q.add(new int[] {nr, nc});
                visited[nr][nc] = true;
            }
        }
    }
}