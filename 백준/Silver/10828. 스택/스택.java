import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		Stack<Integer> stack = new Stack<>();
		
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String s = st.nextToken();

			if(s.equals("push")) {
				stack.push(Integer.parseInt(st.nextToken()));
			} 
			else if(s.equals("top")) {
				if(stack.size() == 0) {
					sb.append("-1").append("\n");
					continue;
				}
				sb.append(stack.peek()).append("\n");
			} 
			else if(s.equals("size")) {
				sb.append(stack.size()).append("\n");
			} 
			else if(s.equals("empty")) {
				if(stack.size() > 0) {
					sb.append("0").append("\n");
				} else {
					sb.append("1").append("\n");
				}
			} 
			else if(s.equals("pop")) {
				if(stack.size() == 0) {
					sb.append("-1").append("\n");
					continue;
				}
				sb.append(stack.pop()).append("\n");
			}
		}
		System.out.println(sb.toString());
	}
}