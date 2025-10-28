import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String s = br.readLine();
            char[] arr = s.toCharArray();

            if (nextPermutation(arr)) {
                System.out.println(new String(arr));
            }
            else {
                System.out.println(s);
            }
        }
    }

    // Next Permutation 알고리즘
    public static boolean nextPermutation(char[] arr) {
        int n = arr.length;

        // 1단계: 뒤에서부터 arr[i] < arr[i+1]인 i 찾기
        int i = n - 2;
        while (i >= 0 && arr[i] >= arr[i+1]) {
            i--;
        }

        // 다음 순열이 없는 경우 (이미 최대)
        if (i < 0) {
            return false;
        }

        // 2단계: i 뒤쪽에서 arr[i]보다 큰 가장 작은 값 찾기
        int j = n - 1;
        while (arr[j] <= arr[i]) {
            j--;
        }

        // 3단계: swap
        swap(arr, i, j);

        // 4단계: i+1부터 끝까지 오름차순 정렬
        reverse(arr, i+1, n-1);

        return true;
    }

    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void reverse(char[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }
}