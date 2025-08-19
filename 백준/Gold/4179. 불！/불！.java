import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int R, C;
    private static int fireCount;
    private static char[][] map;
    private static int[][] fireDist;
    private static int[][] jihunDist;

    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        int jihunR = 0;
        int jihunC = 0;

        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = s.charAt(j);

                if(s.charAt(j) == 'J'){
                    jihunR = i;
                    jihunC = j;
                }
            }
        }

        fireDist = new int[R][C];
        for (int i = 0; i < R; i++) {
            Arrays.fill(fireDist[i], -1);
        }
        bfsFire();

        jihunDist = new int[R][C];
        for (int i = 0; i < R; i++) {
            Arrays.fill(jihunDist[i], -1);
        }
        bfsJihun(jihunR, jihunC);
    }

    public static void bfsFire() {
        Queue<int[]> q = new ArrayDeque<>();

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if(map[r][c] == 'F') {
                    fireCount++;
                    q.add(new int[] {r, c});
                    fireDist[r][c] = 0;
                }
                if(map[r][c] == '#') fireDist[r][c] = -100;
            }
        }

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int cr = curr[0];
            int cc = curr[1];

            for (int d = 0; d < 4; d++) {
                int nr = cr + dr[d];
                int nc = cc + dc[d];

                if(nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
                if(fireDist[nr][nc] == -100 || fireDist[nr][nc] != -1) continue;

                q.add(new int[] {nr, nc});
                fireDist[nr][nc] = fireDist[cr][cc] + 1;
            }
        }
    }

    private static void bfsJihun(int startR, int startC) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {startR, startC});
        jihunDist[startR][startC] = 0;

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int cr = curr[0];
            int cc = curr[1];

            if(cr == 0 || cr == R-1 || cc == 0 || cc == C-1){
                System.out.println(jihunDist[cr][cc] + 1);
                return;
            }

            for (int d = 0; d < 4; d++) {
                int nr = cr + dr[d];
                int nc = cc + dc[d];

                if(nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
                if(fireDist[nr][nc] == -100 || jihunDist[nr][nc] != -1) continue;

                if(map[nr][nc] == '.'){
                    jihunDist[nr][nc] = jihunDist[cr][cc] + 1;

                    if(jihunDist[nr][nc] < fireDist[nr][nc]) q.add(new int[] {nr, nc});
                    if(fireCount == 0) q.add(new int[] {nr, nc});
                }
            }
        }

        System.out.println("IMPOSSIBLE");
    }
}