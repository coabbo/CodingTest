import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // 작은 절반
		PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // 큰 절반
		
		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());	
			
			// 1. 새로운 값은 항상 maxHeap에 먼저 넣음
			maxHeap.add(x);
			
			// 2. 순서가 어긋나면 교환
			if(!minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
				minHeap.add(maxHeap.poll());
				maxHeap.add(minHeap.poll());
			}
			
			// 3. 힙 크기 균형 맞추기
			if(maxHeap.size() > minHeap.size() + 1) {
				minHeap.add(maxHeap.poll());
			}
			else if(minHeap.size() > maxHeap.size()) {
				maxHeap.add(minHeap.poll());
			}
		
			// 4. 중간값 : maxHeap의 루트
			sb.append(maxHeap.peek()).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}