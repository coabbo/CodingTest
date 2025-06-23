import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<Integer>();
		
		int count = 0;
		int i = 1;
		while(count != n) {
			int num = Integer.parseInt(br.readLine());
			
			while (i <= num) {
				stack.push(i);
				sb.append("+").append("\n");
				
				if(i == num) {
					i++;
					break;
				}
				
				i++;
			}
			
			if(stack.peek() == num) {
				stack.pop();
				sb.append("-").append("\n");
			}
			
			count++;
		}
		
		if(stack.isEmpty()) {
			System.out.println(sb.toString());
		}
		else {
			System.out.println("NO");
		}
	}
}