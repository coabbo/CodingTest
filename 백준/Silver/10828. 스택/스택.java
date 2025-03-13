import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		Stack<Integer> stack = new Stack<>();
		
		int N = sc.nextInt();
		
		for (int i = 0; i < N; i++) {
			String s = sc.next();

			if(s.equals("push")) {
				stack.push(sc.nextInt());
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