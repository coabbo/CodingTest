import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();

		for (int testCase = 1; testCase <= N; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int order = Integer.parseInt(st.nextToken());
			
			
			switch (order) {
			case 1:
				int X = Integer.parseInt(st.nextToken());
				stack.push(X);
				break;
			case 2:
				if(stack.isEmpty()) {
					sb.append("-1").append("\n");
					break;
				} else {
					sb.append(stack.pop()).append("\n");
				}
				break;
			case 3:
				sb.append(stack.size()).append("\n");
				break;
			case 4:
				if(stack.isEmpty()) {
					sb.append("1").append("\n");
					break;
				} else {
					sb.append(0).append("\n");
				}
				break;
			case 5:
				if(stack.isEmpty()) {
					sb.append("-1").append("\n");
					break;
				} else {
					sb.append(stack.peek()).append("\n");
				}
				break;
			}
		}
		System.out.println(sb.toString());
	}
}
