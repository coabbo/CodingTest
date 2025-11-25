import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken()); // 지워야 하는 개수
        int tempK = N - K;

        String num = br.readLine();

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            int currentNum = num.charAt(i) - '0';

            while (!deque.isEmpty() && K > 0 && deque.getLast() < currentNum) {
                deque.removeLast();
                K--;
            }

            deque.add(currentNum);
        }

        while(tempK-- > 0) {
            sb.append(deque.pollFirst());
        }

        System.out.println(sb.toString());
    }
}