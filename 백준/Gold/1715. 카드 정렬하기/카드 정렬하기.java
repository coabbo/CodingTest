import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static class Card implements Comparable<Card> {
		int size;

		public Card(int size) {
			this.size = size;
		}

		@Override
		public int compareTo(Card o) {
			return Integer.compare(this.size, o.size);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		if (N == 1) {
			System.out.println(0);
			return;
		}

		PriorityQueue<Card> pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			pq.offer(new Card(Integer.parseInt(br.readLine())));
		}

		int answer = 0;
		while (!pq.isEmpty()) {
			Card card1 = pq.poll();
			Card card2 = pq.poll();
			
			int size1 = card1.size;
			int size2 = card2.size;
			int bundle = size1 + size2;
			answer += bundle;
			
			if (pq.size() == 0) break;
			else pq.add(new Card(bundle));
		}

		System.out.println(answer);
	}
}