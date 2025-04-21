import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine()); //수행해야 하는 연산의 수
		Deque<Integer> deque = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int num = 0;
			
			String s = st.nextToken();
			if(s.equals("add") || s.equals("check") || s.equals("remove") || s.equals("toggle")) {
				num = Integer.parseInt(st.nextToken());
			}
					
			switch (s) {
			case "add":
				if(deque.contains(num)) break;
				deque.addLast(num);
				break;
			case "check":
				if(deque.contains(num)) {
					sb.append(1).append("\n");
				}
				else {
					sb.append(0).append("\n");
				}
				break;
			case "remove":
				if(!deque.contains(num)) {
					break;
				}
				deque.remove(num);
				break;
			case "toggle":
				if(deque.contains(num)) {
					deque.remove(num);
				}
				else {
					deque.addLast(num);
				}
				break;
			case "all":
				deque.clear();
				for (int j = 1; j <= 20; j++) {
					deque.addLast(j);
				}
				break;
			case "empty":
				deque.clear();
				break;
			}
		}
		System.out.print(sb.toString());
	}
}