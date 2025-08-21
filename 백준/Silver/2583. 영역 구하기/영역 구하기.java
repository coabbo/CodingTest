import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int M, N;
    private static int[][] map;
    private static int count;
    private static boolean[][] visited;
    private static List<Integer> areaList;

    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken()); // 직사각형의 개수

        map = new int[M][N];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int y1 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());

            for (int y = y1; y < y2; y++) {
                for (int x = x1; x < x2; x++) {
                    map[x][y] = 1;
                }
            }
        }

        visited = new boolean[M][N];
        count = 0;
        areaList = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] == 0){
                    bfs(i, j);
                }
            }
        }

        Collections.sort(areaList);

        System.out.println(count);
        for(int a : areaList) {
            System.out.print(a + " ");
        }
    }

    public static void bfs(int r, int c) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {r, c});
        visited[r][c] = true;
        int area = 1;

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int cr = curr[0];
            int cc = curr[1];

            for (int d = 0; d < 4; d++) {
                int nr = cr + dr[d];
                int nc = cc + dc[d];

                if(nr < 0 || nc < 0 || nr >= M || nc >= N) continue;
                if(map[nr][nc] == 1) continue;
                if(visited[nr][nc]) continue;

                q.add(new int[] {nr, nc});
                map[nr][nc] = 1;
                visited[nr][nc] = true;
                area++;
            }
        }

        count++;
        areaList.add(area);
    }
}