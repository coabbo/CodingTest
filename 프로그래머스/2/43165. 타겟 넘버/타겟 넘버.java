import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {
        Queue<Integer> q = new ArrayDeque();
        q.add(0);
        
        for(int i = 0; i < numbers.length; i++) {
            int size = q.size(); // 현재 큐 크기 저장
            
            for(int j = 0; j < size; j++) {
                int curr = q.poll(); // 하나씩 꺼냄
                
                q.add(curr + numbers[i]); // + 더한 값
                q.add(curr - numbers[i]); // - 뺀 값
            }
        }
        
        int answer = 0;
        while(!q.isEmpty()) {
            int x = q.poll();
            
            if(x == target) answer++;
        }
        
        return answer;
    }
}