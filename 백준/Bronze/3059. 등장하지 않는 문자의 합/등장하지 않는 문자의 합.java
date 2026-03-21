import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		for (int testCase = 0; testCase < n; testCase++) {
			int[] arr = new int[26];
			int answer = 0;
			
			String s = br.readLine();
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				arr[c - 'A'] += 1;
			}
			
			for (int i = 0; i < arr.length; i++) {
				if(arr[i] == 0) answer += i + 'A';
			}
			
			sb.append(answer).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}