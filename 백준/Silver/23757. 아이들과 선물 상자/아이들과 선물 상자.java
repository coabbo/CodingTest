import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken()); // 선물 상자의 수
		int M = Integer.parseInt(st.nextToken()); // 아이들의 수
		
		PriorityQueue<Integer> c = new PriorityQueue<>(Collections.reverseOrder());
		int[] w = new int[M];
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			c.add(Integer.parseInt(st.nextToken()));
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < M; i++) {
			w[i] = Integer.parseInt(st.nextToken());
		}
		
		int answer = 1;
		for (int want : w) {
			int currC = c.poll();
			
			if(currC < want) {
				answer = 0;
				break;
			}
			
			if(currC > want) {
				c.add(currC - want);
			}
		}
		
		System.out.println(answer);
	}
}