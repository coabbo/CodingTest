import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] U = new int[N];
        for (int i = 0; i < N; i++) {
            U[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(U);

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                list.add(U[i] + U[j]); // 두 수의 합
            }
        }

        Collections.sort(list);

        // x + y + z = k
        // x + y = k - z
        for (int i = N-1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                int k = U[i];
                int z = U[j];
                int target = k - z;

                if (Collections.binarySearch(list, target) >= 0){
                    System.out.println(k);
                    return;
                }
            }
        }
    }
}