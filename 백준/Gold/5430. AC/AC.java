import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

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
			
			for (int i = 1; i < x.length() - 1; i++) {
				String temp = "";
				while(x.charAt(i) != ',') {
					if(i == x.length() - 1) break;
					
					temp += x.charAt(i);
					i++;
				}
				
				deque.add(Integer.parseInt(temp));
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