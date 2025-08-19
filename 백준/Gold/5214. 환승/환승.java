import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N;
    private static List<Integer>[] graph;
    private static int[] dist;
    private static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); // 역의 수
        int K = Integer.parseInt(st.nextToken()); // 한 하이퍼튜브가 서로 연결하는 역의 개수
        int M = Integer.parseInt(st.nextToken()); // 하이퍼튜브의 개수

        graph = new List[N + M + 1];
        for (int i = 1; i <= N + M; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int hyperTube = N + i;

            for (int j = 0; j < K; j++) {
                int station = Integer.parseInt(st.nextToken());

                graph[station].add(hyperTube);
                graph[hyperTube].add(station);
            }
        }

        dist = new int[N + M + 1];
        visited = new boolean[N + M + 1];
        bfs(1, N);
    }

    private static void bfs(int start, int end) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        dist[start] = 1;
        visited[start] = true;

        while(!q.isEmpty()){
            int curr = q.poll();

            if(curr == N){
                System.out.println(dist[N]);
                return;
            }

            for(int next : graph[curr]){
                if(visited[next]) continue;

                q.add(next);
                visited[next] = true;

                if(next <= N) dist[next] = dist[curr] + 1;
                else dist[next] = dist[curr];
            }
        }

        System.out.println(-1);
    }
}