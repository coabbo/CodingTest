import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수
		
		for (int i = 0; i < T; i++) {
			String s = br.readLine();
			
			Deque<Character> left = new ArrayDeque<>();
			Deque<Character> right = new ArrayDeque<>();

			for (Character key : s.toCharArray()) {
				switch (key) {
					case '<':
						if(!left.isEmpty()) right.push(left.pop());
						break;
					case '>':
						if(!right.isEmpty()) left.push(right.pop());
						break;
					case '-':
						if(!left.isEmpty()) left.pop();
						break;
					default:
						left.push(key);
				}
			}
			
			// left -> right로 옮기며 순서 뒤집고
			// right에서 pop하며 올바른 순서로 꺼냄
			while(!left.isEmpty()) right.push(left.pop());
			while(!right.isEmpty()) sb.append(right.pop());
			
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}