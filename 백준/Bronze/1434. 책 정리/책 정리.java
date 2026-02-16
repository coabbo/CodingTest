import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] A = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] B = new int[M];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < M; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		int boxIdx = 0;
		int bookIdx = 0;
		
		while(bookIdx < M) {
			if(A[boxIdx] >= B[bookIdx]) {
				A[boxIdx] -= B[bookIdx];
				bookIdx++;
			}
			else {
				boxIdx++;
			}
		}
		
		int answer = 0;
		for (int i = 0; i < N; i++) {
			answer += A[i];
		}
		
		System.out.println(answer);
	}
}