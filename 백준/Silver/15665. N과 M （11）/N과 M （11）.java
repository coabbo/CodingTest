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
        backtrack(0);

        System.out.println(sb.toString());
    }

    private static void backtrack(int depth) {
        // 종료조건
        if(depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        // 재귀조건
        int last = 0; // 중복 방지를 위해 이전에 뽑았던 값을 저장
        for (int i = 0; i < N; i++) {
            if(last == arr[i]) continue;

            result[depth] = arr[i];
            last = arr[i];
            backtrack(depth + 1);
        }
    }
}