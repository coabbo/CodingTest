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
        backtrack(0, 0);

        System.out.println(sb.toString());
    }

    // start : 이번에 고려할 인덱스
    // depth : 지금까지 채운 자리
    private static void backtrack(int start, int depth) {
        // 종료조건
        if(depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        // 재귀조건
        for (int i = start; i < N; i++) {
            result[depth] = arr[i];
            backtrack(i, depth + 1);
        }
    }
}