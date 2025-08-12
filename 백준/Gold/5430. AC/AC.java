import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int testCase = 0; testCase < T; testCase++) {
			String p = br.readLine(); // 수행할 함수
			int n = Integer.parseInt(br.readLine()); // 배열에 들어있는 수의 개수
			String x = br.readLine();
			
			Deque<Integer> deque = new ArrayDeque<>();
			String temp = x.substring(1, x.length() - 1);
			String[] parts = temp.split(",");

			if(n != 0) {
				for (String s : parts) {
					deque.add(Integer.parseInt(s));
				}
			}
			
			boolean reverse = false;
			boolean check = false;
			
A:			for (int i = 0; i < p.length(); i++) {
				char order = p.charAt(i);
				
				switch (order) {
				case 'R':
					if(reverse) reverse = false;
					else reverse = true;
					break;
					
				case 'D':
					if(deque.size() == 0) {
						sb.append("error").append("\n");
						check = true;
						break A;
					}
					
					if(reverse) deque.removeLast();
					else deque.removeFirst();
					break;
				}
			}
			
			if(deque.size() == 0) {
				if(check) continue;
				else sb.append("[]").append("\n");
			}
			else {
				if(reverse) {
					sb.append("[");
					while(!deque.isEmpty()) {
						sb.append(deque.pollLast()).append(",");
					}
					sb.deleteCharAt(sb.length() - 1);
					sb.append("]").append("\n");
				}
				else {
					sb.append("[");
					while(!deque.isEmpty()) {
						sb.append(deque.poll()).append(",");
					}
					sb.deleteCharAt(sb.length() - 1);
					sb.append("]").append("\n");
				}
			}
		}
		
		System.out.println(sb.toString());
	}
}