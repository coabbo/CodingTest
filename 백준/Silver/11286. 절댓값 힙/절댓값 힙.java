import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)->{
			int absA = Math.abs(a);
			int absB = Math.abs(b);
			
			if(absA != absB)
				return absA - absB; // 절댓값 작은 순
			else
				return a - b; // 절댓값이 같지만, 본래 값이 작은 순
		});

		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());
			if(x != 0) {
				pq.add(x);
			}
			else {
				Integer tmp = pq.poll();
				
				if(tmp == null) {
					System.out.println(0);
				}
				else {
					System.out.println(tmp);
				}
			}
		}
	}
}