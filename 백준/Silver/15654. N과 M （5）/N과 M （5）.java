import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main { ;
    private static int N;
    private static int M;
    private static int[] arr;
    private static int[] result;
    private static boolean[] visited;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken()); // N개의 수
        M = Integer.parseInt(st.nextToken()); // 구해야 할 수열의 길이

        arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        result = new int[M];
        visited = new boolean[arr[N-1] + 1];
        backtrack(0);

        System.out.println(sb.toString());
    }

    private static void backtrack(int idx) {
        // 종료조건
        if(idx == M) {
            for (int i = 0; i < M; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        
        // 재귀조건
        for (int i = 0; i < N; i++) {
            // 사용했으면 쳐내기
            if(visited[arr[i]]) continue;

            result[idx] = arr[i];
            visited[arr[i]] = true; // 방문체크
            backtrack(idx + 1);
            visited[arr[i]] = false; // 원상복구
        }
    }
}