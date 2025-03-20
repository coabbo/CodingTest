import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		int[] findA = new int[M];
		for (int i = 0; i < M; i++) {
			findA[i] = Integer.parseInt(st.nextToken());
		}		
		
		Arrays.sort(A);
		
		for (int i = 0; i < findA.length; i++) {
			
			int answer = 0;
			
			int findNum = findA[i];
			
			int start = 0;
			int end = A.length - 1;
			
			while(start <= end) {
				
				int mid = (start + end) / 2;
				
				if(findNum < A[mid]) {
					end = mid - 1;
				}
				else if(findNum > A[mid]) {
					start = mid + 1;
				}
				else {
					answer = 1;
					break;
				}
			}
			
			sb.append(answer).append("\n");
		}
		
		
		System.out.println(sb.toString());
	}
}