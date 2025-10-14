import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int[] num;
    private static int[] arr;
    private static boolean[] visited;
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        num = new int[N];

        for (int i = 0; i < num.length; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        arr = new int[N];
        visited = new boolean[N];

        backtrack(0);

        System.out.println(answer);
    }

    public static void backtrack(int depth) {
        // 1) 기저조건 (depth == N 이면 하나 완성)
        if (depth == N) {
            int temp = 0;
            for (int i = 0; i < arr.length - 1; i++) {
                temp += Math.abs(arr[i+1] - arr[i]);
            }

            answer = Math.max(temp, answer);

            return;
        }

        // 2) 가능한 후보 순회
        for (int i = 0; i < N; i++) {
            if (visited[i]) continue; // 중복 체크

            // 3) 선택
            visited[i] = true;
            arr[depth] = num[i];

            // 4) 재귀 호출 (다음 깊이로)
            backtrack(depth + 1);

            // 5) 선택 취소
            visited[i] = false;
        }
    }
}