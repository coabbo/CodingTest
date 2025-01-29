import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int answer = 0;

        // 우선순위 큐에 모든 스코빌 지수를 삽입
        for (int s : scoville) {
            pq.offer(s);
        }

        // 최소 스코빌 지수가 K 이상이 될 때까지 반복
        while (pq.size() > 1 && pq.peek() < K) {
            int first = pq.poll();  // 가장 작은 값
            int second = pq.poll(); // 두 번째로 작은 값
            int newScoville = first + (second * 2);
            
            pq.offer(newScoville);
            answer++;
        }

        // 큐에 하나 남았을 때도 K 미만이면 -1 반환
        return pq.peek() >= K ? answer : -1;
    }
}