import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine()); // 지방의 수
		int[] budgetRequest = new int[N]; // 각 지방의 예산 요청
		int maxBudgetRequest = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < budgetRequest.length; i++) {
			budgetRequest[i] = Integer.parseInt(st.nextToken());
			if(maxBudgetRequest < budgetRequest[i]) {
				maxBudgetRequest = budgetRequest[i];
			}
		}
		int M = Integer.parseInt(br.readLine()); // 총 예산
		
		long low = 1;
		long high = maxBudgetRequest;
		long answer = 0;
		
		while(low <= high) {
			long mid = (low + high) / 2;
			long sum = 0;
			
			for (int i = 0; i < budgetRequest.length; i++) {
				if(budgetRequest[i] <= mid) {
					sum += budgetRequest[i];
				}
				else {
					sum += mid;
				}
			}
			
			if(sum <= M) {
				answer = mid;
				low = mid + 1;
			}
			else {
				high = mid - 1;
			}
		}
		
		System.out.println(answer);
	}
}