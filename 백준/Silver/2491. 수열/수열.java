import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 수열의 길이
		int[] arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int answer = 0;
		int count = 0;
		int plusLen = 1;
		int minusLen = 1;
		
		for (int i = 0; i < arr.length; i++) {
			
			// 연속해서 커지는 수열의 길이 체크
			int temp = arr[i];
			for (int j = i+1; j < arr.length; j++) {
				if(temp <= arr[j]) {
					plusLen++;
					temp = arr[j];
				} 
				else {
					break;
				}
			}
			
			// 연속해서 작아지는 수열의 길이 체크
			temp = arr[i];
			for (int j = i+1; j < arr.length; j++) {
				if(temp >= arr[j]) {
					minusLen++;
					temp = arr[j];
				} 
				else {
					break;
				}
			}
			
			count = Math.max(plusLen, minusLen);
			answer = Math.max(answer, count);
			
			plusLen = 1;
			minusLen = 1;
		}
		
		System.out.println(answer);
	}
}