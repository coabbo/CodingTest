import java.io.*;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		int K = Integer.parseInt(br.readLine());
		int sum = 0;

		for (int i = 0; i < K; i++) {
			int X = Integer.parseInt(br.readLine());
			
			if(X != 0) {
				stack.push(X);
			} else {
				stack.pop();
			}
		}
		
		int N = stack.size();
		for (int i = 0; i < N; i++) {
			sum += stack.pop();
		}
		
		sb.append(sum);
		System.out.println(sb.toString());
	}
}
