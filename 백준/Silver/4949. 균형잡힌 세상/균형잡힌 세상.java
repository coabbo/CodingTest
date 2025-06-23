import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			String s = br.readLine();
			
			if(s.equals(".")) {
				break;
			}
			
			Stack<String> stack = new Stack<String>();
			
			for (int i = 0; i < s.length(); i++) {
				// 왼쪽 괄호면 push
				if(s.charAt(i) == '(') stack.push("(");
				if(s.charAt(i) == '[') stack.push("[");
				
				// 오른쪽 괄호면 상황에 따라 pop or push
				if(s.charAt(i) == ')') {
					if(!stack.isEmpty()) {
						if(stack.peek().equals("(")) stack.pop();
						else stack.push(")");
					}
					else stack.push(")");
				}
				if(s.charAt(i) == ']') {
					if(!stack.isEmpty()) {
						if(stack.peek().equals("[")) stack.pop();
						else stack.push("]");
					}
					else stack.push("]");
				}
			}
			
			if(stack.isEmpty()) sb.append("yes").append("\n");
			else sb.append("no").append("\n");
		}
		
		System.out.println(sb.toString());
	}
}