import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int count = 0;
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			
			Deque<Character> deque = new ArrayDeque<>();
			for (int j = 0; j < s.length(); j++) {
				if(deque.isEmpty()) deque.add(s.charAt(j));
				else {
					if(deque.getLast() == s.charAt(j)) deque.removeLast();
					else deque.addLast(s.charAt(j));
				}
			}
			
			if(deque.isEmpty()) count++;
		}
		
		System.out.println(count);
	}
}