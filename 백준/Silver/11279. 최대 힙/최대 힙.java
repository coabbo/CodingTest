import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

	public static void main(String args[]) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			Integer x = Integer.parseInt(br.readLine());
			
			if(x > 0) {
				pq.add(x);
			} 
			
			if(x == 0) {
				Integer tmp = pq.poll();
				if(tmp == null) {
					System.out.println("0");
				} else {
					System.out.println(tmp);
				}
			}
		}
	}
}