import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		Deque<Integer> deque = new LinkedList<>();

		int N = Integer.parseInt(br.readLine());
		for (int i = N; i >= 1; i--) {
			deque.addFirst(i);
		}
		
		while(deque.size() != 1) {
			deque.removeFirst();
			int tmp = deque.removeFirst();
			deque.addLast(tmp);
		}
		
		sb.append(deque.peek());
		System.out.println(sb.toString());
	}
}