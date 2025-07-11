import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 과일의 개수

        int[] type = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            type[i] = Integer.parseInt(st.nextToken());
        }

        int[] cnt = new int[10];
        int left = 0, right = 0;
        int distinct = 0;
        int ans = 0;
        while (right < N) {
            int currFruit = type[right++];

            if(cnt[currFruit]++ == 0) {
                distinct++; // 새로 들어온 과일 추가
            }

            // 종류가 3개 이상일 경우 left 줄임
            while(distinct > 2) {
                int previousFruit = type[left];

                if(--cnt[previousFruit] == 0) {
                    distinct--;
                }

                left++;
            }

            ans = Math.max(ans, right - left);
        }

        System.out.println(ans);
    }
}