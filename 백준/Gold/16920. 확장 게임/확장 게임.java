import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N, M, P;
    private static char[][] map;
    private static int[] S;
    private static int[] castle;

    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken()); // 플레이어의 수

        map = new char[N][M]; // 게임판
        S = new int[P+1]; // 플레이어 별로 이동할 수 있는 칸
        castle = new int[P+1];

        st = new StringTokenizer(br.readLine(), " ");
        for (int player = 1; player < P+1; player++) {
            S[player] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        bfs();

        for (int player = 1; player <= P; player++) {
            sb.append(castle[player] + " ");
        }

        System.out.println(sb.toString());
    }

    public static void bfs() {
        Queue<int[]>[] q = new ArrayDeque[P+1];
        for (int player = 1; player < P+1; player++) {
            q[player] = new ArrayDeque<>();
        }

        // 플레이어 별로 성 담아두기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                char c = map[i][j];

                if (c >= '1' && c <= '9') {
                    int player = c - '0';
                    q[player].add(new int[] {i, j, S[player]});
                    castle[player]++;
                }
            }
        }

        boolean check = true;
        while(check) {
            check = false;

            for (int player = 1; player < P+1; player++) {
                Queue<int[]> nextQ = new ArrayDeque<>();

                while(!q[player].isEmpty()) {
                    int[] curr = q[player].poll();
                    int cr = curr[0];
                    int cc = curr[1];
                    int move = curr[2];

                    for (int d = 0; d < 4; d++) {
                        int nr = cr + dr[d];
                        int nc = cc + dc[d];

                        if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
                        if (map[nr][nc] != '.') continue;

                        if(move > 1) {
                            q[player].add(new int[]{nr, nc, move-1});
                        }
                        else {
                            nextQ.add(new int[]{nr, nc, S[player]});
                        }

                        map[nr][nc] = (char) (player + '0');
                        castle[player]++;
                        check = true;
                    }
                }
                q[player] = nextQ;
            }
        }
    }
}