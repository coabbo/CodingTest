import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] sanggenCard = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			sanggenCard[i] = Integer.parseInt(st.nextToken());
		}
		
		int M = Integer.parseInt(br.readLine());
		int[] numCard = new int[M];
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < M; i++) {
			numCard[i] = Integer.parseInt(st.nextToken());
		}
		
		// 이분탐색은 정렬된 배열에서만 올바르게 동작하기 때문에 정렬을 수행함
		Arrays.sort(sanggenCard);
		
		// 이분탐색 
		for (int i = 0; i < numCard.length; i++) {
			int findNum = numCard[i];
			
			
			int start = 0;
			int end = sanggenCard.length - 1; 
					
			int isHave = 0;
			
			while(start <= end) {
				int mid = (start + end) / 2;
				
				if(findNum < sanggenCard[mid]) {
					end = mid - 1;
				}
				else if(findNum > sanggenCard[mid]) {
					start = mid + 1;
				}
				else {
					isHave = 1;
					break;
				}
			}
			
			System.out.print(isHave + " ");
		}
	}
}