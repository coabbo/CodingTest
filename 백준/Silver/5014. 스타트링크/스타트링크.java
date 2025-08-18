import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int F, S, G, U, D;
    private static boolean[] visited;
    private static int[] dist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        F = Integer.parseInt(st.nextToken()); // 총 F층
        S = Integer.parseInt(st.nextToken()); // 강호의 현재 위치
        G = Integer.parseInt(st.nextToken()); // 스타트링크가 있는 위치
        U = Integer.parseInt(st.nextToken()); // 위로 U층 이동
        D = Integer.parseInt(st.nextToken()); // 아래로 D층 이동

        dist = new int[1000000 + 1];
        Arrays.fill(dist, -1);

        visited = new boolean[1000000 + 1];

        bfs(S, G);

        if(dist[G] == -1){
            System.out.println("use the stairs");
        }
        else{
            System.out.println(dist[G]);
        }
    }

    public static void bfs(int start, int end) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        dist[start] = 0;
        visited[start] = true;

        while(!q.isEmpty()){
            int curr = q.poll();

            if(curr == end) {
                break;
            }

            int[] nexts = {curr + U, curr - D};
            for(int next : nexts){
                if(next <= 0 || next > F) continue;
                if(visited[next]) continue;

                q.add(next);
                dist[next] = dist[curr] + 1;
                visited[next] = true;
            }
        }
    }
}