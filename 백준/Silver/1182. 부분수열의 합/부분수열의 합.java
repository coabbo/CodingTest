import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int S;
    private static int answer = 0;
    private static int[] num;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        num = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        visited = new boolean[N];
        backtrack(0, N);

        System.out.println(answer);
    }

    public static void backtrack(int idx, int n) {
        // 1. 기저조건 (idx가 n이면 하나 완성)
        if (idx == n) {
            int sum = 0;
            int count = 0; // 포함된 원소의 개수를 세기 위한 변수

            // visited[i] == true인 num[i]만 결과에 포함
            for (int i = 0; i < n; i++) {
                if(visited[i]) {
                    sum += num[i];
                    count++;
                }
            }

            if(sum == S && count > 0) answer++;

            return;
        }

        // 2. num[idx] 포함
        visited[idx] = true;
        backtrack(idx + 1, n);

        // 3. arr[idx] 미포함
        visited[idx] = false;
        backtrack(idx + 1, n);
    }
}