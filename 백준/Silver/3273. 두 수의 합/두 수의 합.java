import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 수열의 크기

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N]; // 수열에 포함되는 수
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int x = Integer.parseInt(br.readLine()); // 만들어야 하는 수
		int count = 0;
		
		Arrays.sort(arr);
		
		for (int i = 0; i < arr.length; i++) {
			int currNum = arr[i];
			
			for (int j = i + 1; j < arr.length; j++) {
				if(currNum + arr[j] > x) break;
				
				if(currNum + arr[j] == x) {
					count++;
				}
			}
		}
		
		System.out.println(count);
	}
}