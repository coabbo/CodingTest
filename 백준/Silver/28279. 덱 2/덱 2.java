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
			int command = Integer.parseInt(st.nextToken());
			
			switch (command) {
			case 1:
				int X = Integer.parseInt(st.nextToken());
				deque.addFirst(X);
				break;
			case 2:
				X = Integer.parseInt(st.nextToken());
				deque.addLast(X);
				break;
			case 3:
				if(deque.size() > 0) {
					sb.append(deque.removeFirst()).append("\n");
				}
				else {
					sb.append(-1).append("\n");
				}
				break;
			case 4:
				if(deque.size() > 0) {
					sb.append(deque.removeLast()).append("\n");
				}
				else {
					sb.append(-1).append("\n");
				}
				break;
			case 5:
				sb.append(deque.size()).append("\n");
				break;
			case 6:
				if(deque.isEmpty()) {
					sb.append(1).append("\n");
				}
				else {
					sb.append(0).append("\n");
				}
				break;
			case 7:
				if(deque.size() > 0) {
					sb.append(deque.peekFirst()).append("\n");
				}
				else {
					sb.append(-1).append("\n");
				}
				break;
			case 8:
				if(deque.size() > 0) {
					sb.append(deque.peekLast()).append("\n");
				}
				else {
					sb.append(-1).append("\n");
				}
				break;	
			}
		}
		System.out.println(sb.toString());
	}
}