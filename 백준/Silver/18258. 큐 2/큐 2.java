import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		Deque<Integer> deque = new LinkedList<>();

		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String command = st.nextToken();
			
			switch (command) {
			case "push":
				int X = Integer.parseInt(st.nextToken());
				deque.addLast(X);
				break;
			case "pop":
				if(deque.size() > 0) {
					sb.append(deque.removeFirst()).append("\n");
				}
				else {
					sb.append(-1).append("\n");
				}
				break;
			case "size":
				sb.append(deque.size()).append("\n");
				break;
			case "empty":
				if(deque.isEmpty()) {
					sb.append(1).append("\n");
				}
				else {
					sb.append(0).append("\n");
				}
				break;
			case "front":
				if(deque.isEmpty()) {
					sb.append(-1).append("\n");
				}
				else {
					sb.append(deque.peekFirst()).append("\n");
				}
				break;
			case "back":
				if(deque.isEmpty()) {
					sb.append(-1).append("\n");
				}
				else {
					sb.append(deque.peekLast()).append("\n");
				}
				break;
			}
		}
		System.out.println(sb.toString());
	}
}