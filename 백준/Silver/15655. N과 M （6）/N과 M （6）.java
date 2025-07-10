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

    // idx : 이번에 고려할 인덱스
    // sidx : 뽑은 인덱스
    private static void backtrack(int idx, int sidx) {
        // 종료조건
        if(sidx == M) {
            for (int i = 0; i < M; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        // 재귀조건
        for (int i = idx; i <= N - M + sidx; i++) {
            result[sidx] = arr[i];
            backtrack(i + 1, sidx + 1);
        }
    }
}