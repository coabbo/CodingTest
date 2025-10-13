import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new ArrayDeque<>();
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        for (int i = 0; i < N; i++) {
            deque.add(arr[i]);
        }

        int sum = 0;

        int last = 0;
        last = deque.pollLast();
        sum += last;

        boolean check = false;

        while(!deque.isEmpty()) {
            if(check) {
                int curr = deque.pollLast();

                check = false;

                if(last >= curr) {
                    sum += 0;
                }
                else {
                    sum += curr - last;
                }

                last = curr;
            }
            else {
                int curr = deque.pollFirst();

                check = true;

                if(last >= curr) {
                    sum += 0;
                }
                else {
                    sum += curr - last;
                }

                last = curr;
            }
        }

        System.out.println(sum);
    }
}