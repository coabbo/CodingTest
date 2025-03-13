import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		for (int testCase = 0; testCase < N; testCase++) {
			
			String s = br.readLine();
			
			int sum = 0;
			int count = 0;
			
			for (int i = 0; i < s.length(); i++) {
				
				if(s.charAt(i) == 'O') {
					sum += count++;
				} else {
					sum += count;
					count = 0;
				}
				
				if(i == s.length() - 1) {
					sum += count;
				}
				
			}
			
			System.out.println(sum);
		}
	}
}
