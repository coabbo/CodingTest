import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		
		int multiple = A*B*C;
		String s = "" + multiple;
		
		int[] answer = new int[10];
		
		for (int i = 0; i < s.length(); i++) {
			int temp = s.charAt(i);
			answer[temp - 48]++;
		}
		
		for (int i : answer) {
			sb.append(i).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
