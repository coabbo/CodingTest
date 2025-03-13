import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		Deque<Integer> deque = new LinkedList<>();
		
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			
			switch (s) {
				case "push":
					deque.add(Integer.parseInt(st.nextToken()));
					break;
				case "pop":
					Integer temp = deque.poll();
					if(temp == null) {
						sb.append("-1").append("\n");
					} else {
						sb.append(temp).append("\n");
					}
					break;
				case "size":
					sb.append(deque.size()).append("\n");
					break;
				case "empty":
					if(deque.isEmpty()) {
						sb.append("1").append("\n");
					} else {
						sb.append("0").append("\n");
					}
					break;
				case "front":
					if(deque.isEmpty()) {
						sb.append("-1").append("\n");
					} else {
						sb.append(deque.peekFirst()).append("\n");
					}
					break;
				case "back":
					if(deque.isEmpty()) {
						sb.append("-1").append("\n");
					} else {
						sb.append(deque.peekLast()).append("\n");
					}
			}
		}
		
		System.out.println(sb.toString());
	}
}