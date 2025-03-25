import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");			
			int N = Integer.parseInt(st.nextToken()); // 문서의 개수
			int M = Integer.parseInt(st.nextToken()); // 궁금한 문서의 현재 위치
			
			Deque<int[]> deque = new ArrayDeque<>();
			PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
			
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				int priority = Integer.parseInt(st.nextToken());
				deque.offer(new int[] {i, priority});
				pq.offer(priority);
			}
			/*
			System.out.println(testCase + "번째 테스트케이스 확인");
			for(int[] doc : deque) {
				System.out.println(Arrays.toString(doc));
			}
			*/
			
			int count = 0;
			while(!deque.isEmpty()) {
				int[] doc = deque.poll();
				
				if(doc[1] == pq.peek()) { // 가장 중요도가 높은 문서라면 출력
					pq.poll();
					count++;
					
					if(doc[0] == M) { // 궁금한 문서가 출력된 경우
						System.out.println(count);
						break;
					}
				} else { // 가장 중요도가 높지 않다면 다시 큐의 끝에 추가
					deque.offer(doc);
				}
			}
		}
	}
}